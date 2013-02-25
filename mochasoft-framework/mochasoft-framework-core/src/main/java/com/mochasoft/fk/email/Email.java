package com.mochasoft.fk.email;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <strong>Title : Email </strong>. <br>
 * <strong>Description : 描述电子邮件信息的 javabean.</strong> <br>
 * <strong>Create on : 2013-2-25 上午11:48:20 </strong>. <br>
 * <p>
 * <strong>Copyright (C) Mocha Software Co.,Ltd.</strong> <br>
 * </p>
 * 
 * @author hemw hemw@mochasoft.com.cn <br>
 * @version <strong>FrameWork v0.8</strong> <br>
 * <br>
 *          <strong>修改历史: .</strong> <br>
 *          修改人 修改日期 修改描述<br>
 *          -------------------------------------------<br>
 * <br>
 */
public class Email {
    /** 主题 */
    private String subject;
    /** 内容 */
    private String content;
    /** 附件 */
    private List<File> attachments;
    /** 收件人， Map 的 key 为 email 地址， value 为姓名 */
    private Map<String, String> to;
    /** 抄送， Map 的 key 为 email 地址， value 为姓名 */
    private Map<String, String> cc;
    /** 密送， Map 的 key 为 email 地址， value 为姓名 */
    private Map<String, String> bcc;
    /** 发送人的 email 地址 */
    private String from;
    /** 发送人的姓名 */
    private String fromUsername;
    /** 优先级 */
    private Priority priority;
    /** 需要回执 */
    private boolean receipt;
    /** 发送时间 */
    private Date sendDate;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<File> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<File> attachments) {
        this.attachments = attachments;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
    
    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isReceipt() {
        return receipt;
    }

    public void setReceipt(boolean receipt) {
        this.receipt = receipt;
    }

    public Map<String, String> getTo() {
        return to;
    }

    public void setTo(Map<String, String> to) {
        this.to = to;
    }

    public Map<String, String> getCc() {
        return cc;
    }

    public void setCc(Map<String, String> cc) {
        this.cc = cc;
    }

    public Map<String, String> getBcc() {
        return bcc;
    }

    public void setBcc(Map<String, String> bcc) {
        this.bcc = bcc;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername;
    }
    
    public void addAttachment(File file){
        if(this.attachments == null)
            this.attachments = new ArrayList<File>();
        this.attachments.add(file);
    }
    
    public void addTo(String email, String personal){
        if(this.to == null)
            this.to = new LinkedHashMap<String, String>();
        this.to.put(email, personal);
    }
    
    public void addCc(String email, String personal){
        if(this.cc == null)
            this.cc = new LinkedHashMap<String, String>();
        this.cc.put(email, personal);
    }
    
    public void addBcc(String email, String personal){
        if(this.bcc == null)
            this.bcc = new LinkedHashMap<String, String>();
        this.bcc.put(email, personal);
    }

}
