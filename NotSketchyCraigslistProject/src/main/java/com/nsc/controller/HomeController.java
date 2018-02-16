package com.nsc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nsc.entity.EmailSender;
import com.nsc.entity.Post;
import com.nsc.entity.User;
import com.nsc.service.PostService;
import com.nsc.service.UserService;

@Controller
public class HomeController {
	

	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/")
	public String pub() {
		return "index";

	}
	
	@RequestMapping(value="/categories",  method=RequestMethod.GET)
	public String categories(@RequestParam("city") String city, HttpSession session) {
		session.setAttribute("city", city);
		return "categories";

	}
	@RequestMapping("/contactPage")
	public ModelAndView contactPage() {
		EmailSender email = new EmailSender();
		return new ModelAndView("contactPage","email", email);
}
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	

	
	@RequestMapping(value="/forsale", method=RequestMethod.GET)
	public ModelAndView forsale(@RequestParam("category") String category, HttpSession session) {
		String city = (String)session.getAttribute("city");
		session.setAttribute("category", category);
		ArrayList<Post> categoryPost= postService.getPostByCityCategory(city, category);
		session.setAttribute("categoryPost", categoryPost);
		return new ModelAndView("forsale");
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login() {
		User user = new User();
		return new ModelAndView("login", "user",user);
	}
	@RequestMapping("/messageSent")
	public String messageSent() {
		return "messageSent";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView signup() {
		User user = new User();
		return new ModelAndView("signup", "user",user);
	}
	@RequestMapping("/viewPoster")
	public ModelAndView viewPoster() {
		return new ModelAndView( "viewPoster");
	}
	@RequestMapping("/viewProfile")
	public ModelAndView viewProfile(HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user == null)
			return new ModelAndView("login","user", new User());
		double updateRating = user.getRating();
		double noOfRating = user.getNumberOfReviews();
		double averageRating = updateRating/noOfRating;
		double avgRating = Math.round(averageRating * 100.0) / 100.0;

		session.setAttribute("avgRating", avgRating);
		ArrayList<Post> posts = postService.getPostsByUserId(user.getUserId());
		session.setAttribute("posts", posts);
		return new ModelAndView("viewProfile");
	}
	
}