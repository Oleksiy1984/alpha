package ua.nure.orlovskyi.SummaryTask4.dao;

import java.sql.SQLException;
import java.util.List;

import ua.nure.orlovskyi.SummaryTask4.model.Brand;
import ua.nure.orlovskyi.SummaryTask4.model.Car;
import ua.nure.orlovskyi.SummaryTask4.model.CarType;


public interface CarDAO {
	public List<Car> getAllCars() throws SQLException;
	public List<Car> findByBrand(Brand brand) throws SQLException;
	public List<Car> findByType(CarType carType) throws SQLException;
}
