package cn.com.chnsys.schedulingtasks.controller;

import cn.com.chnsys.schedulingtasks.tasks.AsyncTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuxt
 **/
@RestController
public class AsyncController {
    @Autowired
    AsyncTasks asyncTasks;

    @GetMapping("/success")
    public String success(){
        asyncTasks.simulateSleep();
        return "success";
    }
}
