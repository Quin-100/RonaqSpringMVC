package com.ronaq.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ronaq.model.Account;
import com.ronaq.model.Benificiary;
import com.ronaq.model.Feedback;
import com.ronaq.model.Transactions;
import com.ronaq.model.User;
import com.ronaq.service.IUserService;

@Controller
public class Services {

	private IUserService userService;	
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	
	@RequestMapping(value= {"/services","/user/services"})
	public String loadregister() {		
		return "services";
	}
	
	@RequestMapping(value= {"/transactions","/user/transactions"})
	public String loadmoneytransfer() {		
		return "transactions";
	}
	
	@RequestMapping(value= {"/samebranch","user/samebranch"})
	public String loadsamebranch(Model model,HttpSession session) {
		User u = (User) session.getAttribute("userdetails");
		System.out.println("Temp ......"+u);		
		if(session.getAttribute("userdetails") == null) {
			System.out.println("You are not loggged in as a user");
			return "redirect:/login";
		}
		else {
			List<String> benname = new ArrayList<String>();
			List<Benificiary> lstBen = u.getBenList();
			for (Benificiary benificiary : lstBen) {
				if(benificiary.getBranch().equals(u.getBranch())) {
					String ben = benificiary.getName() +"-"+ benificiary.getAccountno();
					benname.add(ben);
				}
			}
			if(benname.size()>0){
				model.addAttribute("listBeneficiary",benname);
				model.addAttribute("transactions", new Transactions());
				model.addAttribute("transactionmode","samebranch");
				return "transactionForm";
			}
			else {
				System.out.println("Currently no beneficiary added..");
				return "redirect:/user/beneficiary";
			}	
		}
		
	}
	
	@RequestMapping(value= {"/differentbranch","user/differentbranch"})
	public String loaddifferentbranch(Model model,HttpSession session) {
		User u = (User) session.getAttribute("userdetails");
		System.out.println("Temp ......"+u);	
		if(session.getAttribute("userdetails") == null) {
			System.out.println("You are not loggged in as a user");
			return "redirect:/login";
		}
		else {
			List<String> benname = new ArrayList<String>();
			List<Benificiary> lstBen = u.getBenList();
			for (Benificiary benificiary : lstBen) {
				if(!benificiary.getBranch().equals(u.getBranch())) {
					String ben = benificiary.getName() +"-"+ benificiary.getAccountno();
					benname.add(ben);
				}
			}
			if(benname.size()>0){
				model.addAttribute("listBeneficiary",benname);
				model.addAttribute("transactions", new Transactions());
				model.addAttribute("transactionmode","differentbranch");
				return "transactionForm";
			}
			else {
				return "redirect:/user/beneficiary";
			}
		}		
	}
	
	@RequestMapping(value= {"/beneficiary","/user/beneficiary"})
	public String loadbeneficiary(HttpSession httpSession,Model model) {
		//model.addAttribute("feedbackform", new Feedback());
		//model.addAttribute("listState",getStateList());
		if(httpSession.getAttribute("userdetails") == null) {
			System.out.println("You are not loggged in as a user");
			return "redirect:/login";
		}
		else {
			model.addAttribute("beneficiary", new Benificiary());
		}
		return "beneficiary";
	}
	
	
	@RequestMapping(value= {"/cibil","/user/cibil"})
	public String loadCibilCalc(HttpSession httpSession,Model model) {
		//model.addAttribute("feedbackform", new Feedback());
		//model.addAttribute("listState",getStateList());
		if(httpSession.getAttribute("userdetails") == null) {
			System.out.println("You are not loggged in as a user");
			return "redirect:/login";
		}
		else {
			model.addAttribute("beneficiary", new Benificiary());
		}
		return "beneficiary";
	}
	
	
	
	
	
	
	
	
	// For add and update person both
		@RequestMapping(value = "/user/addBeneficiary", method = RequestMethod.POST)
		//@ExceptionHandler({ CustomException.class })
		public String addBeneficiary(@ModelAttribute("beneficiary") @Valid Benificiary benificiary,BindingResult result, Model model,HttpSession session) {
			try {
				if (!result.hasErrors()) {			
					boolean status = this.userService.chkUserBeneficiary(benificiary);
					System.out.println("Beneficiary details : " + benificiary);
					if(status) {
						User u = (User) session.getAttribute("userdetails"); 
						if(u != null) {
							List<Benificiary> lstBen = u.getBenList();
							for (Benificiary benificiary2 : lstBen) {
								if(benificiary2.compare(benificiary2, benificiary) == 0) {
									System.out.println("Comparing value"+benificiary2.compare(benificiary2, benificiary));
									System.out.println("Benificiary already exist..");
									return "redirect:/transactions";
								}
							}						
							
							lstBen.add(benificiary);
							u.setBenList(lstBen);
							this.userService.addUserBenificiary(u);							
							System.out.println(session.getAttribute("userdetails"));
						}
						else {
							return "redirect:/login";
						}
						
					}		
					else {
						System.out.println("out of process of adding beficiary user does not exist :"+benificiary);
					}
					//return "redirect:/register";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//model.addAttribute("listEmployee", this.employeeDetailsService.getAllEmployeeDetails());
			return "redirect:/transactions";
		}		
		
		@RequestMapping(value = "/user/dotransaction", method = RequestMethod.POST)
		//@ExceptionHandler({ CustomException.class })
		public String doMoneyTransaction(@ModelAttribute("beneficiary") @Valid Transactions transactions,BindingResult result, Model model,HttpSession session) {
			try {
				if (!result.hasErrors()) {	
					User u = (User)session.getAttribute("userdetails");
					System.out.println("I am in process of doing transaction...to" + transactions);
					List<Account> lstAccnt = u.getLstAccount();
					if(lstAccnt.get(0).getBalance() > transactions.getAmount()) {
						lstAccnt.get(0).setBalance(lstAccnt.get(0).getBalance() - transactions.getAmount());
						
						System.out.println("Transaction of"+ transactions.getAmount()+" is allowed ...");
						transactions.setUserdetails(u);
						transactions.setTransactiondate(new Date());
						List<Transactions> lstTransactions = u.getLstTransaction();
						lstTransactions.add(transactions);
						u.setLstTransaction(lstTransactions);
						u.setLstAccount(lstAccnt);
						
						System.out.println(u);
						this.userService.addUserTransaction(u);
						String benAccntNo = transactions.getBenname().substring(transactions.getBenname().length()-12, transactions.getBenname().length());
						System.out.println("Benificiary account no is :"+benAccntNo);
						
						/*for (Benificiary ben : u.getBenList()) {
							if(ben.getAccountno().equals(benAccntNo)) {
								
							}
						}*/
						double bal = this.userService.getBalanceByAccNo(benAccntNo);						
						
						this.userService.updateBenificiaryBalance(benAccntNo,bal+transactions.getAmount());
						System.out.println(session.getAttribute("userdetails"));
					}
					else {
						System.out.println("Not enough money..");
					}
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//model.addAttribute("listEmployee", this.employeeDetailsService.getAllEmployeeDetails());
			return "redirect:/user/services";
		}		
	
	
}
