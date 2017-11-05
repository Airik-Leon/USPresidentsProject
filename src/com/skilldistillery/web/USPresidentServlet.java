package com.skilldistillery.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skilldistillery.data.President;
import com.skilldistillery.data.PresidentDAO;
import com.skilldistillery.data.USPresidentDAOImpl;

@WebServlet("/USPresidentServlet")
public class USPresidentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PresidentDAO dao;
	private List<President> presList;

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		dao = new USPresidentDAOImpl(context);
		context.setAttribute("dao", dao);
	}

	public USPresidentServlet() {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		ServletContext context = getServletContext();
		PresidentDAO dao = (PresidentDAO) context.getAttribute("dao");		
		HttpSession session = req.getSession();
		presList = dao.getListPresidents();
		session.setAttribute("presList", presList);
		
		int termInt = 0;
		String term = req.getParameter("term");
		if(term != null) {
		termInt = Integer.parseInt(term);
		} 
		
		President pres = dao.getPresident(termInt);
		session.setAttribute("pres", pres);
		
		req.getRequestDispatcher("/index.jsp").forward(req, res);
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
