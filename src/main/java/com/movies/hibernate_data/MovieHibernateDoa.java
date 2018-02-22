package com.movies.hibernate_data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.movies.entities.Movie;

public class MovieHibernateDoa extends AbstractDao<Movie, Integer> implements MovieDao{

    @Override
    public boolean delete(Integer id) {
        Movie movie = new Movie();
        movie.setId(id);
        this.getSession().delete(movie);
        return true;
    }

   

    @Override
    public boolean insert(Movie entity) {
        this.getSession().saveOrUpdate(entity);
        return true;
    }
    
    @Override
    public Movie save(Movie entity) {
        this.getSession().saveOrUpdate(entity);
        return entity;
    }


    @Override
    public boolean update(Movie entity) {
        this.getSession().saveOrUpdate(entity);
        return true;
    }



    @Override
    public boolean batchInsertMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            this.getSession().saveOrUpdate(movie);
        }
        return true;
    }

    @Override
    public List<Movie> listRaterMovies(int raterId) {
        // TODO Auto-generated method stub
        return null;
    }

    
    @SuppressWarnings("rawtypes")
    @Override
    public List<Movie> listCountryMovies(String showPlace) {
        Session session = this.getSession();
        Query query = session
        .createNativeQuery("select m.* from movies m join showplaces sp on m.id = sp.movie_id where sp.country = :country")
        .addEntity(Movie.class).setParameter("country", showPlace);
        List<Movie> movies = query.list();
        return movies; 
        
    }

    @Override
    public List<Movie> listDirectorMovies(String director) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Movie> listGenreMovies(String genre) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Movie> listCountryGenreMovies(String country, String genre) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> findMovieDirectors(Integer movieId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> findMovieGenres(Integer movieId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> findMovieShowPlaces(Integer movieId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insertMovieDirector(Integer movieId, String director) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insertMovieGenre(Integer movieId, String genre) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insertMovieShowPlace(Integer movieId, String country) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteMovieDirector(Integer movieId, String director) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteMovieGenre(Integer movieId, String genre) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteMovieShowPlace(Integer movieId, String showPlace) {
        // TODO Auto-generated method stub
        return false;
    }



}
