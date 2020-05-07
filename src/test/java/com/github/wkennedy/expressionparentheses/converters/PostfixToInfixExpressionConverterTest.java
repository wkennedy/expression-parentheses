package com.github.wkennedy.expressionparentheses.converters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostfixToInfixExpressionConverterTest {

    private final ExpressionConverter postfixToInfixExpressionConverter = ExpressionConverterFactory.getPostfixToInfixExpressionConverter();

    @Test
    void convert() {
        String infixExpression = postfixToInfixExpressionConverter.convert("1 2 3 4 5 + * + *");
        assertEquals("1*(2+3*(4+5))", infixExpression);

        infixExpression = postfixToInfixExpressionConverter.convert("1 2 3 -4 5 + * + *");
        assertEquals("1*(2+3*(-4+5))", infixExpression);

        infixExpression = postfixToInfixExpressionConverter.convert("2 3 -5 / +");
        assertEquals("2+3/-5", infixExpression);

        infixExpression = postfixToInfixExpressionConverter.convert("4 12 * 11 +");
        assertEquals("4*12+11", infixExpression);

        infixExpression = postfixToInfixExpressionConverter.convert("x y z + + t v w + + +");
        assertEquals("x+y+z+t+v+w", infixExpression);

        infixExpression = postfixToInfixExpressionConverter.convert(null);
        assertEquals("", infixExpression);

        infixExpression = postfixToInfixExpressionConverter.convert("1 2 + 3 *");
        assertEquals("(1+2)*3", infixExpression);
    }

    @Test
    void convertAdditional() {
        String infixExpression = postfixToInfixExpressionConverter.convert("1 2 + 3 *");
        assertEquals("(1+2)*3", infixExpression);

        infixExpression = postfixToInfixExpressionConverter.convert("2 3 -5 / +");
        assertEquals("2+3/-5", infixExpression);
    }

}