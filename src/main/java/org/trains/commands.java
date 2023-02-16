package org.trains;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.lang.System.out;

public class commands {
    public static void trainsInStation(String userInput) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB obj_ConnectDB = new ConnectDB();

        connection = obj_ConnectDB.get_connection();

        try {
            String query = "SELECT station.station_name, count(*) FROM station " +
                    "JOIN train ON train.station_id = station.id " +
                    "WHERE station.station_name = '" + userInput + "' " +
                    "GROUP BY station.station_name";
            statement = connection.createStatement();
            rs=statement.executeQuery(query);


            // Here you can select how it displays the data, you can either use columnLabel or columnIndex
            while (rs.next()) {
                out.println("There are " + rs.getString(2) + " at " + rs.getString(1));
            }
        } catch (Exception e) {
            out.println(e);
        }
    }
}
