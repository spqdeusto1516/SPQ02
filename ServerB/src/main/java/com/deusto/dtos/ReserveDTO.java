package com.deusto.dtos;

/*!
 * ReserveDTO class is used for creating a reservation
 * It is intended to provide id of the reserved book
 */

public class ReserveDTO {

    private String bookId;

    /**
     * Gets the id of the book field
     * @return id String
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * Sets the id of the book field
     * @param bookId String
     */
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
