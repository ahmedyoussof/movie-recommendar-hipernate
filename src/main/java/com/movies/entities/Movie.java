package com.movies.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {
    
	@Id
	@Column(name="id")
    private Integer id;
	
	@Column(name="year")
    private Integer year;
	
	@Column(name="duration")
    private Integer duration;
	
	@Column(name="title")
    private String title;
	
	@Column(name="poster")
    private String posterImage;
	
	@ElementCollection
    @CollectionTable(name="directings", joinColumns=@JoinColumn(name="movie_id"))
    @Column(name="director")
    private Set<String> directors = new HashSet<>();
	
	@ElementCollection
    @CollectionTable(name="genres", joinColumns=@JoinColumn(name="movie_id"))
    @Column(name="genre")
    private Set<String> genres = new HashSet<>();
	
	@ElementCollection
    @CollectionTable(name="showplaces", joinColumns=@JoinColumn(name="movie_id"))
    @Column(name="country")
    private Set<String> showPlaces = new HashSet<>();
	
	

	public Movie() {
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPosterImage() {
		return posterImage;
	}

	public void setPosterImage(String posterImage) {
		this.posterImage = posterImage;
	}

    public Set<String> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<String> directors) {
        this.directors = directors;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    public Set<String> getShowPlaces() {
        return showPlaces;
    }

    public void setShowPlaces(Set<String> showPlaces) {
        this.showPlaces = showPlaces;
    }
	
	public void addDirector(String director) {	    
	    directors.add(director);
	}
	
   public void addGenre(String genre) {
        genres.add(genre);
    }

    public void addShowplace(String country) {
        showPlaces.add(country);
    }

}
