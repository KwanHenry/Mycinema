package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.JdbcTemplate;
import dao.RowMapper;
import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate db = new JdbcTemplate();

	@Override
	public User login(String username, String password) {
		String sql = "SELECT * FROM USER WHERE Username = ? AND PASSWORD = ?";
		List<User> list = db.query(sql, new UserRowMappe(), username, password);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public User fetchByUsername(String username) {
		String sql = "SELECT * FROM USER WHERE Username = ?";
		List<User> list = db.query(sql, new UserRowMappe(), username);
		return list.size() > 0 ? list.get(0) : null;
	}

	private static class UserRowMappe implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("Id"));
			user.setUsername(rs.getString("Username"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setName(rs.getString("Name"));
			user.setAddress(rs.getString("Address"));
			user.setPhone(rs.getString("Phone"));
			user.setEmail(rs.getString("Email"));
			user.setRole(rs.getString("Role"));
			return user;
		}

	}
}
