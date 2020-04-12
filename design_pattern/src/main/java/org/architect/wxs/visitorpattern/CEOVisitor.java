package org.architect.wxs.visitorpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/23
 * @javadoc ：
 */
public class CEOVisitor implements Ivisitor {
    public void visit(Engineer engineer) {
        System.out.println("工程师"+engineer.getName()+"KPI"+engineer.getKpi());
    }

    public void visit(Manager manager) {
        System.out.println("经理"+manager.getName()+"KPI"+manager.getKpi());
    }
}
