package com.example.domain;

public class comment {
	private int comid;
	private String comment;
	private String commentOwner;
	private int commentGood;
	public int getComid() {
		return comid;
	}
	public void setComid(int comid) {
		this.comid = comid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCommentOwner() {
		return commentOwner;
	}
	public void setCommentOwner(String commentOwner) {
		this.commentOwner = commentOwner;
	}
	public int getCommentGood() {
		return commentGood;
	}
	public void setCommentGood(int commentGood) {
		this.commentGood = commentGood;
	}
}
