package com.neighbor.spring_helloworld.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.neighbor.spring_helloworld.service.Service;

@Controller
public class ControllerHelloWorld {

	@Autowired
	Service service;
	
/* main페이지 이동*/
	@Autowired
	@RequestMapping("/main")
	public String main() {

		return "main";
	}
	
/* Login_session 페이로 이동*/
	@RequestMapping("/Login_session")
	public String Login_session() {

		return "Login_session";
	}
		
/* 로그인 화면으로 이동*/
	@RequestMapping("/login/LoginForm")
	public String LoginForm() {

		return "login/LoginForm";
	}
	
/* 로그인 가입화면 이동*/
	@RequestMapping("/login_join")
	public String Login_join() {

		return "/login_join";
	}

/* board 게시판 이동*/
	@RequestMapping("/BoardList")
	public String board_list(HttpServletRequest request, HttpServletResponse response, Model model) {

		model.addAttribute("request", request);
		service.boardlist(model);
		
		return "board/BoardList";
	}

/* board 글쓰기 화면 이동*/
	@RequestMapping("/board_write_form.do")
	public String board_write_form() {

		return "board_write_form";
	}
	
/* memberList화면 으로 이동*/
	@RequestMapping("/member_list")
	public String content_view(HttpServletRequest request, HttpServletResponse response, Model model) {

		model.addAttribute("request", request);
		service.memberlist(model);

		return "member_list";
	}

	@RequestMapping(value="access_denied_page")
	public String accessDeniedPage() throws Exception {
		return "/access/access_denied_page";
	}
	
/* 아이디 중복 체크*/
	@ResponseBody
	@RequestMapping(value = "/idChk", produces = "application/json; charset=UTF8", method = RequestMethod.POST)
	public int idChk(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
			System.out.println("idChk_controller=============");
			model.addAttribute("request", request);
			
			int cnt = service.login(model);	
			return cnt;
		}
		
/* Login_join 에서 mebmer 추가*/
		@RequestMapping(value="/proc_insert_member", method = RequestMethod.GET)
		public void get_proc_insert_member() throws Exception{
			
		}
	
		@RequestMapping(value="/proc_insert_member", method = RequestMethod.POST)
	/*	@RequestMapping("/proc_insert_member")*/
		public String proc_insert_member(HttpServletRequest request, HttpServletResponse response, Model model) {

			System.out.println("insert_controller : " + request.getParameter("id") + ", " + request.getParameter("pwd"));
			model.addAttribute("request", request);
			
			service.insert(model);
			
			return "/login_form";
		}

/* board_write_foem 에서 board게시글 추가*/
		@RequestMapping("/proc_insert_board.do")
		public String proc_insert_board(HttpServletRequest request, HttpServletResponse response, Model model) {

			System.out.println("insert_board_controller : " + request.getParameter("name") + ", " + request.getParameter("title") + ", " + request.getParameter("comment"));
			model.addAttribute("request", request);
			
			service.insert_board(model);
			
			return "redirect:/board_list.do";

		}

		
		@RequestMapping(value ="/Logout")
		public String logout(HttpSession session) {
			
			service.logout(session);
			return "redirect:/main.do";
		}
		
		@RequestMapping(value ="boardview", method = RequestMethod.GET)
		public String boardview(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("no") int no) {
		
			model.addAttribute("request", request);
			service.boardview(model);
			
			return "boardview";
		}
		
		@RequestMapping(value = "board_delete" ,method = RequestMethod.GET)
		public String board_delete(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("no") int no) {
			
		System.out.println("board_delete===========================================================>"+no);
		model.addAttribute("request", request);
		service.board_delete(model);
			
			return "board_delete";
		}
		
		
		@RequestMapping(value = "board_update" ,method = RequestMethod.GET)
		public String board_update(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("no") int no) {
			model.addAttribute("request", request);
			service.boardview(model);
			
			return "board_update";
		}
		
		@RequestMapping(value = "board_modify", method = RequestMethod.POST)
		public String board_modify(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("no") int no) {
			System.out.println("board_modify_controller : " + request.getParameter("title") + ", " + request.getParameter("comment"));
			System.out.println("board_modify_controller11111 : " + no);
			
			model.addAttribute("request", request);
			service.board_modify(model);
			
			return "redirect:/board_list.do";

		}
}
	