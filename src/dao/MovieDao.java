package dao;

import java.util.List;

import entity.Movie;

public interface MovieDao {
	Movie fetchById(int id);

	void addMoive(Movie movie);

	void deleteMovie(int id);

	void updateMovie(Movie moive);

	List<Movie> fetchByCategoryName(String name);

	List<Movie> getMoviesByCategoryId(int id);

	int fetchNumberByCategoryName(String name);
}
