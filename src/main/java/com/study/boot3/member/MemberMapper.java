package com.study.boot3.member;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	public MemberVO mypage(MemberVO memberVO) throws Exception;
	
	public MemberVO login(MemberVO memberVO) throws Exception;

	public int join(MemberVO memberVO) throws Exception;
	
	public int update(MemberVO memberVO) throws Exception;
	
	public int delete(MemberVO memverVO) throws Exception;
	
	public int fileAdd(MemberFileVO memberFileVO)throws Exception;
	
	public int fileDelete(MemberFileVO memberFileVO)throws Exception;
	
	public MemberFileVO fileDetail(MemberFileVO memberFileVO)throws Exception;
	
	public int setRoleAdd(Map<String,String> map)throws Exception;
	
	public MemberVO findId(MemberVO memberVO)throws Exception;
	
	public MemberVO idCheck(MemberVO memberVO)throws Exception;
	
}
