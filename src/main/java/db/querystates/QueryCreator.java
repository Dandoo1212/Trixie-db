package db.querystates;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static db.querystates.QueryMaker.*;

public class QueryCreator {

    public static QueryAfterSelect select(String... selectParameters) {
        return QueryAfterSelect.of(createSelectMaker(selectParameters));
    }

    public static <T> QueryAfterSelect select(Class<T> clazz) {
        return QueryAfterSelect.of(createSelectMaker(fetchFieldNames(clazz)));
    }

    public static <T> QueryAfterFrom selectAllFrom(Class<T> clazz) {
        return QueryAfterSelect
                .of(createSelectMaker(fetchFieldNames(clazz)))
                .from(clazz.getSimpleName());
    }

    public static QueryAfterInsert insert(String tableName) {
        return QueryAfterInsert.of(createInsertMaker(tableName));
    }

    public static QueryAfterInsert insert(String tableName, String tableColumns) {
        return QueryAfterInsert.of(createInsertMaker(tableName, tableColumns));
    }

    public static QueryAfterDelete delete(String tableName) {
        return QueryAfterDelete.of(createRemoveMaker(tableName));
    }

    public static QueryAfterUpdate update(String tableName) {
        return QueryAfterUpdate.of(createUpdateMaker(tableName));
    }

    private static <T> String[] fetchFieldNames(Class<T> clazz) {
        List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
        return fields
                .stream()
                .map(Field::getName)
                .toArray(String[]::new);
    }
}
