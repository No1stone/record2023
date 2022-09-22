package com.example.swagger.biz.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request Body Exame")
public class UserReq {

    /**
     * 발리데이터는 별도로 꼭 걸어줄것. 스웨거 에서만 적용됨.
     */


//    @ApiModelProperty(value = "아이디", example = "1", required = true, position = 1)
    @Schema(description = "아이디", name = "아이디 네임", required = true, maxLength = 1000, minLength = 1, example = "1")
    private Long id;
    @ApiModelProperty(value = "이름", example = "장원석", required = true, position = 2)
    private String name;
    @ApiModelProperty(value = "이메일", example = "test@test.com", required = true, position = 3)
    private String email;
    @ApiModelProperty(value = "나이", example = "20", required = false, position = 4)
    private int age;

}
