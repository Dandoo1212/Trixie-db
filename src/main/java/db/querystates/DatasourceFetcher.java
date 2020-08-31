package db.querystates;

import db.QueryResult;
import db.Row;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

public class DatasourceFetcher {
    private DataSource dataSource;


    public QueryResult fetch(String query) {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new QueryResult(Collections.emptyList());
    }
}
