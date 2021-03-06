package com.mochasoft.fk.security.entity;

public class RoleUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOCHA_SECU_ROLE_USER.ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOCHA_SECU_ROLE_USER.ROLE_ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    private String roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOCHA_SECU_ROLE_USER.USER_ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    private String userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOCHA_SECU_ROLE_USER.ID
     *
     * @return the value of MOCHA_SECU_ROLE_USER.ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOCHA_SECU_ROLE_USER.ID
     *
     * @param id the value for MOCHA_SECU_ROLE_USER.ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOCHA_SECU_ROLE_USER.ROLE_ID
     *
     * @return the value of MOCHA_SECU_ROLE_USER.ROLE_ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOCHA_SECU_ROLE_USER.ROLE_ID
     *
     * @param roleId the value for MOCHA_SECU_ROLE_USER.ROLE_ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOCHA_SECU_ROLE_USER.USER_ID
     *
     * @return the value of MOCHA_SECU_ROLE_USER.USER_ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOCHA_SECU_ROLE_USER.USER_ID
     *
     * @param userId the value for MOCHA_SECU_ROLE_USER.USER_ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
	
	@Override
   	public String toString() {
   		StringBuilder builder = new StringBuilder();
   		builder.append("RoleUser[ id=")
   				.append(this.id)
   				.append(",roleId=")
   				.append(this.roleId)
   				.append(",userId=")
   				.append(this.userId)
   				.append("]\n");
   		return builder.toString();
   	}
}