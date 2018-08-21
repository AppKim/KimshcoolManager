package com.kimschool.main.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimschool.main.Dao.KSC1010Dao;
import com.kimschool.main.Service.KSC1010Service;
import com.kimschool.main.vo.BoardInfoVo;
import com.kimschool.main.vo.ImageVo;


@Service
public class KSC1010ServiceImpl implements KSC1010Service {

	@Autowired
	private KSC1010Dao ksc1010Dao;

	public List<BoardInfoVo> getList() {

		List<BoardInfoVo> boardInfoList = ksc1010Dao.getOshiraseList();

		return boardInfoList;
	}

	public List<ImageVo> getImgList(){

		List<ImageVo> imgList = ksc1010Dao.getImageList();

		return imgList;
	}
}
