package com.utc.beans;
public class Book {
	Long  bookId;
	String title;
	String ISBN;
	String genre;
	String auteur;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Long bookId, String title, String genre, String auteur) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.genre = genre;
		this.auteur = auteur;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
}
