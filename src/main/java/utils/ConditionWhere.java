package utils;

import lombok.AllArgsConstructor;

import static utils.StringUtils.appendBrackets;
import static utils.StringUtils.createListOfValues;

@AllArgsConstructor(staticName = "of")
public class ConditionWhere {

    private static final String EQUAL_OPERAND = "=";
    private static final String LIKE_OPERAND = "LIKE";
    private static final String GREATER_OPERAND = ">";
    private static final String LESS_OPERAND = "<";
    private static final String GREATER_EQUAL_OPERAND = ">=";
    private static final String LESS_EQUAL_OPERAND = "<=";
    private static final String NOT_EQUAL_OPERAND = "<>";
    private static final String BETWEEN_OPERAND = "BETWEEN";
    private static final String IS_IN_OPERAND = "IS IN";
    private static final String AND_OPERAND = " AND ";

    private final String leftOperandParameter;

    public Condition isEqualTo(String rightOperandParameter) {
        return Condition.of(leftOperandParameter, EQUAL_OPERAND, rightOperandParameter);
    }

    public Condition isLike(String isLikeParameter) {
        return Condition.of(leftOperandParameter, LIKE_OPERAND, isLikeParameter);
    }

    public Condition isGreaterThan(String isGreaterParameter) {
        return Condition.of(leftOperandParameter, GREATER_OPERAND, isGreaterParameter);
    }

    public Condition isLessThan(String isLessParamter) {
        return Condition.of(leftOperandParameter, LESS_OPERAND, isLessParamter);
    }

    public Condition isGreaterOrEqualThan(String isGreaterParameter) {
        return Condition.of(leftOperandParameter, GREATER_EQUAL_OPERAND, isGreaterParameter);
    }

    public Condition isLessOrEqualThan(String isLessParameter) {
        return Condition.of(leftOperandParameter, LESS_EQUAL_OPERAND, isLessParameter);
    }

    public Condition isNotEqualTo(String notEqualParameter) {
        return Condition.of(leftOperandParameter, NOT_EQUAL_OPERAND, notEqualParameter);
    }

    public Condition isBetween(String firstValue, String secondValue) {
        return Condition.of(leftOperandParameter, BETWEEN_OPERAND, joinWithAndOperator(firstValue, secondValue));
    }

    public Condition isIn(String... values) {
        return Condition.of(leftOperandParameter, IS_IN_OPERAND, createListOfValues(values));
    }

    public Condition isIn(String sql) {
        return Condition.of(leftOperandParameter, IS_IN_OPERAND, appendBrackets(sql));
    }

    public Condition ownCondition(String operand, String rightOperand) {
        return Condition.of(leftOperandParameter, operand, rightOperand);
    }

    private String joinWithAndOperator(String firstValue, String secondValue) {
        return firstValue + AND_OPERAND + secondValue;
    }
}
