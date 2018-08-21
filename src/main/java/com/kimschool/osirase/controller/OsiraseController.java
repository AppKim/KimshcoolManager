package com.kimschool.osirase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kimschool.osirase.service.OsiraseService;
import com.kimschool.osirase.vo.OsiraseVO;

/**
*
* KSC1060のコントローラクラス
* @author kimjunseok
*
*/


@Controller
@RequestMapping("/osirase")
public class OsiraseController {

	@Autowired
	private OsiraseService orisaseService;

	static Logger logger = Logger.getLogger("OsiraseController.class");

	//お知らせ登録画面遷移処理
	@RequestMapping(value = "create")
	public String create() {

		return "WEB-INF/views/osirase/KSC106A";

	}

	//お知らせ登録処理
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public @ResponseBody Object save(@ModelAttribute OsiraseVO vo) {

		HashMap<String, Object> retVal = new HashMap<>();
		
		logger.info("お知らせ登録");
		try {
			//登録処理実行
			orisaseService.save(vo);
			//登録成功の場合
			retVal.put("code", "OK");
			retVal.put("message","登録しました。");
		} catch (Exception e) {
			//登録失敗の場合
			retVal.put("code", "FAIL");
			retVal.put("message", "失敗しました。");
			logger.warning("登録失敗");
		}

		return retVal;

	}

	//お知らせリスト
	@RequestMapping(value = "/list")
	public ModelAndView list() {

		ModelAndView mv = new ModelAndView();
		List<OsiraseVO> list = orisaseService.listAll();
		mv.setViewName("WEB-INF/views/osirase/KSC1060");
		mv.addObject("list", list);
		

		return mv;

	}
	//お知らせ詳細
	@RequestMapping(value = "/view")
	public ModelAndView view(@RequestParam int idx) {

		ModelAndView mv = new ModelAndView();
		OsiraseVO view = orisaseService.view(idx);
		mv.setViewName("WEB-INF/views/osirase/KSC106B");
		mv.addObject("view",view);

		return mv;
	}

}
