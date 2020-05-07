package com.github.wkennedy.expressionparentheses.converters;

import java.util.Stack;

public class InfixToPostfixExpressionConverter extends BaseExpressionConverter {

    @Override
    public String convert(String infixExpression) {
        if (infixExpression == null || infixExpression.isEmpty()) {
            return "";
        }

        //Remove white space from the expression so we don't consider that when we are looping through the characters
        infixExpression = infixExpression.replaceAll("\\s+", "");

        //The postfix expression will be our final result
        StringBuilder postfixExpression = new StringBuilder();
        //Keep track of operators and parentheses on the stack
        Stack<Character> operatorStack = new Stack<>();

        //Begin evaluation of the infix expression
        for (int i = 0; i < infixExpression.length(); i++) {
            char currentChar = infixExpression.charAt(i);

            //If the current character is an operator
            if (InfixToPostfixExpressionConverter.operatorPrecedence.containsKey(currentChar)) {
                //Handle the special case for negation versus subtraction. We know if the '-' is the first character
                //in the expression or the last character was an operator, then concat it to the postfix expression
                if (currentChar == '-') {
                    Character topOperator = operatorStack.peek();
                    if (topOperator == null || topOperator == '(' || InfixToPostfixExpressionConverter.operatorPrecedence.containsKey(topOperator)) {
                        postfixExpression.append(currentChar);
                    }
                } else {
                    //      If the precedence of scanned operator is less than or equal to the top most operator of operator's stack,
                    //      pop the operators from operand's stack until we find a low precedence operator than the scanned character.
                    //      Never pop out ( '(' ) or ( ')' ) whatever may be the precedence level of scanned character.
                    while (!operatorStack.isEmpty() &&
                            getPrecedence(currentChar) <= getPrecedence(operatorStack.peek())) {
                        postfixExpression.append(" ");
                        postfixExpression.append(operatorStack.pop());
                    }
                    postfixExpression.append(" ");
                    operatorStack.push(currentChar);
                }
            } else if (currentChar == '(') {
                operatorStack.push(currentChar);
            } else if (currentChar == ')') {
                //Closing paren found, pop operator stack until we find matching paren and append operators to postfix expression along the way
                Character topOperator = operatorStack.pop();
                while (topOperator != '(') {
                    postfixExpression.append(" ");
                    postfixExpression.append(topOperator);

                    topOperator = operatorStack.pop();
                }
            } else {
                postfixExpression.append(currentChar);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixExpression.append(" ");
            postfixExpression.append(operatorStack.pop());
        }

        return postfixExpression.toString();
    }
}
