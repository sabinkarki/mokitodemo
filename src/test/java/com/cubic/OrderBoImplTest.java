package com.cubic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.sql.SQLException;

import com.mokito.dao.Order;
import com.mokito.dao.OrederDaoImpl;
import com.mokito.exceptions.BoException;

/*@RunWith(MockitoJUnitRunner.class)*/
public class OrderBoImplTest {
	@Mock
	OrederDaoImpl dao;

	private OrderBoImpl impl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		impl = new OrderBoImpl();
		impl.setDao(dao);
	}

	@Test
	public void testPlaceOrder() throws SQLException, BoException {

		Order or = new Order();
		when(dao.create(or)).thenReturn(new Integer(1));
		boolean b = impl.placeOrder(or);
		assertTrue(b);
	}

	@Test
	public void testfalsePlaceOrder() throws SQLException, BoException {

		Order or = new Order();
		when(dao.create(or)).thenReturn(new Integer(0));
		boolean b = impl.placeOrder(or);
		assertFalse(b);
	}

	@Test(expected = BoException.class)
	public void testExceptionPlaceOrder() throws SQLException, BoException {

		Order or = new Order();
		when(dao.create(or)).thenThrow(SQLException.class);
		impl.placeOrder(or);

	}

	@Test
	public void cancelOrder() throws BoException, SQLException {		
		when(dao.update(any(Order.class))).thenReturn(1);
		boolean b = impl.cancleOrder(1);
		assertTrue(b);
	}
	@Test
	public void cancelOrderExcp() throws BoException, SQLException {		
		when(dao.update(any(Order.class))).thenThrow(SQLException.class);
		try{
		impl.cancleOrder(1);
		}catch(BoException e){
			
		}
		
	}

	@Test
	public void delete() {
		boolean b = impl.deleteOrder(2);
		assertTrue(b);
	}
}
