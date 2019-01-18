package com.ronaq.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ronaq.model.Transactions;
import com.ronaq.model.User;
import com.ronaq.service.IUserService;

@Controller
public class Dashboard {
	
	private IUserService userService;	
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value= {"/"})
	public ModelAndView loadhome() {
		//model.addAttribute("feedbackform", new Feedback());
		//model.addAttribute("listState",getStateList());
		ModelAndView mv = new ModelAndView("index.jsp");		
		return mv;
	}
	
	@RequestMapping(value= {"/dashboard","/user/dashboard"})
	public String loaddashboard(Model model,HttpSession session) {
		//model.addAttribute("feedbackform", new Feedback());
		User user = (User) session.getAttribute("userdetails");		
		model.addAttribute("listTransaction",user.getLstTransaction());
		model.addAttribute("listLoanApplication",user.getLstLoanApplications());
		System.out.println(user.getLstTransaction());
		return "dashboard";
	}
	
	
}
