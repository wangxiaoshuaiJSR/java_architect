package architect.org.wxs.liskovsutitution;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/23
 * @javadoc ：里氏替换原则，防止继承泛滥
 */
public class Test {
    public static void  resize(Rectangle rectangle){
        while (rectangle.getWidth()>=rectangle.getHeight()){
            rectangle.setHeight(rectangle.getHeight()+1);
            System.out.printf("width:%s,heigth:%s\n",rectangle.getWidth(),rectangle.getHeight());
        }
        System.out.printf("resize end width:%s,heigth:%s\n",rectangle.getWidth(),rectangle.getHeight());
    }
    public static void main(String[] args) {
      /*  Rectangle rectangle = new Rectangle();
        rectangle.setHeight(10);
        rectangle.setWidth(20);
        resize(rectangle);*/

      Square square = new Square();
      square.setLength(10);
      resize(square);
    }
}
