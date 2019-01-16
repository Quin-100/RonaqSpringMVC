package com.ronaq.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ronaq.model.Account;
import com.ronaq.model.Feedback;
import com.ronaq.model.User;
import com.ronaq.service.IUserService;

@Controller
public class AboutUs {
	
	private IUserService userService;	
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	
	@RequestMapping(value= {"/aboutus","/user/aboutus"})
	public String loadregister(Model model) {
		model.addAttribute("feedbackform", new Feedback());
		//model.addAttribute("listState",getStateList());
		return "aboutus";
	}
	
	@RequestMapping(value="/info@gmail.com")
	public String loadmail() {
		//model.addAttribute("user", new User());
		//model.addAttribute("listState",getStateList());
		return "aboutus";
	}
	
	// For add and update person both
	@RequestMapping(value = "/user/feedback", method = RequestMethod.POST)
	//@ExceptionHandler({ CustomException.class })
	public String addFeedback(@ModelAttribute("feedbackform") @Valid Feedback feedback,BindingResult result, Model model) {
		try {
			if (!result.hasErrors()) {	
				this.userService.addFeedback(feedback);	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//model.addAttribute("listEmployee", this.employeeDetailsService.getAllEmployeeDetails());
		return "redirect:/aboutus";
	}			

}
