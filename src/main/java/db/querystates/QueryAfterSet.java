package db.querystates;

import lombok.AllArgsConstructor;
import utils.Condition;

@AllArgsConstructor(staticName = "of")
public class QueryAfterSet {
    private final QueryMaker queryMaker;
    public String create(){
        return queryMaker.getQueryText();
    }

    public QueryAfterWhereInUpdate where(Condition condition){
        return QueryAfterWhereInUpdate.of(queryMaker.where(condition));
    }
}
