package com.kimschool.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kimschool.sample.service.SampleService;
import com.kimschool.vo.GuestBookVO;

@Controller
@RequestMapping("/sample")
public class SampleController {

	  @Autowired
	  private SampleService sampleService;

	  @RequestMapping("/index")
	  public String index(Model model) {
	    List<GuestBookVO> list = sampleService.getList();
	    model.addAttribute("list", list);
	    return "WEB-INF/views/sample/index";
	  }
}
