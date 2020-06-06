package com.example.dao;

import java.sql.*;

import com.example.util.Conn;

public class comment_dao
{
	private static Connection con;
	private static PreparedStatement pstmt;
	private static PreparedStatement pstmt1;
	private static ResultSet rs1;
	private static PreparedStatement pstmt2;
	private static ResultSet rs2;
	
	public static void add(String comment,String cmo, int cmg)
	{
		try 
		{
			Conn conn = new Conn();
			con = conn.getCon();
			pstmt = con.prepareStatement("insert into comment (comment,commentOwner,commentGood)values(?,?,?)"); 
			pstmt.setString(1, comment);
			pstmt.setString(2, cmo);
			pstmt.setInt(3, cmg);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();		
			
		}catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	public static int finder (int cmg)
	{
		try 
		{		
			Conn conn = new Conn();
			con = conn.getCon();
			
			int maxc =0;
			
			pstmt1 = con.prepareStatement("select * from comment where commentGood=?");
			pstmt1.setInt(1,cmg);
			rs1 = pstmt1.executeQuery();
			rs1.last();    //将rs的指标移动到最后一位
			maxc = rs1.getRow();
			pstmt1.close();
			rs1.close();
	        con.close();
	        return maxc; 
		}
		catch (Exception e) 
		{
	        throw new RuntimeException(e);
	    }	
		 
		
	}
	public static String[][] find(int cmg)
	{
		try 
		{
			int maxc = finder(cmg);
			int i = 0;
			String [][] comment = new String[maxc][2];
			Conn conn = new Conn();
			con = conn.getCon();
			pstmt2 = con.prepareStatement("select * from comment where commentGood=?"); 
			pstmt2.setInt(1, cmg);
			rs2 = pstmt2.executeQuery();  
			while(rs2.next()) 
			{		
				comment[i][0]=rs2.getString(2);
				comment[i][1]=rs2.getString(3);
			
								
				i++;
			}
			if(rs2 != null)
				rs2.close(); 
				if(pstmt2 != null)
				pstmt2.close();
				if(con != null)
	            con.close();	
			return comment;
		}catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	
}
