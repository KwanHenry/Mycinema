package entity;

import java.util.Date;

public class Movie {
	private int id;
	private String movieCode;
	private int categoryId;
	private String title;
	private String director;
	private Date dateReleased;

	public Movie() {

	}

	public Movie(int id, String movieCode, int categoryId, String title, String director, Date dateReleased) {
		this.id = id;
		this.movieCode = movieCode;
		this.categoryId = categoryId;
		this.title = title;
		this.director = director;
		this.dateReleased = dateReleased;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieCode() {
		return movieCode;
	}

	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Date getDateReleased() {
		return dateReleased;
	}

	public void setDateReleased(Date dateReleased) {
		this.dateReleased = dateReleased;
	}
}
