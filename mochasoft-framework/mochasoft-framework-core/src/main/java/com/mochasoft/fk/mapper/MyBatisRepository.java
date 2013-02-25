package com.mochasoft.fk.mapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <strong>Title : MyBatisRepository </strong>. <br>
 * <strong>Description : 标识MyBatis的DAO，方便  
 * org.mybatis.spring.mapper.MapperScannerConfigurer的扫描.</strong> <br>
 * <strong>Create on : 2013-1-5 上午11:44:47 </strong>. <br>
 * <p>
 * <strong>Copyright (C) Mocha Software Co.,Ltd.</strong> <br>
 * </p>
 * @author wanghe wanghe@mochasoft.com.cn <br>
 * @version <strong>Framework0.8</strong> <br>
 * <br>
 * <strong>修改历史: .</strong> <br>
 * 修改人 修改日期 修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyBatisRepository {
}
