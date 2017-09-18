package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			throw new DaoException("数据库驱动加载失败！", e);
		}
	}

	public Connection openConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/MyCinema?useSSL=false", "root", "root");
	}

	public void closeResource(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DaoException("结果集关闭失败！", e);
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new DaoException("stmt 关闭失败！", e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DaoException("数据库连接关闭失败！", e);
			}
		}
	}

	public int update(String sql, Object... parmeters) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.openConnection();
			stmt = conn.prepareStatement(sql);
			if (parmeters != null) {
				for (int i = 0; i < parmeters.length; i++) {
					stmt.setObject(i + 1, parmeters[i]);
				}
			}
			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("更新失败！", e);
		} finally {
			this.closeResource(conn, stmt, rs);
		}
	}

	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parmeters) {
		List<T> list = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.openConnection();
			stmt = conn.prepareStatement(sql);
			if (parmeters != null) {
				for (int i = 0; i < parmeters.length; i++) {
					stmt.setObject(i + 1, parmeters[i]);
				}
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				T t = rowMapper.mapRow(rs);
				list.add(t);
			}
		} catch (SQLException e) {
			throw new DaoException("查询失败！", e);
		} finally {
			this.closeResource(conn, stmt, rs);
		}
		return list;
	}
}
