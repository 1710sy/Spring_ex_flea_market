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

import com.example.dao.user_dao;
import com.example.domain.user;

@WebServlet("/register")




@Controller
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

  @GetMapping("register")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.setCharacterEncoding("utf-8");
		String ID=request.getParameter("ID");
		String pwd=request.getParameter("pwd1");
		String name = request.getParameter("name");
		user U = new user();
		int flag =0;
			
			flag =user_dao.add(ID,user_dao.getMD5String(pwd),name,0);
			if(flag != 1) {
				request.getSession().setAttribute("err", "×¢²á³É¹¦£¡£¡");
			response.sendRedirect("login.jsp");

			}else {
				request.getSession().setAttribute("repeated", "1");
				response.sendRedirect("register.jsp");
				
			}
	}

	
	@PostMapping("/register")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		doGet(request, response);
	}

}
