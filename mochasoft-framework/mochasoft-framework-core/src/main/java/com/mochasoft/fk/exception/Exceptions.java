package com.mochasoft.fk.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <strong>Title : Exceptions </strong>. <br>
 * <strong>Description : 关于异常的工具类.</strong> <br>
 * <strong>Create on : 2013-1-5 上午11:46:49 </strong>. <br>
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
public class Exceptions {

	/**
	 * 将CheckedException转换为UncheckedException.
	 * @param exception   需要处理的异常 
	 * @return RuntimeException
	 */
	public static RuntimeException unchecked(Exception exception) {
		if (exception instanceof RuntimeException) {
			return (RuntimeException) exception;
		} else {
			return new RuntimeException(exception);
		}
	}

	/**
	 * 将ErrorStack转化为String.
	 * @param exception 异常 
	 * @return 转换后的字符串
	 */
	public static String getStackTraceAsString(Exception exception) {
		StringWriter stringWriter = new StringWriter();
		exception.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

	/**
	 * 判断异常是否由某些底层的异常引起.
	 * @param ex	异常
	 * @param causeExceptionClasses 底层异常数组
	 * @return false不在异常数组中， true在异常数组中
	 */
	public static boolean isCausedBy(Exception ex, Class<? extends Exception>... causeExceptionClasses) {
		Throwable cause = ex.getCause();
		while (cause != null) {
			for (Class<? extends Exception> causeClass : causeExceptionClasses) {
				if (causeClass.isInstance(cause)) {
					return true;
				}
			}
			cause = cause.getCause();
		}
		return false;
	}
}
