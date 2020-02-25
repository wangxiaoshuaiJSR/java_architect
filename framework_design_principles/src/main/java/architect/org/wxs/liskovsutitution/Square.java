package architect.org.wxs.liskovsutitution;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/23
 * @javadoc ：正方形
 */
public class Square extends Rectangle{
    private long length;

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    @Override
    public long getHeight() {
        return this.length;
    }

    @Override
    public void setHeight(long height) {
        setLength(height);
    }

    @Override
    public long getWidth() {
        return this.length;
    }

    @Override
    public void setWidth(long width) {
        setLength(width);
    }
}
