package com.movies.hibernate_data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.movies.entities.Movie;
import com.movies.utils.HibernateUtil;

public class MovieHibernateDoa extends AbstractDao<Movie, Integer> implements MovieDao{

    @Override
	public boolean delete(Integer movieId) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Movie movie = session.get(Movie.class, movieId);
			session.delete(movie);
			
			transaction.commit();
			System.out.println("Movie deleted");
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return false;
    }

   

	@Override
	public boolean insert(Movie entity) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(entity);
			
			transaction.commit();
			System.out.println("Movie inserted");
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return false;
	}
    
    @Override
	public void save(Movie entity) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(entity);
			
			transaction.commit();
			System.out.println("Movie saved");
			
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		
    }


    @Override
    public boolean update(Movie entity) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(entity);
			
			transaction.commit();
			System.out.println("Movie updated");
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return false;
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
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Query query = session
			        .createNativeQuery(
			            "select m.* from movies m join showplaces sp on m.id = sp.movie_id" + " where sp.country = :country")
			        .addEntity(Movie.class).setParameter("country", showPlace);
			List<Movie> movies = query.list();
			transaction.commit();
			return movies;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return null;
        
    }

    @Override
	public List<Movie> listDirectorMovies(String director) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Query query = session.createNativeQuery(
			    "select m.* from movies m join directings dir on m.id = dir.movie_id " + " where dir.director = :director")
			        .addEntity(Movie.class).setParameter("director", director);
			List<Movie> movies = query.list();
			transaction.commit();
			return movies;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
    @Override
	public List<Movie> listGenreMovies(String genre) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Query query = session
			        .createNativeQuery(
			            "select m.* from movies m join genres gen on m.id = gen.movie_id where gen.genre = :genre")
			        .addEntity(Movie.class).setParameter("genre", genre);
			List<Movie> movies = query.list();
			transaction.commit();
			return movies;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
    @Override
    public List<Movie> listCountryGenreMovies(String country, String genre) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Query query = session.createNativeQuery(
			    "select m.* from movies m join showplaces sp join genres gen on m.id = sp.movie_id and m.id = gen.movie_id"
			            + " where gen.genre = :genre and sp.country = :country")
			        .addEntity(Movie.class).setParameter("genre", genre);
			query.setParameter("country", country);
			List<Movie> movies = query.list();
			transaction.commit();
			return movies;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return null;
    }

	@SuppressWarnings("unchecked")
    @Override
    public List<String> findMovieDirectors(Integer movieId) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Movie movie = session.get(Movie.class, movieId);
			List<String> directors = new ArrayList(movie.getDirectors());
			transaction.commit();
			return directors;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return null;
    }


    @Override
    public List<String> findMovieGenres(Integer movieId) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Movie movie = session.get(Movie.class, movieId);
			List<String> genres = new ArrayList(movie.getGenres());
			transaction.commit();
			return genres;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return null;
    }

    @Override
    public List<String> findMovieShowPlaces(Integer movieId) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Movie movie = session.get(Movie.class, movieId);
			List<String> showPlaces = new ArrayList(movie.getShowPlaces());
			
			return showPlaces;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return null;
    }

    @Override
    public boolean insertMovieDirector(Integer movieId, String director) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Movie movie = session.get(Movie.class, movieId);
			movie.getDirectors().add(director);
			transaction.commit();
			System.out.println("Director inserted");
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return false;
    }

    @Override
    public boolean insertMovieGenre(Integer movieId, String genre) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Movie movie = session.get(Movie.class, movieId);
			movie.getGenres().add(genre);
			transaction.commit();
			System.out.println("Genre inserted");
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return false;
    }

    @Override
    public boolean insertMovieShowPlace(Integer movieId, String country) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Movie movie = session.get(Movie.class, movieId);
			movie.getShowPlaces().add(country);
			transaction.commit();
			System.out.println("Country inserted");
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return false;
    }

    @Override
    public boolean deleteMovieDirector(Integer movieId, String director) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Movie movie = session.get(Movie.class, movieId);
			movie.getDirectors().remove(director);
			transaction.commit();
			System.out.println("Director deleted");
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return false;
		
    }

    @Override
    public boolean deleteMovieGenre(Integer movieId, String genre) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Movie movie = session.get(Movie.class, movieId);
			movie.getGenres().remove(genre);
			transaction.commit();
			System.out.println("Genre deleted");
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return false;
    }

    @Override
	public boolean deleteMovieShowPlace(Integer movieId, String country) {
		org.hibernate.SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Movie movie = session.get(Movie.class, movieId);
			movie.getShowPlaces().remove(country);
			transaction.commit();
			System.out.println("Country deleted");
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
		return false;
    }



}
