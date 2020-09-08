package db.querystates;

import static java.util.Arrays.asList;

public class QueryCreator {
    public static QueryAfterSelect select(String... parameters){
        return QueryAfterSelect.of(new QueryMaker(), asList(parameters));
    }
}
