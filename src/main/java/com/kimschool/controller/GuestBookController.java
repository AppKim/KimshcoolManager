package com.kimschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kimschool.repository.GuestBookDAO;
import com.kimschool.vo.GuestBookVO;

@Controller
@RequestMapping("/main")
public class GuestBookController {
  @Autowired
  private GuestBookDAO GuestBookDAO;


  @RequestMapping("/index")
  public String index(Model model) {
    List<GuestBookVO> list = GuestBookDAO.getList();
    model.addAttribute("list", list);
    return "WEB-INF/views/index";
  }


  @RequestMapping("/deleteform")
  public String deleteform() {
    return "WEB-INF/views/deleteform";
  }


  @RequestMapping(value="/add", method=RequestMethod.POST)
  public String add(@ModelAttribute GuestBookVO vo) {
    GuestBookDAO.insert(vo);
    return "redirect:/main/index";
  }


  @RequestMapping(value="/delete", method=RequestMethod.POST)
  public String delete(
      @RequestParam Integer no,
      @RequestParam String pwd ) {
    String dbPwd = GuestBookDAO.getPwd(no);
    String parseInputPwd = GuestBookDAO.getInputPwd(pwd);

    if( dbPwd.equals(parseInputPwd)){
      GuestBookDAO.delete(no);
    }

    return "redirect:/main/index";
  }
}

