package com.study.boot3.member;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberVO {
	
	@NotBlank
	private String id;
	@Size(min = 3, max = 8, message = "비밀번호는 3자 이상 8자 이하")
	private String pw;
	
	private String checkPw;
	
	@NotEmpty(message = "이름을 입력해주세요.")
	private String name;
	@Email(message = "이메일 형식에 맞게 입력해주세요.")
	@NotBlank
	private String email;
	private String phone;
	private MemberFileVO memberFileVO;
	private List<RoleVO> roleVOs;
}
