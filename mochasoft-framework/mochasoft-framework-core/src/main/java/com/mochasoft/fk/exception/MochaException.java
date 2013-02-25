package com.mochasoft.fk.exception;

/**
 * <strong>Title : MochaException </strong>. <br>
 * <strong>Description : 业务异常对象封装.</strong> <br>
 * <strong>Create on : 2012-9-3 下午3:51:04 </strong>. <br>
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
public class MochaException extends RuntimeException{

	/**
	 * <code>serialVersionUID</code>-注释
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * <code>m_errorMessage</code>-业务组件层详细的错误信息
	 */
	private String m_errorMessage = null;

	/**
	 * 构造函数
	 */
	public MochaException() {
		super();
	}

	/**
	 * 构造函数
	 * 
	 * @param message
	 *            <code>异常消息</code>
	 */
	public MochaException(String message) {
		super(message);
		this.m_errorMessage = message;
	}

	/**
	 * 构造函数
	 * 
	 * @param cause
	 *            <code>可抛出的异常对象</code>
	 */
	public MochaException(Throwable cause) {
		super(cause);
	}

	/**
	 * 构造函数
	 * 
	 * @param message
	 *            <code>异常消息</code>
	 * @param cause
	 *            <code>可抛出的异常对象</code>
	 */
	public MochaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @return Returns the errorMessage.
	 */
	public final String getErrorMessage() {
		if (null != m_errorMessage && !"".equals(this.m_errorMessage)) {
			return convertErrorMessage(this.m_errorMessage);
		}

		if (null != this.getCause()) {
			return convertErrorMessage(this.getCause().getMessage());
		}

		return this.getMessage();

	}

	/**
	 * @param errorMessage
	 *            The errorMessage to set.
	 */
	public final void setErrorMessage(String errorMessage) {
		m_errorMessage = errorMessage;
	}

	/**
	 * 转换ErrorMessage的方法
	 * 
	 * @param message －
	 *            原始的错误信息
	 * @return 转换后的错误信息
	 */
	private String convertErrorMessage(String message) {
		if (null != message && !"".equals(message) && message.indexOf(":") > 0) {
			return message.substring(message.indexOf("Exception:") + 1, message
					.length());
		} else {
			return message;
		}
	}
}
