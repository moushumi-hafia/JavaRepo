package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayResultServlet
 */
@WebServlet("/DisplayResultServlet")
public class DisplayResultServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Integer totalScore = (Integer) session.getAttribute("score");
		response.setContentType("text/html");
		out.print("<h1 style='align:center'>Test Completed</h1>");
		out.print("<h3 style='align:center'> Your score : " + totalScore + "</h3>");
	}
	
}
