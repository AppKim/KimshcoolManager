package com.kimschool.sample.service;

import java.util.List;

import com.kimschool.vo.GuestBookVO;

public interface SampleService {
	  // 게시판 전체 정보를 검색한다.
	  public List<GuestBookVO> getList();
}
