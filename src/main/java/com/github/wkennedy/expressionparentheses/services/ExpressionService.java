package com.github.wkennedy.expressionparentheses.services;

import com.github.wkennedy.expressionparentheses.converters.ExpressionConverter;
import com.github.wkennedy.expressionparentheses.converters.ExpressionConverterFactory;
import org.springframework.stereotype.Service;

@Service
public class ExpressionService {

    private final ExpressionConverter infixToPostfixConverter = ExpressionConverterFactory.getInfixToPostfixExpressionConverter();
    private final ExpressionConverter postfixToInfixConverter = ExpressionConverterFactory.getPostfixToInfixExpressionConverter();

    public String removeRedundantParentheses(String expression) {
        expression = infixToPostfixConverter.convert(expression);
        expression = postfixToInfixConverter.convert(expression);

        return expression;
    }
}
