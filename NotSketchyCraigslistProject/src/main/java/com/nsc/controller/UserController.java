package com.nsc.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nsc.entity.EmailSender;
import com.nsc.entity.Post;
import com.nsc.entity.User;
import com.nsc.service.PostService;
import com.nsc.service.SendMail;
import com.nsc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private SendMail sendMail;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	

	@RequestMapping(value="signUp", method=RequestMethod.POST)
	public ModelAndView signUp(Model model, @ModelAttribute("user") User user)
	{
		if(user.getEmail().contains("asu.edu" )|| user.getEmail().contains("ua.edu" ) ||user.getEmail().contains("uiowa.edu" ) || user.getEmail().contains("umich.edu" ) || user.getEmail().contains("duke.edu" ) || user.getEmail().contains("missouri.edu" )|| user.getEmail().contains("fsu.edu" )|| user.getEmail().contains("cornell.edu" ) || user.getEmail().contains("colostate.edu" ) ||user.getEmail().contains("uiowa.edu" ) || user.getEmail().contains("gmail.com" ) ) {
		userService.saveUser(user);
		sendMail.sendMail(user.getEmail(), "Welcome to Thirsty Thursdays!!!! ", "Welcome to Thirsty Thursdays the cool way to stay connect and find all the best events, deals and people on campus. Please feel free to browse all areas of the site. If you for any reason find one of our post offensive, not safe, or generally sketchy dont hessitate to contact us as safety is our #1 concern. Most importantly dont forget to rate your poster as this is esssential to keeping our community safe.   Thanks,Thirsty Thursday", "thirstyxthursday@gmail.com");
		return new ModelAndView("login");
		} else 
			return new ModelAndView("invalidStudentEmail");
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login(Model model, @ModelAttribute("user") User user, HttpSession session)
	{
		
		User loggedInUser = userService.login(user.getUserName(), user.getPassword());
		if(loggedInUser != null)
		{
			double updateRating = loggedInUser.getRating();
			double noOfRating = loggedInUser.getNumberOfReviews();
			double averageRating = updateRating/noOfRating;
			double avgRating = Math.round(averageRating * 100.0) / 100.0;
			session.setAttribute("avgRating", avgRating);
			ArrayList<Post> posts = postService.getPostsByUserId(loggedInUser.getUserId());
			session.setAttribute("posts", posts);
			session.setAttribute("user", loggedInUser);
			return new ModelAndView("viewProfile", "user", loggedInUser);
		}
		else
			return new ModelAndView("login");
		
	}
	
	@RequestMapping(value="contactPage", method=RequestMethod.POST)
	public ModelAndView contactPage(Model model, @ModelAttribute("email") EmailSender email)
	{
		System.out.println("Email details: "+email.toString());
		sendMail.getMail(email.getFromEmail(), email.getSubject(), email.getMessage());
		return new ModelAndView("login", "user", new User());
	}
	
	@RequestMapping(value="contactPoster", method=RequestMethod.POST)
	public ModelAndView  contactPoster( Model model, @ModelAttribute("message") EmailSender email, HttpSession session)
	{
		User user = (User)session.getAttribute("user");
		
		//sendMail.sendMail(,"NSC Post Inquiry", email.getMessage(),user.getEmail());
		return new ModelAndView("");
				
	}
	
	
}
