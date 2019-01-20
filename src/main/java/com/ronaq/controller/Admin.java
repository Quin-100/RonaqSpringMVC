package com.ronaq.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ronaq.model.LoanApplication;

import com.ronaq.model.User;
import com.ronaq.service.IUserService;

@Controller
public class Admin {
	private IUserService userService;	
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/adminlogin")
	public String loadadminlogin(Model model) {
		List<LoanApplication> lstloan = this.userService.getLoanApplications();
		if(lstloan.size() > 0) {
			User name = lstloan.get(0).getUserdetails();
			model.addAttribute("user",name);
			System.out.println("I had applied for loan"+name);
		}
		
		model.addAttribute("loanlst", lstloan);
		model.addAttribute("admindetails","suzaf");
		return "adminHome";
	}
	
	@RequestMapping("/approve/{id}")
	public String updateApproveLoan(@PathVariable("id") int id, Model model) {		
		if(id != 0) {
			this.userService.approveLoan(id);
			System.out.println("Loan approved"+id);
			return "redirect:/adminlogin";// view name
		}
		return "redirect:/adminlogin";
	}

	@RequestMapping("/reject/{id}")
	//@ExceptionHandler({ CustomException.class })
	public String updateRejectLoan(@PathVariable("id") int id) {
		if(id != 0) {
			this.userService.rejectLoan(id);
			System.out.println("Reject Loan"+id);
			return "redirect:/adminlogin";// view name
		}
		return "redirect:/adminlogin";
		
	}
	
	@RequestMapping(value = {"/admin/logout","/user"}, method = RequestMethod.GET)
	//@ExceptionHandler({ CustomException.class })
	public String logoutPerson(HttpSession session) {
		try {
				System.out.println("From admin Logut:"+session.getAttribute("admindetails"));				
				
				session.invalidate();				
				
				System.out.println("sesseion successfully invalidated");						
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//model.addAttribute("listEmployee", this.employeeDetailsService.getAllEmployeeDetails());
		return "redirect:/login";

	}	
	
	
}
