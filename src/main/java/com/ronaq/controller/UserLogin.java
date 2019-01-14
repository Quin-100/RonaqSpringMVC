package com.ronaq.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ronaq.model.Login;
import com.ronaq.model.User;
import com.ronaq.service.IUserService;

@Controller
public class UserLogin {
	private IUserService userService;
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/login")
	public String loadlogin(Model model) {
		model.addAttribute("login", new Login());
		//model.addAttribute("listState",getStateList());
		return "login";
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	//@ExceptionHandler({ CustomException.class })
	public String loginPerson(@ModelAttribute("login") Login l,BindingResult result, Model model) {
		try {
			if (!result.hasErrors()) {			
				if (!l.getUsername().isEmpty()) {
						// new user, add it		
						//User user = handleFileUpload(result, fileUpload, u);
						boolean status = this.userService.chkUserForLogin(l);
						if(status) {
							
							return "dashboard";
						}
						else {
							return "login";
						}
				} else {
						// existing person, call update
						//this.employeeDetailsService.updateEmployeeDetails(p);
				}
				//return "redirect:/login";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//model.addAttribute("listEmployee", this.employeeDetailsService.getAllEmployeeDetails());
		return "login";

	}	
}
