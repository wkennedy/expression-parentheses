package com.github.wkennedy.expressionparentheses.converters;

public class ExpressionConverterFactory {

    private static final InfixToPostfixExpressionConverter infixToPostfixExpressionConverter = new InfixToPostfixExpressionConverter();
    private static final PostfixToInfixExpressionConverter postfixToInfixExpressionConverter = new PostfixToInfixExpressionConverter();

    public static ExpressionConverter getExpressionConverter(ExpressionConverterType expressionConverterType) {
        if (expressionConverterType == ExpressionConverterType.INFIX_TO_POSTFIX) {
            return infixToPostfixExpressionConverter;
        } else if (expressionConverterType == ExpressionConverterType.POSTFIX_TO_INFIX) {
            return postfixToInfixExpressionConverter;
        }

        throw new IllegalArgumentException("No converter found for type: " + expressionConverterType);
    }

    public static ExpressionConverter getPostfixToInfixExpressionConverter() {
        return getExpressionConverter(ExpressionConverterType.POSTFIX_TO_INFIX);
    }

    public static ExpressionConverter getInfixToPostfixExpressionConverter() {
        return getExpressionConverter(ExpressionConverterType.INFIX_TO_POSTFIX);
    }
}
