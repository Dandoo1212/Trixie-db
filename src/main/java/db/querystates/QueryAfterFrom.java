package db.querystates;

import utils.Condition;


public class QueryAfterFrom {
    private final QueryMaker queryMaker;

    private QueryAfterFrom(QueryMaker queryMaker) {
        this.queryMaker = queryMaker;
    }

    static QueryAfterFrom of(QueryMaker queryMaker) {
        return new QueryAfterFrom(queryMaker);
    }


    public QueryAfterFrom join(String tableName, Condition joinCondition) {
        queryMaker.join(tableName, joinCondition);
        return this;
    }

    public QueryAfterWhere where(Condition whereCondition) {
        return QueryAfterWhere.of(queryMaker.where(whereCondition));
    }

    public QueryAfterOrder orderBy(String orderParameter) {
        return QueryAfterOrder.of(queryMaker.orderBy(orderParameter));
    }

    public String create() {
        return queryMaker.getQueryText();
    }
}
