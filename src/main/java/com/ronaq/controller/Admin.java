package com.ronaq.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ronaq.model.Feedback;
import com.ronaq.model.LoanData;
import com.ronaq.model.User;
import com.ronaq.service.IUserService;

@Controller
public class Admin {
	private IUserService userService;	
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	
	@RequestMapping(value= {"/addloan","user/addloan"})
	public String loadregister(Model model) {
		model.addAttribute("loans", new LoanData());
		//model.addAttribute("listState",getStateList());
		return "admin";
	}
	
	@RequestMapping(value= {"/add/loan"})
	public void addLoan(@ModelAttribute("loans") @Valid LoanData u,BindingResult result, Model model) {
		System.out.println("Laon Info :" + u);
		//userService.addLoan(u);
		System.out.println("Loan Types are :------"+this.userService.getLoan());
	}
}
