package com.jws.wonseok.biz.v1.model;

import com.jws.wonseok.biz.v1.EnumTestModel.DefaultEnumYn;
import com.jws.wonseok.jpa.repository.AccountRepository;
import lombok.*;
import org.hibernate.annotations.NotFound;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter@NoArgsConstructor@AllArgsConstructor
@RequiredArgsConstructor
public class TestModelRequest {

    @NotNull
    private String a;
    
    @NonNull
    //롬복 논널을 RequestBody Json에서 못걸러줌
    private String b;
    @NotNull
    private String c;

    //발리드 어노테이션 선언후 걸림.
    //공백 허용
    @NotEmpty
    private String d;
    //공백도 허용안함
    @NotBlank
    private String e;
    @NotFound
    private String f;
    private String g;

    public TestModel TestModelRequest(){
    return TestModel.builder()
            .a(a)
            .b(b)
            .c(c)
            .d(d)
            .e(e)
            .f(f)
            .g(DefaultEnumYn.N.getDefault1())
            .build();
    }


}
