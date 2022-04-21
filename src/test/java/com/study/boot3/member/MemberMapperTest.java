package com.study.boot3.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberMapperTest {

	@Autowired
	private MemberMapper memberMapper;
	
	//@Test
	void joinTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("q2");
		memberVO.setPw("q2");
		memberVO.setName("q2");
		memberVO.setEmail("q2");
		memberVO.setPhone("q2");
		int result = memberMapper.join(memberVO);
		assertNotEquals(0, result);
	}

	//@Test
	void loginTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("q1");
		memberVO.setPw("q1");
		memberVO = memberMapper.login(memberVO);
		assertNotNull(memberVO.getName());
	}
	//@Test
	void mypageTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("q1");
		memberVO = memberMapper.mypage(memberVO);
		assertNotNull(memberVO.getName());
	}
	
	//@Test
	void updateTest()throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("q2");
		memberVO.setName("q2 update");
		memberVO.setEmail("q2 update");
		memberVO.setPhone("q2 update");
		int result = memberMapper.update(memberVO);
		assertNotEquals(0, result);
	}
	
	//@Test
	void deleteTest()throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("q2");
		int result = memberMapper.delete(memberVO);
		assertNotEquals(0, result);
	}
	
	//@Test
	void fileAddTest()throws Exception{
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId("q2");
		memberFileVO.setFileName("q2file");
		memberFileVO.setOriName("q2file");
		int result = memberMapper.fileAdd(memberFileVO);
		assertNotEquals(0, result);
	}
	
	@Test
	void fileDeleteTest() throws Exception{
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId("q2");
		int result = memberMapper.fileDelete(memberFileVO);
		assertNotEquals(0, result);
	}
	


}
