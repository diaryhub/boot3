package com.study.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
				if(f!=null) {
				String fileName = fileManager.fileSave(f, "resources/upload/product/");
				ProductFilesVO productFilesVO = new ProductFilesVO();
				productFilesVO.setProductNum(productVO.getProductNum());
				productFilesVO.setFileName(fileName);
				productFilesVO.setOriName(f.getOriginalFilename());
				result = productMapper.fileAdd(productFilesVO);
				}
			}
		}
		return result;
	}
	
	public ProductVO detail(ProductVO productVO)throws Exception{
		return productMapper.detail(productVO);
	}

}
