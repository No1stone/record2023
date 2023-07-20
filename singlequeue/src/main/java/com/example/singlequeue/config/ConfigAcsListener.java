package com.example.singlequeue.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConfigAcsListener implements ApplicationListener<ContextClosedEvent> {

    private final ConfigAcsSystem configAcsSystem;

    /**
     * 로직 순서
     * 사용자가 전화번호를 세팅 한다. 전화번호를 10,000개라 치고
     * 사용할수 있는 채널은 2개 전화 중이라는 상태 필요
     * 스케듈러는 items 를 가져와 사용한다
     * <p>
     * 기본적으로 DB 에서 가져오는 값은 대기 상태로 둔다
     * 유저가 온로드 API로 트리거를 발생시칸다  -> 해당 아이템즈를 시작 상태로 변경 /전화를 건다 <---- 시작이라는 아이템즈 상태값 구현
     * 보이스게이트웨이와의 API 통신이 200 Ok면 전화를 다시 안걸게 <------- 아이템즈 상태값을 send로 변경 <- 통화중
     * 보이스게이트웨이가 전화를 걸어서 콜백이든 성공이든 <----- 보이스 게이트웨이가 결과를 알려주는 상태값들
     * <p>
     * 시작 액션으로 스케쥴러 큐에 넣어줬다가
     * 스톱이라는 액션으로 스케쥴러 큐에서 지워야한다.
     * 큐는 전화 중 을 가지고 있어야 채널을 관리할수 있다.
     *
     * @param event
     */


    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        log.info("종료");
        for (String e : configAcsSystem.getItems().values()) {
            log.info("종료 id" + e);
        //status 98 = 서버종료 또는 다운
        }
    }


}
