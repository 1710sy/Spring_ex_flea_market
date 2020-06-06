package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dao.user_dao;
import com.example.domain.user;

import java.sql.*;

//�������㣺����view���󣬲��ַ���Model����
@Controller
public class login_servlet extends HttpServlet {
@GetMapping("/login")	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//�����¼����
		
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("ID");
		String pwd=request.getParameter("pwd");
		int maxg = 0;
		user U = new user();
		
			U = user_dao.find(name);//Ȼ�����ｫ����Ķ������ù����ˡ�
			if(U !=null) {
				
				if(U.getpassword().equals(user_dao.getMD5String(pwd)) ) {
					if(U.getis_adm() == 1) {
						request.getSession().setAttribute("uname", U.getname());
						request.getSession().setAttribute("uid", name);
						request.getSession().setAttribute("maxg", maxg);
						request.getSession().setAttribute("flag", "9999");
						request.getRequestDispatcher("adm.jsp").forward(request, response);
				}
					else {
						request.getSession().setAttribute("uname", U.getname());
						request.getSession().setAttribute("uid", name);
						request.getSession().setAttribute("maxg", maxg);
						request.getSession().setAttribute("flag", "9999");
						request.getRequestDispatcher("n_user.jsp").forward(request, response);
					}
				}
				else {
					request.getSession().setAttribute("err", "���벻��ȷ����");
					response.sendRedirect("login.jsp");
				}
			}
			else {
				request.getSession().setAttribute("err", "�û��������ڣ���");
				response.sendRedirect("login.jsp");
			}
			
	}

@PostMapping("/login")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}