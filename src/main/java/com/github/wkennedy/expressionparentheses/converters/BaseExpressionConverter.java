package com.github.wkennedy.expressionparentheses.converters;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseExpressionConverter implements ExpressionConverter {
    protected static final Map<Character, Integer> operatorPrecedence = new HashMap<>();

    static {
        operatorPrecedence.put('+', 1);
        operatorPrecedence.put('-', 1);
        operatorPrecedence.put('*', 2);
        operatorPrecedence.put('/', 2);
        operatorPrecedence.put('^', 3);
    }

    public static int getPrecedence(char operator) {
        if (operatorPrecedence.containsKey(operator)) {
            return operatorPrecedence.get(operator);
        }

        return -1;
    }

    public static int getPrecedence(String operator) {
        if (operator == null || operator.length() != 1) {
            return -1;
        }

        if (operatorPrecedence.containsKey(operator.charAt(0))) {
            return operatorPrecedence.get(operator.charAt(0));
        }

        return -1;
    }
}
