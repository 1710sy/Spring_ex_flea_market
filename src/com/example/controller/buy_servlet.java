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

@WebServlet("/buy_servlet")




@Controller()
public class buy_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public buy_servlet() {
        super();
       
    }

@GetMapping("/buy_servlet")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gid = request.getParameter("goodsid");
		String uid = request.getParameter("userid");
		goods_dao.buy(gid, uid);
		request.getRequestDispatcher("buy_succeed.jsp").forward(request, response);
	}

	
@PostMapping("/buy_servlet")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
