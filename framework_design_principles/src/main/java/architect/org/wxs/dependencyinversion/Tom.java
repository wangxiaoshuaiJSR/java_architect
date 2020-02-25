package architect.org.wxs.dependencyinversion;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/23
 * @javadoc ：依赖倒置原则
 */
public class Tom {
  /*  public void studyJava(){
        System.out.println("学习java");
    }

    public void studyPython(){
        System.out.println("学习Python");
    }

    public void studyAI(){
        System.out.println("学习AI");
    }*/

    /*public void studyCourse(ICourse course){
        course.study();
    }*/

    private ICourse course;

  /*  public Tom(ICourse course) {
        this.course = course;
    }*/

    public void setCourse(ICourse course) {
        this.course = course;
    }

    public void study(){
        course.study();
    }
}
