package com.onedays.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onedays.vo.PlanDto;

public class PlanDao {
	Connection conn = null;
	PreparedStatement  pstmt = null;
	
	public PlanDao() {
		
	}
	
	private static class Holder{
		
		static {System.out.println("holder class create"); }
		private static final PlanDao instance = new PlanDao();		
	}
	
	public static PlanDao getInstance() {
		return Holder.instance;
	}
	
	// 연결 
	public Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "planner";
		String pwd = "20200824";
			
		try {
			Class.forName(driver);
				
			conn = DriverManager.getConnection(url,uid,pwd);
				
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
			
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
		}
			
		return conn;
	}
		
	
	/*index 컨트롤러 목록조회하기 위한 서비스*/
	public List<PlanDto> searchDate(String id, String date) {
		System.out.println(id);
		System.out.println(date);
		
		ResultSet rs = null;
		
		List<PlanDto> li = new ArrayList<PlanDto>();
		String sql = "SELECT * FROM MYWORK WHERE ID=? AND PLANDATE LIKE ?";
		
		try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,date+"%");		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			PlanDto p_dto = new PlanDto();//
			p_dto.setId(rs.getString("id"));
			p_dto.setWork_start(rs.getString("work_start"));
			p_dto.setWork_end(rs.getInt("work_end"));
			p_dto.setPlanDate(rs.getString("planDate"));/*2020-01-02*/	
			li.add(p_dto);/*값을전부 넣어둠 li에*/
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				pstmt.close();
				conn.close();
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return li;/*li를 반환*/
	}
	
	/*정확한 날짜검색 insert 목록 용*/
	public List<PlanDto> searchDate_insert(String id, String date) {
		
		ResultSet rs = null;
		
		List<PlanDto> li = new ArrayList<PlanDto>();
		String sql = "SELECT * FROM MYWORK WHERE ID=? AND PLANDATE = ?";
		
		try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,date);		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			PlanDto p_dto = new PlanDto();//
			p_dto.setId(rs.getString("id"));
			p_dto.setWork_start(rs.getString("work_start"));
			p_dto.setWork_end(rs.getInt("work_end"));
			p_dto.setPlanDate(rs.getString("planDate"));/*2020-01-02*/	
			li.add(p_dto);/*값을전부 넣어둠 li에*/
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				pstmt.close();
				conn.close();
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return li;/*li를 반환*/
	}
	
	/*플랜삭제*/
	public void plan_del(String id, String ws, String we, String date) {
		String sql = "delete FROM MYWORK WHERE ID=? AND work_start =? AND work_end = ? AND planDate =?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,ws);
			pstmt.setString(3,we);	
			pstmt.setString(4,date);	
			pstmt.executeUpdate();
			
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try{
					pstmt.close();
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
	}
	
	
	/*플랜 완료처리*/
	public void plan_chk(String id,String ws, String we, String date) {
		String sql = "update MYWORK set work_end=? where ID=? AND work_start =? AND planDate =?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,2);
			pstmt.setString(2,id);
			pstmt.setString(3,ws);	
			pstmt.setString(4,date);	
			pstmt.executeUpdate();
			
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try{
					pstmt.close();
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
	}
	/*할일 작성*/
	public void plan_set(String id,String text,String date) {
		String sql = "insert into MyWork values(?,?,?,?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,text);
			pstmt.setInt(3,1);	
			pstmt.setString(4,date);	
			pstmt.executeUpdate();
			
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try{
					pstmt.close();
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		
	}
	
	public void plan_all_del(String id) {
	
	conn = getConnection();
	String sql = "delete from MYWORK where id = ?";
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.executeUpdate();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally {
		
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
			
			
	}
	
}
