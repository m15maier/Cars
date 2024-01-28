package de.telran;

import java.sql.*;

public class Main {

    public static void main(String[] args)  {
        // DAO - data access object

try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
        "postgres", "admin"))
    {
      Statement statement = connection.createStatement();
//      statement.execute("CREATE TABLE IF NOT EXISTS abc(id int)");
      ResultSet resultSet = statement.executeQuery("SELECT * from car");

      while (resultSet.next()); {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String country = resultSet.getString("country");
            Car car = new Car(id, name, country);
            System.out.println(car);
        }

    System.out.println("Done");

    }
catch (Exception e) {
e.printStackTrace();
}
    }
}
