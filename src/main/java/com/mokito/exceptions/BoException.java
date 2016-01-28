package com.mokito.exceptions;

import java.sql.SQLException;

public class BoException extends Exception {
	public BoException(SQLException e) {
        super(e);
}
}
