package db.querystates;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter(value = AccessLevel.PACKAGE)
public class QueryAfterSelect {
    private final QueryMaker queryMaker;

    public QueryAfterFrom from(String tableName) {
        return QueryAfterFrom.of(queryMaker.from(tableName));
    }
}
