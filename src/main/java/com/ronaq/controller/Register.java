package com.ronaq.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ronaq.model.Account;
import com.ronaq.model.SecurityQuestion;
import com.ronaq.model.User;
import com.ronaq.service.IUserService;

@Controller
public class Register {
	
	private IUserService userService;	
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/register")
	public String loadregister(Model model) {
		model.addAttribute("user", new User());
		List<SecurityQuestion> lst = this.userService.getSecurityQuestions();
		
		model.addAttribute("securityquestions",lst);
		//model.addAttribute("listState",getStateList());
		return "register";
	}
	
	// For add and update person both
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	//@ExceptionHandler({ CustomException.class })
	public String addUser(@ModelAttribute("user") @Valid User u,BindingResult result, Model model) {
		try {
			if (!result.hasErrors()) {			
				if (u.getId() == null || u.getId() == 0) {
						
						Account acc = new Account();
						acc.setUserdetails(u);						
						acc.setAccountNo(acc.generateAccountNo());
						
						List<Account> lstAcc = new ArrayList<Account>();
						lstAcc.add(acc);
						
						u.setLstAccount(lstAcc);						
						
						
						System.out.println("Hello thier i want to get registered :"+u);
						
						boolean status = this.userService.chkUserForRegistration(u);
						if(!status) {
							this.userService.createUser(u);
							return "redirect:/login";
						}
						else {
							System.out.println("Already registered with same email and password for this account.");
							return "redirect:/register";
						}
				} else {
						
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "register";

	}		
}

