package com.mokito.dao;

import java.sql.SQLException;


public interface OrderDao {
	int create(Order or)throws SQLException;
	Order read(int id)throws SQLException;
	int update(Order or)throws SQLException;
	int delete(int id)throws SQLException;
}
