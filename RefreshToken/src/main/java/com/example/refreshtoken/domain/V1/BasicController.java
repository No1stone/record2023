package com.example.refreshtoken.domain.V1;

import com.example.refreshtoken.domain.V1.model.BasicModel;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/API/V1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class BasicController {

    private final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @PostMapping(path = "/test1")
    public void test1(@RequestBody BasicModel dto){

        logger.info("test log - - - {}",dto.getId());
        logger.info("test log - - - {}",dto.getPw());

    }
/*
    @GetMapping("/")
    public String index(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Hello, %s!", jwt.getSubject());
    }
*/

    @GetMapping("/message")
    public String message() {
        return "secret message";
    }
/*
https://www.javainuse.com/spring/boot-jwt
https://taes-k.github.io/2019/06/20/spring-msa-4/
https://bcp0109.tistory.com/301
https://github.com/ParkJiwoon/practice-codes/tree/master/spring-security-jwt/src/main/java/com/tutorial/jwtsecurity
 */
}
