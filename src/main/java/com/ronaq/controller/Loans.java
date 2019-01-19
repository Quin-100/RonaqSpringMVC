package com.ronaq.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ronaq.model.LoanData;
import com.ronaq.model.Transactions;
import com.ronaq.model.User;
import com.ronaq.model.Account;
import com.ronaq.model.Benificiary;
import com.ronaq.model.LoanApplication;
import com.ronaq.service.IUserService;

import oracle.net.aso.r;

@Controller
public class Loans {
	
	private IUserService userService;	
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value= {"/loans","/user/loans"})
	public String loadloans(Model model,HttpSession session) {
		//model.addAttribute("feedbackform", new Feedback());	
		//System.out.println(this.userService.getBen(7));
		session.removeAttribute("userloan");
		return "loan";
	}
	
	@RequestMapping(value="/user/applyloan/{id}")
	public String showEditPersonPage(
			@PathVariable("id") int id, Model model,HttpSession session) {
		if(session.getAttribute("userdetails") == null) {
			System.out.println("You are not loggged in as a user");
			return "redirect:/login";
		}
		else {
			User u = (User) session.getAttribute("userdetails");
			LoanData loandata = this.userService.getLoanById(id);
			session.setAttribute("userloan", loandata);
			System.out.println("Loan data is :--------"+loandata);
			//model.addAttribute("loanid",loandata.getLoanId());
			model.addAttribute("loandata",loandata);
			model.addAttribute("loantype",loandata.getLoantype());
			model.addAttribute("duration",loandata.getRepaylimit());
			model.addAttribute("rateofinterest",loandata.getLoanrate());
			model.addAttribute("loanform",new LoanApplication());
			return "loanapplication";// view name
		}		
	}
	
	@RequestMapping(value="/user/calcreturnamount")
	public String calcReturnAmount(
			@ModelAttribute("loanform") @Valid LoanApplication loanApplication,BindingResult result, Model model,HttpSession session) {
		if(session.getAttribute("userdetails") == null) {
			System.out.println("You are not loggged in as a user");
			return "redirect:/login";
		}
		else {
			if(session.getAttribute("userloan") != null) {
				LoanData loanData = (LoanData) session.getAttribute("userloan");
				//loanApplication.s
				session.setAttribute("loanamount", loanApplication.getAmount());
				double amt = loanApplication.getAmount();
				float rate = loanData.getLoanrate();
				int repaylimit = loanData.getRepaylimit();
				
				float retamt = (float) returnAmt(amt,rate,repaylimit);
				session.setAttribute("returnamt", retamt);
				
				User u = (User) session.getAttribute("userdetails");
				List<Account> lstAccounts = u.getLstAccount();
				List<Transactions> lstTransactions = u.getLstTransaction();
				
				System.out.println("i am in calcReturnAmount --- "+u+" ----"+lstAccounts.get(0).getBalance()+"--"+lstTransactions.size());
				
				int cibil = calcCibil(lstAccounts.get(0).getBalance(),lstTransactions.size(),u.getDob());
				
				System.out.println("I am in process of loan applying-------with cibil :"+ cibil);
				System.out.println("I am in process of loan applying-------with retamt  :"+ retamt);				
				
				model.addAttribute("cibil",cibil);
				model.addAttribute("retamt",retamt);
				//model.addAttribute("loandata",loanData);
				return "loaneligibility";
				
			}						
			return "redirect:/user/loans";// view name
		}	
	}
	
	@RequestMapping(value="/user/loanapplication")
	public String processLoanApplication(Model model,HttpSession session) {
		if(session.getAttribute("userdetails") == null) {
			System.out.println("You are not loggged in as a user");
			return "redirect:/login";
		}
		else {
			if(session.getAttribute("userloan") != null) {
				User u = (User) session.getAttribute("userdetails");
				LoanData loanData = (LoanData) session.getAttribute("userloan") ;
				
				LoanApplication loanApplication = new LoanApplication();
				
				loanApplication.setLoantype(loanData.getLoantype());
				loanApplication.setRepaylimit(loanData.getRepaylimit());
				loanApplication.setAmount((Double) session.getAttribute("loanamount"));
				loanApplication.setLoanrate(loanData.getLoanrate());
				loanApplication.setReturnamount((Float) session.getAttribute("returnamt"));
				loanApplication.setStatus("Pending");
				loanApplication.setUserdetails(u);
				
				List<LoanApplication> lstApplications = u.getLstLoanApplications();
				
				lstApplications.add(loanApplication);
				u.setLstLoanApplications(lstApplications);
				this.userService.addLoanApplication(u);							
				System.out.println(session.getAttribute("userdetails"));
				return "redirect:/user/dashboard";// view name
			}
			else {
				System.out.println("select proper loan type");
				return "redirect:/user/loans";
			}			
			
		}				
	}
	
	public double returnAmt(double amt, float rate, int repaylimit) {
		repaylimit = repaylimit * 12;
		double emi;
		double returnamt;
		rate = ((rate/12)/100);
		double numerator = Math.pow((1+rate), repaylimit);
		double denominator = Math.pow((1+rate), repaylimit-1);
		
		emi = amt * rate * (numerator/denominator);
		
		returnamt = emi * repaylimit;
		
		System.out.println("Your emi is :"+emi+" and return amount is :"+returnamt );
		
		return returnamt;
	}
	
	public int calcCibil(double balance, int lsttrans, String dob) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
		//convert String to LocalDate
		LocalDate db = LocalDate.parse(dob, formatter); //Birth date
		 
		LocalDate today = LocalDate.now(); 
		 
		Period p = Period.between(db, today);	 
		
		int age ;
		if(p.getYears() != 0) {
			age = p.getYears();
		}
		else if(p.getMonths() != 0) {
			age = p.getYears();
		}
		else {
			age = p.getDays();
		}	
		
		int cibil = (int) (((balance / 300) * lsttrans) + 300 + age);
		
		if(cibil > 900) {
			cibil = (int) getRandomDoubleBetweenRange(800, 890);
		}
		if(cibil < 300) {
			cibil = (int) getRandomDoubleBetweenRange(300, 390);
		}
		
		System.out.println("Your age in days is :"+p.getDays() );
		System.out.println("Your age in months is :"+p.getMonths() );
		System.out.println("Your age in years is :"+p.getYears() );
		System.out.println("Your cibil score is :"+cibil );
		
		return cibil;
	}
	

	public static double getRandomDoubleBetweenRange(double min, double max){
	    double x = (Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	
	
	
	

}
