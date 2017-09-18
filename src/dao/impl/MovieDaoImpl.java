package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.JdbcTemplate;
import dao.MovieDao;
import dao.RowMapper;
import entity.Movie;

public class MovieDaoImpl implements MovieDao {

	private JdbcTemplate db = new JdbcTemplate();

	@Override
	public Movie fetchById(int id) {
		String sql = "SELECT * FROM Movie WHERE Id=?";
		List<Movie> movies = db.query(sql, new MovieRowMappe(), id);
		return movies.size() > 0 ? movies.get(0) : null;
	}

	@Override
	public void addMoive(Movie movie) {
		String sql = "INSERT INTO Movie(MovieCode, CategoryId, Title, Director, DateReleased) VALUES(?,?,?,?,?)";
		db.update(sql, movie.getMovieCode(), movie.getCategoryId(), movie.getTitle(), movie.getDirector(),
				movie.getDateReleased());
	}

	@Override
	public void deleteMovie(int id) {
		String sql = "DELETE FROM Movie WHERE Id=?";
		db.update(sql, id);
	}

	@Override
	public void updateMovie(Movie movie) {
		String sql = "UPDATE Movie SET MovieCode=?,CategoryId=?,Title=?,Director=?,DateReleased=? WHERE Id=?";
		db.update(sql, movie.getMovieCode(), movie.getCategoryId(), movie.getTitle(), movie.getDirector(),
				movie.getDateReleased(), movie.getId());
	}

	@Override
	public List<Movie> fetchByCategoryName(String name) {
		String sql = "SELECT * FROM Movie WHERE CategoryId =(SELECT Id FROM Category WHERE NAME = ?)";
		List<Movie> list = db.query(sql, new MovieRowMappe(), name);
		return list;
	}

	public int fetchNumberByCategoryName(String name) {
		String sql = "SELECT * FROM Movie WHERE CategoryId =(SELECT Id FROM Category WHERE NAME = ?)";
		List<Movie> list = db.query(sql, new MovieRowMappe(), name);
		return list.size() > 0 ? list.size() : 0;
	}

	@Override
	public List<Movie> getMoviesByCategoryId(int id) {
		String sql = "SELECT * FROM Movie WHERE CategoryId =?";
		List<Movie> list = db.query(sql, new MovieRowMappe(), id);
		return list;
	}

	private static class MovieRowMappe implements RowMapper<Movie> {

		@Override
		public Movie mapRow(ResultSet rs) throws SQLException {
			Movie m = new Movie();
			m.setId(rs.getInt("Id"));
			m.setMovieCode(rs.getString("MovieCode"));
			m.setTitle(rs.getString("Title"));
			m.setCategoryId(rs.getInt("CategoryId"));
			m.setDirector(rs.getString("Title"));
			m.setDirector(rs.getString("Director"));
			m.setDateReleased(rs.getDate("DateReleased"));
			return m;
		}

	}

}
