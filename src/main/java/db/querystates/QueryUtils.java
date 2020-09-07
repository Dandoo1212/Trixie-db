package db.querystates;

import db.QueryResult;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QueryUtils {
    private final QueryCreator queryCreator;
    private final DatasourceFetcher datasourceFetcher;

    QueryResult execute(QueryAfterFrom queryAfterFrom){
        String query = queryCreator.createQuery(queryAfterFrom);
        return datasourceFetcher.fetch(query, queryAfterFrom.getQueryAfterSelect().getFieldsToFetch());
    }

}