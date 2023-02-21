package org.trains;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Commands {
    public static void trainsInStation(String userInput) {
        Connection connection;
        Statement statement;
        ResultSet rs;

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
        ResultSet rs;

        ConnectDB obj_ConnectDB = new ConnectDB();

        connection = obj_ConnectDB.get_connection();

        try {

            String query = "SELECT * FROM station WHERE station_name = '" + inputCurrentStation + "'";

            statement = connection.createStatement();
            rs=statement.executeQuery(query);

            rs.next();
            int trainCurrentLocationId = Integer.parseInt(rs.getString(1));

            String query2 = "SELECT * FROM station WHERE station_name = '" + inputDestination + "'";

            statement = connection.createStatement();
            rs=statement.executeQuery(query2);

            rs.next();
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
    public static void viewAllTrains() {
        Connection connection;
        Statement statement;
        ResultSet rs;

        ConnectDB obj_ConnectDB = new ConnectDB();

        connection = obj_ConnectDB.get_connection();

        try {
            String query = "SELECT * FROM trains";
            statement = connection.createStatement();
            rs=statement.executeQuery(query);

            out.println("Train All info:");

            while (rs.next()) {
                out.print("Name: ");
                out.print(rs.getString(2));
                out.print("      ");
                out.print("Cargo: ");
                out.print(rs.getString(3));
                out.print("      ");
                out.print("Speed: ");
                out.print(rs.getString(4));
                out.print("mph      ");
                out.print("Maker: ");
                out.print(rs.getString(5));
                out.print("      ");
                out.print("Production Date: ");
                out.print(rs.getString(6));
                out.println();
                out.println();
            }

            out.println("Value Successfully Inserted");

        } catch (Exception e) {
            out.println(e);
        }
    }
    public static void viewAllStation() {
        Connection connection;
        Statement statement;
        ResultSet rs;

        ConnectDB obj_ConnectDB = new ConnectDB();

        connection = obj_ConnectDB.get_connection();

        try {

            String query = "SELECT * FROM station";
            statement = connection.createStatement();
            rs=statement.executeQuery(query);

            out.println("Station Info: ");
            while (rs.next()) {
                out.print("Name: ");
                out.print(rs.getString(2));
                out.println();
                out.println();
            }

            out.println("Value Successfully Inserted");

        } catch (Exception e) {
            out.println(e);
        }
    }
    public static void alterDestination(String inputTrain, String inputDestination) {
        Connection connection;
        Statement statement;
        ResultSet rs;

        ConnectDB obj_ConnectDB = new ConnectDB();

        connection = obj_ConnectDB.get_connection();

        try {

            String query = "SELECT * FROM station WHERE station_name = '" + inputDestination + "'";

            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            rs.next();
            int trainDestinationId = Integer.parseInt(rs.getString(1));

            String query2 = "UPDATE trains SET next_destination_id = " + trainDestinationId + " WHERE train_name = '" + inputTrain + "'";

            statement = connection.createStatement();
            statement.executeUpdate(query2);


            out.println("Value Successfully Inserted");

        } catch (Exception e) {
            out.println(e);
        }
    }

    public static void viewInfoTrain(String inputTrainName) {
        Connection connection;
        Statement statement;
        ResultSet rs;

        ConnectDB obj_ConnectDB = new ConnectDB();

        connection = obj_ConnectDB.get_connection();

        try {

            String query = "SELECT * FROM trains WHERE train_name = '" + inputTrainName + "'";
            statement = connection.createStatement();
            rs=statement.executeQuery(query);

            out.println("Train Info: ");
            while (rs.next()) {
                out.print("Name: ");
                out.print(rs.getString(2));
                out.print("      ");
                out.print("Cargo: ");
                out.print(rs.getString(3));
                out.print("      ");
                out.print("Speed: ");
                out.print(rs.getString(4));
                out.print("mph      ");
                out.print("Maker: ");
                out.print(rs.getString(5));
                out.print("      ");
                out.print("Production Date: ");
                out.print(rs.getString(6));
                out.println();
                out.println();
            }

            out.println("Value Successfully Inserted");

        } catch (Exception e) {
            out.println(e);
        }
    }
    public static void goMethod() {
        Connection connection;
        Statement statement;
        ResultSet rs;

        ConnectDB obj_ConnectDB = new ConnectDB();

        connection = obj_ConnectDB.get_connection();

        try {
            String query = "SELECT * FROM trains";
            statement = connection.createStatement();
            rs=statement.executeQuery(query);

            List<List> l = new ArrayList<>();

            while (rs.next()) {
                List<String> l2 = new ArrayList<>();
                l2.add(rs.getString(1));
                l2.add(rs.getString(2));
                l2.add(rs.getString(3));
                l2.add(rs.getString(4));
                l2.add(rs.getString(5));
                l2.add(rs.getString(6));
                l2.add(rs.getString(7));
                l2.add(rs.getString(8));
                l.add(l2);
            }
            for (List each: l) {
                String query2 = "UPDATE trains SET current_location_id = " + each.get(7) + " WHERE train_name = '" + each.get(1) + "'";
                statement = connection.createStatement();
                statement.executeUpdate(query2);

                String query3 = "UPDATE trains SET next_destination_id = " + each.get(6) + " WHERE train_name = '" + each.get(1) + "'";
                statement = connection.createStatement();
                statement.executeUpdate(query3);
            }
        } catch (Exception e) {
            out.println(e);
        }
    }
}
