package utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class Condition {
    String leftOperandParameter;
    String operand;
    String rightOperandParameter;

    public String createConditionString() {
        return leftOperandParameter + " " + operand + " " + rightOperandParameter;
    }
}
