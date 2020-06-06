package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dao.goods_dao;
import com.example.dao.user_dao;
import com.example.domain.user;

@WebServlet("/confirm")



@Controller
public class confirm_goods extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public confirm_goods() {
        super();
       
    }
    @GetMapping("/confirm")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		user user;
		String gid =request.getParameter("goodsid");
		goods_dao.confirm(gid);
		int maxg = goods_dao.finder("0");
		
		String[] unames = new String[maxg];
		String[][] goods = new String[maxg][5];
		goods = goods_dao.findall("0");
		for(int i=0;i<maxg;i++) {
			user = user_dao.find(goods[i][3]);
			unames[i] = user.getname();
		}
		request.getSession().setAttribute("unames", unames);
		request.getSession().setAttribute("goods", goods);
		request.getSession().setAttribute("maxg", maxg);
		request.getSession().setAttribute("flag", "0");
		
	
	
	request.getRequestDispatcher("adm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @PostMapping("/confirm")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
