package db;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Row {
    private final Map<String, String> results;

    public String getResultString(String name){
        return results.get(name);
    }

}
