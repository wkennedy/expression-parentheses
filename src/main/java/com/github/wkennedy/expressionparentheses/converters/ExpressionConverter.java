package com.github.wkennedy.expressionparentheses.converters;

public interface ExpressionConverter {

    /**
     * @param expression the expression in a format you want to convert from
     * @return String - the converted expression
     */
    String convert(String expression);

}
