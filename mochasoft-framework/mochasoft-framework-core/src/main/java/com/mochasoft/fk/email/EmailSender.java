package com.mochasoft.fk.email;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * <strong>Title : EmailSender </strong>. <br>
 * <strong>Description : 发送电子邮件的工具类.</strong> <br>
 * <strong>Create on : 2013-2-25 上午12:48:20 </strong>. <br>
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
@Component
public class EmailSender {

    @Resource
    private JavaMailSender sender;
    @Resource
    private MimeMessageHelper mmHelper;

    /**
     * 发送简单的电子邮件（纯文本电子邮件）
     * @param simpleMailMessage 需要发送的电子邮件
     */
    public void send(SimpleMailMessage simpleMailMessage) {
        sender.send(simpleMailMessage);
    }

    /**
     * 发送电子邮件，可以是纯文本的，也可以是富文本的，还可以包含附件等
     * @param mimeMessage 需要发送的电子邮件
     */
    public void send(MimeMessage mimeMessage) {
        sender.send(mimeMessage);
    }

    /**
     * 发送电子邮件，可以是纯文本的，也可以是富文本的，还可以包含附件等
     * @param mimeMessageHelper 用于创建需要发送的电子邮件的 Helper
     */
    public void send(MimeMessageHelper mimeMessageHelper) {
        sender.send(mimeMessageHelper.getMimeMessage());
    }

    /**
     * 发送电子邮件，发送的电子邮件可以包含附件、设置优先级、要求阅读回执
     * @param email 需要发送的电子邮件的 javabean
     */
    public void send(Email email) {

        MimeMessage msg = null;
        try {
            mmHelper.setSubject(email.getSubject()); // 主题
            mmHelper.setFrom(email.getFrom(), email.getFromUsername()); // 发送人的 email 地址和姓名
            mmHelper.setText(email.getContent(), true); // 内容
            
            if(email.getSendDate() != null)
                mmHelper.setSentDate(email.getSendDate()); // 发送时间

            // 收件人
            Map<String, String> to = email.getTo();
            Set<Entry<String, String>> toSet = to.entrySet();
            for (Entry<String, String> entry : toSet) {
                mmHelper.addTo(entry.getKey(), entry.getValue());
            }

            // 抄送
            Map<String, String> cc = email.getCc();
            if (cc != null && !cc.isEmpty()) {
                Set<Entry<String, String>> ccSet = cc.entrySet();
                for (Entry<String, String> entry : ccSet) {
                    mmHelper.addCc(entry.getKey(), entry.getValue());
                }
            }

            // 密送
            Map<String, String> bcc = email.getBcc();
            if (bcc != null && !bcc.isEmpty()) {
                Set<Entry<String, String>> bccSet = bcc.entrySet();
                for (Entry<String, String> entry : bccSet) {
                    mmHelper.addBcc(entry.getKey(), entry.getValue());
                }
            }

            // 附件
            List<File> attachments = email.getAttachments();
            if (attachments != null && !attachments.isEmpty()) {
                for (File file : attachments) {
                    mmHelper.addAttachment(file.getName(), file);
                }
            }

            // 优先级：一般来说， 1为最高优先级，5为最低优先级
            Priority priority = email.getPriority();
            if (priority != null) {
                switch (priority) {
                case HIGH:
                    mmHelper.setPriority(1);
                    break;
                case NORM:
                    mmHelper.setPriority(3);
                    break;
                case LOWER:
                    mmHelper.setPriority(5);
                    break;
                default:
                    break;
                }
            }

            msg = mmHelper.getMimeMessage();
            if (email.isReceipt()) // 要求阅读回执
                msg.addHeader("Disposition-Notification-To", "1");
        } catch (MessagingException e) {
            throw new RuntimeException("创建 Email 信息时发生异常。", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("创建 Email 信息时发生异常。", e);
        }

        sender.send(msg);
    }

}
