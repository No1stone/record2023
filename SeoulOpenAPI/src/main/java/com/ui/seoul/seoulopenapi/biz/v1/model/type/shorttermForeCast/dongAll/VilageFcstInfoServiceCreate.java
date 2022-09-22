package com.ui.seoul.seoulopenapi.biz.v1.model.type.shorttermForeCast.dongAll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VilageFcstInfoServiceCreate {

    private final Logger logger = LoggerFactory.getLogger(VilageFcstInfoServiceCreate.class);

    public URLDate getVilageFcstInfoServiceDate(){
        LocalDateTime baseDate = LocalDateTime.now();
        DateTimeFormatter form = DateTimeFormatter.ofPattern("YYYYMMdd HHmm");
        String[] dateTime = form.format(baseDate).split(" ");
        String day = dateTime[0];
        String time = dateTime[1];
        int yyyy = Integer.parseInt(day.substring(0, 4));
        int dd = Integer.parseInt(day.substring(4, 6));
        int mm = Integer.parseInt(day.substring(6, 8));
        LocalDateTime Time02 = LocalDateTime.of(yyyy, dd, mm, 2, 15);
        LocalDateTime Time05 = LocalDateTime.of(yyyy, dd, mm, 5, 15);
        LocalDateTime Time08 = LocalDateTime.of(yyyy, dd, mm, 8, 15);
        LocalDateTime Time11 = LocalDateTime.of(yyyy, dd, mm, 11, 15);
        LocalDateTime Time14 = LocalDateTime.of(yyyy, dd, mm, 14, 15);
        LocalDateTime Time17 = LocalDateTime.of(yyyy, dd, mm, 17, 15);
        LocalDateTime Time20 = LocalDateTime.of(yyyy, dd, mm, 20, 15);
        LocalDateTime Time23 = LocalDateTime.of(yyyy, dd, mm, 23, 15);
        logger.info("Time02 - {}", Time02);
        logger.info("Time05 - {}", Time05);
        logger.info("Time08 - {}", Time08);
        logger.info("Time11 - {}", Time11);
        logger.info("Time14 - {}", Time14);
        logger.info("Time17 - {}", Time17);
        logger.info("Time20 - {}", Time20);
        logger.info("Time23 - {}", Time23);
        String resday = form.format(LocalDateTime.now().minusDays(1L)).substring(0,8);
        String restime = "2300";
        logger.info("if testTime - {}", restime);
        logger.info("if day - {}", resday);
        if (LocalDateTime.now().isAfter(Time02)) {
            restime = "0200";
            resday = form.format(LocalDateTime.now()).substring(0,8);
        }
        if (LocalDateTime.now().isAfter(Time05)) {
            restime = "0500";
        }
        if (LocalDateTime.now().isAfter(Time08)) {
            restime = "0800";
        }
        if (LocalDateTime.now().isAfter(Time11)) {
            restime = "1100";
        }
        if (LocalDateTime.now().isAfter(Time14)) {
            restime = "1400";
        }
        if (LocalDateTime.now().isAfter(Time17)) {
            restime = "1700";
        }
        if (LocalDateTime.now().isAfter(Time20)) {
            restime = "2000";
        }
        if (LocalDateTime.now().isAfter(Time23)) {
            restime = "2300";
        }

        logger.info("if testTime - {}", restime);
        logger.info("if day - {}", resday);
        return URLDate.builder()
                .day(resday)
                .time(restime)
                .build();
    }

    public List<Grid> getVilageFcstInfoServiceGridList(){

        List<Grid> listGrid = new ArrayList<>();
        listGrid.add(Grid.builder().gridx("57").gridy("126").build());
        listGrid.add(Grid.builder().gridx("57").gridy("127").build());
        listGrid.add(Grid.builder().gridx("57").gridy("125").build());
        listGrid.add(Grid.builder().gridx("58").gridy("126").build());
        listGrid.add(Grid.builder().gridx("58").gridy("127").build());
        listGrid.add(Grid.builder().gridx("58").gridy("126").build());
        listGrid.add(Grid.builder().gridx("58").gridy("125").build());
        listGrid.add(Grid.builder().gridx("58").gridy("124").build());
        listGrid.add(Grid.builder().gridx("59").gridy("126").build());
        listGrid.add(Grid.builder().gridx("59").gridy("127").build());
        listGrid.add(Grid.builder().gridx("59").gridy("128").build());
        listGrid.add(Grid.builder().gridx("59").gridy("124").build());
        listGrid.add(Grid.builder().gridx("59").gridy("125").build());
        listGrid.add(Grid.builder().gridx("59").gridy("126").build());
        listGrid.add(Grid.builder().gridx("59").gridy("124").build());
        listGrid.add(Grid.builder().gridx("60").gridy("127").build());
        listGrid.add(Grid.builder().gridx("60").gridy("126").build());
        listGrid.add(Grid.builder().gridx("60").gridy("128").build());
        listGrid.add(Grid.builder().gridx("60").gridy("125").build());
        listGrid.add(Grid.builder().gridx("61").gridy("127").build());
        listGrid.add(Grid.builder().gridx("61").gridy("126").build());
        listGrid.add(Grid.builder().gridx("61").gridy("128").build());
        listGrid.add(Grid.builder().gridx("61").gridy("129").build());
        listGrid.add(Grid.builder().gridx("61").gridy("125").build());
        listGrid.add(Grid.builder().gridx("61").gridy("124").build());
        listGrid.add(Grid.builder().gridx("62").gridy("126").build());
        listGrid.add(Grid.builder().gridx("62").gridy("127").build());
        listGrid.add(Grid.builder().gridx("62").gridy("128").build());
        listGrid.add(Grid.builder().gridx("62").gridy("129").build());
        listGrid.add(Grid.builder().gridx("62").gridy("125").build());
        listGrid.add(Grid.builder().gridx("63").gridy("126").build());
        listGrid.add(Grid.builder().gridx("63").gridy("125").build());
        listGrid.add(Grid.builder().gridx("63").gridy("126").build());
        listGrid.add(Grid.builder().gridx("63").gridy("127").build());
        return listGrid;
    }

}
