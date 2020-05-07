package com.github.wkennedy.expressionparentheses.converters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InfixToPostfixExpressionConverterTest {

    private final ExpressionConverter infixToPostfixExpressionConverter = ExpressionConverterFactory.getInfixToPostfixExpressionConverter();

    @Test
    void convert() {
        String postfixExpression = infixToPostfixExpressionConverter.convert("1*(2+(3*(4+5)))");
        assertEquals("1 2 3 4 5 + * + *", postfixExpression);

        postfixExpression = infixToPostfixExpressionConverter.convert("1*(2+(3*(-4+5)))");
        assertEquals("1 2 3 -4 5 + * + *", postfixExpression);

        postfixExpression = infixToPostfixExpressionConverter.convert("2 + (3 / -5)");
        assertEquals("2 3 -5 / +", postfixExpression);

        String simplifiedExpression = infixToPostfixExpressionConverter.convert("(4*12)+11");
        assertEquals("4 12 * 11 +", simplifiedExpression);

        postfixExpression = infixToPostfixExpressionConverter.convert("x+(y+z)+(t+(v+w))");
        assertEquals("x y z + + t v w + + +", postfixExpression);

        postfixExpression = infixToPostfixExpressionConverter.convert(null);
        assertEquals("", postfixExpression);

        postfixExpression = infixToPostfixExpressionConverter.convert("");
        assertEquals("", postfixExpression);
    }

    @Test
    void simpleTest() {
        String postfixExpression = infixToPostfixExpressionConverter.convert("x+(y+z)+(t+(v+w))");
        assertEquals("x y z + + t v w + + +", postfixExpression);
    }
}