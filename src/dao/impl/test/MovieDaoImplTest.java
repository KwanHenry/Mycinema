package dao.impl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import dao.impl.MovieDaoImpl;
import entity.Movie;

public class MovieDaoImplTest {

	private MovieDaoImpl m = new MovieDaoImpl();

	@Test
	public void testFetchById() {
		Movie movie = m.fetchById(1);
		System.out.println(movie.getTitle());
	}

	@Test
	public void testAddMoive() {
		Movie movie = new Movie();
		movie.setId(16);
		movie.setMovieCode("CT00111");
		movie.setCategoryId(4);
		movie.setTitle("悬崖上的金鱼姬ssss");
		movie.setDirector("宫崎骏?");
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
		Date date = null;
		try {
			date = sdf.parse(" 2008-07-10 19:20:00 ");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		movie.setDateReleased(date);
		m.addMoive(movie);
	}

	@Test
	public void testDeleteMovie() {
		m.deleteMovie(17);
	}

	@Test
	public void testUpdateMovie() {
		Movie movie = new Movie();
		movie.setId(16);
		movie.setMovieCode("CT003?");
		movie.setCategoryId(4);
		movie.setTitle("悬崖上的金鱼姬?");
		movie.setDirector("宫崎骏?");
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
		Date date = null;
		try {
			date = sdf.parse(" 2008-07-10 19:20:00 ");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		movie.setDateReleased(date);
		m.updateMovie(movie);
	}

	@Test
	public void testFetchByCategoryName() {
		List<Movie> list = m.fetchByCategoryName("喜剧");
		for (Movie movie : list) {
			System.out.println(movie.getTitle());
		}
	}

	@Test
	public void testFetchNumberByCategoryName() {
		System.out.println(m.fetchNumberByCategoryName("喜剧"));
	}
	
	public void testGetMovieByCategoryById() {
		List<Movie> list = m.getMoviesByCategoryId(7);
	}

}
