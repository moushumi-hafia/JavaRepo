package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.model.Option;
import com.lti.model.Question;
import com.lti.model.QuestionBankLoader;

/**
 * Servlet implementation class QuestionLoaderServlet
 */
@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {
	
	private List<Question> questions;
	private int noOfquestions;  //count of questions fetched
	private boolean check = true;

	
	/* loading the questions from the servlet using the "init()" method  -> servlet life cycle method
	   as the questions will be loaded by the loader only once in the servlet container */ 
	@Override
	public void init() throws ServletException {
		questions = QuestionBankLoader.loadQuestionsOnJava();
		noOfquestions = questions.size();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//creating session for each user (for storing the current question number of each user)
		HttpSession session = request.getSession();
		Integer questionNo = (Integer)session.getAttribute("qNo");
		PrintWriter out = response.getWriter();
		if(questionNo == null){
			questionNo = 0;
			check = true;
		}
		else{
			questionNo++;
			check = true;
		}
		if(questionNo >= noOfquestions){
			check = false;
			response.sendRedirect("DisplayResultServlet");
		}
		
		session.setAttribute("qNo", questionNo);
		
		if(check){
			
			Question q = questions.get(questionNo++);
			session.setAttribute("currentQs", q);
			
			response.setContentType("text/html");
			out.print("<form action = 'CalculateScoreServlet'>");
			out.print("<h3>Question  " + questionNo + "  of  " + noOfquestions + " : ");
			out.print(q.getQuestion() + "</h3>");
			int optionNo = 0;
			for(Option o: q.getOptions()){
				out.print("<h4><input type='radio' name='option' value='"+ (optionNo++) +"'>" + o.getOption() + "</input></h4>");
			}
			if(questionNo == (noOfquestions)){
				out.print("<button type= 'submit'> Submit Test </button>");
			}
			else{
				out.print("<button type= 'submit'> Continue </button>");
			}
			out.print("</form>");
		}
	}
}
