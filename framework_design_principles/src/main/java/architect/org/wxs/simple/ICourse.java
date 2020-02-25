package architect.org.wxs.simple;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/23
 * @javadoc ：单一职责
 */
public interface ICourse {

    String getName();
    byte[] getvideo();

    void study();
    void refoundCourse();//退费
}
