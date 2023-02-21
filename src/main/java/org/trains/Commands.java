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

            statement = connection.createStatement();
            rs=statement.executeQuery(query);


            // Here you can select how it displays the data, you can either use columnLabel or columnIndex
            while (rs.next()) {
                out.print("There are ");
                out.print(rs.getString(2));
                out.print(" trains at ");
                out.println(rs.getString(1));
            }
        } catch (Exception e) {
            out.println(e);
        }
    }
    public static void insertTrain(String inputTrainName, String inputCargo, int inputSpeed, String inputTrainMaker, String inputDate, String inputCurrentStation, String inputDestination) {
        Connection connection;
        Statement statement;
        ResultSet rs = null;

        ConnectDB obj_ConnectDB = new ConnectDB();

        connection = obj_ConnectDB.get_connection();

        try {

            String query = "SELECT FROM station WHERE station_name = '" + inputCurrentStation + "'";

            statement = connection.createStatement();
            rs=statement.executeQuery(query);

            while (rs.next()) {
                int trainCurrentLocationId = Integer.parseInt(rs.getString(1));
            }

            String query2 = "SELECT FROM station WHERE station_name = '" + inputDestination + "'";

            statement = connection.createStatement();
            rs=statement.executeQuery(query2);

            int trainDestinationId = Integer.parseInt(rs.getString(1));

            String query3 = "insert into trains (train_name, cargo, speed, maker, produc_year, current_location_id, next_destination_id) values('" + inputTrainName + "', '" + inputCargo + "', " + inputSpeed + ", '" + inputTrainMaker + "', '" + inputDate + "', " + trainCurrentLocationId + ", " + trainDestinationId + ")";
            statement = connection.createStatement();
            statement.executeUpdate(query3);

            out.println("Value Successfully Inserted");


        } catch (Exception e) {
            out.println(e);
        }
    }
    public static void insertStation(String inputStationName) {
        Connection connection;
        Statement statement;

        ConnectDB obj_ConnectDB = new ConnectDB();

        connection = obj_ConnectDB.get_connection();

        try {
            String query = "insert into station (station_name) values ('" + inputStationName + "')";
            statement = connection.createStatement();
            statement.executeUpdate(query);

            out.println("Value Successfully Inserted");

        } catch (Exception e) {
            out.println(e);
        }
    }
}
