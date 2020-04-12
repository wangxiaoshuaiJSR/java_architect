package org.architect.wxs.visitorpattern;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/23
 * @javadoc ：
 */
public interface Ivisitor {

    void visit(Engineer engineer);

    void visit(Manager manager);
}
