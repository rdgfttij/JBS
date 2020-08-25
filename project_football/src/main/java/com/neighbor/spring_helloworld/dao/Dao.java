package com.neighbor.spring_helloworld.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public interface Dao {
		
	// 조회
	public int login(String id, String pwd);
	
	public String insert(String id, String pwd, String name, String email, String grade);
	
	public List<Map<String, Object>> memberlist();
	
	public List<Map<String, Object>> boardlist();
	
	public String insert_board(String name, String title, String comment);

	public String Login_session(String id, String pwd);

	public void logout(HttpSession session);

	public List<Map<String, Object>> boardview(int no);

	public void board_delete(int no);

	public String board_modify(String title, String comment, int no);

	

}
