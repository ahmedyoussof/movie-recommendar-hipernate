package com.movies.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Session;

import com.movies.entities.Movie;
import com.movies.entities.Rating;
import com.movies.hibernate_data.MovieDao;
import com.movies.hibernate_data.MovieHibernateDoa;
import com.movies.utils.FileResource;

public class MovieServiceImpl implements MovieService {

    private MovieDao movieDao = new MovieHibernateDoa();

    public MovieServiceImpl(Session session) {
        // TODO Auto-generated constructor stub
        movieDao.setSession(session);
    }
    
    
    @Override
    public Movie findMovie(int id) {
        return movieDao.findById(id);
    }

    @Override
    public boolean insertMovie(Movie movie) {
        return movieDao.insert(movie);
    }

    @Override
    public boolean updateMovie(Movie movie) {
        return movieDao.update(movie);
    }

    @Override
    public boolean deleteMovie(int id) {
        return movieDao.delete(id);
    }


    @Override
    public List<Movie> listRaterMovies(int raterId) {
        return movieDao.listRaterMovies(raterId);
    }

    @Override
    public List<Movie> listCountryMovies(String country) {
        return movieDao.listCountryMovies(country);
    }

    @Override
    public List<Movie> listDirectorMovies(String director) {
        return movieDao.listDirectorMovies(director);
    }

    @Override
    public List<Movie> listGenreMovie(String genre) {
        return movieDao.listGenreMovies(genre);
    }

    @Override
    public List<Movie> listCountryGenreMovies(String country, String genre) {
        return movieDao.listCountryGenreMovies(country, genre);
    }

    @Override
    public List<Rating> findMovieRatings(int movieId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> listMovieDirectors(int movieId) {
        return movieDao.findMovieDirectors(movieId);
    }

    @Override
    public boolean insertMovieDirector(int movieId, String director) {
        return movieDao.insertMovieDirector(movieId, director);
    }

    @Override
    public boolean deleteMovieDirector(int movieId, String director) {
        return movieDao.deleteMovieDirector(movieId, director);
    }

    @Override
    public List<Movie> listAllMovies() {
        return movieDao.listMovies();
    }

    @Override
    public List<String> listMovieGenres(int movieId) {
        return movieDao.findMovieGenres(movieId);
    }

    @Override
    public List<String> listMovieShowPlaces(int movieId) {
        return movieDao.findMovieShowPlaces(movieId);
    }

    @Override
    public boolean insertMovieGenre(int movieId, String genre) {
        return movieDao.insertMovieGenre(movieId, genre);
    }

    @Override
    public boolean insertMovieShowPlace(int movieId, String country) {
        return movieDao.insertMovieShowPlace(movieId, country);
    }

    @Override
    public boolean deleteMovieGenre(int movieId, String genre) {
        return movieDao.deleteMovieGenre(movieId, genre);
    }

    @Override
    public boolean deleteMovieShowPlace(int movieId, String country) {
        return movieDao.deleteMovieShowPlace(movieId, country);
    }
    
    @Override
    public List<Movie> listMovies() {
        // TODO Auto-generated method stub
        return movieDao.listMovies();
    }

    @Override
    public boolean importMovies(String fileName) {
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser();
        List<Movie> movies = new ArrayList<>();

        for (CSVRecord rec : parser) {
            Movie mov = getCSVMovie(rec);
            mov.setDirectors(new HashSet<>(Arrays.asList(rec.get("director").split(", "))));
            mov.setGenres(new HashSet<>(Arrays.asList(rec.get("genre").split(", "))));
            mov.setShowPlaces(new HashSet<>(Arrays.asList(rec.get("country").split(", "))));
            movies.add(mov);
        }

        return movieDao.batchInsertMovies(movies);
    }

    private Movie getCSVMovie(CSVRecord rec) {
        Movie mov = new Movie();
        mov.setId(Integer.parseInt(rec.get("id")));
        mov.setTitle(rec.get("title"));
        mov.setYear(Integer.parseInt(rec.get("year")));
        mov.setDuration(Integer.parseInt(rec.get("minutes")));
        mov.setPosterImage(rec.get("poster"));
        return mov;
    }


}
