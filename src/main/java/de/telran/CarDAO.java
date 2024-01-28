package de.telran;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    private Connection connection;

    public List<Car> getAllCars() throws SQLException {
List<Car> list = new ArrayList<>();

        Statement statement = connection.createStatement(); // создание "состояния"
        ResultSet resultSet = statement.executeQuery("SELECT * FROM car"); // делаем запрос

        while (resultSet.next()) {
            int id = resultSet.getInt("id"); // получить число из поля "id"
            String name = resultSet.getString("name");
            String country = resultSet.getString("country");
            Car car = new Car(id, name, country);
            list.add(car);
        }
        return list;
    }

    public void insertNewCar(Car car) throws SQLException {
        Statement statement = connection.createStatement();
        int id = car.getId();
        String name = car.getName();
        String country = car.getCountry();

        String str = "INSERT INTO car VALUES (" + id + ", '" + name + "', '" + country + "');";

                statement.execute(str);

    }

    public CarDAO(Connection connection) {
        this.connection = connection;
    }
}
