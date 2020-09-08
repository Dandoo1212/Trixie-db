package db.querystates;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter(value = AccessLevel.PACKAGE)
public class QueryAfterFrom {
    private final QueryAfterSelect queryAfterSelect;
    private final QueryMaker queryMaker;
    private final String tableName;

    public String create(){
        return queryMaker.createQuery(this);
    }
}
