package com.javatest.ex_13_1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="board/confirmId")
	public String confirmId(HttpServletRequest httpServletRequest, Model model) {
		
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		
		return "board/confirmId";
	}
	
	@RequestMapping(value="board/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) { // RequestParam 어노테이션 사용해서 바로 가져오기
		
		model.addAttribute("id2",id);
		model.addAttribute("pw2",pw);
		
		return "board/checkId";
	}
	
//	@RequestMapping(value="board/join")
//	public String join(@RequestParam("id") String id, @RequestParam("pw") String pw, @RequestParam("name") String name, @RequestParam("email") String email, Model model) { // RequestParam 어노테이션 사용해서 바로 가져오기
//		
//		//model.addAttribute("id",id);
//		//model.addAttribute("pw",pw);
//		//model.addAttribute("name",name);
//		//model.addAttribute("email",email);
//		
//		Member member = new Member();
//		member.setId(id);
//		member.setPw(pw);
//		member.setName(name);
//		member.setEmail(email);
//		
//		model.addAttribute("memberInfo",member);
//		
//		return "board/join";
//	}
	
	@RequestMapping(value="board/join")
	public String joinData(Member member) {
		return "board/join";
	}
}
