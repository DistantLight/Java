package org.example.dataBaseHandlers;

import org.example.dataBase.DataBaseConnection;
import org.example.dataBaseAnnotations.Column;
import org.example.dataBaseAnnotations.Table;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.*;

public class TableHandler {

    public TableHandler() {

    }

    public boolean createTable(Class classObject, DataBaseConnection dataBaseConnection) throws SQLException, InstantiationException, IllegalAccessException {
        if (!classObject.isAnnotationPresent(Table.class)){
            throw new RuntimeException("@Table missed");
        }

        Map<Class, String> dataTypeToSting = new HashMap<>();
        dataTypeToSting.put(int.class, "INTEGER");
        dataTypeToSting.put(String.class, "TEXT");

        var sqlQuery = new StringBuilder("CREATE TABLE ");
        var tableTitle = ((Table)classObject.getAnnotation(Table.class)).title();
        if(tableTitle.equals("")){
            tableTitle = classObject.getSimpleName();
        }
        sqlQuery.append(tableTitle);
        sqlQuery.append(" (");
        var declaredFields = classObject.getDeclaredFields();
        for(Field field: declaredFields){
            if(field.isAnnotationPresent(Column.class)) {
                sqlQuery.append(field.getName())
                        .append(" ")
                        .append(dataTypeToSting.get(field.getType()))
                        .append(", ");
            }
        }
        sqlQuery.setLength(sqlQuery.length() - 2);
        sqlQuery.append(");");

        dataBaseConnection.connect();
        dataBaseConnection.getStatement().executeUpdate(sqlQuery.toString());
        dataBaseConnection.disconnect();
        return true;
    }
}
