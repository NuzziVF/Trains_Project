package org.trains;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.lang.System.out;

public class Commands {
    public static void trainsInStation(String userInput) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB obj_ConnectDB = new ConnectDB();

        connection = obj_ConnectDB.get_connection();

        try {
            String query = "SELECT station.station_name, count(*) FROM station " +
                    "JOIN trains ON trains.current_location_id = station.id " +
                    "WHERE station.station_name = '" + userInput + "' " +
                    "GROUP BY station.station_name";
            out.println(query);
            statement = connection.createStatement();
            rs=statement.executeQuery(query);


            // Here you can select how it displays the data, you can either use columnLabel or columnIndex
            while (rs.next()) {
                out.print("There are ");
                out.print(rs.getString(2));
                out.print("trains at ");
                out.println(rs.getString(1));
            }
        } catch (Exception e) {
            out.println(e);
        }
    }
    public static void insertTrain() {
        String nameInput = "John";
        String addressInput = "USA";
        Connection connection;
        Statement statement;

        ConnectDB obj_ConnectDB = new ConnectDB();

        connection = obj_ConnectDB.get_connection();

        try {
            String query = "INSERT INTO employee(name, address) " +
                    "VALUES('" + nameInput +"', '" + addressInput + "')";
            statement = connection.createStatement();
            statement.executeUpdate(query);

            out.println("Value Successfully Inserted");


        } catch (Exception e) {
            out.println(e);
        }
    }
}
