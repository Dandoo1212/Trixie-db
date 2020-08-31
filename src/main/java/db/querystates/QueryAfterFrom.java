package db.querystates;

import db.QueryResult;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter(value = AccessLevel.PACKAGE)
public class QueryAfterFrom {
    private final QueryAfterSelect queryAfterSelect;
    private final QueryUtils queryUtils;
    private final String tableName;

    public QueryResult execute(){
        return queryUtils.execute(this);
    }
}
