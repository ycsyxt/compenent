package cn.com.chnsys.schedulingtasks.tasks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author yuxt
 **/
@Service
public class AsyncTasks {
    @Async
    public void simulateSleep(){
        try {
            Thread.sleep(3000);
            System.out.println("test");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
