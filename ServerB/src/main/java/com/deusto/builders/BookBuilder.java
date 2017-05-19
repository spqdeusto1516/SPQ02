package com.deusto.builders;

import com.deusto.dtos.BookDTO;
import com.deusto.models.Book;

import java.util.List;

/*!
 * BookBuilder class is used for building a Book object
 */

public class BookBuilder {

	/*! Creates an empty book objects */
	private Book book = new Book();

	/**
	 * Empty constructor
	 */
	private BookBuilder() {
	}

	/**
	 * Builds the title in book
	 * @param title String
	 * @return itself
	 */
	public BookBuilder title(String title) {
		this.book.setTitle(title);
		return this;
	}

	/**
	 * Builds the atuthor first name in book
	 * @param authorFirstName String
	 * @return itself
	 */
	public BookBuilder authorFirstName(String authorFirstName) {
		this.book.setAuthorFirstName(authorFirstName);
		return this;
	}

	/**
	 * Builds the author last name in book
	 * @param authorLastName String
	 * @return itself
	 */
	public BookBuilder authorLastName(String authorLastName) {
		this.book.setAuthorLastName(authorLastName);
		return this;
	}

	/**
	 * Builds the genre in book
	 * @param genre String
	 * @return itself
	 */
	public BookBuilder genre(String genre) {
		this.book.setGenre(genre);
		return this;
	}

	/**
	 * Builds the description in book
	 * @param description String
	 * @return itself
	 */
	public BookBuilder description(String description) {
		this.book.setDescription(description);
		return this;
	}

	/**
	 * Builds the publish date in book
	 * @param publishDate Long
	 * @return itself
	 */
	public BookBuilder publishDate(Long publishDate) {
		this.book.setPublishDate(publishDate);
		return this;
	}

	/**
	 * Builds the number of pages in book
	 * @param pages Integer
	 * @return itself
	 */
	public BookBuilder pages(Integer pages) {
		this.book.setPages(pages);
		return this;
	}

	/**
	 * Builds the publish date in book
	 * @param ageLimit Integer
	 * @return itself
	 */
	public BookBuilder ageLimit(Integer ageLimit) {
		this.book.setAgeLimit(ageLimit);
		return this;
	}

	/**
	 * Builds the number of copies of the book
	 * @param count Integer
	 * @return itself
	 */
	public BookBuilder count(Integer count) {
		this.book.setCount(count);
		return this;
	}

	/**
	 * Builds the tages associated to this book
	 * @param tags List(String)
	 * @return itself
	 */
	public BookBuilder tags(List<String> tags) {
		this.book.setTags(tags);
		return this;
	}

	/**
	 * Creates a builder object
	 * @return new builder object
	 */
	public static BookBuilder builder() {
		return new BookBuilder();
	}

	/**
	 * Returns the build address
	 * @return a book object
	 */
	public Book build() {
		return this.book;
	}

	/**
	 * Gets a Book object from a DTO object
	 * @param bookDTO BookDTO
	 * @return an book object
	 */
	public static Book get(BookDTO bookDTO) {
		Book book = new Book();
		book.setAgeLimit(bookDTO.getAgeLimit());
		book.setAuthorFirstName(bookDTO.getAuthorFirstName());
		book.setAuthorLastName(bookDTO.getAuthorLastName());
		book.setCount(bookDTO.getCount());
		book.setDescription(bookDTO.getDescription());
		book.setPages(bookDTO.getPages());
		book.setPublishDate(bookDTO.getPublishDate());
		book.setTitle(bookDTO.getTitle());
		book.setTags(bookDTO.getTags());
		book.setGenre(bookDTO.getGenre());
		return book;
	}
}
