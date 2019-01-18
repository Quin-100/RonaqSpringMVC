package com.ronaq.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ronaq.model.LoanData;
import com.ronaq.model.User;
import com.ronaq.model.LoanApplication;
import com.ronaq.service.IUserService;

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
			System.out.println("Loan data is :--------"+loandata);
			model.addAttribute("loanid",loandata.getLoanId());
			model.addAttribute("loanform",new LoanApplication());
			return "loanapplication";// view name
		}		
	}

}
