package dao;

import java.util.List;

import entity.Category;

public interface CategoryDao {
	
	void update(Category category);

	void delete(int id);

	Category fetchById(int id);

	List<Category> getAll();

	void addCatrgory(String name);
}
