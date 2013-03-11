package com.mochasoft.fk.email;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.annotation.DirtiesContext;

import com.mochasoft.fk.test.spring.SpringTransactionalTestCase;

@DirtiesContext
public class EmailSenderTest extends SpringTransactionalTestCase {
    @Autowired
    private SimpleMailMessage simpleMailMessage;
    @Autowired
    private MimeMessageHelper mmHelper;
    @Autowired
    private EmailSender emailSender;
    
    @Test
    public void testSendSimpleMailMessage() {
        emailSender.send(simpleMailMessage);
    }

    @Test
    public void testSendMimeMessageHelper() throws MessagingException, UnsupportedEncodingException {
        mmHelper.setSubject("测试发送带附件的富文本邮件");
        mmHelper.setTo("674422038@qq.com");
        mmHelper.setFrom("baizhi_bj@sina.com", "何明旺");
        mmHelper.addInline("pic_01", new File("E:/temp/20130219.jpg"));
        mmHelper.setText("<h3>此邮件是由系统自动发送，<span style='color:#f00'>请勿回复！</span></h3><br><img src='cid:pic_01'>", true);
        mmHelper.addAttachment("log4j.properties", new ClassPathResource("log4j.properties"));
        emailSender.send(mmHelper);
    }

    @Test
    public void testSendEmail() {
        Email email = new Email();
        email.setSubject("Spring 发送邮件测试");
        email.setFrom("baizhi_bj@sina.com");
        email.setFromUsername("何明旺");
        email.addTo("674422038@qq.com", null);
        email.addCc("4012508@qq.com", "王洪恩");
        email.addBcc("hemingwang0902@126.com", "");
        email.setContent("<h3>此邮件是由系统自动发送</h3>，<span style='color:#f00'>请勿回复！</span><br><img src='http://www.mochasoft.com.cn/about_mocha/images/cp.jpg'>");
        email.addAttachment(new File("src/test/resources/applicationContext.xml"));
        email.setPriority(Priority.HIGH);
        email.setReceipt(true);
        emailSender.send(email);
    }

}
