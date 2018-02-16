package com.nsc.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nsc.entity.Post;
import com.nsc.entity.User;

public interface PostRepository extends JpaRepository<Post, Integer>{

	@Query("Select P from Post P where userId=:userId")
	public ArrayList<Post> returnPost(@Param("userId") int userId);
	
	@Query("Select P from Post P where postCity=:city and postCategory=:category")
	public ArrayList<Post> returnCityCategoryPost(@Param("city")String city, @Param("category")String category);
	
	@Query("Select P.userId from Post P  where P.postId=:id")
	public int getUserIdByPostId(@Param("id") int id);
	
	@Query("Select P from Post P where (postDescription like %:searchPost% or postTitle like %:searchPost%) and (postCity=:city and postCategory=:category )")
	public ArrayList<Post> returnSearchPost(@Param("searchPost") String searchPost,@Param("city")String city, @Param("category")String category);
	
	/*@Query("Remove postDescription, PostTitle from Post P where postId=:postId")
	@Query("Insert postDescription, PostTitle from Post P where postId=:postId")
	public void editPost(@Param("post")Post post);*/
}
