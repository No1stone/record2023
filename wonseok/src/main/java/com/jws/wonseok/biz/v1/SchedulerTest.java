package com.jws.wonseok.biz.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@EnableScheduling
public class SchedulerTest {
    private final Logger logger = LoggerFactory.getLogger(SchedulerTest.class);

    /*
    @Scheduled(cron = "0/10 * * * * ?")
    public void Test1 () throws InterruptedException {
        logger.info("10/60초 10초 마다");
        int start = 0;
        int end = 30;
        int sec = 0;
        for(int i = 0 ; i < 30 ; i ++){

            logger.info("i ------ {}",i);

            if(sec > 9){
                logger.info("sec = {}",sec);
                Thread.sleep(1000);
                sec = 0;
            }
            sec ++;
        }

//        RecursionEmailSend(start, end, 0);
    }

    @Scheduled(cron = "0 0/01 * * * ?")
    public void Test2 (){
        logger.info("01/60분 1분 마다");


    }

    public int RecursionEmailSend(int start, int end, int sec) throws InterruptedException {
        int res = 0;
        if(sec > 9){
            logger.info("sec = {}",sec);
            Thread.sleep(1000);
            sec = 0;
        }
        if ( start > end) {
            return start;
        }
        else {
            logger.info("start = = = = {}",start);
            logger.info("else seq = = = = {}",sec);
            return RecursionEmailSend(start + 1, end, sec +1);
        }

    }


    ;

    @Scheduled(cron = "0 0/10 * * * ?")
    public void Test3 (){
        logger.info("10/60 10분 마다");
    }

    @Scheduled(cron = "0 0/30 * * * ?")
    public void Test4 (){
        logger.info("30/60 30분 마다");
    }

*/
}
