package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dao.comment_dao;
import com.example.dao.goods_dao;
import com.example.dao.user_dao;
import com.example.domain.goods;
import com.example.domain.user;

@WebServlet("/details")



@Controller
public class detial_servelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public detial_servelt() {
        super();
        // TODO Auto-generated constructor stub
    }

@GetMapping("/details")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("gid",  request.getParameter("gid")); //获取商品信息
		String gid =request.getParameter("goodsid");
		goods good;
		good = goods_dao.find(gid);
		String gowner;
		user user;
		int maxc = comment_dao.finder(Integer.valueOf(gid));
		String [][] comments = new String[maxc][2];
		String [] owners = new String[maxc];

		comments = comment_dao.find(Integer.valueOf(gid));
		gowner = user_dao.find(good.getOwner()).getname();
		request.getSession().setAttribute("gid",gid);
		request.getSession().setAttribute("gname",good.getGname());
		request.getSession().setAttribute("gprise",good.getGprise());
		request.getSession().setAttribute("gowner",gowner);
		request.getSession().setAttribute("maxc",maxc);
		for(int i=0;i<maxc;i++) {
			user = user_dao.find(comments[i][1]);
			owners[i] = user.getname();
		}
		request.getSession().setAttribute("comments",comments);
		request.getSession().setAttribute("owners",owners);
		
		
		
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
