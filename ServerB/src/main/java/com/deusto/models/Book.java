package com.deusto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/*!
* This class is a model of the database document, used to store a book.
*/
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String genre;
    private String description;
    private Long publishDate;
    private Integer pages;
    private Integer ageLimit;
    private Integer count;
    private List<String> tags;

    /**
     * Gets the id of the book
     * @return id String
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the book
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the title of the book
     * @return title String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book
     * @param title String
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author of the book
     * @return author String
     */
    public String getAuthorFirstName() {
        return authorFirstName;
    }

    /**
     * Sets the authorFirstName of the book
     * @param authorFirstName String
     */
    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }
    /**
     * Gets the author last name of the book
     * @return authorLastName String
     */
    public String getAuthorLastName() {
        return authorLastName;
    }

    /**
     * Sets the authorLastName of the book
     * @param authorLastName String
     */
    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    /**
     * Gets the genre of the book
     * @return genre String
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the book
     * @param genre String
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets the description of the book
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the book
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the publish date of the book
     * @return publishDate String
     */
    public Long getPublishDate() {
        return publishDate;
    }

    /**
     * Sets the publishDate of the book
     * @param publishDate Long
     */
    public void setPublishDate(Long publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * Gets the number of pages of the book
     * @return pages String
     */
    public Integer getPages() {
        return pages;
    }

    /**
     * Sets the pages of the book
     * @param pages Integer
     */
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    /**
     * Gets the age limit of the book
     * @return ageLimit Integr
     */
    public Integer getAgeLimit() {
        return ageLimit;
    }

    /**
     * Sets the ageLimit of the book
     * @param ageLimit Integer
     */
    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    /**
     * Gets the number of copies available of the book
     * @return count Integer
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets the count of the book
     * @param count Integer
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * Gets the tags of the book
     * @return tags List(String)
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * Sets the tags of the book
     * @param tags List(String)
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /* Decrements the value of the counter */
    public Book decrementCount() {
        this.count--;
        return this;
    }
}
