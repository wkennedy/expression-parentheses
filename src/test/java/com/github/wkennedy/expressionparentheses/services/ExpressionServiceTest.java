package com.github.wkennedy.expressionparentheses.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionServiceTest {

    private final ExpressionService expressionService = new ExpressionService();

    @Test
    void removeRedundantParentheses() {
        String simplifiedExpression = expressionService.removeRedundantParentheses("1*(2+(3*(4+5)))");
        assertEquals("1*(2+3*(4+5))", simplifiedExpression);

        simplifiedExpression = expressionService.removeRedundantParentheses("1*(2+(3*(-4+5)))");
        assertEquals("1*(2+3*(-4+5))", simplifiedExpression);

        simplifiedExpression = expressionService.removeRedundantParentheses("2 + (3 / -5)");
        assertEquals("2+3/-5", simplifiedExpression);

        simplifiedExpression = expressionService.removeRedundantParentheses("x+(y+z)+(t+(v+w))");
        assertEquals("x+y+z+t+v+w", simplifiedExpression);

        simplifiedExpression = expressionService.removeRedundantParentheses(null);
        assertEquals("", simplifiedExpression);

        simplifiedExpression = expressionService.removeRedundantParentheses("");
        assertEquals("", simplifiedExpression);
    }

    @Test
    public void removeRedundantParentheses_additional() {
        String simplifiedExpression = expressionService.removeRedundantParentheses("(4*11)+11");
        assertEquals("4*11+11", simplifiedExpression);

        simplifiedExpression = expressionService.removeRedundantParentheses("(1+2)*3");
        assertEquals("(1+2)*3", simplifiedExpression);

        simplifiedExpression = expressionService.removeRedundantParentheses("((((123))))");
        assertEquals("123", simplifiedExpression);

        simplifiedExpression = expressionService.removeRedundantParentheses("(1+1)");
        assertEquals("1+1", simplifiedExpression);

        simplifiedExpression = expressionService.removeRedundantParentheses("(((22+4+80)*46*70*(24*62)+(94+25))+6)");
        assertEquals("(22+4+80)*46*70*24*62+94+25+6", simplifiedExpression);
    }
}