package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
	// 处理ResultSet，返回泛型对象
	T mapRow(ResultSet rs) throws SQLException;
}
