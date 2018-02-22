package com.movies.test;

import java.util.List;

import org.hibernate.Session;

import com.movies.entities.Movie;
import com.movies.service.MovieService;
import com.movies.service.MovieServiceImpl;
import com.movies.utils.HibernateUtil;

public class Main {
    private static final String SAMPLE_DATA_CSV = "src/main/resources/sample_data/ratedmovies_short.csv";

    public static void main(String[] args) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        MovieService movieService = new MovieServiceImpl(session);
        
        session.getTransaction().begin();
//        movieService.importMovies(SAMPLE_DATA_CSV);
        List<Movie> movies = movieService.listCountryMovies("USA");
        for (Movie mov : movies) {
            System.out.println(mov.getTitle());
        }
        session.getTransaction().commit();
        session.close();
        
//        m.setId(11);
//        m.setTitle("test");
//        m.setDuration(50);
//        m.setYear(2018);
//        m.setPosterImage("N/A");
//        movieService.insertMovie(m);
        
        
//        session.getTransaction().begin();
//        Movie m = movieService.findMovie(11);
//        m.setTitle("test3");
//        movieService.updateMovie(m);
//        session.getTransaction().commit();
//        session.close();
            
        
        
        
//        List<Movie> movies = movieService.listMovies();
//        for(Movie m : movies) {
//            System.out.println(m.getTitle());
//        }
//        System.out.println(m.getTitle());
//        List<Movie> movies = movieService.importMovies(SAMPLE_DATA_CSV);
//        
//        for(Movie movie : movies) {
//        
//            session.getTransaction().begin();
//            session.save(movie);
//            session.getTransaction().commit();
//            session.close();
//        } 
        
//        movieService.deleteMovie(113277);
//        System.out.println(m.getTitle());
        

    }
    
}

