package org.ClientP;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
	private String id;
	private String title;
	private String authorFirstName;
	private String authorLastName;
	private String genre;
	private String description;
	private Long publishDate;
	private int pages;
	private int ageLimit;
	private int count;

    public Quote() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;

    }

    @Override
    public String toString() {
        return "Quote{" +
                "ID='" + id + '\'' +
                ", Title =" + title +
                '}';

    }
}
