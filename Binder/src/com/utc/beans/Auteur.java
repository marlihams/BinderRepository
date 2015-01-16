package com.utc.beans;

import java.util.HashSet;
import java.util.Set;

public class Auteur {

	private Long auteurId;
	private String name ;
	Set<Book> books=new HashSet<Book>();
	public Auteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public Auteur(Long auteurId, String name) {
		super();
		this.auteurId = auteurId;
		this.name = name;
	}
	public Long getAuteurId() {
		return auteurId;
	}
	public void setAuteurId(Long auteurId) {
		this.auteurId = auteurId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
