package com.kimschool.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kimschool.login.service.LoginService;
import com.kimschool.login.vo.UserInfoVo;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/index")
	public String showLoginForm() {

		return "WEB-INF/views/login/KSC1080";
	}

	@RequestMapping("/searchIDForm")
	public String searchIDForm(
			Model model) {

		boolean isSearchIDFormFlg = true;
		model.addAttribute("isSearchIDFormFlg", isSearchIDFormFlg);

		return "WEB-INF/views/login/KSC108A";
	}

	@RequestMapping("/searchPWForm")
	public String searchPWForm(
			Model model) {

		boolean isSearchPWFormFlg = true;
		model.addAttribute("isSearchPWFormFlg", isSearchPWFormFlg);

		return "WEB-INF/views/login/KSC108B";
	}

	@RequestMapping("/insertUserForm")
	public String insertUserForm(
			Model model) {

		boolean isInsertUserFormFlg = true;
		model.addAttribute("isInsertUserFormFlg", isInsertUserFormFlg);

		return "WEB-INF/views/login/KSC1090";
	}

	@RequestMapping(value="/getUser", method=RequestMethod.POST)
	public String getUser(
			Model model,
			@RequestParam String userId,
			@RequestParam String password,
			@RequestParam String isSaveId ) {

		UserInfoVo userInfoVo = loginService.getUser(userId, password);
		boolean checkboxFlg = false;

		model.addAttribute("userInfoVo", userInfoVo);
		model.addAttribute("userId", userId);

		if(!isSaveId.equals("off")) {
			checkboxFlg = true;
		}
		model.addAttribute("checkboxFlg", checkboxFlg);

		return "WEB-INF/views/login/KSC1080";
	}

	@RequestMapping(value="/searchID", method=RequestMethod.GET)
	public String searchID(
			Model model,
			@RequestParam String email,
			@RequestParam String birthDate ) {

		List<UserInfoVo> userIdList = loginService.searchID(email, birthDate);
		boolean isSearchIDFormFlg = false;
		model.addAttribute("userIdList", userIdList);
		model.addAttribute("isSearchIDFormFlg", isSearchIDFormFlg);

		return "WEB-INF/views/login/KSC108A";
	}

	@RequestMapping(value="/searchPW", method=RequestMethod.GET)
	public String searchPW(
			Model model,
			@RequestParam String userId,
			@RequestParam String birthDate ) {

		UserInfoVo userInfoVo = loginService.searchPW(userId, birthDate);
		boolean isSearchPWFormFlg = false;
		model.addAttribute("userInfoVo", userInfoVo);
		model.addAttribute("isSearchPWFormFlg", isSearchPWFormFlg);

		return "WEB-INF/views/login/KSC108B";
	}

	@RequestMapping(value="/updatePW", method=RequestMethod.POST)
	public String updatePW(
			Model model,
			@RequestParam String password,
			@RequestParam String userId,
			@RequestParam String birthDate ) {

		boolean isSearchPWFormFlg = false;
		boolean updatePWFlg = loginService.updatePW(password, userId, birthDate);
		model.addAttribute("isSearchPWFormFlg", isSearchPWFormFlg);
		model.addAttribute("updatePWFlg", updatePWFlg);

		return "WEB-INF/views/login/KSC108B";
	}

	@RequestMapping(value="/insertUser", method=RequestMethod.POST)
	public String insertUser(
			Model model,
			@RequestParam String userId,
			@RequestParam String password,
			@RequestParam String lastname_kanji,
			@RequestParam String firstname_kanji,
			@RequestParam String lastname_hurigana,
			@RequestParam String firstname_hurigana,
			@RequestParam String sex,
			@RequestParam String year,
			@RequestParam String month,
			@RequestParam String day,
			@RequestParam String email,
			@RequestParam String kakaoId,
			@RequestParam String lineId,
			@RequestParam String address) {

		String nameKanji = lastname_kanji + firstname_kanji;
		String nameHurigana = lastname_hurigana + firstname_hurigana;
		String birthDate = new String();
		birthDate += year;
		birthDate += String.format("%02d", Integer.parseInt(month));
		birthDate += String.format("%02d", Integer.parseInt(day));
		boolean isUserIDFlg = false;
		boolean isInsertUserFormFlg = false;

		UserInfoVo userInfoVo = new UserInfoVo(
					userId, password, nameKanji,
					nameHurigana, sex, birthDate, email,
					kakaoId, lineId, address);

		isUserIDFlg = loginService.getUserID(userInfoVo.getUserId());

		if(isUserIDFlg) {
			isInsertUserFormFlg = true;
			model.addAttribute("isInsertUserFormFlg", isInsertUserFormFlg);
			model.addAttribute("isUserIDFlg", isUserIDFlg);

			return "WEB-INF/views/login/KSC1090";
		}

		loginService.insertUser(userInfoVo);

		return "WEB-INF/views/login/KSC1080";
	}

	@RequestMapping(value="/getUserID", method=RequestMethod.GET)
	public String getUserID(
			Model model,
			@RequestParam String userId ) {

			UserInfoVo userInfoVo = new UserInfoVo();
			boolean isUserIDFlg = false;
			boolean isInsertUserFormFlg = false;

			userInfoVo.setUserId(userId);
			isUserIDFlg = loginService.getUserID(userId);

			model.addAttribute("isUserIDFlg", isUserIDFlg);
			model.addAttribute("isInsertUserFormFlg", isInsertUserFormFlg);

			return "WEB-INF/views/login/KSC1090";
	}
}
