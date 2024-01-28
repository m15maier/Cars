package de.telran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class MainWithDAO {

    public static void main(String[] args) throws SQLException {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "admin"); //сделали соединение с базой данных

        CarDAO carDAO = new CarDAO(connection); // создали DAO

        List<Car> cars = carDAO.getAllCars(); // получили все машины

        Car car = new Car(1, "Qwerty", "Germany");

        carDAO.insertNewCar(car);
    }
}
