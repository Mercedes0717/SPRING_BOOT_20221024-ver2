
package com.example.demo.model.request;

import com.example.demo.model.domain.Member;
import jakarta.validation.constraints.*;

public class AddMemberRequest {

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @Email(message = "올바른 이메일 형식이 아닙니다.")
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$", message = "비밀번호는 8자 이상, 대소문자 및 숫자를 포함해야 합니다.")
    private String password;

    @Min(value = 19, message = "나이는 19세 이상이어야 합니다.")
    @Max(value = 90, message = "나이는 90세 이하여야 합니다.")
    private int age;

    @NotBlank(message = "전화번호를 입력해주세요.")
    private String mobile;

    @NotBlank(message = "주소를 입력해주세요.")
    private String address;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .age(age)
                .mobile(mobile)
                .address(address)
                .build();
    }

    // Getters and setters omitted for brevity
}
