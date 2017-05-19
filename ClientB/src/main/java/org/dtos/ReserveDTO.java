package org.dtos;

public class ReserveDTO {

    private String bookId;
    
    

    public ReserveDTO(String bookId) {
		super();
		this.bookId = bookId;
	}

	public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
