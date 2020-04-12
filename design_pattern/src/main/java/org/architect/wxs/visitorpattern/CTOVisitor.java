package org.architect.wxs.visitorpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/23
 * @javadoc ：
 */
public class CTOVisitor implements Ivisitor {
    public void visit(Engineer engineer) {
        System.out.println("工程师"+engineer.getName()+"代码行数"+engineer.getCodeLines());
    }

    public void visit(Manager manager) {
        System.out.println("经理"+manager.getName()+"产品"+manager.getProducts());
    }
}
