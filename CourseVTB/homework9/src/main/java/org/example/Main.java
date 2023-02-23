package org.example;

import org.example.dataBase.DataBaseConnection;
import org.example.dataBaseHandlers.RecordHandler;
import org.example.dataBaseHandlers.TableHandler;
import org.example.entity.Employee;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            var dataBaseConnection = DataBaseConnection.getInstance();
            new TableHandler().createTable(Employee.class, dataBaseConnection);
            new RecordHandler().createRecord(new Employee(1,"bob",21), dataBaseConnection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}