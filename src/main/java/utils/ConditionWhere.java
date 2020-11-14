package utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class ConditionWhere {
    String leftOperandParameter;

    public Condition isEqualTo(String rightOperandParameter) {
        return Condition.of(leftOperandParameter, "=", rightOperandParameter);
    }
}
