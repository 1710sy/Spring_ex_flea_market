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
@WebServlet("/shopping_list")





@Controller()
public class shopping_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public shopping_list() {
        super();
        // TODO Auto-generated constructor stub
    }

@GetMapping("/shopping_list")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		user user;
		String uid = request.getParameter("uid");
		//System.out.println(uid);
		
		int maxg = goods_dao.list_finder(uid);
		//System.out.println(maxg);
		
		String[] unames = new String[maxg];
		String[] buyer = new String[maxg];
		String[][] goods = new String[maxg][5];
		goods = goods_dao.shopping_list(uid);
		
		for(int i=0;i<maxg;i++) {
			user = user_dao.find(goods[i][3]);
			unames[i] = user.getname();
			
		}
		for(int i=0;i<maxg;i++) {
			user = user_dao.find(goods[i][4]);
			buyer[i] = user.getname();
			
		}
		
		
		
		request.getSession().setAttribute("unames", unames);
		request.getSession().setAttribute("buyer", buyer);
		request.getSession().setAttribute("goods", goods);
		request.getSession().setAttribute("maxg", maxg);
		request.getSession().setAttribute("flag", "2");
		request.getRequestDispatcher("n_user.jsp").forward(request, response);
	}

@PostMapping("shopping_list")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
