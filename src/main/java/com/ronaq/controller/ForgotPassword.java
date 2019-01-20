package com.ronaq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ronaq.model.Login;
import com.ronaq.model.User;
import com.ronaq.service.IUserService;

@Controller
public class ForgotPassword {
	
private IUserService userService;	
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value= {"/forgotpassword"})
	public String loadForgotPassword(Model model) {
		model.addAttribute("user",new User());		
		return "forgotpassword";
	}
	
	@RequestMapping(value= {"/resetpassword"})
	public String loadResetPassword(Model model,HttpSession session) {
		model.addAttribute("user", session.getAttribute("user"));			
		return "forgotpassword";
	}

	@RequestMapping(value = "/user/forgotpassword")
	//@ExceptionHandler({ CustomException.class })
	public String chkUserInformation(@ModelAttribute("user") @Valid User u,BindingResult result, Model model,HttpSession session) {
		try {					
				 String email = u.getEmail();
				 String secques = u.getSecurityQuestion();
				 String ans = u.getSecurityAnswer();
			 	
				 System.out.println("I want to change pass :"+email+" , "+secques+" , "+ ans);
				 
				 boolean status = userService.chkUserForForgotPassword(email,secques,ans);
				 if(status) {
					 System.out.println("i am valid user..");
					 User user = userService.findUserByEmail(email);					
					 session.setAttribute("user",user);
					 return "resetpassword";
				 }
				 else {
					 System.out.println("Invalid information provided...");
					 return "redirect:/forgotpassword";
				 }			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "resetpassword";

	}	
	
	@RequestMapping(value = "/user/resetpassword")
	//@ExceptionHandler({ CustomException.class })
	public String resetPassword(@ModelAttribute("user") @Valid User u,BindingResult result, Model model,HttpSession session) {
		try {					
				 String password = u.getPassword();
				 User user = (User) session.getAttribute("user");
				 int id = user.getId();				 
				 this.userService.updatePassword(password, id);
				 session.removeAttribute("user");
				 return "redirect:/login";				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "resetpassword";

	}	
}
