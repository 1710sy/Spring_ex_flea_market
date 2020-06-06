package com.example.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.*;

import com.example.domain.user;
import com.example.util.Conn;
public class user_dao {
	private static Connection con =null;
	private static ResultSet rs = null;
	private static PreparedStatement pstmt =null;
	
	public static String getMD5String(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }

	public static  user find(String ID) {
        try{
        	user user = null;
        	Conn conn = new Conn();
			con = conn.getCon();
			pstmt = con.prepareStatement("select * from t_user where ID=?");
			pstmt.setString(1,ID);
			rs = pstmt.executeQuery();  
		
			if (rs.next()) {
				user = new user();
				user.setID(rs.getString(1));
				user.setpassword(rs.getString(2));
				user.setname(rs.getString(3));
				user.setis_adm(rs.getInt(4));
			}
			
			if(rs != null)
				rs.close(); 
				if(pstmt != null)
				pstmt.close();
				if(con != null)
	            con.close();
            return user;
        
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int add(String ID,String pwd,String username,int is_adm)
	{
    	int flag = 0;
		try
		{
			user user = null;
			user = find(ID);
				if(user != null){
					flag = 1;
				}else {
			Conn conn = new Conn();
			con = conn.getCon();
			pstmt = con.prepareStatement("insert into t_user values(?,?,?,?)"); 
			pstmt.setString(1, ID);
			pstmt.setString(2, pwd);
			pstmt.setString(3, username);
			pstmt.setInt(4, is_adm);
			pstmt.executeUpdate();
		
			if(rs != null)
				rs.close(); 
				if(pstmt != null)
				pstmt.close();
				if(con != null)
	            con.close();
				}
				return flag;
		}catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
}
