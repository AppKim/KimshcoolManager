package com.kimschool.osirase.service;

import java.util.List;

import com.kimschool.osirase.vo.OsiraseVO;

public interface OsiraseService {

	public void save(OsiraseVO vo) throws Exception;

	public List<OsiraseVO> listAll();

	public OsiraseVO view(int idx);


}
