package architect.org.wxs.principle;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/2/23
 * @javadoc ：
 */
public class MySqlConnection implements DBConnection {
    public String getConnection() {
        return "Mysql 链接";
    }
}
