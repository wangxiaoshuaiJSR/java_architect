package architect.org.wxs.openclose;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/23
 * @javadoc ：测试类
 */
public class OpenCloseTest {

    public static void main(String[] args) {
        ICourse course = new JavaDisCountCourse(1,"java架构师",8000.0);
        System.out.printf("课程ID %s ,课程名称 %s,课程价格%s,售价%s\n",
                course.getId(),course.getName(),course.getPrice(),((JavaDisCountCourse) course).getDisCountPrice());
    }
}
