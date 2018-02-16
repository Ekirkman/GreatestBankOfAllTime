package com.nsc.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	@Column
	private String userName;
	@Column
	private String email;
	@Column
	private int rating;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int userId;

	@Column
	private  int numberOfReviews;
	@Column
	private int totalReviewPoints;
	
	@Column
	private String password;
	
	@Column
	private String city;
	
	
	public User() {}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNumberOfReviews() {
		return numberOfReviews;
	}

	public void setNumberOfReviews(int numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}

	public int getTotalReviewPoints() {
		return totalReviewPoints;
	}

	public void setTotalReviewPoints(int totalReviewPoints) {
		this.totalReviewPoints = totalReviewPoints;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", rating=" + rating + ", userId=" + userId
				+ ", numberOfReviews=" + numberOfReviews + ", totalReviewPoints=" + totalReviewPoints + ", password="
				+ password + "]";
	}
	 
	
}
