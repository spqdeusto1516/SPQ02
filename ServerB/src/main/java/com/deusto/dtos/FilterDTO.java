package com.deusto.dtos;

/*!
 * FilterDTO class is used for filtering books
 * It is used in the request as a RequestBody
 */
public class FilterDTO {

    private String title;
    protected String genre;
    // implement for author
    private Long reserveDate;
    private Long reserveExpire;

    /**
     * Gets the reservation date
     * @return reserveDate Long
     */
    public Long getReserveDate() {
        return reserveDate;
    }

    /**
     * Sets the reservation date in FilterDTO
     * @param reserveDate String
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
     * Sets the reservation Expiration Date
     * @param reserveExpire String
     */
    public void setReserveExpire(Long reserveExpire) {
        this.reserveExpire = reserveExpire;
    }

    /**
     * Gets the title
     * @return title String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title in FilterDTO
     * @param title String
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the gentre date
     * @return genre String
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre in FilterDTO
     * @param genre String
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
