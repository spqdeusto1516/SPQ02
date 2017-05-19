package org.models;


public class Reserve {
	private String id;
	private User user;
	private Book book;
	private long reserveDate;
	private long reserveExpire;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public long getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(long reserveDate) {
		this.reserveDate = reserveDate;
	}
	public long getReserveExpire() {
		return reserveExpire;
	}
	public void setReserveExpire(long reserveExpire) {
		this.reserveExpire = reserveExpire;
	}
	

}
