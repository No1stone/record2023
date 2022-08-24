package com.jws.wonseok.config.filter.token;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Service
public class UserInfoDTO {

    private Long accountId;
    private String accntTypeCd;
    private Long lastUseProfileId;
    private List<Long> ProfileList;
    private HashMap<String, String> permission;

}
