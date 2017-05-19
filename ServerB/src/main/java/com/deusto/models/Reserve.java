package com.deusto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/*!
* This class is a model of the database document, used to store a reservation.
*/
@Document(collection = "reservers")
public class Reserve {
	@Id
	private String id;
	@DBRef
	private User user;
	@DBRef
	private Book book;
	private Long reserveDate;
	private Long reserveExpire;

    /**
     * Gets the id of the reservation
     * @return id String
     */
	public String getId() {
		return id;
	}

    /**
     * Sets the id of the reservation
     * @param id String
     */
	public void setId(String id) {
		this.id = id;
	}

    /**
     * Gets the user of the reservation
     * @return user User
     */
	public User getUser() {
		return user;
	}

    /**
     * Sets the user of the reservation
     * @param user User
     */
	public void setUser(User user) {
		this.user = user;
	}

    /**
     * Gets the book of the reservation
     * @return book Book
     */
	public Book getBook() {
		return book;
	}

    /**
     * Sets the book of the reservation
     * @param book Book
     */
	public void setBook(Book book) {
		this.book = book;
	}

    /**
     * Gets the reservation date
     * @return reserveDate Long
     */
	public Long getReserveDate() {
		return reserveDate;
	}

    /**
     * Sets the reservation date
     * @param reserveDate Long
     */
	public void setReserveDate(Long reserveDate) {
		this.reserveDate = reserveDate;
	}

    /**
     * Gets the reservation expiration date
     * @return reserveExpire Long
     */
	public Long getReserveExpire() {
		return reserveExpire;
	}

    /**
     * Sets the reservation expiration date
     * @param reserveExpire Long
     */
	public void setReserveExpire(Long reserveExpire) {
		this.reserveExpire = reserveExpire;
	}
}
