package com.neighbor.spring_helloworld.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;


@Component
public interface Service {

	public int login(Model model);

	public String insert(Model model);

	public void memberlist(Model model);
	
	public void boardlist(Model model);
	
	public String insert_board(Model model);

	public String Login_session(Model model);

	public void logout(HttpSession session);

	public void boardview(Model  model);

	public void board_delete(Model model);

	public String board_modify(Model model);


	
	

}
