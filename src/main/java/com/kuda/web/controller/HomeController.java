package com.kuda.web.controller;

import com.kuda.common.LoginDelegate;
import com.kuda.common.Project;
import com.kuda.common.rest.RestService;
import com.kuda.common.rest.impl.RestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kuda on 10/12/2016.
 */
@Controller
public class HomeController {
	private boolean loggedIn = false;
	private LoginBean loginBean = null;
	private String token;
	@Autowired
	private LoginDelegate loginDelegate;
	private RestServiceImpl restService;
	private Project[] projects;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		if(loggedIn) {
			return getHome();
		}else
			return login();
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView getHome() {
		ModelAndView model;
		if(loggedIn){
			model = new ModelAndView("home");
			model.addObject("msg", loginBean.getUserName());
			model.addObject("page", "home");
			restService = new RestServiceImpl(token);
			projects = (Project[])restService.get("");
			model.addObject("projects", projects);
			return model;
		}else {
			model = new ModelAndView("login");
			model.addObject("msg", "Please Enter Your Login Details");
			return model;
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		model.addObject("msg", "Please Enter Your Login Details");
		return model;
	}

	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView model = new ModelAndView("login");
		model.addObject("msg", "You have logged out");
		loggedIn = false;
		loginBean = null;
		token = null;
		projects = null;
		return model;
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("loginBean") LoginBean loginBean) {
		System.out.println("*********inside submit****************");
		System.out.println("loginbean == null? "+ loginBean.getUserName());
		System.out.println("logindelegate == null? "+ loginDelegate.equals(null));
		ModelAndView model = null;
		boolean isValidUser = false;
		Map response = new HashMap<>();
		if(loginDelegate != null && loginBean != null && !loginBean.getUserName().equals("") && !loginBean.getPassword().equals("")) {
			System.out.println("inside if statement -- username"+loginBean.getUserName());
			response = loginDelegate.isValidUser(loginBean.getUserName(), loginBean.getPassword());
			isValidUser = (boolean) response.get("success");
		}
		if(isValidUser) {
			loggedIn = true;
			this.loginBean = loginBean;
			token = response.get("token").toString();
			System.out.println("*********end submit****************");
			return getHome();
		}else{
			model = new ModelAndView("login");
			model.addObject("error", "Invalid Details");
			System.out.println("*********end submit****************");
			return model;
		}
	}

}