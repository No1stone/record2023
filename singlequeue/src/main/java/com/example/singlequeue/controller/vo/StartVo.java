package com.example.singlequeue.controller.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class StartVo {

    @NotBlank
    private String key;
    @NotBlank
    private AcsVo val;
    public StartVo(String key, AcsVo val) {
        this.key = key;
        this.val = val;
    }

}
