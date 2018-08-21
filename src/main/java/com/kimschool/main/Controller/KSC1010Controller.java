package com.kimschool.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kimschool.main.Service.KSC1010Service;
import com.kimschool.main.vo.BoardInfoVo;

/**
 *
 * KSC1010のコントローラクラス
 * @author yun
 *
 */
@Controller
@RequestMapping("/kimschool")
public class KSC1010Controller {

	@Autowired
	private KSC1010Service ksc1010Service;


	@RequestMapping("/view")
	public String showMain(Model model) {

		List<BoardInfoVo> boardInfoVoList = ksc1010Service.getList();
		//List<ImageVo> imageVoList = ksc1010Service.getImgList();


		//model.addAttribute("imageDto", imageVoList);
		model.addAttribute("boardInfoVoList", boardInfoVoList);

		return "WEB-INF/views/main/KSC1010";
	}

}
