package db.querystates;

public class QueryCreator {

    public static QueryAfterSelect select(String... selectParameters) {
        return QueryAfterSelect.of(QueryMaker.createSelectMaker(selectParameters));
    }

    public static QueryAfterInsert insert(String tableName) {
        return QueryAfterInsert.of(QueryMaker.createInsertMaker(tableName));
    }

    public static QueryAfterInsert insert(String tableName, String tableColumns){
        return QueryAfterInsert.of(QueryMaker.createInsertMaker(tableName, tableColumns));
    }

    public static QueryAfterDelete delete(String tableName){
        return QueryAfterDelete.of(QueryMaker.createRemoveMaker(tableName));
    }

    public static QueryAfterUpdate update(String tableName){
        return QueryAfterUpdate.of(QueryMaker.createUpdateMaker(tableName));
    }
}
