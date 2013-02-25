package com.mochasoft.fk.db.page;

/**
 * <strong>Title : Dialect </strong>. <br>
 * <strong>Description : 数据库方言接口.</strong> <br>
 * <strong>Create on : 2013-1-31 下午1:49:55 </strong>. <br>
 * <p>
 * <strong>Copyright (C) Mocha Software Co.,Ltd.</strong> <br>
 * </p>
 * @author wanghe wanghe@mochasoft.com.cn <br>
 * @version <strong>FrameWork v0.8</strong> <br>
 * <br>
 * <strong>修改历史: .</strong> <br>
 * 修改人 修改日期 修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
public interface Dialect {     
    
    public static enum Type{     
        MYSQL,
        ORACLE,
        DB2
    }
    
    /**
     * 获取分页SQL.
     * @param sql		原始查询SQL
     * @param offset	开始记录索引（从0开始计算）
     * @param pageSize	每页记录大小
     * @return          返回数据库相关的分页SQL语句
     */
    public abstract String getPageSql(String sql, int offset, int pageSize); 
}
