package architect.org.wxs.dependencyinversion;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/23
 * @javadoc ：
 */
public class Test {
    // V1
    public static void main(String[] args) {
       Tom tom=new Tom();
       /* tom.studyJava();
        tom.studyPython();
        tom.studyAI();*/


       /* tom.studyCourse(new JavaCourse());
        tom.studyCourse(new PythonCourse());*/

   /*     Tom tom = new Tom(new JavaCourse());
        tom.study();*/

        tom.setCourse(new JavaCourse());
        tom.study();
        tom.setCourse(new PythonCourse());
        tom.study();
    }
}
