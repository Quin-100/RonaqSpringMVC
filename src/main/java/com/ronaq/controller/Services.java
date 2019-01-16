package com.ronaq.controller;

import java.util.ArrayList;
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
		//model.addAttribute("feedbackform", new Feedback());
		//model.addAttribute("listState",getStateList());
		return "services";
	}
	
	@RequestMapping(value= {"/transactions","/user/transactions"})
	public String loadmoneytransfer() {
		//model.addAttribute("feedbackform", new Feedback());
		//model.addAttribute("listState",getStateList());
		return "transactions";
	}
	
	@RequestMapping(value="/samebranch")
	public String loadsamebranch() {
		//model.addAttribute("feedbackform", new Feedback());
		//model.addAttribute("listState",getStateList());
		return "transactions";
	}
	
	@RequestMapping(value="/differentbranch")
	public String loaddifferentbranch() {
		//model.addAttribute("feedbackform", new Feedback());
		//model.addAttribute("listState",getStateList());
		return "transactions";
	}
	
	@RequestMapping(value= {"/beneficiary","/user/beneficiary"})
	public String loadbeneficiary(HttpSession httpSession,Model model) {
		//model.addAttribute("feedbackform", new Feedback());
		//model.addAttribute("listState",getStateList());
		if(httpSession.getAttribute("username") == null && httpSession.getAttribute("password") == null) {
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
		public String addBeneficiary(@ModelAttribute("beneficiary") @Valid Benificiary benificiary,BindingResult result, Model model) {
			try {
				if (!result.hasErrors()) {			
					boolean status = this.userService.chkUserBeneficiary(benificiary);
					if(status) {
						System.out.println("I am in process of adding beneficiary"+benificiary);
					}
					
							// new user, add it		
							//User user = handleFileUpload(result, fileUpload, u);
							//set date
							/*Date formaDate = new SimpleDateFormat("dd/MM/yyyy").parse(u.getDob());
				            String dob = formaDate.format(u.getDob());
		
				            u.setDob(formaDate.parse(dob));*/
						
						
							/*List<Account> lstAccount = new ArrayList<Account>();
							u.setLstAccount(lstAccount);
							Account acc = new Account();
							acc.setUserdetails(u);
							
							acc.setAccountNo(acc.generateAccountNo());
							List<Account> lstAcc = new ArrayList<Account>();
							lstAcc.add(acc);
							u.setLstAccount(lstAcc);
							boolean status = this.userService.chkUserForRegistration(u);
							if(!status) {
								this.userService.createUser(u);
								return "redirect:/login";
							}
							else {
								System.out.println("Already registered with same email and account type");
								return "redirect:/register";
							}*/
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
			return "redirect:/register";
		}		
	
	
}
