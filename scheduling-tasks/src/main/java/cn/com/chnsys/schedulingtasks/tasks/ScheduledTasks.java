package cn.com.chnsys.schedulingtasks.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yuxt
 **/
@Component //必须加入到容器中定时任务才会生效
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    /**
     * @Scheduled 标注的方法会定时执行，fixedRate=xxx表示间隔xxx ms执行一次该方法，也可以使用cron表达式
     * cron="* * * * * * *" 秒 分 时 几号 几月 周几 , *表示任意，,表示枚举，-区间，/步长
     * 例如：
     * cron="0 * * * * MON-FRI":周一到周五，每月每天每时每分钟执行一次该方法
     * cron="0,1,2,3 * * * * MON-FRI":周一到周五，每每月每天每时每分钟的0,1,2,3秒执行一次该方法
     * cron="0-3 * * * * MON-FRI":周一到周五，每每月每天每时每分钟的0,1,2,3秒执行一次该方法
     * cron="0/15 * * * * MON-FRI":周一到周五，每每月每天每时每分钟0秒开始每15秒执行一次该方法
     */
    @Scheduled(cron = "${ScheduledTask.cronException}")
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}