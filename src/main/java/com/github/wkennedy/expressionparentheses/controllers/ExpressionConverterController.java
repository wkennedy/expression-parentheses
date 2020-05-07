package com.github.wkennedy.expressionparentheses.controllers;

import com.github.wkennedy.expressionparentheses.services.ExpressionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@RestController
@RequestMapping("/api")
public class ExpressionConverterController {

    private final ExpressionService expressionService;

    public ExpressionConverterController(ExpressionService expressionService) {
        this.expressionService = expressionService;
    }

    @Operation(summary = "Remove redundant parentheses from a mathematical expression",
            description = "For example, if your input is 1\\*(2+(3\\*(4+5))) you'll receive a simplified expression in the form 1\\*(2+3\\*(4+5))")
    @GetMapping(value = "/removeRedundantParentheses")
    public @ResponseBody
    String removeRedundantParentheses(@RequestParam String expression) {
        return HtmlUtils.htmlEscape(expressionService.removeRedundantParentheses(expression));
    }

}
