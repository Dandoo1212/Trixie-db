package db.querystates;

import utils.Condition;
import utils.SetParameter;
import utils.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

class QueryMaker {

    private final StringBuffer queryText;

    private QueryMaker(StringBuffer queryText) {
        this.queryText = queryText;
    }

    static QueryMaker createSelectMaker(String... selectParameters) {
        StringBuffer stringBuffer = new StringBuffer("SELECT ").append(String.join(", ", selectParameters));
        return new QueryMaker(stringBuffer);
    }

    static QueryMaker createInsertMaker(String tableName) {
        StringBuffer stringBuffer = new StringBuffer("INSERT INTO ").append(tableName);
        return new QueryMaker(stringBuffer);
    }

    static QueryMaker createInsertMaker(String tableName, String... tableColumns) {
        StringBuffer stringBuffer = new StringBuffer("INSERT INTO ")
                .append(tableName)
                .append(StringUtils.createListOfValues(tableColumns));
        return new QueryMaker(stringBuffer);
    }

    static QueryMaker createRemoveMaker(String tableName) {
        return new QueryMaker(new StringBuffer("DELETE FROM ").append(tableName));
    }

    static QueryMaker createUpdateMaker(String tableName) {
        return new QueryMaker(new StringBuffer("UPDATE ").append(tableName));
    }

    String getQueryText() {
        return queryText.toString() + ";";
    }

    QueryMaker from(String tableName) {
        queryText
                .append(" FROM ")
                .append(tableName);
        return this;
    }

    QueryMaker orderBy(String orderParameter) {
        queryText
                .append(" ORDER BY ")
                .append(orderParameter);
        return this;
    }

    void join(String tableName, Condition joinCondition) {
        queryText
                .append(" JOIN ")
                .append(tableName)
                .append(" ON ")
                .append(joinCondition.createConditionString());
    }

    QueryMaker where(Condition whereCondition) {
        queryText
                .append(" WHERE ")
                .append(whereCondition.createConditionString());
        return this;
    }

    QueryMaker values(String[] values) {
        queryText
                .append(" VALUES ")
                .append(StringUtils.createListOfValues(values));
        return this;
    }

    QueryMaker set(SetParameter[] setParameters) {
        queryText.append(Arrays
                .stream(setParameters)
                .map(SetParameter::createSetParameterText)
                .collect(Collectors.joining(", ")));
        return this;
    }
}
