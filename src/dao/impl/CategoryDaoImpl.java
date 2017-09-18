package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.CategoryDao;
import dao.JdbcTemplate;
import dao.RowMapper;
import entity.Category;

public class CategoryDaoImpl implements CategoryDao {

	private JdbcTemplate db = new JdbcTemplate();

	@Override
	public void addCatrgory(String name) {
		String sql = "INSERT INTO Category(Name) VALUES(?)";
		db.update(sql, name);
	}

	@Override
	public void update(Category category) {
		String sql = "UPDATE Category SET Name = ? WHERE Id = ?";
		db.update(sql, category.getName(), category.getId());
	}

	@Override
	public void delete(int id) {
		db.update("DELETE FROM Category WHERE Id = ?", id);
	}

	@Override
	public Category fetchById(int id) {
		String sql = "SELECT * FROM Category WHERE Id = ?";
		List<Category> list = db.query(sql, new CategoryRowMapper(), id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public List<Category> getAll() {
		return db.query("SELECT * FROM Category", new CategoryRowMapper());
	}

	private static class CategoryRowMapper implements RowMapper<Category> {
		public Category mapRow(ResultSet rs) throws SQLException {
			return new Category(rs.getInt("Id"), rs.getString("Name"));
		}
	}
}
