package db;

import db.querystates.QueryAfterSelect;
import db.querystates.QueryUtils;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DatasourceService {

    private final QueryUtils queryUtils;

    public QueryAfterSelect select(String... fieldsToFetch) {
        return QueryAfterSelect.of(queryUtils, List.of(fieldsToFetch));
    }
}
