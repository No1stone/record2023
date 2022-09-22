package com.jws.wonseok.biz.v1;


import com.google.gson.Gson;
import com.jws.wonseok.biz.v1.EnumTestModel.*;
import com.jws.wonseok.biz.v1.dto.Lottos;
import com.jws.wonseok.biz.v1.java8testModel.BlogPost;
import com.jws.wonseok.biz.v1.java8testModel.BlogPostType;
import com.jws.wonseok.biz.v1.java8testModel.Tuple;
import com.jws.wonseok.biz.v1.model.TestModelRequest;
import com.jws.wonseok.config.common.EnumMapperConfig;
import com.jws.wonseok.jpa.entity.MediaVerify;
import com.jws.wonseok.jpa.repository.MediaVerifyRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TestService {

    private final Logger logger = LoggerFactory.getLogger(TestService.class);

    public void aa() {

    }


    private static class KAKAOID {
        private String s;

        KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLessThan2() {
            StringBuilder sBuilder = new StringBuilder(s);
            while (sBuilder.length() <= 2) {
                sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
            }
            s = sBuilder.toString();
            return this;
        }

        private String getResult() {
            return s;
        }
    }


    public int[] 로또최대번호최소번호서비스(Lottos dto) {
        int[] lottos = dto.getMy_num();
        int[] win_nums = dto.getWin_num();

        int[] answer = new int[2];
        int count = 0;
        int binggo = 0;

        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                count += 1;
            }
            for (int e : win_nums) {
                if (lottos[i] == e) {
                    binggo += 1;
                    break;
                }
            }
        }
//        logger.info("binggo - - {}", binggo);
//        logger.info("count - - {}", count);
        answer[0] = 7 - (count + binggo);
        if (binggo < 1) {
            binggo = 1;
        }
        answer[1] = 7 - binggo;
//        logger.info("answer - - {}", answer);
        return answer;
    }

    public String HandPhoneWithc(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();
        int left = 10, rigth = 12;

        for (int num : numbers) {
            if (num == 0) {
                num = 11;
            }
            switch (num % 3) {
                case 0:
                    answer.append("R");
                    rigth = num;
                    break;
                case 1:
                    answer.append("L");
                    left = num;
                    break;
                case 2:
                    int minusL = num > left ? num - left : left - num;
                    int minusR = num > rigth ? num - rigth : rigth - num;
                    int distanceL = (minusL % 3) + (minusL / 3);
                    int distanceR = (minusR % 3) + (minusR / 3);
                    if (distanceL < distanceR) {
                        answer.append("L");
                        left = num;
                    } else if (distanceR < distanceL) {
                        answer.append("R");
                        rigth = num;
                    } else {
                        answer.append(hand.equals("right") ? "R" : "L");
                        if (hand.equals("right")) {
                            rigth = num;
                        } else {
                            left = num;
                        }
                    }
            }
        }
        return answer.toString();
    }

    public int[] Solution1() {

        String[] id_list = {};
        String[] report = {};
        int k = 0;
        Map<String, HashSet<String>> reportMemberList = new HashMap<>();
        Map<String, Integer> getMailCount = new HashMap<>();
        for (String id : id_list) {
            getMailCount.put(id, 0);
            reportMemberList.put(id, new HashSet<>());
        }

        for (String rep : report) {
            String[] checkReport = rep.split(" ");
            reportMemberList.get(checkReport[1]).add(checkReport[0]);
        }

        for (String key : reportMemberList.keySet()) {
            HashSet<String> reporters = reportMemberList.get(key);
            if (reporters.size() >= k) {
                for (String repot : reporters) {
                    Integer getMail = getMailCount.get(repot);
                    getMailCount.put(repot, getMail + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = getMailCount.get(id_list[i]);
        }

        return answer;
    }

    public String 신규아이디추천서비스1(String new_id) {
        String answer = new_id.toLowerCase(); // 1단계

        answer = answer.replaceAll("[^-_.a-z0-9]", ""); // 2단계
        answer = answer.replaceAll("[.]{2,}", "."); // 3단계
        answer = answer.replaceAll("^[.]|[.]$", "");    // 4단계
        if (answer.equals("")) {    // 5단계
            answer += "a";
        }
        if (answer.length() >= 16) {     // 6단계
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        if (answer.length() <= 2) {  // 7단계
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }
        return answer;
    }

    public String 신규아이디추천서비스2(String new_id) {
        String s = new KAKAOID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();
        return s;
    }

    public int 숫자문자열과영단어서비스(String s) {
        s = s.replaceAll("zero", "0");
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");
        int answer = Integer.parseInt(s);
        return answer;
    }

    public int 없는수더하기서비스(int[] numbers) {
        List<Integer> baseNum = new ArrayList<>();
        int[] baseArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int e : baseArray) {
            baseNum.add(e);
        }
        int answer = 0;
        int count = 0;
        List<Integer> removeList = new ArrayList<>();
        for (int e : numbers) {
            removeList.add(e);
        }
        baseNum.removeAll(removeList);
        for (int e : baseNum) {
            answer += e;
        }
        return answer;
    }

    public int 음양더하기서비스(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }

    public int 내적서비스(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }


    public void 이메일정규식테스트(String email) {
        String a = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
        logger.info("email service --{}", Pattern.matches(a, email));
    }


    public void 비밀번호정규식테스트(String passw) {
        String a = "^.*(?=^.{8,20}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";
        logger.info("password service --{}", Pattern.matches(a, passw));
    }


    public void 비밀번호정규식테스트2(String passw) {
        String a = "^.*(?=^.{8,20}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&-_+.=]).*$";
        logger.info("password service --{}", Pattern.matches(a, passw));
    }

    public int 탐욕법서비스(int n, int[] lost, int[] reserve) {
        int answer = 0;
        if (n < 30 || n > 2) {
            return answer;
        }
        if (lost.length < 1) {
            return answer;
        }

        for (int i = 0; i < n; i++) {
            if (reserve[i] == lost[i]) {
                continue;
            } else if (reserve[i] == lost[i - 1]) {
                continue;
            } else if (reserve[i] == lost[i + 1]) {
                continue;
            } else {
                n -= 1;
            }
        }


        return answer;
    }

    public int PoketService(int[] nums) {
//        int answer = nums.length / 2;
//        HashSet<Integer> disNum = new HashSet();
//        for (int e : nums) {
//            disNum.add(e);
//        }
//        int disNum2 = (int) Arrays.stream(nums).distinct().count();
//        int disNum3 = Arrays.stream(nums)
//                .boxed()
//                .collect(Collectors.collectingAndThen(Collectors.toSet(), e -> Integer.min(e.size(), answer)));
//        logger.info("stream - -{}", disNum);
//        logger.info("stream - -{}", disNum2);
//        logger.info("stream - -{}", disNum3);
//        logger.info("answer  - - -{}", answer);
//        logger.info("disnum  - - -{}", disNum.size());
//        logger.info("nums  - - -{}", nums);
//        return answer > disNum2 ? disNum2 : answer;
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(), e -> Integer.min(e.size(), nums.length / 2)));
    }

    public int SosuService(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    logger.info("sum - - {}", nums[i] + nums[j] + nums[k]);
                    logger.info("num1 - - {}", nums[i]);
                    logger.info("num2 - - {}", nums[j]);
                    logger.info("num3 - - {}", nums[k]);
                    if (isSosu(nums[i] + nums[j] + nums[k])) {
                        answer++;
                        logger.info("answer - - {}", answer);

                    }
                }
            }
        }
        return answer;
    }

    public static boolean isSosu(int n) {
        boolean result = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public int[] FailPercentService(int n, int[] stages) {
        int[] answer = new int[n];
        Map<Integer, Integer> clearPeple = new HashMap();
        Map<Integer, Double> failPer = new HashMap<>();
        int userCount = 0;
        for (int i = 0; i <= n; i++) {
            int count = 0;
            for (int e : stages) {
                if (i + 1 == e) {
                    count += 1;
                }
            }
            userCount += count;
            logger.info("usercount = {}", userCount);
            logger.info("count = {}", count);
            clearPeple.put(i + 1, count);
            failPer.put(i + 1, (double) count / (double) stages.length - userCount);
            logger.info("clear user = {}", stages.length - userCount);
        }

        logger.info(" --clear == {}", clearPeple);
        logger.info(" --clear == {}", failPer);
        return answer;
    }

    public int YaksuCountroller(int left, int right) {
        int answer = 0;
        List<Integer> yak = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    yak.add(j);
                }
            }
            if (yak.size() % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
            yak = new ArrayList<>();
        }
        return answer;
    }

    public ArrayList<Integer> Ea2PlusController(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public int YesanService(int[] d, int budget) {
        int answer = 0;
        int ch = 0;
        int idx = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            ch += d[i];
            if (ch >= budget) {
                answer = i;
                break;
            }
        }
        if (ch <= budget) {
            answer = d.length;
        }
        return answer;
    }

    public int Modi1Service(int n) {
        int answer = 0;
        int idx = 1;
        while (true) {
            if (n % idx == 1) {
                answer = idx;
                break;
            }
            idx++;
        }
        return answer;
    }

    public int ThreeReverseService(int n) {
        int answer = 0;


        return answer;
    }

    public String StringDescService(String s) {
        char aa[] = s.toCharArray();
        Arrays.sort(aa);
        StringBuffer sb = new StringBuffer();
        for (char e : aa) {
            sb.append(e);
        }
        return sb.reverse().toString();
    }

    public String ee2016eee(int a, int b) {
        String answer = "";

        String cal1 = new Calendar.Builder().setDate(2016, a - 1, b)
                .build().getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
        logger.info(" - - -{}", cal1);
        String cal2 = LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
        logger.info(" - - -{}", cal2);
        return answer;
    }

    public int minitableService(int[][] a) {
        int answer = 0;
        int aa = 0;
        int bb = 0;
        for (int i = 0; i < a.length; i++) {
            int temp = 0;
            if (a[i][0] > a[i][1]) {
                temp = a[i][0];
                a[i][0] = a[i][1];
                a[i][1] = temp;
            }
            if (aa < a[i][0]) {
                aa = a[i][0];
            }
            if (bb < a[i][1]) {
                bb = a[i][1];
            }
            temp = 0;
        }
        return aa * bb;
    }

    public Long NolEService(int a, int b, int c) {
        Long totalPrice = 0L;
        for (long i = 1; i <= (long) c; i++) {
            totalPrice += a * i;
        }
        return totalPrice - (long) b;
    }

    public String CenterStringGetService(String s) {
        char a[] = s.toCharArray();
        int center = a.length / 2;
        if (a.length % 2 == 0) {
            return String.format("%s%s", a[center - 1], a[center]);
        } else {
            return String.format("%s", a[center]);
        }
    }

    public List<Integer> NopareNumberService(int[] arr) {
        int temp = arr[0];
        List<Integer> a = new ArrayList<>();
        a.add(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            if (temp != arr[i]) {
                a.add(arr[i]);
                temp = arr[i];
            }
        }
        return a;
    }

    public List<Integer> ModifiCompareService(int[] arr, int divisor) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                a.add(arr[i]);
            }
        }
        if (a.size() > 0) {
            Collections.sort(a);
            return a;
        } else {
            a.add(-1);
            return a;
        }
    }

    public Long NumberSumService(int a, int b) {
        Long answer = 0L;
        if (a == b) {
            return (long) a;
        }
        int temp = 0;
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        for (int i = a; i <= b; i++) {
            answer += i;
        }
        return answer;
    }

    public ArrayList<String> StringChoiceService(String[] strings, int n) {
        HashMap<String, String> index = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            index.put(strings[i].substring(n) + i, strings[i]);
        }
        ArrayList<String> answer = new ArrayList<>();
        var sort = index.keySet().stream().sorted().collect(Collectors.toList());
        for (String e : sort) {
            answer.add(index.get(e));
        }
        return answer;
    }

    public Boolean PYcountService(String a) {
        var b = a.toLowerCase().toCharArray();
        int ycount = 0;
        int pcount = 0;
        for (char e : b) {
            if (e == 'y') {
                ycount++;
            }
            if (e == 'p') {
                pcount++;
            }
        }
        return ycount == pcount ? true : false;
    }

    public Boolean StringCheckService(String s) {
        return Pattern.matches("[1-9]{4},{6}", s);
    }

    public int StringZipService(String s) {
        int answer = 0;
        // s를 서브스트링 1 ~ lenght로 자른 문자열 배열 만들기
        //01 12 23 34
        //02 24 46 68
        //03 36 69


        return answer;
    }

    public List<String> KakaoOpenChatingService(String[] s) {
        HashMap<String, String> idResult = new HashMap<>();
        List<String> messageResult = new ArrayList<>();
        for (String e : s) {
//            if(e.startsWith("Enter")){
//                idResult.put(e.split(" ")[1],e.split(" ")[2]);
//                messageResult.add(String.format("%s@님이 들어왔습니다.", e.split(" ")[1]));
//                continue;
//            }
//            if(e.startsWith("Change")){
//                idResult.put(e.split(" ")[1],e.split(" ")[2]);
//                continue;
//            }
//            if(e.startsWith("Leave")){
//                messageResult.add(String.format("%s@님이 나갔습니다.", e.split(" ")[1]));
//                continue;
//            }
            switch (e.split(" ")[0]) {
                case "Enter":
                    idResult.put(e.split(" ")[1], e.split(" ")[2]);
                    messageResult.add(String.format("%s@님이 들어왔습니다.", e.split(" ")[1]));
                    break;
                case "Change":
                    idResult.put(e.split(" ")[1], e.split(" ")[2]);
                    break;
                case "Leave":
                    messageResult.add(String.format("%s@님이 나갔습니다.", e.split(" ")[1]));
                    break;
            }
        }

        List<String> answer = new ArrayList<>();
        for (String e : messageResult) {
            String[] indexId = e.split("@");
            answer.add(e.replaceAll(indexId[0] + "@", idResult.get(indexId[0])));
        }
        return answer;
    }

    public String World124Service(int n) {
        StringBuffer answer = new StringBuffer();
        String toS = String.valueOf(n);
        logger.info("validString = = ={}", toS);
        return answer.toString();
    }

    public Long PerfactSquareService(int w, int h) {

        // 12 * 8 = 96
        // gdc = 4
        // 16 ? = 12 + 8 - 4
        // 3 2
        // 80

        return (long) w * h - (w + h - gdcTest1(w, h));
    }

    public int gdcTest1(int w, int h) {
        int temp = 0;
        if (w > h) {
            temp = w;
            w = h;
            h = temp;
        }
        int n = 0;
        while (h != 0) {
            n = w % h;
            w = h;
            h = n;
        }
        return w;
    }

    public int gdcTest2(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gdcTest2(b, a % b);
        }
    }

    public int[] FunctionDevService(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> sumList = new ArrayList<>();
        // 프로그래스 를 스피드로 더한다
        // 첫번째의 합이 100이 넘으면 그리스트의 100보다 큰값을 리턴한다
        progresses = progressFor(progresses, speeds);
        return answer;
    }

    public int[] progressFor(int[] progresses, int[] speeds) {
        for (int i = 0; i < progresses.length; i++) {
            progresses[i] += speeds[i];
            logger.info("profress - {}", progresses);
        }
        return progresses;
    }

    public int ScovilleService(int[] a, int b) {
        int answer = 0;
        return answer;
    }

    public int networkController(int a, int[][] b) {
        int answer = 0;


        return answer;
    }

    public int aa(int[][] b) {
        int re = 0;

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {

            }
            re++;
            return re;
        }

        return 0;
    }

    public int trafficService(String[] s) throws ParseException {
        int answer = 0;

        // 날짜 시간뒤에 3.123s 라는 시간으로 인풋이들어옴
        // 날짜와 시간을 분리시킨뒤 날짜시간 / 날짜시간 + 시행시간 한것 2개를 만듬
        // 해당날짜시간에 해당하는 날짜시간+시행시간을 카운트함


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("SSS");
        List<Date> comparisonList = new ArrayList<>();
        List<Date> startDate = new ArrayList<>();
        List<Date> endDate = new ArrayList<>();
        for (String e : s) {
            String pre = e.substring(0, 23);
            String sub = e.substring(24, e.length()).replaceAll("s", "");
            Date preDate = df.parse(pre);
            double subD = Double.parseDouble(sub) * 1000;
            Long subL = (new Double(subD).longValue());
            startDate.add(preDate);
            endDate.add(Date.from(preDate.toInstant().plusMillis(subL)));
            comparisonList.add(df.parse(pre.substring(0, 20) + "000"));
        }
        comparisonList.stream().sorted().distinct().collect(Collectors.toList());
        logger.info("comparisonList - {}", comparisonList.stream().sorted().distinct().collect(Collectors.toList()));
        logger.info("startDate - {}", startDate);
        logger.info("endDate - {}", endDate);
//        comparisonList.stream().sorted().distinct().collect(Collectors.toList()).size();;
        int result[] = new int[comparisonList.stream().sorted().distinct().collect(Collectors.toList()).size()];

        for (int i = 0; i < startDate.size(); i++) {
            for (int j = 0; j < comparisonList.stream().sorted().distinct().collect(Collectors.toList()).size(); j++) {
                logger.info("i {}", i);
                logger.info("start = ={}", startDate.get(i).compareTo(comparisonList.get(j)));
                logger.info("end   = ={}", endDate.get(i).compareTo(comparisonList.get(j)));
                logger.info("startDate   = ={}", startDate.get(i));
                logger.info("endDate     = ={}", endDate.get(i));
                if (
                        endDate.get(i).compareTo(comparisonList.get(j)) > 0
                ) {
                    result[j]++;
                }
            }
        }
        logger.info("result - {}", result);
        return answer;
    }

    @Autowired
    private EnumMapperConfig enumMapperConfig;

    public List<EnumMapperValue> test44Service() {
//        String ansewr = "";

        logger.info("DefaultEnum {}", DefaultEnumYn.N.getDefault1());
        logger.info("DefaultEnum {}", DefaultEnumYn.N.getDefault2());
        logger.info("DefaultEnum {}", DefaultEnumYn.N.getDefault3());
        logger.info("DefaultEnum {}", DefaultEnumYn.Y.getDefault1());
        logger.info("DefaultEnum {}", DefaultEnumYn.Y.getDefault2());
        logger.info("DefaultEnum {}", DefaultEnumYn.Y.getDefault3());

//        Map<String, String> testMap = new HashMap<>();
//        testMap.put("1","a");
//        testMap.put("2","b");
//        testMap.put("3","c");

        logger.info("calTest a {}", CalEnumTest.cal_a.appCal(100L));
        logger.info("calTest b {}", CalEnumTest.cal_b.appCal(100L));
        logger.info("calTest c {}", CalEnumTest.cal_c.appCal(100L));

        logger.info("PayGroupAdvanced c {}", PayGroupAdvanced.CARD.getTitle());
        logger.info("PayGroupAdvanced c {}", PayGroupAdvanced.CASH.getTitle());
        logger.info("PayGroupAdvanced c {}", PayGroupAdvanced.ETC.getTitle());
        logger.info("PayGroupAdvanced c {}", PayGroupAdvanced.EMPTY.getTitle());

        logger.info("PayGroupAdvanced c {}", PayGroupAdvanced.findByPayType(PayType.PAYCO));

        logger.info("enumMapperEnum  {}", EnumMapperEnum.PERCENT.getCode());
        logger.info("enumMapperEnum  {}", EnumMapperEnum.PERCENT.getTitle());
        logger.info("enumMapperEnum  {}", EnumMapperEnum.MONEY.getCode());
        logger.info("enumMapperEnum  {}", EnumMapperEnum.MONEY.getTitle());


        logger.info("enumMapper1  {}", enumMapperConfig.enumMapper1().get("EnumMapperEnum1"));
        logger.info("enumMapper2  {}", enumMapperConfig.enumMapper2().get("EnumMapperEnum2"));
        logger.info("getConstructors  {}", Arrays.stream(EnumMapperEnum.class.getConstructors()).collect(Collectors.toList()));


        return enumMapperConfig.enumMapper1().get("EnumMapperEnum1");
    }

    public String testCall(String a, String b) {
        return a + b;
    }


    public void test45Service(int[] a, int b) {

        int math = -1;
        int sum = 0;
        int answer = 0;

        moveHanoiTower(b, 1, 2, 3);
    }

    public static void moveHanoiTower(int num, int from, int by, int to) {
// 이동할 원반의 수가 1개라면?
        if (num == 1) {
            System.out.println("원반" + num + "을 " + from + "에서 " + to + "로 이동");
        } else {
            // STEP 1 : num-1개를 A에서 B로 이동
            moveHanoiTower(num - 1, from, to, by);
            // STEP 2 : 1개를 A에서 C로 이동
            System.out.println("원반" + num + "을 " + from + "에서 " + to + "로 이동");
            // STEP 3 : num-1개를 B에서 C로 이동
            moveHanoiTower(num - 1, by, from, to);
        }
    }

    public void test46Service(TestModelRequest dto) {
        Gson gson = new Gson();
//        logger.info(" - - -{}",dto.TestModelRequest()) ;
        logger.info(" - - -{}", gson.toJson(dto.TestModelRequest()));

    }

    public int recusuintest46(int b) {
        if (b == 0) {
            return 0;
        } else {
            return recusuintest46(b - 1);
        }
    }

    public void test47Service() {

        List<String> test1 = new ArrayList<>();
        Map<String, String> test2 = new HashMap<>();
        List<Integer> test3 = new ArrayList<>();
        Map<Integer, Integer> test4 = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            test1.add(String.format("List%s", i));
            test3.add(i);
            test2.put(String.format("key%s", i), String.format("value%s", i));
            test4.put(i, i);
        }
        logger.info(" List - {}", test1);
        logger.info(" List - {}", test3);
        logger.info(" Map - {}", test2);
        logger.info(" Map - {}", test4);

//        test3.stream().collect(Collectors.);

    }

    public void test48Service() {
        UnaryOperator<Integer> test1 = (i) -> i * i;
        BinaryOperator<Integer> test2 = (i, j) -> i * j;
        IntConsumer test3 = (i) -> logger.info("intcon - {}", i);
        IntSupplier test4 = () -> 123123123;
        logger.info("test1 = {}", test1.apply(5));
        logger.info("test2 = {}", test2.apply(5, 6));
        test3.accept(8);
        logger.info("test4 = {}", test4.getAsInt());


    }

    private final MediaVerifyRepository mediaVerifyRepository;

    @Transactional
    public void test49Service(MediaVerifyReq dto) {
        Gson gson = new Gson();
        logger.info("dto - {}", gson.toJson(dto.MediaVerifyReq()));
        logger.info("dto - {}", dto.MediaVerifyReq().getAccntId());
        mediaVerifyRepository.save(dto.MediaVerifyReq());
    }

    public void test50Service() {

        List<String> test1 = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k");
        List<String> test2 = Stream.of("l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v")
                .collect(Collectors
                        .collectingAndThen(
                                Collectors.toList(),
                                Collections::<String>unmodifiableList));

        var test11 = test1.stream().collect(Collectors.toCollection(LinkedList::new));
        test1.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collection::toString));
        logger.info("test11 - {}", test11);
        var test111 = test1.stream().collect(Collectors.joining(", "));
        logger.info("test111 - {}", test111);
    }


    public void test51Service() {

        List<BlogPost> posts = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            posts.add(BlogPost
                    .builder()
                    .author(String.format("author%s", i))
                    .likes(i)
                    .title(String.format("title%s", i))
                    .type(BlogPostType.NEWS)
                    .build());
            posts.add(BlogPost
                    .builder()
                    .author(String.format("author%s", i * 10))
                    .likes(i)
                    .title(String.format("title%s", i * 10))
                    .type(BlogPostType.REVIEW)
                    .build());
            posts.add(BlogPost
                    .builder()
                    .author(String.format("author%s", i * 100))
                    .likes(i)
                    .title(String.format("title%s", i * 100))
                    .type(BlogPostType.GUIDE)
                    .build());
        }


        posts.stream().forEach(System.out::println);

        //단일 열로 간단한 그룹화
        Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType));
        logger.info("postsPerType = {}", postsPerType.get(BlogPostType.NEWS).get(1).getTitle());
        logger.info("postsPerType = {}", postsPerType.get(BlogPostType.REVIEW).get(1).getTitle());
        logger.info("postsPerType = {}", postsPerType.get(BlogPostType.GUIDE).get(1).getTitle());

        //복잡한 맵 키 유형으로 그룹화
        Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
                .collect(Collectors.groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));
        logger.info("tupleSize = {}", postsPerTypeAndAuthor.size());
        var keySet = postsPerTypeAndAuthor.keySet().iterator();
        logger.info("tupleKey = {}", postsPerTypeAndAuthor.values());
        logger.info("tupleKey = {}", postsPerTypeAndAuthor.get(keySet.next()));

        Gson gson = new Gson();

        while (keySet.hasNext()) {
            Tuple a = keySet.next();
            logger.info(" - -{}", gson.toJson(postsPerTypeAndAuthor.get(a)));
        }

        //리턴 된 맵 값 유형 수정
        Map<BlogPostType, Set<BlogPost>> postsPerType1 = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType, Collectors.toSet()));

        logger.info(" - - -{}", gson.toJson(postsPerType1.get(BlogPostType.NEWS)));

        //여러 필드로 그룹화
        Map<String, Map<BlogPostType, List<BlogPost>>> map = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.groupingBy(BlogPost::getType)));

        logger.info("map -- {}", gson.toJson(map.get("author1").get(BlogPostType.NEWS).get(0)));

        //그룹화 된 결과에서 평균 얻기
        Map<BlogPostType, Double> averageLikesPerType = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType, Collectors.averagingInt(BlogPost::getLikes)));

        //그룹화 된 결과에서 합계 얻기
        Map<BlogPostType, Integer> likesPerType = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType, Collectors.summingInt(BlogPost::getLikes)));

        //그룹화 된 결과에서 최대 또는 최소 얻기
        Map<BlogPostType, Optional<BlogPost>> maxLikesPerPostType = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType,
                        Collectors.maxBy(Comparator.comparingInt(BlogPost::getLikes))));

        //그룹화 된 결과의 속성에 대한 요약 얻기
        Map<BlogPostType, IntSummaryStatistics> likeStatisticsPerType = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType,
                        Collectors.summarizingInt(BlogPost::getLikes)));

        //그룹화 된 결과를 다른 유형으로 맵핑
        Map<BlogPostType, String> postsPerType2 = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType,
                        Collectors.mapping(BlogPost::getTitle, Collectors.joining(", ", "Post titles: [", "]"))));
        //맵타입 그룹핑 반환
        EnumMap<BlogPostType, List<BlogPost>> postsPerType3 = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType,
                        () -> new EnumMap<>(BlogPostType.class), Collectors.toList()));

        //동시성 Grouping by Collector
        ConcurrentMap<BlogPostType, List<BlogPost>> postsPerType4 = posts.parallelStream()
                .collect(Collectors.groupingByConcurrent(BlogPost::getType));


    }

    public void test52Service() {
        List<MediaVerify> aa = new ArrayList<>();

        logger.info("==============");
        for (int i = 0; i < 5; i++) {
            aa.add(MediaVerify.builder()
                    .accntId((long)i)
                    .mediaVerifyReqId("test")
                    .mediaTypeCd("test")
                    .mediaValidString("test")
                    .verifyTypeCd("test")
                    .expiredDt(LocalDateTime.now())
                    .regDt(LocalDateTime.now())
                    .build());
        }

        aa.stream().forEach(mediaVerifyRepository::save);
    }

    public void test53Service() {




    }


}



