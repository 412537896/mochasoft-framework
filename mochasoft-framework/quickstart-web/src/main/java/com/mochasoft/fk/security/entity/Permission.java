package com.mochasoft.fk.security.entity;

public class Permission {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOCHA_SECU_PERMISSION.ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOCHA_SECU_PERMISSION.NAME
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOCHA_SECU_PERMISSION.CREATE_TIME
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    private Long createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MOCHA_SECU_PERMISSION.DESCN
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    private String descn;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOCHA_SECU_PERMISSION.ID
     *
     * @return the value of MOCHA_SECU_PERMISSION.ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOCHA_SECU_PERMISSION.ID
     *
     * @param id the value for MOCHA_SECU_PERMISSION.ID
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOCHA_SECU_PERMISSION.NAME
     *
     * @return the value of MOCHA_SECU_PERMISSION.NAME
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOCHA_SECU_PERMISSION.NAME
     *
     * @param name the value for MOCHA_SECU_PERMISSION.NAME
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOCHA_SECU_PERMISSION.CREATE_TIME
     *
     * @return the value of MOCHA_SECU_PERMISSION.CREATE_TIME
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOCHA_SECU_PERMISSION.CREATE_TIME
     *
     * @param createTime the value for MOCHA_SECU_PERMISSION.CREATE_TIME
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MOCHA_SECU_PERMISSION.DESCN
     *
     * @return the value of MOCHA_SECU_PERMISSION.DESCN
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public String getDescn() {
        return descn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MOCHA_SECU_PERMISSION.DESCN
     *
     * @param descn the value for MOCHA_SECU_PERMISSION.DESCN
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    public void setDescn(String descn) {
        this.descn = descn == null ? null : descn.trim();
    }
}