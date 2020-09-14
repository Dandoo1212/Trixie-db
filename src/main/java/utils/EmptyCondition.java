package utils;

public class EmptyCondition {
    public static ConditionWhere where(String leftOperandParameter){
        return ConditionWhere.of(leftOperandParameter);
    }

}
