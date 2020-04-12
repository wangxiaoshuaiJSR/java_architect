package org.architect.wxs.interpreterpattern;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/22
 * @javadoc ： 解析器模式  spring的解析器
 */
public class SpringExpression {

    public static void main(String[] args) {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("100*2+400*1+66");
        Integer value = (Integer)expression.getValue();
        System.out.println(value);
    }
}
