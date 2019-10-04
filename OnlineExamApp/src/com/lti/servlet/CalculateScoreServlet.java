package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.model.Option;
import com.lti.model.Question;

/**
 * Servlet implementation class CalculateScoreServlet
 */
@WebServlet("/CalculateScoreServlet")
public class CalculateScoreServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int optionNo = Integer.parseInt(request.getParameter("option"));
		
		HttpSession session = request.getSession();
		Question q = (Question)session.getAttribute("currentQs");
		Integer score = (Integer)session.getAttribute("score"); //storing score in session
		
		if(score == null){
			score = 0;
		}
		
		Option selectedOption = q.getOptions().get(optionNo);
		if(selectedOption.isRightAnswer())
		score++;
		
		session.setAttribute("score", score);
		
		response.sendRedirect("QuestionLoaderServlet");
 	}
}
