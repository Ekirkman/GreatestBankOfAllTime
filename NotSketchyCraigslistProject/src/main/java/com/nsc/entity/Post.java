package com.nsc.entity;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
@Column
private int userId;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column
private int postId;
@Column
private String postCategory;
@Column
private byte[] postPic;
@Column
private String postTitle;
@Column
private String postDescription;
@Column
private String postCity;

public Post() {}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public int getPostId() {
	return postId;
}

public void setPostId(int postId) {
	this.postId = postId;
}

public String getPostCategory() {
	return postCategory;
}

public void setPostCategory(String postCategory) {
	this.postCategory = postCategory;
}

public byte[] getPostPic() {
	return postPic;
}

public void setPostPic(byte[] postPic) {
	this.postPic = postPic;
}

public String getPostTitle() {
	return postTitle;
}

public void setPostTitle(String postTitle) {
	this.postTitle = postTitle;
}

public String getPostDescription() {
	return postDescription;
}

public void setPostDescription(String postDescription) {
	this.postDescription = postDescription;
}

public String getPostCity() {
	return postCity;
}

public void setPostCity(String postCity) {
	this.postCity = postCity;
}

public String showPicture(){
    String encoded = "";
    if(postPic != null && postPic.length>0){
            encoded = Base64.getEncoder().encodeToString(postPic);
      }
     return encoded;
}


}
