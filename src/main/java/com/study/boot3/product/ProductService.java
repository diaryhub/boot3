package com.study.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.study.boot3.member.MemberVO;
import com.study.boot3.util.FileManager;
import com.study.boot3.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private FileManager fileManager;

	public List<ProductVO> list(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(productMapper.total(pager));
		return productMapper.list(pager);
	}

	public int add(ProductVO productVO, MultipartFile[] files) throws Exception {
		int result = productMapper.add(productVO);
		if (files != null) {
			for (MultipartFile f : files) {
				if (f.isEmpty()) {
					continue;
				}
				String fileName = fileManager.fileSave(f, "resources/upload/product/");
				ProductFilesVO productFilesVO = new ProductFilesVO();
				productFilesVO.setProductNum(productVO.getProductNum());
				productFilesVO.setFileName(fileName);
				productFilesVO.setOriName(f.getOriginalFilename());
				if (!productFilesVO.getOriName().equals("")) {
					result = productMapper.fileAdd(productFilesVO);
				} else {
					fileManager.remove("resources/upload/product/", fileName);
				}
			}
		}
		return result;
	}

	public ProductVO detail(ProductVO productVO) throws Exception {
		return productMapper.detail(productVO);
	}

	public int update(ProductVO productVO, MultipartFile[] files) throws Exception {
		int result = productMapper.update(productVO);
		if (files != null) {
			for (MultipartFile f : files) {
				if (f.isEmpty()) {
					continue;
				}
				String fileName = fileManager.fileSave(f, "resources/upload/product/");
				ProductFilesVO productFilesVO = new ProductFilesVO();
				productFilesVO.setProductNum(productVO.getProductNum());
				productFilesVO.setFileName(fileName);
				productFilesVO.setOriName(f.getOriginalFilename());
				if (!productFilesVO.getOriName().equals("")) {
					result = productMapper.fileAdd(productFilesVO);
				} else {
					fileManager.remove("resources/upload/product/", fileName);
				}
			}
		}
		return result;
	}
	
	public int delete(ProductVO productVO)throws Exception{
		int result = 0; 
		productVO = productMapper.detail(productVO);
		
		for(ProductFilesVO filesVO:productVO.getFilesVOs()) {
			result = productMapper.fileDelete(filesVO);
			if (result > 0) {
				fileManager.remove("/resources/upload/product/", filesVO.getFileName());
			}
		}
		result = productMapper.delete(productVO);
		return result;
	}

	public int fileDelete(ProductFilesVO productFilesVO) throws Exception {
		productFilesVO = productMapper.fileDetail(productFilesVO);
		int check = productMapper.fileDelete(productFilesVO);
		if (check > 0) {
			fileManager.remove("/resources/upload/product/", productFilesVO.getFileName());
		}
		return check;
	}

}
