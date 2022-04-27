package com.study.boot3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.study.boot3.util.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private FileManager fileManager;
	
	public int join(MemberVO memberVO,String roleName,MultipartFile file) throws Exception {
		int result = memberMapper.join(memberVO);
		RoleVO roleVO = new RoleVO();
		roleVO.setRoleName(roleName);
		result = memberMapper.setRoleAdd(roleVO);
		MemberRoleVO memberRoleVO = new MemberRoleVO();
		memberRoleVO.setId(memberVO.getId());
		memberRoleVO.setRoleId(roleVO.getRoleId());
		result = memberMapper.setMemberRoleAdd(memberRoleVO);
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
	
}
