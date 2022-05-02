package com.study.boot3.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.study.boot3.util.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${member.role.member}")
	private String memberRole;
	
	public int join(MemberVO memberVO,String roleName,MultipartFile file) throws Exception {
		int result = memberMapper.join(memberVO);
		Map<String, String> map = new HashMap<>();
		map.putIfAbsent("id",memberVO.getId());
		map.put("roleId",memberRole);
		result = memberMapper.setRoleAdd(map);
		if(file!=null) {
		String fileName = fileManager.fileSave(file, "resources/upload/member/");
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId(memberVO.getId());
		memberFileVO.setFileName(fileName);
		memberFileVO.setOriName(file.getOriginalFilename());
		result = memberMapper.fileAdd(memberFileVO);
		}
		return result;
	} 
	public MemberVO login(MemberVO memberVO) throws Exception{
		return memberMapper.login(memberVO);
	}
	public MemberVO mypage(MemberVO memberVO) throws Exception{
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId(memberVO.getId());
		memberFileVO = memberMapper.fileDetail(memberFileVO);
		memberVO.setMemberFileVO(memberFileVO);
		return memberMapper.mypage(memberVO);
	}
	public int update(MemberVO memberVO) throws Exception{
		return memberMapper.update(memberVO);
	}
	public int delete(MemberVO memberVO) throws Exception{
		return memberMapper.delete(memberVO);
	}
	
	public MemberVO findId(MemberVO memberVO)throws Exception{
		return memberMapper.findId(memberVO);
	}
	
}
