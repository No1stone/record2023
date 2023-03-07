package com.example.excelcommon;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TextClass {

    private String custName;
    private String custServiceMent;
    private String useYn;
    private String registId;
    private LocalDateTime registDate;
    private String updateId;
    private LocalDateTime updateDate;

    @Builder
    public TextClass(String custName, String custServiceMent, String useYn, String registId, LocalDateTime registDate, String updateId, LocalDateTime updateDate) {
        this.custName = custName;
        this.custServiceMent = custServiceMent;
        this.useYn = useYn;
        this.registId = registId;
        this.registDate = registDate;
        this.updateId = updateId;
        this.updateDate = updateDate;
    }
}
