package db.querystates;

import db.querystates.QueryAfterFrom;

public class QueryCreator {

    public String createQuery(QueryAfterFrom queryAfterFrom){
        String fields  = String.join(", ", queryAfterFrom
                .getQueryAfterSelect()
                .getFieldsToFetch());
        String tableName = queryAfterFrom.getTableName();
        return "SELECT " + fields + " FROM " +tableName;
    }
}
