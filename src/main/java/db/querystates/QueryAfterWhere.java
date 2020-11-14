package db.querystates;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class QueryAfterWhere {
    private final QueryMaker queryMaker;

    public String create() {
        return queryMaker.getQueryText();
    }

    public QueryAfterOrder orderBy(String orderParameter) {
        return QueryAfterOrder.of(queryMaker.orderBy(orderParameter));
    }
}
