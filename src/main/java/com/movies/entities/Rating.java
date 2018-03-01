package com.movies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ratings")
public class Rating {
    
	@Id
	@Column(name = "rater_id")
    private Integer raterId;
	
	@Column(name = "movie_id")
	private Integer movieId;
	
	@Column(name="value")
    private Integer value;

    public Integer getRaterId() {
        return raterId;
    }

    public void setRaterId(Integer raterId) {
        this.raterId = raterId;
    }

	public Integer getMovieId() {
		return movieId;
    }

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
