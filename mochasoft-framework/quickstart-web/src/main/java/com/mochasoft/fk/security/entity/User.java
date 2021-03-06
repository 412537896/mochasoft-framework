package com.mochasoft.fk.security.entity;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOCHA_SECU_USER.ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOCHA_SECU_USER.USER_ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOCHA_SECU_USER.USERNAME
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOCHA_SECU_USER.PASSWORD
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOCHA_SECU_USER.STATUS
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    private Short status;
    
    public User() {
    	
    }
    
    public User(String userId, String password, Short status, String username) {
		this.userId = userId;
		this.password = password;
		this.status = status;
		this.username = username;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOCHA_SECU_USER.ID
     *
     * @return the value of MOCHA_SECU_USER.ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOCHA_SECU_USER.ID
     *
     * @param id the value for MOCHA_SECU_USER.ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOCHA_SECU_USER.USER_ID
     *
     * @return the value of MOCHA_SECU_USER.USER_ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOCHA_SECU_USER.USER_ID
     *
     * @param userId the value for MOCHA_SECU_USER.USER_ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOCHA_SECU_USER.USERNAME
     *
     * @return the value of MOCHA_SECU_USER.USERNAME
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOCHA_SECU_USER.USERNAME
     *
     * @param username the value for MOCHA_SECU_USER.USERNAME
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOCHA_SECU_USER.PASSWORD
     *
     * @return the value of MOCHA_SECU_USER.PASSWORD
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOCHA_SECU_USER.PASSWORD
     *
     * @param password the value for MOCHA_SECU_USER.PASSWORD
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOCHA_SECU_USER.STATUS
     *
     * @return the value of MOCHA_SECU_USER.STATUS
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public Short getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOCHA_SECU_USER.STATUS
     *
     * @param status the value for MOCHA_SECU_USER.STATUS
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public void setStatus(Short status) {
        this.status = status;
    }

	@Override
   	public String toString() {
   		StringBuilder builder = new StringBuilder();
   		builder.append("User [id=")
   				.append(this.id)
   				.append(",userId=")
   				.append(this.userId)
   				.append(",password=")
   				.append(this.password)
   				.append(",username=")
   				.append(this.username)
   				.append(",status=")
   				.append(this.status)
   				.append("]\n");
   		return builder.toString();
   	}
}