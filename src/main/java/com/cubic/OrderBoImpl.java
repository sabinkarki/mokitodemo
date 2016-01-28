package com.cubic;

import java.sql.SQLException;

import com.mokito.dao.Order;
import com.mokito.dao.OrderDao;
import com.mokito.exceptions.BoException;





public class OrderBoImpl implements OrderBo {
OrderDao dao;
	public boolean placeOrder(Order or) throws BoException {
		try {
			int result = dao.create(or);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BoException(e);
		}
		return true;
	}

	public boolean cancleOrder(int id) throws BoException {
		try {
			Order order =new Order();
			int result = dao.update(order);
			if(result==0){
				return false;
			}
		} catch (SQLException e) {
			throw new BoException(e);
		}

		return true;
	
	}

	public boolean deleteOrder(int id) {
		// TODO Auto-generated method stub
		return true;
	}
	public void setDao(OrderDao dao) {
		this.dao = dao;
	}

}
