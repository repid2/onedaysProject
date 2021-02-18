package com.onedays.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onedays.vo.MemberDto;


public class MemberDao {
	
	Connection conn = null;
	PreparedStatement  pstmt = null;
	
	private MemberDao() {};
	
	private static class Holder{
		static { System.out.println("holder class create"); }
		private static final MemberDao instance = new MemberDao();
		
	}
	
	public static MemberDao getInstance() {
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
	
	// 로그인
	public int login(String id, String pwd) {
		int result = 0;
		
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select id from members where id = ? and pwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	// 자동 로그인
	public String autoLogin(String id) {
		String str = "";
		
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select id, pwd from members where id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				str = rs.getString("id") + "/"+ rs.getString("pw");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return str;
	}
	
	// 아이디 찾기
	public String idSelect(String name, String str, int i) {
		String id = "";
		
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "select id from members where name = ? and ";
			if(i == 1) {
				sql += " email = ?";			
			}else {
				sql += " phone = ?";				
			}
			
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, str);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("id");
			}else {
				System.out.println("아이디가 검색되지 않았습니다.");
				id = "에러";
			}
			
			System.out.println("id : "+id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return id;
	}
	
	// 비밀번호 변경
	public String pwdSelect(String id ,String str , int i) {
		String user_id = "";
		
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "select id where id = ? and ";
			
			if(i == 1) {
				sql += " email = ?";
				
			}else {
				sql += " phone = ?";				
			}

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, str);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user_id=rs.getString("id");
			}else {
				System.out.println("아이디가 검색되지 않았습니다.");
				user_id = "에러";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return user_id;
	}
	
	// 아이디 중복 검사
	public int idChk(String id) {

		int result = 0;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select id from members where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				 result = 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	// 닉네임 중복 검사
	public int nickChk(String nick) {

			int result = 0;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				String sql = "select nickname from members where nickname = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, nick);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					 result = 1;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			return result;
		}
	
	// 이메일 중복 검사
	public int emailChk(String email) {

			int result = 0;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				String sql = "select email from members where email = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					 result = 1;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			return result;
		}
	
	// 전화번호 중복 검사
		public int phoneChk(String phone) {

			int result = 0;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				String sql = "select phone from members where phone = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, phone);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					 result = 1;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			return result;
		}
	
	// 정보
	public MemberDto memberInfo(String id){
		
		MemberDto dto = new MemberDto();
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select * from members where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs =  pstmt.executeQuery();
			
			while(rs.next()) {
				
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));
				dto.setAuth(rs.getInt("auth"));
				dto.setBirth_date(rs.getString("birth_date"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getInt("gender"));
				dto.setJoin_date(rs.getString("join_date"));
				dto.setPhone(rs.getString("phone"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return dto;
	}
	
	// 수정
	public int memberModify(MemberDto dto, String id) {
		int result = 0;
		
		try {
			conn= getConnection();
			String sql = "update members set pwd = ?, email= ?, phone=? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getPwd());
			pstmt.setString(2,dto.getEmail());
			pstmt.setString(3,dto.getPhone());
			pstmt.setString(4,dto.getId());
			result = pstmt.executeUpdate();
			/*
			System.out.println("1. "+dto.getPwd());
			System.out.println("2. "+dto.getEmail());
			System.out.println("3. "+dto.getPhone());
			System.out.println("4. "+dto.getId());
			
			System.out.println("쿼리 확인 : "+result);
			*/
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	
	// 추가
	public int memberInsert(MemberDto dto) {
		int result = 0;
		
		conn = getConnection();
		String sql = "insert into members values(?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getId());
			pstmt.setString(2,dto.getPwd());
			pstmt.setString(3,dto.getName());
			pstmt.setString(4,dto.getBirth_date());
			pstmt.setString(5,dto.getJoin_date());
			pstmt.setString(6,dto.getNickname());
			pstmt.setString(7,dto.getEmail());
			pstmt.setString(8,dto.getPhone());
			pstmt.setInt(9,dto.getGender());
			pstmt.setInt(10,dto.getAuth());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	// 삭제
	public int memberDelete(String id) {
		int result = 0;
		
		conn = getConnection();
		String sql = "delete from members where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
		
	
	
	
	
}
