package db.querystates;

import utils.Condition;

public class QueryMaker {

    StringBuffer queryText;

    private QueryMaker(StringBuffer queryText) {
        this.queryText = queryText;
    }

    static QueryMaker create(String... selectParameters) {
        StringBuffer stringBuffer = new StringBuffer("SELECT ")
                .append(String.join(", ", selectParameters));
        return new QueryMaker(stringBuffer);
    }

    String getQueryText() {
        return queryText.toString();
    }

    QueryMaker from(String tableName) {
        queryText.append(" FROM ").append(tableName);
        return this;
    }

    public QueryMaker orderBy(String orderParameter) {
        queryText.append(" ORDER BY ").append(orderParameter);
        return this;
    }

    public void join(String tableName, Condition joinCondition) {
        queryText.append(" JOIN ").append(tableName).append(" ON ").append(joinCondition.createConditionString());
    }

    public QueryMaker where(Condition whereCondition) {
        queryText.append(" WHERE ").append(whereCondition.createConditionString());
        return this;
    }
}
