package db.querystates;

import db.QueryResult;
import db.Row;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonMap;

@AllArgsConstructor
public class DatasourceFetcher {
    private final Connection connection;

    public QueryResult fetch(String query, List<String> parameters) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Row> rows = new ArrayList<>();
            while (resultSet.next()) {
                parameters.forEach(parameter -> {
                    try {
                        rows.add(Row.of(singletonMap(parameter, resultSet.getString(parameter))));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                });
            }
            return QueryResult.of(rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return QueryResult.of(Collections.emptyList());
    }
}
