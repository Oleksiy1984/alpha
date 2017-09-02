package ua.nure.orlovskyi.SummaryTask4.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.nure.orlovskyi.SummaryTask4.connection.DBUtil;
import ua.nure.orlovskyi.SummaryTask4.model.Brand;
import ua.nure.orlovskyi.SummaryTask4.model.Car;
import ua.nure.orlovskyi.SummaryTask4.model.CarType;


public class CarDAOJdbc implements CarDAO  {
	private Connection conn = null;

	public CarDAOJdbc(Connection cn) {
		this.conn = cn;
	}

	private static final String SELECT_CARS = "SELECT cars.id, cars.available, cars.car_type, "
			+ "cars.color, cars.photo, cars.price, car_brands.id AS id_brand, car_brands.brand " + 
			"FROM rental.cars " + 
			"INNER JOIN rental.car_brands " + 
			"ON rental.cars.brand_id = rental.car_brands.id;";
	private static final String SELECT_BY_BRAND = "SELECT cars.id, cars.available, cars.car_type, " + 
			"cars.color, cars.photo, cars.price, car_brands.id AS id_brand, car_brands.brand " + 
			"FROM rental.cars " + 
			"iNNER JOIN rental.car_brands " + 
			"ON rental.cars.brand_id = rental.car_brands.id " + 
			"WHERE rental.car_brands.brand = ?;";
	private static final String SELECT_BY_TYPE = "SELECT cars.id, cars.available, cars.car_type, " + 
			"cars.color, cars.photo, cars.price, car_brands.id AS id_brand, car_brands.brand " + 
			"FROM rental.cars " + 
			"INNER JOIN rental.car_brands " + 
			"ON rental.cars.brand_id = rental.car_brands.id " + 
			"WHERE rental.cars.car_type = ?;";

	@Override
	public List<Car> getAllCars() throws SQLException {
		List<Car> result = new ArrayList<>();
		try (Statement statement = conn.createStatement(); 
				ResultSet resultSet = statement.executeQuery(SELECT_CARS)) {

			while(resultSet.next()) {
				Car car = new Car();
				Brand brand = new Brand();
				
				//set Car
				car.setId(resultSet.getInt("id"));
				car.setCarType(CarType.valueOf(resultSet.getString("car_type")));
				car.setColor(resultSet.getString("color"));
				car.setIsAvailable(resultSet.getBoolean("available"));
				car.setPhoto(resultSet.getString("photo"));
				car.setPrice(resultSet.getDouble("price"));

				//set Brand
				brand.setId(resultSet.getInt("id_brand"));
				brand.setName(resultSet.getString("brand"));
				car.setBrand(brand);
				
				result.add(car);
				
			}
			System.out.println(result);
		} catch (SQLException ex) {
			DBUtil.showErrorMessage(ex);
			throw ex;
		}
		return result;
	}

	@Override
	public List<Car> findByBrand(Brand brand) throws SQLException {
		List<Car> result = new ArrayList<>();
		try (PreparedStatement preparedStatement = conn.prepareStatement(SELECT_BY_BRAND)) {

			preparedStatement.setString(1, brand.getName());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Car car = new Car();
				Brand newBrand = new Brand();
				
				//set Car
				car.setId(resultSet.getInt("id"));
				car.setCarType(CarType.valueOf(resultSet.getString("car_type")));
				car.setColor(resultSet.getString("color"));
				car.setIsAvailable(resultSet.getBoolean("available"));
				car.setPhoto(resultSet.getString("photo"));
				car.setPrice(resultSet.getDouble("price"));

				//set Brand
				newBrand.setId(resultSet.getInt("id_brand"));
				newBrand.setName(resultSet.getString("brand"));
				car.setBrand(newBrand);
				
				result.add(car);
				
			}
			System.out.println(result);
		} catch (SQLException ex) {
			DBUtil.showErrorMessage(ex);
			throw ex;
		}
		return result;
	}

	@Override
	public List<Car> findByType(CarType carType) throws SQLException {
		List<Car> result = new ArrayList<>();
		try (PreparedStatement preparedStatement = conn.prepareStatement(SELECT_BY_TYPE)) {

			preparedStatement.setString(1, carType.name());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Car car = new Car();
				Brand newBrand = new Brand();
				
				//set Car
				car.setId(resultSet.getInt("id"));
				car.setCarType(CarType.valueOf(resultSet.getString("car_type")));
				car.setColor(resultSet.getString("color"));
				car.setIsAvailable(resultSet.getBoolean("available"));
				car.setPhoto(resultSet.getString("photo"));
				car.setPrice(resultSet.getDouble("price"));

				//set Brand
				newBrand.setId(resultSet.getInt("id_brand"));
				newBrand.setName(resultSet.getString("brand"));
				car.setBrand(newBrand);
				
				result.add(car);
				
			}
			System.out.println(result);
			System.out.println(result.size());
		} catch (SQLException ex) {
			DBUtil.showErrorMessage(ex);
			throw ex;
		}
		return result;
	}





}
