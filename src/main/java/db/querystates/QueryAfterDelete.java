package db.querystates;

import lombok.AllArgsConstructor;
import utils.Condition;

@AllArgsConstructor(staticName = "of")
public class QueryAfterDelete {
    private final QueryMaker queryMaker;

    public QueryAfterWhereInDelete where(Condition whereCondition) {
        return QueryAfterWhereInDelete.of(queryMaker.where(whereCondition));
    }
}
