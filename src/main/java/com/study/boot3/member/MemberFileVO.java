package com.study.boot3.member;

import com.study.boot3.util.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MemberFileVO extends FileVO {
	private String id;
}
