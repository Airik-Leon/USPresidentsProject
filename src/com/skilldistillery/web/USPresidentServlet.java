package com.skilldistillery.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skilldistillery.data.PresidentDAO;
import com.skilldistillery.data.USPresidentDAOImpl;

/**
 * Servlet implementation class USPresidentServlet
 */
//@WebServlet("/USPresidentServlet")
public class USPresidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PresidentDAO dao;
	
	

    @Override
	public void init() throws ServletException {
    	dao = new USPresidentDAOImpl();
	}

	public USPresidentServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
