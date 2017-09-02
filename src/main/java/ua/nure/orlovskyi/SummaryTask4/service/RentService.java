package ua.nure.orlovskyi.SummaryTask4.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.nure.orlovskyi.SummaryTask4.connection.ConnectionPoolException;
import ua.nure.orlovskyi.SummaryTask4.connection.DBConnectionPool;
import ua.nure.orlovskyi.SummaryTask4.dao.CarDAO;
import ua.nure.orlovskyi.SummaryTask4.dao.CarDAOJdbc;
import ua.nure.orlovskyi.SummaryTask4.model.Car;

public class RentService {
	
	
	private Connection connection;
	private static final DBConnectionPool connectionPool = DBConnectionPool.getInstance();
	private static final Logger LOGGER = LoggerFactory.getLogger(RentService.class);
	
	public RentService() {
        try {
            if (connection == null) {
                connection = connectionPool.getConnection();
            }
        } catch (ConnectionPoolException e) {
            LOGGER.error("Cannot create connection", e);
            e.printStackTrace();
        }
    }
	
	public List<Car> getAllCars() throws SQLException {
		CarDAO carDAO = new CarDAOJdbc(connection);
        return carDAO.getAllCars();
	}

}
