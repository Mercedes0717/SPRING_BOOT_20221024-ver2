
package com.example.demo.model.request;

import jakarta.validation.constraints.NotBlank;

public class UpdateMemberRequest {

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    private String password;

    @NotBlank(message = "전화번호를 입력해주세요.")
    private String mobile;

    @NotBlank(message = "주소를 입력해주세요.")
    private String address;

    // Getters and setters omitted for brevity
}
