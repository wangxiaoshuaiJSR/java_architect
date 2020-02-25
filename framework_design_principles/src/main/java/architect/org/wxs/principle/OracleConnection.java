package architect.org.wxs.principle;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/23
 * @javadoc ：
 */
public class OracleConnection implements DBConnection {
    public String getConnection() {
        return "Oracle 链接";
    }
}
