package com.skilldistillery.web;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
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

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		dao = new USPresidentDAOImpl(context);
		context.setAttribute("dao", dao);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletContext context = getServletContext();
		PresidentDAO dao = (PresidentDAO) context.getAttribute("dao");
		HttpSession session = req.getSession();
		// first time
		if (session.getAttribute("presList") == null) {
			session.setAttribute("count", new Integer(0));
			session.setAttribute("pres", new USPresidentDAOImpl(context));
			session.setAttribute("presList", new ArrayList<President>());

			session.setAttribute("presList", dao.getListPresidents());
			session.setAttribute("pres", dao.getListPresidents().get(0));
		}
		List<President> presList = (List<President>) session.getAttribute("presList");
		int count = (int) session.getAttribute("count");
		President pres = (President) session.getAttribute("pres");

		String searchBar = req.getParameter("searchBar");

		// Forward and backward buttons for photo carousel
		if (req.getParameter("forward") != null) {
			if (count == presList.size() - 1) {
				count = 0;
				session.setAttribute("count", count);
				pres = presList.get(count);
				session.setAttribute("pres", pres);
			} else {
				count++;
				session.setAttribute("count", count);
				pres = presList.get(count);
				session.setAttribute("pres", pres);
			}
		} else if (req.getParameter("back") != null) {
			if (count == 0) {
				count = presList.size() - 1;
				session.setAttribute("count", count);
				pres = presList.get(count);
				session.setAttribute("pres", pres);
			} else {
				count--;
				session.setAttribute("count", count);
				pres = presList.get(count);
				session.setAttribute("pres", pres);
			}
		}
		//
		// //Button functionality for retrieving party lists
		else if (req.getParameter("Democrat") != null) {
			presList = dao.getPresidentsByParty("Democrat");
			session.setAttribute("presList", presList);
			count = 0;
			session.setAttribute("count", count);
			pres = presList.get(count);
			session.setAttribute("pres", pres);
		} else if (req.getParameter("Republican") != null) {
			presList = dao.getPresidentsByParty("Republican");
			session.setAttribute("presList", presList);
			count = 0;
			session.setAttribute("count", count);
			pres = presList.get(count);
			session.setAttribute("pres", pres);
		} else if (req.getParameter("Democratic-Republican") != null) {
			presList = dao.getPresidentsByParty("Democratic-Republican");
			session.setAttribute("presList", presList);
			count = 0;
			session.setAttribute("count", count);
			pres = presList.get(count);
			session.setAttribute("pres", pres);
		} else if (req.getParameter("Federalist") != null) {
			presList = dao.getPresidentsByParty("Federalist");
			session.setAttribute("presList", presList);
			count = 0;
			session.setAttribute("count", count);
			pres = presList.get(count);
			session.setAttribute("pres", pres);
		} else if (req.getParameter("Whig") != null) {
			presList = dao.getPresidentsByParty("Whig");
			session.setAttribute("presList", presList);
			count = 0;
			session.setAttribute("count", count);
			pres = presList.get(count);
			session.setAttribute("pres", pres);
		} else if (req.getParameter("reset") != null) {
			presList = dao.getListPresidents();
			session.setAttribute("presList", presList);
			count = 0;
			session.setAttribute("count", count);
			pres = presList.get(count);
			session.setAttribute("pres", pres);
		}

//		 Retrieve the president selected from the dropdown menu
		 else if(req.getParameter("ListOfPresidents") != null) {
			 try {
				 presList = dao.getListPresidents();
				 int termInt = Integer.parseInt(req.getParameter("ListOfPresidents"));
				 if (termInt >= 1 && termInt <= presList.size()) {
					termInt--;
					count = termInt;
					pres = presList.get(count);
					session.setAttribute("pres", pres);
				    session.setAttribute("count", count);
				    session.setAttribute("presList", presList);
				 }
				 else {
					 session.setAttribute("presList", presList);
					 return; 
				 }
			 }
			 catch(NumberFormatException nfe) {
			 }
		 }
		else {
			try {
				int termInt;
				if (searchBar != null) {
					termInt = Integer.parseInt(searchBar);
					if (termInt >= 1 && termInt <= presList.size()) {
						termInt--;
						count = termInt;
						pres = presList.get(count);
						session.setAttribute("pres", pres);
						session.setAttribute("count", count);
					} else {
						throw new NumberFormatException();
					}
				}
			} catch (NumberFormatException nfe) {
				switch (searchBar) {
				case "Democrat":
					presList = dao.getPresidentsByParty(searchBar);
					session.setAttribute("presList", presList);
					count = 0;
					session.setAttribute("count", count);
					pres = presList.get(count);
					session.setAttribute("pres", pres);
					break;
				case "Republican":
					presList = dao.getPresidentsByParty(searchBar);
					session.setAttribute("presList", presList);
					count = 0;
					session.setAttribute("count", count);
					pres = presList.get(count);
					session.setAttribute("pres", pres);
					break;
				case "Democratic-Republican":
					presList = dao.getPresidentsByParty(searchBar);
					session.setAttribute("presList", presList);
					count = 0;
					session.setAttribute("count", count);
					pres = presList.get(count);
					session.setAttribute("pres", pres);
					break;
				case "Federalist":
					presList = dao.getPresidentsByParty(searchBar);
					session.setAttribute("presList", presList);
					count = 0;
					session.setAttribute("count", count);
					pres = presList.get(count);
					session.setAttribute("pres", pres);
					break;
				case "Independent":
					presList = dao.getPresidentsByParty(searchBar);
					session.setAttribute("presList", presList);
					count = 0;
					session.setAttribute("count", count);
					pres = presList.get(count);
					session.setAttribute("pres", pres);
					break;
				case "Whig":
					presList = dao.getPresidentsByParty(searchBar);
					session.setAttribute("presList", pres);
					count = 0;
					session.setAttribute("count", count);
					pres = presList.get(count);
					session.setAttribute("pres", pres);
					break;
				default:
					presList = dao.getListPresidents();
					session.setAttribute("presList", presList);
					count = 0;
					session.setAttribute("count", count);
					pres = presList.get(count);
					session.setAttribute("pres", pres);
				}
			}
		}
		req.getRequestDispatcher("/index.jsp").forward(req, res);
	}

}
