package org.trains;

import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.System.out;

public class ConnectDB {
    public Connection get_connection() {

        Connection connection = null;

        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            out.println(connection != null ? "Connection Success" : "Connection Failure");

        } catch (Exception e) {
            out.println(e);
        }
        return connection;
    }
}
