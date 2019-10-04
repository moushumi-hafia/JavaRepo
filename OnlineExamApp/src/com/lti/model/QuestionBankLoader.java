package com.lti.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankLoader {

	public static List<Question> loadQuestionsOnJava(){
		
		QuestionBank qb = new QuestionBank();
		
		Subject s = new Subject();
		s.setName("Java");
		
		//add the subject in QuestionBank
		qb.addNewSubject(s);
		
		//question 0 in Java
		Question q = new Question();
		q.setQuestion("What is G1 in Java?");
		
		List<Option> ops = new ArrayList<Option>();
		ops.add(new Option("G1 is a Garbage Collector", true));
		ops.add(new Option("G1 is another name for Jeevan", false));
		ops.add(new Option("G1 is the name of a spy agency", false));
		ops.add(new Option("G1 is sequel of Ra.One", false));
		q.setOptions(ops);
		
		qb.addNewQuestion(s, q);
		
		//question 1 in Java
		q = new Question();
		q.setQuestion("What is JVM?");
		
		ops = new ArrayList<Option>();
		ops.add(new Option("Java Visual Machine", false));
		ops.add(new Option("Java Virtual Maching", false));
		ops.add(new Option("Java Virtual Machine", true));
		ops.add(new Option("Java Visual Maching", false));
		q.setOptions(ops);
		
		qb.addNewQuestion(s, q);
		
		//question 2 in Java
		q = new Question();
		q.setQuestion("When does method overloading is determined?");
		
		ops = new ArrayList<Option>();
		ops.add(new Option("At run time", false));
		ops.add(new Option("At compile time", true));
		ops.add(new Option("At coding time", false));
		ops.add(new Option("At execution time", false));
		q.setOptions(ops);
		
		qb.addNewQuestion(s, q);
		
		//question 3 in Java
		q = new Question();
		q.setQuestion("Method overriding is combination of inheritance and polymorphism?");
		
		ops = new ArrayList<Option>();
		ops.add(new Option("True", true));
		ops.add(new Option("False", false));
		q.setOptions(ops);
		
		qb.addNewQuestion(s, q);

		//question 4 in Java
		q = new Question();
		q.setQuestion("What is true about protected constructor?");
		
		ops = new ArrayList<Option>();
		ops.add(new Option("Protected constructor can be called directly", false));
		ops.add(new Option("Protected constructor can only be called using super()", true));
		ops.add(new Option("Protected constructor can be used outside package", false));
		ops.add(new Option("Protected constructor can be instantiated even if child is in a different package", false));
		q.setOptions(ops);
		
		qb.addNewQuestion(s, q);
		
		return qb.getQuestionsFor(s);
	}
}
