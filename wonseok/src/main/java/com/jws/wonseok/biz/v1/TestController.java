package com.jws.wonseok.biz.v1;

import com.jws.wonseok.biz.v1.EnumTestModel.EnumMapperEnum;
import com.jws.wonseok.biz.v1.EnumTestModel.EnumMapperValue;
import com.jws.wonseok.biz.v1.EnumTestModel.MediaVerifyReq;
import com.jws.wonseok.biz.v1.dto.*;
import com.jws.wonseok.biz.v1.model.TestModelRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);
    private final TestService testService;

    @GetMapping(path = "/test1")
    public void Test1() {
        LinkedList ll = new LinkedList();
    }

    @GetMapping(path = "/test2")
    public int[] Test2() {
        logger.info("init");
        return testService.Solution1();
    }

    @GetMapping(path = "/test3/{aa}")
    public int[] Test3(@PathVariable(name = "aa") String aa) {
        logger.info("init -{}", aa);
        return testService.Solution1();
    }

    @GetMapping(path = "/test4/{id}")
    public String 신규아이디추천컨트롤러1(@PathVariable(name = "id") String id) {
        return testService.신규아이디추천서비스1(id);
    }

    @GetMapping(path = "/test5/{id}")
    public String 신규아이디추천컨트롤러2(@PathVariable(name = "id") String id) {
        return testService.신규아이디추천서비스2(id);
    }

    @GetMapping(path = "/test6/{id}")
    public int 숫자문자열과영단어컨트롤러(@PathVariable(name = "id") String id) {
        return testService.숫자문자열과영단어서비스(id);
    }

    @PostMapping(path = "/test7")
    public int[] 로또최대번호최소번호컨트롤러(@RequestBody Lottos dto) {
        logger.info(" - - - - -{} ", dto.toString());
        return testService.로또최대번호최소번호서비스(dto);
    }

    @PostMapping(path = "/test8")
    public int 없는수더하기(@RequestBody NotingNumber dto) {
        logger.info(" - - - - -{} ", dto.toString());
        return testService.없는수더하기서비스(dto.getNumbers());
    }

    @PostMapping(path = "/test9")
    public int 음양더하기(@RequestBody PlusMinusSum dto) {
        logger.info(" - - - - -{} ", dto.toString());
        return testService.음양더하기서비스(dto.getNumbers(), dto.getSigns());
    }

    @PostMapping(path = "/test10")
    public int 내적(@RequestBody Neajuk dto) {
        logger.info(" - - - - -{} ", dto.toString());
        return testService.내적서비스(dto.getA(), dto.getB());
    }


    @GetMapping(path = "/test11/{email}")
    public void 이메일정규식테스트(@PathVariable(name = "email") String email) {
        logger.info(" - - - - -{} ", email);
        testService.이메일정규식테스트(email);
    }

    @GetMapping(path = "/test12/{password}")
    public void 비밀번호정규식(@PathVariable(name = "password") String password) {
        logger.info(" - - - - -{} ", password);
        testService.비밀번호정규식테스트(password);
    }

    @GetMapping(path = "/test13/{password}")
    public void 비밀번호정규식2(@PathVariable(name = "password") String password) {
        logger.info(" - - - - -{} ", password);
        testService.비밀번호정규식테스트2(password);
    }

    @PostMapping(path = "/test14")
    public int 탐욕법컨트롤러(@RequestBody Greedy dto) {
        return testService.탐욕법서비스(dto.getN(), dto.getLost(), dto.getReserve());
    }

    @PostMapping(path = "/test15")
    public int PoketCountroller(@RequestBody Poketmon dto) {
        return testService.PoketService(dto.getNums());
    }

    @PostMapping(path = "/test16")
    public int SosuCountroller(@RequestBody Poketmon dto) {
        return testService.SosuService(dto.getNums());
    }

    @PostMapping(path = "/test17")
    public int[] FailPercentCountroller(@RequestBody FailPercent dto) {
        return testService.FailPercentService(dto.getN(), dto.getStages());
    }

    @PostMapping(path = "/test18")
    public int YaksuCountroller(@RequestBody Yaksu dto) {
        return testService.YaksuCountroller(dto.getLeft(), dto.getRight());
    }

    @PostMapping(path = "/test19")
    public ArrayList<Integer> Ea2PlusController(@RequestBody Plus2Ea dto) {
        return testService.Ea2PlusController(dto.getNumbers());
    }

    @PostMapping(path = "/test20")
    public int YesanController(@RequestBody Yesan dto) {
        return testService.YesanService(dto.getD(), dto.getBudget());
    }

    @PostMapping(path = "/test21")
    public int Modi1Controller(@RequestBody Modi1 dto) {
        return testService.Modi1Service(dto.getN());
    }

    @PostMapping(path = "/test22")
    public int ThreeReverseController(@RequestBody Modi1 dto) {
        return testService.ThreeReverseService(dto.getN());
    }

    @GetMapping(path = "/test23/{string}")
    public String StringDescController(@PathVariable(name= "string") String string) {
        return testService.StringDescService(string);
    }

    @PostMapping(path = "/test24")
    public String ee2016eee(@RequestBody IntAB dto) {
        return testService.ee2016eee(dto.getA(), dto.getB());
    }

    @PostMapping(path = "/test25")
    public int minitableController(@RequestBody Int2chArray dto) {
        return testService.minitableService(dto.getA());
    }

    @PostMapping(path = "/test29")
    public Long NolEController(@RequestBody IntABC dto) {
        return testService.NolEService(dto.getA(), dto.getB(), dto.getC());
    }

    @GetMapping(path = "/test30/{s}")
    public String CenterStringGetController(@PathVariable(name = "s")String s) {
        return testService.CenterStringGetService(s);
    }

    @PostMapping(path = "/test31")
    public List<Integer> NopareNumberController(@RequestBody IntArray dto) {
        return testService.NopareNumberService(dto.getArr());
    }

    @PostMapping(path = "/test32")
    public List<Integer> ModifiCompareController(@RequestBody ModifiCompare dto) {
        return testService.ModifiCompareService(dto.getArr(), dto.getDivisor());
    }

    @GetMapping(path = "/test33/{a}/{b}")
    public Long NumberSum(@PathVariable(name = "a")int a, @PathVariable(name = "b")int b ) {
        return testService.NumberSumService(a, b);
    }

    @PostMapping(path = "/test34")
    public ArrayList<String> StringChoiceController(@RequestBody StringArrayInt dto) {
        return testService.StringChoiceService(dto.getStrings(), dto.getN());
    }

    @GetMapping(path = "/test33/{a}")
    public Boolean PYcountController(@PathVariable(name = "a")String a) {
        return testService.PYcountService(a);
    }

    @GetMapping(path = "/test34/{a}")
    public Boolean StringCheckController(@PathVariable(name = "a")String a) {
        return testService.StringCheckService(a);
    }

    @GetMapping(path = "/test35/{s}")
    public int StringZipController(@PathVariable(name = "s")String s) {
        return testService.StringZipService(s);
    }

    @PostMapping(path = "/test36")
    public List<String> KakaoOpenChatingController(@RequestBody StringArray dto) {

        return testService.KakaoOpenChatingService(dto.getS());
    }

    @GetMapping(path = "/test36/{n}")
    public String World124controller(@PathVariable(name = "n")int n) {
        return testService.World124Service(n);
    }

    @PostMapping(path = "/test37")
    public Long PerfactSquareController(@RequestBody IntAB dto){
        return testService.PerfactSquareService(dto.getA(), dto.getB());
    }

    @PostMapping(path = "/test38")
    public int GdcTest1Controller(@RequestBody IntAB dto){
        return testService.gdcTest1(dto.getA(), dto.getB());
    }
    @PostMapping(path = "/test39")
    public int GdcTest2Controller(@RequestBody IntAB dto){
        return testService.gdcTest2(dto.getA(), dto.getB());
    }

    @PostMapping(path = "/test40")
    public int[] FunctionDevController(@RequestBody IntArrayIntArray dto){
        return testService.FunctionDevService(dto.getA(), dto.getB());
    }

    @PostMapping(path = "/test41")
    public int ScovilleController(@RequestBody IntArrayInt dto){
        return testService.ScovilleService(dto.getA(), dto.getB());
    }

    @PostMapping(path = "/test42")
    public int networkController(@RequestBody IntInt2Array dto){
        return testService.networkController(dto.getA(), dto.getB());
    }

    @PostMapping(path = "/test43")
    public int trafficController(@RequestBody StringArray dto) throws ParseException {
        return testService.trafficService(dto.getS());
    }

    @GetMapping(path = "/test44")
    public List<EnumMapperValue>  test44() {
        return testService.test44Service();
    }

    @GetMapping(path = "/test45")
    public void  test45(@RequestBody IntArrayInt dto) {
        testService.test45Service(dto.getA(), dto.getB());
    }

    @PostMapping(path = "/test46")
    public void  test46(@Valid @Validated @RequestBody TestModelRequest dto) {
        testService.test46Service(dto);
    }

    @GetMapping(path = "/test47")
    public void test47() {
        testService.test47Service();
    }

    @GetMapping(path = "/test48")
    public void test48() {
        testService.test48Service();
    }

    @PostMapping(path = "/test49")
    public void test49(@RequestBody MediaVerifyReq dto) {
        testService.test49Service(dto);
    }

    @GetMapping(path = "/test50")
    public void test50() {
        testService.test50Service();
    }
    @GetMapping(path = "/test51")
    public void test51() {
        testService.test51Service();
    }
    @GetMapping(path = "/test52")
    public void test52() {
        testService.test52Service();
    }


}



