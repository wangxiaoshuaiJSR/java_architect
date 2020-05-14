package org.architect.wxs.v1;

/**
 * @Author: wangxiaoshuai
 */
public class SqlSession {
    private Configuration configuration;

    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor){
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(String statementId, Object paramater){
        // 根据statementId拿到SQL
        String sql = Configuration.sqlMappings.getString(statementId);
        if(null != sql && !"".equals(sql)){
            return executor.query(sql, paramater );
        }
        return null;
    }

    public <T> T getMapper(Class clazz){
        return configuration.getMapper(clazz, this);
    }

}
