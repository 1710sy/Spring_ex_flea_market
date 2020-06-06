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
import com.example.domain.goods;

@WebServlet("/goods_add")
@Controller
public class goods_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public goods_add() {
        super();
        // TODO Auto-generated constructor stub
    }
@GetMapping("/goods_add")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gname = request.getParameter("gname");
		int gprise = Integer.valueOf(request.getParameter("gprise"));
		String ownername = (String) request.getSession().getAttribute("uid");
		goods good = new goods();
		good.setGname(gname);
		good.setGprise(gprise);
		good.setOwner(ownername);
		goods_dao.add(good);
		request.getSession().setAttribute("pid", gname);
		request.getRequestDispatcher("n_user.jsp").forward(request, response);
	
	}

@PostMapping("/goods_add")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
