package db;

import db.querystates.QueryAfterSelect;
import db.querystates.QueryUtils;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class DatasourceService {

    private QueryUtils queryUtils;


    public QueryAfterSelect select(String... fieldsToFetch){
        return QueryAfterSelect.of(Arrays.asList(fieldsToFetch));
    }
}
