package com.utc.beans;

public class Notes {
	
	 private String booktitle;
	 private String auteur;
	 private String isbn;
	 private int qWriting  ;
	 private int  iSubject;
	 private int dEnd;
	 private int  dAuteur;
	 private int recommend;
	 private int completed;
	 
	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur =auteur;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public int getqWriting() {
		return qWriting;
	}
	public void setqWriting(int qWriting) {
		this.qWriting = qWriting;
	}
	public int getiSubject() {
		return iSubject;
	}
	public void setiSubject(int iSubject) {
		this.iSubject = iSubject;
	}
	public int getdEnd() {
		return dEnd;
	}
	public void setdEnd(int dEnd) {
		this.dEnd = dEnd;
	}
	public int getdAuteur() {
		return dAuteur;
	}
	public void setdAuteur(int dAuteur) {
		this.dAuteur = dAuteur;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
