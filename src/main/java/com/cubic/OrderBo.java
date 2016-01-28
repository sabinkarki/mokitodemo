package com.cubic;

import com.mokito.dao.Order;
import com.mokito.exceptions.BoException;

public interface OrderBo {
	
		boolean placeOrder(Order or)throws BoException;
		boolean cancleOrder(int id)throws BoException;
		boolean deleteOrder(int id)throws BoException;

}
