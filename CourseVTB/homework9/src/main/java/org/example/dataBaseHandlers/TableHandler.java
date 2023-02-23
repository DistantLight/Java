package org.example.dataBaseHandlers;

import org.example.dataBase.DataBaseConnection;
import org.example.dataBaseAnnotations.Column;
import org.example.dataBaseAnnotations.Table;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.*;

public class TableHandler {
    private HashMap<String, String> columns;

    public TableHandler() {
        columns = new HashMap<>();
    }

    public boolean createTable(Class classObject, DataBaseConnection dataBaseConnection) throws SQLException, InstantiationException, IllegalAccessException {
        if (!classObject.isAnnotationPresent(Table.class)){
            return false;
        }

        var declaredFields = classObject.getDeclaredFields();
        String columnDataType;
        String columnName;
        for (Field field: declaredFields) {
            if (field.isAnnotationPresent(Column.class)){
                if (field.getType().equals(String.class)) {
                    columnDataType = "TEXT";
                } else if (field.getType().equals(int.class)) {
                    columnDataType = "INTEGER";
                } else if (field.getType().equals(boolean.class)) {
                    columnDataType = "BOOLEAN";
                } else {
                    return false;
                }
                columnName = field.getAnnotation(Column.class).name();
                if(columnName.equals("")){
                    columnName = field.getName();
                }
                columns.put(columnName, columnDataType);
                }
        }

        var tableTitle = classObject.newInstance().getClass().getAnnotation(Table.class).title();
        if(tableTitle.equals("")){
            tableTitle = classObject.getSimpleName();
        }
        String sql = "CREATE TABLE IF NOT EXISTS " + tableTitle + "(";
        for (Map.Entry<String, String> entry : columns.entrySet()) {
            sql += entry.getKey() + " " + entry.getValue() + ",";
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += ");";

        dataBaseConnection.connect();
        dataBaseConnection.getStatement().executeUpdate(sql);
        dataBaseConnection.disconnect();
        return true;
    }
}
