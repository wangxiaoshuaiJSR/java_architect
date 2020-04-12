package org.architect.wxs.visitorpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/23
 * @javadoc ： 访问者模式
 */
public class Test {

    public static void main(String[] args) {
        BusinessReport businessReport=new BusinessReport();

        System.out.println("CEO");

        businessReport.showReport(new CEOVisitor());

        businessReport.showReport(new CTOVisitor());
    }
}
