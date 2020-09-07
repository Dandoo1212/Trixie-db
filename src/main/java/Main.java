import db.DatasourceService;
import db.QueryResult;
import db.querystates.DatasourceFetcher;
import db.querystates.QueryCreator;
import db.querystates.QueryUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "get", "yourpass");
        DatasourceService datasourceService = new DatasourceService(new QueryUtils(new QueryCreator(),
                new DatasourceFetcher(connection)));

        QueryResult execute = datasourceService.select("id", "x", "y").from("point").execute();
        execute.getRows().forEach(System.out::println);
        execute.getRows().stream()
                .map(row-> row.getResultString("id"))
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }
}
