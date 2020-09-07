package db.querystates;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@Getter(value = AccessLevel.PACKAGE)
public class QueryAfterSelect {
    private final QueryUtils queryUtils;
    private final List<String> fieldsToFetch;

    public QueryAfterFrom from(String tableName) {
        return QueryAfterFrom.of(this, queryUtils, tableName);
    }
}
