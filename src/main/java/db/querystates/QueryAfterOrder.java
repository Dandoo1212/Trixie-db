package db.querystates;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class QueryAfterOrder {
    private final QueryMaker queryMaker;

    public String create() {
        return queryMaker.getQueryText();
    }
}
