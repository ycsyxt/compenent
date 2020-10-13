package cn.com.chnsys.schedulingtasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
class SchedulingTasksApplicationTests {
    @Autowired
    JavaMailSenderImpl sender;

    @Test
    void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setSubject("通知-这是一个测试邮件");
        simpleMailMessage.setText("this is test");

        simpleMailMessage.setTo("15241496739@163.com");
        simpleMailMessage.setFrom("2953557740@qq.com");
        sender.send(simpleMailMessage);
    }

}
