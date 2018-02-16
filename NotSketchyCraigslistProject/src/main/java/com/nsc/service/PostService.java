package com.nsc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsc.entity.Post;
import com.nsc.repository.PostRepository;
import com.nsc.repository.UserRepository;
@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	
	public ArrayList<Post> getPostsByUserId(int userId) {
		return postRepository.returnPost(userId);

	}
	
	public ArrayList<Post> getPostByCityCategory(String city, String category){
		return postRepository.returnCityCategoryPost(city, category);
	}
	
	public void savePost(Post post) {
		postRepository.save(post);
	}
	
	public void deletePost(int id) {
		postRepository.delete(id);
	}
	
	public Post getPostById(int id) {
		
		return postRepository.findOne(id);
	}
	
	public ArrayList<Post> searchPost(String searchPost, String city, String category){
	return postRepository.returnSearchPost(searchPost,city, category);
	}
	
	public void editPost(Post post) {
		postRepository.save(post);
	}
}
