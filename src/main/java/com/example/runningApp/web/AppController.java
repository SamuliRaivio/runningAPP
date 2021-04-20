package com.example.runningApp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.runningApp.domain.Run;
import com.example.runningApp.domain.RunRepository;
import com.example.runningApp.domain.User;
import com.example.runningApp.domain.UserRepository;

@Controller
public class AppController {
	
	@Autowired
	private RunRepository rRepository;
	
	@Autowired
	private UserRepository uRepository;
	
	@RequestMapping("/test")
	public @ResponseBody String greeting() {
        return "frontpage";
	}
	
	@RequestMapping("/allruns")
	public String allruns(Model model) {
		model.addAttribute("run", rRepository.findAll());
		return "allruns";
	}
	
	@RequestMapping("/myruns/{username}")
	public String myruns(@PathVariable("username") String username, Model model) {
		User user = uRepository.findByUsername(username);
		model.addAttribute("run", rRepository.findByUser(user));
		return "myruns";
	}
	
	@RequestMapping(value="/runs/{username}", method = RequestMethod.GET)
	public @ResponseBody List<Run> myrunsRest(@PathVariable("username") String username) {
		User user = uRepository.findByUsername(username);
		return rRepository.findByUser(user);
	}
	

}
