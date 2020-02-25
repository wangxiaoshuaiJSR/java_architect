package architect.org.wxs.openclose;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/23
 * @javadoc ：针对java课程类进行提升
 */
public class JavaDisCountCourse extends JavaCourse{
    public JavaDisCountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getDisCountPrice() {
        return super.getPrice()*0.6;
    }
}
