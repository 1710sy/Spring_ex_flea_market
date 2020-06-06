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

import com.example.dao.comment_dao;
import com.example.dao.user_dao;
import com.example.domain.user;

@WebServlet("/add_comment")
@Controller()
public class add_comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public add_comment() {
        super();
       
    }

	@GetMapping("/add_comment")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int gid = Integer.valueOf(request.getParameter("goodsid"));
		String uid = request.getParameter("userid");
		String comment = request.getParameter("comment");	
		comment_dao.add(comment, uid, gid);
		user user;
		int maxc = comment_dao.finder(Integer.valueOf(gid));
		String [][] comments = new String[maxc][2];
		String [] owners = new String[maxc];
		if(maxc != 0)
			comments = comment_dao.find(Integer.valueOf(gid));
		request.getSession().setAttribute("maxc",maxc);
		request.getSession().setAttribute("comments",comments);
		for(int i=0;i<maxc;i++) {
			user = user_dao.find(comments[i][1]);
			owners[i] = user.getname();
		}
		request.getSession().setAttribute("owners",owners);
		
		
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}

	
	@PostMapping("/add_comment")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
