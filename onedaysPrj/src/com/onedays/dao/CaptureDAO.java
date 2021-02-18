package com.onedays.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.onedays.vo.CaptureDTO;
import com.onedays.vo.PlanDto;

public class CaptureDAO {
	// �����ͺ��̽��� �����ϱ� ���� ����
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;
 
    // �����ͺ��̽��� Ŀ�ؼǵ��� ����ϵ��� �����ϴ� �޼ҵ�
    public void getCon() {
 
        try { // �����ͺ��̽��� �����Ҷ��� ����ó���� ���־���Ѵ�.
 
            Context initctx = new InitialContext(); // �ܺο��� �����͸� �о���� �ϱ� ������ Context ��ü ����
            // ��Ĺ ������ ������ ��Ƴ��� ������ �̵���
            Context envctx = (Context) initctx.lookup("java:comp/env"); // lookup�޼ҵ带 �̿��ؼ� �ڷḦ �о���� �ڵ�
            DataSource ds = (DataSource) envctx.lookup("jdbc/Onedays"); // datasource ��ü�� ���� , ������Ʈ Ÿ���̱� ������ Ÿ�Ժ�ȯ�� �Ѵ�.
 
            con = ds.getConnection(); // ������ �ҽ��� �������� Ŀ�ؼ��� ������
        } catch (Exception e) {
            e.printStackTrace(); // ����κ��� �߸��Ǿ����� �˷��ִ� ����ó��
        }
    }
 
    // �ϳ��� ���ο� �Խñ��� �Ѿ�ͼ� ����Ǵ� �޼ҵ�
    public int insertBoard(CaptureDTO bean) {
        getCon();
        int i= -1;
        try {
 
            //String datesql = "select TO_CHAR(SYSDATE, 'YYYY/MM/DD') from planner";
 
            // ������ �Խñ� ��ü���� ���̺� ����
            String sql = "insert into picture values(pic_sqc.NEXTVAL,1,?,?,?,?,?)"; // ?�� �ƴ϶� �������� �����
            pstmt = con.prepareStatement(sql); 
            System.out.println("test1");
            // �������� �̹� ���ִ°���
            pstmt.setString(1,bean.getId());
             pstmt.setString(2, bean.getPic_title());
             pstmt.setString(3, bean.getPic_content());
             pstmt.setDate(4, bean.getPic_date());
             pstmt.setString(5, bean.getPic_path());   
             
            // ������ �����Ͻÿ�.
            i=pstmt.executeUpdate();
            // �ڿ� �ݳ�
            con.close();
            return i;
            
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }
    
    
    //��� �Խñ��� �������ִ� �޼ҵ� �ۼ�
    public List<CaptureDTO> getAllBoard(String id)
    {
        //������ ��ü ����
        List<CaptureDTO> v = new ArrayList<CaptureDTO>();
        
        getCon();
        
        
        try {
            //���� �غ�
            String sql = "select * from picture where id=? order by pic_date "; //�Խ��� ���� ������������ �����ϱ� ���� sql�ڵ�
            //������ ������ ��ü ����
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,id);
            //���� ������ ��� ����
            rs = pstmt.executeQuery();
            //������ ������ ����� �𸣱⿡ �ݺ����� �̿��Ͽ� �����͸� ����
            while(rs.next()) 
            {
                //�����͸� ��Ű¡ ��Ű��(���� = Boardbean Ŭ������ �̿�) ��Ű�� �ȿ� �ִ´ٴ� �ǹ�
            	CaptureDTO bean = new CaptureDTO();
                bean.setPic_no(rs.getInt(1));
                bean.setBca_no(rs.getInt(2));
                bean.setId(rs.getString(3));
                bean.setPic_title(rs.getString(4));
                bean.setPic_content(rs.getString(5));
                bean.setPic_date(rs.getDate(6));
                bean.setPic_path(rs.getString(7));

                //��Ű¡�� �����͸� ���Ϳ� ����
                v.add(bean);
            }
            
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return v;
    }
    //�ϳ��� �Խñ��� �����ϴ� �޼ҵ�
    public CaptureDTO getOneBoard(Date date,String id) 
    {
        //����Ÿ�� ����(��ü ����)
    	CaptureDTO bean = new CaptureDTO();
        getCon();
        try {
            
            
            //���� �غ�
            String sql = "select * from picture where pic_date=? and id=?";
            //���� ���� ��ü
            pstmt = con.prepareStatement(sql);
            pstmt.setDate(1,date);
            pstmt.setString(2, id);
            //���� ������ ����� ����
            rs = pstmt.executeQuery();
            
            if(rs.next())
            {
                bean.setPic_no(rs.getInt(1));
                bean.setBca_no(rs.getInt(2));
                bean.setId(rs.getString(3));
                bean.setPic_title(rs.getString(4));
                bean.setPic_content(rs.getString(5));
                bean.setPic_date(rs.getDate(6));
                bean.setPic_path(rs.getString(7));
            }
            
            con.close();
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
 // �ϳ��� �Խñ��� �����ϴ� �޼ҵ�
    public void updateBoard(CaptureDTO bean) {
        getCon();
        System.out.println("query test:"+bean.getPic_content());
        try {
            // ���� �غ�
            String sql = "update picture set pic_title=?,pic_content=?,pic_path=? where pic_date=? and id=?";
            pstmt = con.prepareStatement(sql);
 
            // ?���� ����
            pstmt.setString(1, bean.getPic_title());
            pstmt.setString(2, bean.getPic_content());
            pstmt.setString(3, bean.getPic_path());
            pstmt.setDate(4, bean.getPic_date());
            pstmt.setString(5, bean.getId());
 
            pstmt.executeUpdate();
 
            con.close();// �ڿ��ݳ�
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
    // �ϳ��� �Խñ��� ���� �ϴ� �޼ҵ�
    public int deleteBoard(Date pic_date,String id) {
        getCon();
        int i=-1;
        try {
            // ���� �غ�
            String sql = "delete from picture where pic_date=? and id=?";
            pstmt = con.prepareStatement(sql);
 
            // ���� ������ ���� �ε����� ���� �־��ֱ�
            pstmt.setDate(1, pic_date);
            pstmt.setString(2, id);
            // ���� ����
            i=pstmt.executeUpdate();
            // �ڿ� �ݳ�
            con.close();
            return i;
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return i;
    }
    public String deletepic(Date pic_date,String id) 
    {
    	String i="";
        //����Ÿ�� ����(��ü ����)
    	CaptureDTO bean = new CaptureDTO();
        getCon();
        try {
            
            
            //���� �غ�
            String sql = "select pic_path from picture where pic_date=? and id=?";
            //���� ���� ��ü
            pstmt = con.prepareStatement(sql);
            pstmt.setDate(1,pic_date);
            pstmt.setString(2,id);
            //���� ������ ����� ����
            rs = pstmt.executeQuery();
            
            if(rs.next())
            {
               bean.setPic_path(rs.getString(1));
            }
            
            con.close();
            return i=bean.getPic_path();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return i;
    }
 
	
	
    
}
