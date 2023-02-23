package org.example.dataBaseHandlers;

import org.example.dataBase.DataBaseConnection;
import org.example.dataBaseAnnotations.Column;
import org.example.dataBaseAnnotations.Table;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class RecordHandler {
    Map<String, Object> record;

    public RecordHandler() {
        record = new LinkedHashMap<>();
    }

    public boolean createRecord(Object object, DataBaseConnection dataBaseConnection) throws IllegalAccessException, SQLException {
        if (!object.getClass().isAnnotationPresent(Table.class)){
            return false;
        }

        var declaredFields = object.getClass().getDeclaredFields();
        for (Field field: declaredFields) {
            if (field.isAnnotationPresent(Column.class)){
                field.setAccessible(true);
                record.put(field.getAnnotation(Column.class).name(),field.get(object));
            }
        }


        StringBuilder sql = new StringBuilder("INSERT INTO ");
        var tableTitle = object.getClass().getAnnotation(Table.class).title();
        if(tableTitle.equals("")){
            tableTitle = object.getClass().getSimpleName();
        }
        sql.append(tableTitle).append(" (");
        for (Map.Entry<String, Object> entry : record.entrySet()) {
            sql.append(" ").append(entry.getKey()).append(",");
        }
        sql = new StringBuilder(sql.substring(0, sql.length() - 1));
        sql.append(") VALUES (");
        for (Map.Entry<String, Object> entry : record.entrySet()) {
            if (entry.getValue() instanceof String){
                sql.append(" " + "'").append(entry.getValue()).append("'").append(",");
                continue;
            }
            sql.append(" ").append(entry.getValue()).append(",");
        }
        sql = new StringBuilder(sql.substring(0, sql.length() - 1));
        sql.append(");");

        dataBaseConnection.connect();
        dataBaseConnection.getStatement().executeUpdate(sql.toString());
        dataBaseConnection.disconnect();
        return true;
    }
}
