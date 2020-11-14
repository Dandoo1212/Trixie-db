package db.querystates;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")

public class QueryAfterInsert {
    private final QueryMaker queryMaker;

    public QueryAfterValues values(String... values) {
        return QueryAfterValues.of(queryMaker.values(values));
    }
}
