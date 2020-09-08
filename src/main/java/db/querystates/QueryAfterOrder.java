package db.querystates;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class QueryAfterOrder {
    private final QueryAfterFrom queryAfterFrom;
    private final String orderParameter;
    private final QueryMaker queryMaker;

    public void create(){
        //todo continue here
    }
}
