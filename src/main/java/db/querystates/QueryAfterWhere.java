package db.querystates;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class QueryAfterWhere {
    private final QueryMaker queryMaker;

    public String create() {
        return queryMaker.getQueryText();
    }
}
