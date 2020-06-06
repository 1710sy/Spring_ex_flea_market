package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dao.goods_dao;
import com.example.dao.user_dao;
import com.example.domain.user;
@WebServlet("/print_goods")



@Controller()
public class print_goods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public print_goods() {
        super();
        // TODO Auto-generated constructor stub
    }

@GetMapping("/print_goods")	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int maxg = goods_dao.finder("1");
		String [][]goods = new String[maxg][5];
		String []unames = new String[maxg]; 
		goods = goods_dao.findall("1");
		user user;
		for(int i=0;i<maxg;i++) {
			user = user_dao.find(goods[i][3]);
			unames[i] = user.getname();
		}
		request.getSession().setAttribute("goods", goods);
		request.getSession().setAttribute("unames", unames);
		request.getSession().setAttribute("maxg", maxg);
		request.getSession().setAttribute("flag", 1);
		request.getRequestDispatcher("n_user.jsp").forward(request, response);
	}

@PostMapping("/print_goods")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
