package org.example.dataBase;

import java.sql.*;

public class DataBaseConnection {
    private static DataBaseConnection INSTANCE;
    private Connection connection;
    private Statement statement;

    private DataBaseConnection(){}

    public static DataBaseConnection getInstance() {
        if(INSTANCE == null){
            INSTANCE = new DataBaseConnection();
        }
        return INSTANCE;
    }

    public void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }
    public void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

}
