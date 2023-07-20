package com.example.singlequeue.service;

import com.example.singlequeue.config.ConfigAcsSystem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
@Slf4j
@RequiredArgsConstructor
public class AcsSchedule {
    private final ConfigAcsSystem configAcsSystem;
    //그냥1초마다
    //    @Scheduled(fixedDelay = 1 * 1000L)
    //월금 1초마다
    //    @Scheduled(cron = "0/1 * * * * 1-5")
    //    @Scheduled(cron = "0/1 * * * * MON-FRI")
    //수요일 7시 ~ 13시 1사이 1초마다
    //    @Scheduled(cron = "0/1 * 7-13 * * 3")

    @Scheduled(cron = "0/1 * 7-18 * * 4")
    public void AcsSend() {
        //스타트 오더를 요청한 것만 처리한다.
            if (checkStartOder()) {
            //스타트 오더 아이디 확인
            for (String e : configAcsSystem.getStartOder().keySet()) {
                //e = key: servicegroup,
                addItems(e);
            }
            //추가된 아이템이 있으면 전화를건다
            if (checkItems()) {
                for (String e : configAcsSystem.getItems().values()) {
                    // 상태 = 1 추가된 아이템 // 전화를 건다
//                    if (e.getAcsStatus = 1) {
                    send();
//                    }
                    // 상태 = 2 전화 요청 상태
                    // 일정시간이 지나면 통화성공처리 status = 10 또는 에러처리 status = 99가 필요함 //보이스게이트웨이에게 전화건 시간을 체크하여 현재 시간과 비교
                    // 에러사항 ex) 보이스게이트웨이가 server down 콜 갱신 을 못 할경우.
//                    if (e.getAcsStatus = 2) {
//                }
                }
            }
        }
    }

    // 스타트 오더 -> 유저가 서버로 로드 실행요청
    // 서버로 실행 받는 이유는 종료를 시킬수 있어야 하기 때문에 한번에 실행시키지 않는다.
    // StartOrder add, remove 구현
    private boolean checkStartOder() {
        log.info("Check Start Oder");
        log.info("Check Start Get license Count");
        return configAcsSystem.getStartOder().keySet().size() > 0;
    }

    private boolean checkItems() {
        log.info("Check Item");
        return configAcsSystem.getItems().size() > 0;
    }

    // 오더에 라이센스 수량을 체크하여 아이템을 가져온다
    // 하위 서비스그룹에 할당된 라이센스 개수 필요
    private void addItems(String e) {

        // 시작요청시간이 있을 경우 현재시간과 비교
        if(false){
            return;
        }

        int useCall = configAcsSystem.getItems().values().size();
        Object useLicense = configAcsSystem.getStartOder().get(e).getLicenseCount(); // < -  객체 안에 LicenceCount 들어있을예정;
        int aliveLicense = (int) useLicense - useCall;
        if (aliveLicense > 0) {
            // 사용 할 수 있는 수량 만 가져온다
            List<String> addItems = new ArrayList<>();
            //addItems = select * from TB_ACS리스트 where acsStatus = 1 limit aliveLicense ;
            for(String f: addItems){
                configAcsSystem.setItems(e,f);
            }
            // 가져온 리스트의 사이즈가 사용 가능한 라이센스보다 작으면 스타트오더 종료
            if (aliveLicense > addItems.size()) {
                configAcsSystem.removeStartOder(e);
            }
        }
    }

    private void send() {
        log.info("voice gate call");
        log.info("Campaign Status Change");
        int resstatus = 200;
        if (resstatus != 200) {
            configAcsSystem.removeStartOder("servicegroup");
            log.info("잠시후 다시 시도해 주세요");
        }

    }

}
