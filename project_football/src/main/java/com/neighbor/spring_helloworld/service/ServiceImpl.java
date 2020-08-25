package com.neighbor.spring_helloworld.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.neighbor.spring_helloworld.dao.Dao;

@Component
public class ServiceImpl implements Service {

	@Autowired
	private Dao dao;
	
	@Override
	public int login(Model model) {

		Map<String, Object> modelMap = (Map<String, Object>) model.asMap();
		HttpServletRequest request = (HttpServletRequest) modelMap.get("request");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		System.out.println("login_service : " + id + ", " + pwd);
		
		
	    return dao.login(id, pwd);

	
	
	}

	@Override
	public String insert(Model model) {
		
		Map<String, Object> modelMap = (Map<String, Object>) model.asMap();
		HttpServletRequest request = (HttpServletRequest) modelMap.get("request");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String grade = request.getParameter("grade");
		
		System.out.println("insert_service : " + id + ", " + pwd + ", " + name + ", " + email + ", " + grade );
		
		return dao.insert(id, pwd, name, email, grade);
	}

	
	@Override
	public void memberlist(Model model) {
		
		List<Map<String, Object>> list = dao.memberlist();
		model.addAttribute("userList", list);
		
	}

	@Override
	public void boardlist(Model model) {
		List<Map<String, Object>> list = dao.boardlist();
		model.addAttribute("boardList", list);
	}
	
	@Override
	public String insert_board(Model model) {
		Map<String, Object> modelMap = (Map<String, Object>) model.asMap();
		HttpServletRequest request = (HttpServletRequest) modelMap.get("request");
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String comment = request.getParameter("comment");
		
		System.out.println("insert_board_service : " + name + ", " + title+ ", " + comment);
		
		return dao.insert_board(name,title,comment);
	}

	@Override
	public String Login_session(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> modelMap = (Map<String, Object>) model.asMap();
		HttpServletRequest request = (HttpServletRequest) modelMap.get("request");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		return dao.Login_session(id,pwd);
	}



	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		dao.logout(session);
		session.invalidate();
		
	}

	@Override
	public void boardview(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> modelMap = (Map<String, Object>) model.asMap();
		HttpServletRequest request = (HttpServletRequest) modelMap.get("request");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		List<Map<String, Object>> list = dao.boardview(no);
		model.addAttribute("boardview", list);
	}

	@Override
	public void board_delete(Model model) {
		// TODO Auto-generated method stub
		System.out.println("11111111111111111111111111111");
		Map<String, Object> modelMap = (Map<String, Object>) model.asMap();
		HttpServletRequest request = (HttpServletRequest) modelMap.get("request");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		dao.board_delete(no);
		
	}

	@Override
	public String board_modify(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> modelMap = (Map<String, Object>) model.asMap();
		HttpServletRequest request = (HttpServletRequest) modelMap.get("request");
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String comment = request.getParameter("comment");
		
		return dao.board_modify(title,comment,no);
	}

		

}