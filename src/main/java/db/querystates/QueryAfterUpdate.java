package db.querystates;

import lombok.AllArgsConstructor;
import utils.SetParameter;

@AllArgsConstructor(staticName = "of")
public class QueryAfterUpdate {
    private final QueryMaker queryMaker;

    public QueryAfterSet set(SetParameter... setParameters){
        return QueryAfterSet.of(queryMaker.set(setParameters));
    }
}
