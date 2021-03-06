package com.analyzer.model;

import java.util.List;
import java.util.Objects;

/**
 * Represents a LinkedIn User Post.
 *
 * @author Jason Zhang
 * @author Nick Scherer
 * @version 1.0
 * @since 1.0
 */
public class Post {

	// unique id, user written text, hashtags used, likes received,
	// number of comments and views
	private int postId;
	private String mainTextContent;
	private List<String> listOfHashTags;
	private int numOfLikes;
	private int numOfComments;
	private int numOfViews;

	/**
	 * Creates an empty Post.
	 */
	public Post() {
		super();
	}

	/**
	 * Creates a Post containing only an Id.
	 *
	 * @param postId The post's unique ID.
	 */
	public Post(int postId) {
		setPostId(postId);
	}

	/**
	 * Creates a Post with all fields minus its views.
	 *
	 * @param postId          The post's unique ID.
	 * @param mainTextContent The post's text body.
	 * @param listOfHashTags  The post's hashtags.
	 * @param numOfLikes      The post's number of likes.
	 * @param numOfComments   The post's number of comments.
	 */
	public Post(int postId, String mainTextContent, List<String> listOfHashTags,
	            int numOfLikes, int numOfComments) {
		this(postId);
		setMainTextContent(mainTextContent);
		setListOfHashTags(listOfHashTags);
		setNumOfLikes(numOfLikes);
		setNumOfComments(numOfComments);
	}

	/**
	 * Creates a Post with all fields.
	 *
	 * @param postId          The post's unique ID.
	 * @param mainTextContent The post's text body.
	 * @param listOfHashTags  The post's hashtags.
	 * @param numOfLikes      The post's number of likes.
	 * @param numOfComments   The post's number of comments.
	 * @param numOfViews      The post's number of views.
	 */
	public Post(int postId, String mainTextContent, List<String> listOfHashTags,
	            int numOfLikes, int numOfComments, int numOfViews) {
		this(postId, mainTextContent, listOfHashTags,
				numOfLikes, numOfComments);
		setNumOfViews(numOfViews);
	}

	/**
	 * Gets the Post's ID.
	 *
	 * @return An int representing the Post's ID.
	 */
	public int getPostId() {
		return postId;
	}

	/**
	 * Sets the Post's ID.
	 *
	 * @param postId An int representing the Post's ID.
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}

	/**
	 * Gets Post's main text body.
	 *
	 * @return A string representing all of the Post's primary text.
	 */
	public String getMainTextContent() {
		return mainTextContent;
	}

	/**
	 * Sets the Post's main text body.
	 *
	 * @param mainTextContent A string representing all of the Post's primary text.
	 */
	public void setMainTextContent(String mainTextContent) {
		this.mainTextContent = mainTextContent;
	}

	/**
	 * Gets the Post's hashtags.
	 *
	 * @return A List of Strings each representing a used hashtag.
	 */
	public List<String> getListOfHashTags() {
		return listOfHashTags;
	}

	/**
	 * Sets the Post's hashtag list.
	 *
	 * @param listOfHashTags A List of Strings each representing a used hashtag.
	 */
	public void setListOfHashTags(List<String> listOfHashTags) {
		this.listOfHashTags = listOfHashTags;
	}

	/**
	 * Gets the Post's number of likes.
	 *
	 * @return An int representing the number of likes
	 * that the post has received.
	 */
	public int getNumOfLikes() {
		return numOfLikes;
	}

	/**
	 * Sets the Post's number of likes.
	 *
	 * @param numOfLikes An int representing the number of likes
	 *                   that the post has received.
	 */
	public void setNumOfLikes(int numOfLikes) {
		this.numOfLikes = numOfLikes;
	}

	/**
	 * Gets the Post's number of comments.
	 *
	 * @return An int representing the number of comments
	 * that the post has received.
	 */
	public int getNumOfComments() {
		return numOfComments;
	}

	/**
	 * Sets the Post's number of comments.
	 *
	 * @param numOfComments An int representing the number of comments
	 *                      that the post has received.
	 */
	public void setNumOfComments(int numOfComments) {
		this.numOfComments = numOfComments;
	}

	/**
	 * Gets the Post's number of views.
	 *
	 * @return An int representing the number of views
	 * that the post has received.
	 */
	public int getNumOfViews() {
		return numOfViews;
	}

	/**
	 * Sets the Post's number of views.
	 *
	 * @param numOfViews An int representing the number of views
	 *                   that the post has received.
	 */
	public void setNumOfViews(int numOfViews) {
		this.numOfViews = numOfViews;
	}

	/**
	 * Determines equality compared to another Post object.
	 *
	 * @param comparePost the Post object to compare against.
	 * @return boolean whether or not the two Post objects are equal.
	 */
	@Override
	public boolean equals(Object comparePost) {
		if (this == comparePost) return true;
		if (comparePost == null || getClass() != comparePost.getClass()) return false;
		Post post = (Post) comparePost;
		return postId == post.postId &&
				numOfViews == post.numOfViews &&
				numOfLikes == post.numOfLikes &&
				Objects.equals(mainTextContent, post.mainTextContent) &&
				Objects.equals(listOfHashTags, post.listOfHashTags);
	}

	/**
	 * Determines the hashCode of a Post object.
	 *
	 * @return int of the Post's generated hashcode.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(postId, numOfViews, numOfLikes, mainTextContent);
	}

	/**
	 * Determines equality compared to another Post object.
	 *
	 * @return String representation of a Post object and its fields.
	 */
	@Override
	public String toString() {
		return "Post{" +
				"postid=" + postId +
				", text='" + mainTextContent + '\'' +
				", hashtags='" + listOfHashTags.toString() + '\'' +
				", likes=" + numOfLikes +
				", likes=" + numOfComments +
				", views=" + numOfViews +
				'}';
	}

}