package com.example.mybatisjpadslmulticonnect.biz;

import com.example.mybatisjpadslmulticonnect.db.first.repo.TbCodeRepository1;
import com.example.mybatisjpadslmulticonnect.db.second.entity.TbCmnCode;
import com.example.mybatisjpadslmulticonnect.db.second.repo.TbCodeRepository2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class cont {

    private final TbCodeRepository1 tbCodeRepository1;
    private final TbCodeRepository2 tbCodeRepository2;

    @GetMapping("/test1")
    public List<com.example.mybatisjpadslmulticonnect.db.first.entity.TbCmnCode> test1(){
        return tbCodeRepository1.findAll();
    }
    @GetMapping("/test2")
    public List<TbCmnCode> test2(){
        return tbCodeRepository2.findAll();
    }


}
