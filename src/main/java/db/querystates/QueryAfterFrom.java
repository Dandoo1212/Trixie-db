package db.querystates;

import lombok.AccessLevel;
import lombok.Getter;
import utils.Condition;

import java.util.HashMap;
import java.util.Map;


@Getter(value = AccessLevel.PACKAGE)
public class QueryAfterFrom {
    private final QueryAfterSelect queryAfterSelect;
    private final QueryMaker queryMaker;
    private final String tableName;
    private final Map<String, Condition> conditionByTableNamesToJoin;

    private QueryAfterFrom(QueryAfterSelect queryAfterSelect,
                           QueryMaker queryMaker,
                           String tableName,
                           Map<String, Condition> conditionByTableNamesToJoin) {
        this.queryAfterSelect = queryAfterSelect;
        this.queryMaker = queryMaker;
        this.tableName = tableName;
        this.conditionByTableNamesToJoin = conditionByTableNamesToJoin;
    }

    public static QueryAfterFrom of(QueryAfterSelect queryAfterSelect, QueryMaker queryMaker, String tableName){
        return new QueryAfterFrom(queryAfterSelect, queryMaker, tableName, new HashMap<>());
    }


    public QueryAfterFrom join(String tableName, Condition joinCondition){
        conditionByTableNamesToJoin.put(tableName, joinCondition);
        return this;
    }

    public QueryAfterOrder orderBy(String orderParameter){
        return QueryAfterOrder.of(this, orderParameter, queryMaker);
    }

    public String create(){
        return queryMaker.createQuery(this);
    }
}
