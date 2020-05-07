package com.github.wkennedy.expressionparentheses.converters;

import java.util.Stack;

public class PostfixToInfixExpressionConverter extends BaseExpressionConverter {

    @Override
    public String convert(String postfix) {
        if (postfix == null || postfix.isEmpty()) {
            return "";
        }

        //Expressions were separated by space via the InfixToPostfixExpressionConverter to preserve operand accuracy
        String[] expressions = postfix.split("\\s");
        Stack<ExpressionHelper> expressionStack = new Stack<>();
        for (String expression : expressions) {
            if (getPrecedence(expression) < 1) {
                expressionStack.push(new ExpressionHelper(expression, ""));
            } else {
                String rightSide = "";
                String leftSide = "";
                if (getPrecedence(expression) == 1) { //+ or -
                    rightSide = expressionStack.pop().getExpression();
                    leftSide = expressionStack.pop().getExpression();
                } else if (getPrecedence(expression) > 1) { // *, / or ^
                    rightSide = addParentheses(expressionStack.pop());
                    leftSide = addParentheses(expressionStack.pop());
                }

                expressionStack.push(new ExpressionHelper(leftSide + expression + rightSide, expression));
            }
        }
        return expressionStack.pop().getExpression();
    }

    private String addParentheses(ExpressionHelper expressionHelper) {
        String expression = expressionHelper.getExpression();
        String operator = expressionHelper.getOperator();
        if (getPrecedence(operator) == 1) {
            expression = String.format("(%s)", expression);
        }
        return expression;
    }

    private static class ExpressionHelper {
        private final String expression;
        private final String operator;

        public ExpressionHelper(String expression, String operator) {
            this.expression = expression;
            this.operator = operator;
        }

        public String getExpression() {
            return expression;
        }

        public String getOperator() {
            return operator;
        }
    }
}
