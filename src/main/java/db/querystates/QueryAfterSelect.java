package db.querystates;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class QueryAfterSelect {
    private final QueryMaker queryMaker;

    public QueryAfterFrom from(String tableName) {
        return QueryAfterFrom.of(queryMaker.from(tableName));
    }
}
