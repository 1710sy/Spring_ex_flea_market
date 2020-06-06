package com.example.dao;

import java.sql.*;

import com.example.domain.goods;
import com.example.domain.user;
import com.example.util.Conn;


public class goods_dao {
private static Connection con;
private static PreparedStatement pstmt;
private static PreparedStatement pstmt1;
private static PreparedStatement pstmt2;
private static PreparedStatement pstmt3;
private static PreparedStatement pstmt4;
private static PreparedStatement pstmt5;
private static PreparedStatement pstmt6;
private static PreparedStatement pstmt7;
private static ResultSet rs;
private static ResultSet rs1;
private static ResultSet rs3;
private static ResultSet rs6;
private static ResultSet rs7;

public static int finder (String flag)
{
	try 
	{		
		Conn conn = new Conn();
		con = conn.getCon();
		
		int maxg =0;
		
		pstmt = con.prepareStatement("select * from goods where status=?");
		pstmt.setString(1,flag);
		rs = pstmt.executeQuery();
		rs.last();    //将rs的指标移动到最后一位
		maxg = rs.getRow();
		pstmt.close();
		rs.close();
        con.close();
        return maxg; 
	}
	catch (Exception e) 
	{
        throw new RuntimeException(e);
    }	
	 
	
}
public static int list_finder (String buyer)
{
	try 
	{		
		Conn conn = new Conn();
		con = conn.getCon();
		
		int maxg =0;
		
		pstmt7 = con.prepareStatement("select * from goods where buyer=?");
		pstmt7.setString(1,buyer);
		rs7 = pstmt7.executeQuery();
		rs7.last();    //将rs的指标移动到最后一位
		maxg = rs7.getRow();
		pstmt7.close();
		rs7.close();
        con.close();
        return maxg; 
	}
	catch (Exception e) 
	{
        throw new RuntimeException(e);
    }	
	 
	
}
public static String[][] findall(String flag)
{
	try 
	{
		
		Conn conn = new Conn();
		con = conn.getCon();
		
		int maxg =0;
		int i=0;
	
		
		pstmt1 = con.prepareStatement("select * from goods where status=?");
		pstmt1.setString(1, flag);
		maxg = finder(flag);
		String  [][]good = new String[maxg][5];
		rs1 = pstmt1.executeQuery();
							
		while(rs1.next()) 
		{		
			good[i][0]=rs1.getString(1);
			good[i][1]=rs1.getString(2);
			good[i][2]=rs1.getString(3);
			good[i][3]=rs1.getString(4);
			good[i][4]=rs1.getString(6);				
			i++;
		}
		
	
		rs.close();
		pstmt.close();
        con.close();		
		return good;
	}catch (Exception e) {
        throw new RuntimeException(e);
    }
			
}
public static String[][] shopping_list(String buyer)
{
	try 
	{
		
		Conn conn = new Conn();
		con = conn.getCon();
		
		int maxg =0;
		int i=0;
	
		
		pstmt6 = con.prepareStatement("select * from goods where  buyer =?");

		pstmt6.setString(1, buyer);	
		maxg = list_finder(buyer);
		String  [][]good = new String[maxg][5];
		rs6 = pstmt6.executeQuery();
			System.out.println(maxg);				
		while(rs6.next()) 
		{		
			good[i][0]=rs6.getString(1);
			good[i][1]=rs6.getString(2);
			good[i][2]=rs6.getString(3);
			good[i][3]=rs6.getString(4);
			good[i][4]=rs6.getString(6);				
			i++;
		}
		
	
		rs6.close();
		pstmt6.close();
        con.close();		
		return good;
	}catch (Exception e) {
        throw new RuntimeException(e);
    }
			
}
public static goods find(String ID) {
    try{
    	goods good = null;
    	Conn conn = new Conn();
		con = conn.getCon();
		pstmt3 = con.prepareStatement("select * from goods where idgoods=?");
		pstmt3.setString(1,ID);
		rs3 = pstmt3.executeQuery();  
		if (rs3.next()) {
			good = new goods();
			good.setGid(rs3.getInt(1));
			good.setGname(rs3.getString(2));
			good.setGprise(rs3.getInt(3));
			good.setOwner(rs3.getString(4));
			good.setBuyer(rs3.getString(5));
				
		}
		
		if(rs3 != null)
			rs3.close(); 
			if(pstmt3 != null)
			pstmt3.close();
			if(con != null)
            con.close();
        return good;
    
    }catch (Exception e) {
        throw new RuntimeException(e);
    }
}
public static void add(goods que)
{
	try
	{
		Conn conn = new Conn();
		con = conn.getCon();
		pstmt2 = con.prepareStatement("insert into goods(g_name,g_prise,owner,status)values(?,?,?,0)"); 
		pstmt2.setString(1, que.getGname());
		pstmt2.setInt(2,que.getGprise());
		pstmt2.setString(3, que.getOwner());
		pstmt2.executeUpdate();
		pstmt2.close();
		//rs2.close();
        con.close();
	
	}catch (Exception e)
	{
        throw new RuntimeException(e);
    }
	
	
}
public static void buy(String gid , String uid )
{
	try
	{
		Conn conn = new Conn();
		con = conn.getCon();
		pstmt4 = con.prepareStatement("update goods set status=2,buyer=? WHERE idgoods=?"); 
		pstmt4.setString(1, uid);
		pstmt4.setString(2,gid);
		pstmt4.executeUpdate();
		pstmt4.close();
	
        con.close();
	
	}catch (Exception e)
	{
        throw new RuntimeException(e);
    }
	
	
}
public static void confirm(String gid )
{
	try
	{
		Conn conn = new Conn();
		con = conn.getCon();
		pstmt5 = con.prepareStatement("update goods set status=1 WHERE idgoods=?"); 
		
		pstmt5.setString(1,gid);
		pstmt5.executeUpdate();
		pstmt5.close();
	
        con.close();
	
	}catch (Exception e)
	{
        throw new RuntimeException(e);
    }
	
	
}


}
