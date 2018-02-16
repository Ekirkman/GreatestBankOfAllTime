package com.nsc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nsc.entity.EmailSender;
import com.nsc.entity.Post;
import com.nsc.entity.User;
import com.nsc.service.PostService;
import com.nsc.service.SendMail;
import com.nsc.service.UserService;


@Controller
public class PostController {
	

	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SendMail sendMail;
	

	@RequestMapping(value="/addPost", method=RequestMethod.POST)
	public ModelAndView savePost(@RequestParam("post")Post post, HttpSession session)
	{
	
		postService.savePost(post);
		System.out.println("Post Created"+post.getPostTitle()+post.getPostDescription());
		return new ModelAndView("postCreated");
	}
	@RequestMapping(value="/postDetails" ,method=RequestMethod.POST)
	public ModelAndView postDetails(@RequestParam("id")int id) {
		System.out.print(id);
		return new ModelAndView("postDetails");
	}
	@RequestMapping(value="deletePost", method=RequestMethod.GET)
	public ModelAndView deletePost(@RequestParam("id")int id, HttpSession session) {
		postService.deletePost(id);
		User user = (User)session.getAttribute("user");
		
		ArrayList<Post> posts = postService.getPostsByUserId(user.getUserId());
		session.setAttribute("posts", posts);
		System.out.print("delete");
		return new ModelAndView("viewProfile");
	}
	
	@RequestMapping(value="/postCreated", method=RequestMethod.POST)
	public ModelAndView postCreated(Model model, @ModelAttribute("post") Post post, HttpSession session) {
		User user = (User)session.getAttribute("user");
		post.setUserId(user.getUserId());
		postService.savePost(post);
		session.setAttribute("post", post);
		return new ModelAndView("postCreated");
	}
	
	@RequestMapping(value="/postDetails", method=RequestMethod.GET)
	public ModelAndView postDetailsDisplay(@RequestParam("postId")int id, HttpSession session) {
		Post post = postService.getPostById(id);
		
		
		
		User toUser = userService.getUserById(post.getUserId());
		double updateRating = toUser.getRating();
		double noOfRating = toUser.getNumberOfReviews();
		double averageRating = updateRating/noOfRating;
		double avgRating = Math.round(averageRating * 100.0) / 100.0;
		session.setAttribute("avgRating", avgRating);
		session.setAttribute("posterInfo", toUser);
		session.setAttribute("post", post);
		User fromUser = (User)session.getAttribute("user");
		if(fromUser == null)
		{
			return new ModelAndView("login","user", new User());
		}
		
		EmailSender emailSender = new EmailSender();
		emailSender.setFromEmail(fromUser.getEmail());
		emailSender.setToEmail(toUser.getEmail());
		emailSender.setSubject("New Message From Thirsty Thursdays");
		
		return new ModelAndView("postDetails","email", emailSender);
	}
	
	@RequestMapping(value="/createAPost", method=RequestMethod.GET)
	public ModelAndView createAPost(Model model) {
		return new ModelAndView("createAPost","post",new Post());
	}
	
	@RequestMapping(value="/sendEmailToPoster", method=RequestMethod.POST)
	public ModelAndView sendEmailToPoster(Model model, @ModelAttribute("email") EmailSender email) {
		System.out.println(email);
		sendMail.sendMail(email.getToEmail(), email.getSubject(), email.getMessage(), email.getFromEmail());
		return new ModelAndView("messageSent");
	}
	
	@RequestMapping(value="/editPost", method=RequestMethod.GET)
	public ModelAndView postEdit(@RequestParam("id")int id, HttpSession session) {
		Post post = postService.getPostById(id);
		session.setAttribute("post", post);
		return new ModelAndView("editPost","post", post);
	}
	
	@RequestMapping(value="/postUpdate", method=RequestMethod.POST)
	public ModelAndView postUpdate(@ModelAttribute("post")Post post, HttpSession session) {
		 postService.savePost(post);
		return new ModelAndView("viewProfile","post", post);
	}
	
	@RequestMapping(value = "/rate", method = RequestMethod.GET)
	public ModelAndView test(Model model,@RequestParam("rating")int rating, @RequestParam("postId")int postId,HttpSession session) {
	System.out.println("Rating received: "+rating);
	
	Post post = postService.getPostById(postId);
	User poster= userService.getUserById(post.getUserId());
	System.out.println(poster);

	User fromUser = (User)session.getAttribute("user");
	int updateRating = poster.getRating()+rating;
	poster.setRating(updateRating);

	int noOfRating = poster.getNumberOfReviews()+1;
	poster.setNumberOfReviews(noOfRating);
	userService.saveUser(poster);
	double avgRating = updateRating/noOfRating;

	session.setAttribute("avgRating", avgRating);
	session.setAttribute("user", poster);
	
	EmailSender emailSender = new EmailSender();
	emailSender.setFromEmail(fromUser.getEmail());
	emailSender.setToEmail(poster.getEmail());
	emailSender.setSubject("Inquiry");
	return new ModelAndView("postDetails","email", new EmailSender());
	}

	
	
	@RequestMapping(value="/searchPost", method=RequestMethod.GET)
	public ModelAndView searchPost(@RequestParam("mySearch")String search, HttpSession session) {
		System.out.println("Search parameter from view : "+search);
		String city = (String)session.getAttribute("city");
		String category = (String)session.getAttribute("category");
		ArrayList<Post> foundPost= postService.searchPost(search,city,category);
		System.out.println(search+city+category);
		session.setAttribute("categoryPost", foundPost);
		return new ModelAndView("forsale");
	}
	
	@RequestMapping(value="/postPic",method=RequestMethod.POST)
	public String upload(@RequestParam("file")MultipartFile file,HttpSession session,Model model) {
	Post post=(Post)session.getAttribute("post");
	
	//TEST CODE
	
	User user = (User)session.getAttribute("user");
	
	ArrayList<Post> posts = postService.getPostsByUserId(user.getUserId());
	session.setAttribute("posts", posts);
	
	//TEST CODE ENDS HERE
	try {
	post.setPostPic(file.getBytes());
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	postService.savePost(post); 

	return "viewProfile";

	}
	
	@RequestMapping(value="/updatePic",method=RequestMethod.POST)
	public ModelAndView updatePic(@RequestParam("file")MultipartFile file,HttpSession session,Model model) {
		Post post=(Post)session.getAttribute("post");
		
		System.out.println(post);
	try {
	post.setPostPic(file.getBytes());
	postService.savePost(post);
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	 return new ModelAndView("editPost","post",post);

	}
}