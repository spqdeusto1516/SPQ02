package com.deusto.builders;

import java.util.List;

import com.deusto.model.Book;

public class BookBuilder {
	
	private Book book;
	
	public BookBuilder title(String title) {
		this.book.setTitle(title);
		return this;
	}
	
	public BookBuilder authorFirstName(String authorFirstName) {
		this.book.setAuthorFirstName(authorFirstName);
		return this;
	}
	
	public BookBuilder authorLastName(String authorLastName) {
		this.book.setAuthorLastName(authorLastName);
		return this;
	}
	
	public BookBuilder genre(String genre) {
		this.book.setGenre(genre);
		return this;
	}
	
	public BookBuilder description(String description) {
		this.book.setDescription(description);
		return this;
	}
	
	public BookBuilder publishDate(Long publishDate) {
		this.book.setPublishDate(publishDate);
		return this;
	}
	
	public BookBuilder pages(int pages) {
		this.book.setPages(pages);
		return this;
	}
	
	public BookBuilder ageLimit(int ageLimit) {
		this.book.setAgeLimit(ageLimit);
		return this;
	}
	
	public BookBuilder count(int count) {
		this.book.setCount(count);
		return this;
	}
	
	public BookBuilder tags(List<String> tags) {
		this.book.setTags(tags);
		return this;
	}

	public Book build() {
		return this.book;
	}
}
