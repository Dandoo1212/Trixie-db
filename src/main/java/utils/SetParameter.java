package utils;

//import lombok.AllArgsConstructor;

import static utils.StringParameter.stringParameter;
//@AllArgsConstructor(staticName = "of") //TODO don't want to work. Don't know why
public class SetParameter {
    private final String columnName;
    private final String columnValue;

    private SetParameter(String columnName, String columnValue) {
        this.columnName = columnName;
        this.columnValue = columnValue;
    }

    public static SetParameter setParameter(String columnName, String columnValue){
        return new SetParameter(columnName, columnValue);
    }
    public String createSetParameterText(){
        return columnName + " = " + stringParameter(columnValue);
    }
}
