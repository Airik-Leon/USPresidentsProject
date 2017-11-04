package com.skilldistillery.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skilldistillery.data.President;
import com.skilldistillery.data.PresidentDAO;
import com.skilldistillery.data.USPresidentDAOImpl;
public class USPresidentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PresidentDAO dao;
	
    @Override
	public void init() throws ServletException {
    	dao = new USPresidentDAOImpl();
	}

	public USPresidentServlet() {
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		President pres = (President) session.getAttribute("pres");
		if (pres == null) {
			pres = new President();
			session.setAttribute("pres", pres);
		}
		List<President> presList = dao.getListPresidents();
		req.setAttribute("presList", presList);
		req.getRequestDispatcher("/index.jsp").forward(req, res);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
