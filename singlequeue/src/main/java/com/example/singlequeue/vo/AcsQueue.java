package com.example.singlequeue.vo;

import com.example.singlequeue.config.ConfigAcsSystem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

@Getter
@Setter
@NoArgsConstructor
public class AcsQueue {

    private String id;
    private boolean queueFlag;

    public static AcsQueue builder() throws ExecutionException, InterruptedException {
//        int time = 5000;
//        if (timeMilli > 0 && timeMilli < time) time = timeMilli;
        return Executors.newSingleThreadExecutor().submit(AcsQueue::new).get();
    }

    public AcsQueue setFlag(boolean b) {
        this.queueFlag = b;
        return this;
    }

    public AcsQueue start() throws InterruptedException {
        while (queueFlag) {
            System.out.println("queue ======" + System.currentTimeMillis());
            System.out.println("queue ============================" + Thread.currentThread().getState());
            System.out.println("queue ============================" + Thread.currentThread().getName());
            System.out.println("queue ============================" + Thread.currentThread().getId());
            Thread.sleep(500);
        }
        return this;
    }

}
