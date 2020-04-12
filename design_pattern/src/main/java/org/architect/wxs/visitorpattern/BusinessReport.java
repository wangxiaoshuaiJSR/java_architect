package org.architect.wxs.visitorpattern;

import java.util.LinkedList;
import java.util.List;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/23
 * @javadoc ：
 */
public class BusinessReport {
    private List<Employee> employees = new LinkedList<Employee>();

    public BusinessReport() {
        employees.add(new Manager("产品经理A"));
        employees.add(new Manager("产品经理B"));

        employees.add(new Engineer("工程师A"));

        employees.add(new Engineer("工程师B"));
    }

    public void showReport(Ivisitor ivisitor){
        for (Employee employee : employees) {
            employee.accept(ivisitor);
        }

    }
}
