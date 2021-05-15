package utils;

public class Conditions {
    public static ConditionWhere where(String leftOperandParameter){
        return ConditionWhere.of(leftOperandParameter);
    }

}
