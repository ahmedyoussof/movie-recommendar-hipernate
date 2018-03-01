package com.movies.test;

import java.util.HashSet;
import java.util.Set;

import com.movies.entities.Movie;
import com.movies.service.MovieService;
import com.movies.service.MovieServiceImpl;

public class Application {
	

	private static final String SAMPLE_DATA_CSV = "src/main/resources/sample_data/ratedmovies_short.csv";
	

    public static void main(String[] args) {
        
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        MovieService movieService = new MovieServiceImpl(session);
//        
//        session.getTransaction().begin();
//		//		movieService.importMovies(SAMPLE_DATA_CSV);
//		List<Movie> movies = movieService.listCountryGenreMovies("USA", "Drama");
//		for (Movie mov : movies) {
//			System.out.println(mov.getTitle());
//		}
//        session.getTransaction().commit();
//        session.close();
        

        
        
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
        
		//		MovieService movieService = new MovieServiceImpl();
//		List<String> movies = movieService.listMovieDirectors(6414);
//		for (String s : movies) {
//			System.out.println(s);
//		}
		
		//		movieService.deleteMovieDirector(6414, "youssof");
		
		MovieService movieService = new MovieServiceImpl();
		//		Movie m = createMovie();
		//		movieService.insertMovie(m);
		movieService.deleteMovie(11);


    }
	
	private static Movie createMovie() {
		
		Movie m = new Movie();
		Set<String> directors = new HashSet<>();
		Set<String> showPlaces = new HashSet<>();
		Set<String> genres = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			directors.add("dir" + i);
			showPlaces.add("count" + i);
			genres.add("genre" + i);
			
		}
		
		m.setId(11);
		m.setTitle("test");
		m.setDuration(50);
		m.setYear(2018);
		m.setPosterImage("N/A");
		m.setDirectors(directors);
		m.setGenres(genres);
		m.setShowPlaces(showPlaces);
		return m;
	}
    
}

