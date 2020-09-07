package db;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor(staticName = "of")
@ToString
public class Row {
    private final Map<String, String> results;

    public String getResultString(String name){
        return results.get(name);
    }
}
