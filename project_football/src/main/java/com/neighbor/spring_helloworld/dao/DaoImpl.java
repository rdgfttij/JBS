package com.neighbor.spring_helloworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashMap;
//import java.util.Map;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class DaoImpl implements Dao {

	@Autowired
	private DataSource dataSource;
	// 조회
	public int login(String id, String pwd) {
	
				
		System.out.println("Login_DAO view : " + id + ", " + pwd);
		
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				int cnt = 0;
				
				try {
					conn = dataSource.getConnection();
					stmt = conn.createStatement();
					String sql1 = "select count(*) cnt from ex_user where id ="+"'"+id+"'"+"and "+"pwd ="+"'"+pwd+"'";
					System.out.println(sql1);
					rs = stmt.executeQuery(sql1);
									
					while(rs.next()) {
					cnt =  rs.getInt("cnt");
					System.out.println("cnt=============>"+cnt);
					}
					
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				return cnt;
	}

	@Override
	public String insert(String id, String name, String pwd, String email, String grade) {
		// TODO Auto-generated method stub
		
		System.out.println("insert_DAO view : " + id + ", " + pwd+ ", " + name+ ", " + email+ ", " + grade);
		

		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("insert into ex_user values(?, ?, ?, ?, ?, NOW(),'ROLE_USER','1')");
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pwd);
			pstmt.setString(4, email);
			pstmt.setString(5, grade);
			
			pstmt.executeUpdate();
			System.out.println(pstmt);
	
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		return null;
	}


	@Override
	public List<Map<String, Object>> memberlist() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			String sql1 = "select * from ex_user";
			
			rs = stmt.executeQuery(sql1);
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String regdt = rs.getString("regdt");
				map.put("id",id);
				map.put("name",name);
				map.put("pwd",pwd);
				map.put("email",email);
				map.put("regdt",regdt);
				
				list.add(map);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

/* 게시글 insert*/
	@Override
	public String insert_board(String name, String title, String comment) {
		System.out.println("insert_DAO view : " + name + ", " + title + ", " + comment);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("insert into football_board(name, title, comment, wdate) values(?, ?, ?, NOW())");
			
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, comment);
			
			pstmt.executeUpdate();
			System.out.println(pstmt);
	
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		return null;
	}

	@Override
	public String Login_session(String id, String pwd) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select id, pwd, name, email, grade from ex_user where id=? and pwd=?");
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();	
			if(rs.next()) {
				String name = rs.getString("name");
			}
		} catch (Exception e) {
		      e.printStackTrace();
	    } finally {
	      try {
	        if(rs != null)
	          rs.close();
	      } catch (Exception e2) {
	        e2.printStackTrace();
	      }
	    }
		
		return id;
		
	}

	@Override
	public List<Map<String, Object>> boardlist() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			String sql1 = "select no, name, title, comment, wdate,view_cnt from football_board";
			
			rs = stmt.executeQuery(sql1);
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				String no = rs.getString("no");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String comment = rs.getString("comment");
				String wdate = rs.getString("wdate");
				String view_cnt = rs.getString("view_cnt");
				map.put("no",no);
				map.put("name",name);
				map.put("title",title);
				map.put("comment",comment);
				map.put("wdate",wdate);
				map.put("view_cnt",view_cnt);
				
				list.add(map);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> boardview(int no) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println("DAO_boardview_no=============================================================>"+no);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			System.out.println("DAO_boardview_no3333333333333333333333333333333333333333333333333333333333333"+no);
			String sql1 = "select no, name, title, comment, wdate,view_cnt from football_board where no = "+"'"+no+"'";
			
			rs = stmt.executeQuery(sql1);
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
//				String no = rs.getString("no");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String comment = rs.getString("comment");
				String wdate = rs.getString("wdate");
				String view_cnt = rs.getString("view_cnt");
				map.put("no",no);
				map.put("name",name);
				map.put("title",title);
				map.put("comment",comment);
				map.put("wdate",wdate);
				map.put("view_cnt",view_cnt);
				
				list.add(map);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DAO_boardview_list==================44444444444444444444=================>"+list);
		return list;
	}

	@Override
	public void board_delete(int no) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("delete from football_board where no=?");
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			System.out.println(pstmt);
	
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
	}

	@Override
	public String board_modify(String title, String comment, int no) {
		// TODO Auto-generated method stub
System.out.println("board_modify_DAO view : " + title + ", " + comment);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("update football_board set title = ? , comment = ? where no = ?");
			
			pstmt.setString(1, title);
			pstmt.setString(2, comment);
			pstmt.setInt(3, no);
			
			pstmt.executeUpdate();
			System.out.println(pstmt);
	
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
		return null;
	}

}
