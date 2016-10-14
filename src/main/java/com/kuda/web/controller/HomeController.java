package com.kuda.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Created by kuda on 10/12/2016.
 */
@Controller
public class HomeController {
	private boolean loggedIn = false;
	private LoginBean loginBean = null;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		if(loggedIn) {
			return getHome(model);
		}else
			return login(model);
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome(Model model) {
		model.addAttribute("msg", loginBean.getUserName());
		model.addAttribute("page", "home");
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
		//System.out.println("*****************"+loginBean.getUserName()+"*********************");
		if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
			if (loginBean.getUserName().equals("kuda") && loginBean.getPassword().equals("kuda123")) {
				loggedIn = true;
				this.loginBean = loginBean;
				return getHome(model);
			} else {
				model.addAttribute("error", "Invalid Details");
				return "/login";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "/login";
		}
	}

}