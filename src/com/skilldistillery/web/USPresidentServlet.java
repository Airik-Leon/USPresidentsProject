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
	private President pres;
	private int count=0;
	private int termInt=0;

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		dao = new USPresidentDAOImpl(context);
		presList = dao.getListPresidents();
		pres = presList.get(count);
		context.setAttribute("dao", dao);
	}

	public USPresidentServlet() {
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletContext context = getServletContext();
		PresidentDAO dao = (PresidentDAO) context.getAttribute("dao");		
		HttpSession session = req.getSession();
		
		session.setAttribute("presList", presList);
		String searchBar = req.getParameter("searchBar");
		
		if(req.getParameter("forward") != null) {
			forwardButton();
		}
		else if(req.getParameter("back") != null ) {
			backButton();
		}
		else if(req.getParameter("dem") != null) {
			count = 0;
			presList = dao.getPresidentsByParty("Democrat");
			pres = presList.get(count);
		}
		else if(req.getParameter("repub") != null){
			count = 0;
			presList = dao.getPresidentsByParty("Republican");
			pres = presList.get(count);
		}
		else if(req.getParameter("demRepub") != null){
			count = 0;
			presList = dao.getPresidentsByParty("Democratic-Republican");
			pres = presList.get(count);
		}
		else if(req.getParameter("fed")!= null) {
			count = 0;
			presList = dao.getPresidentsByParty("Federalist");
			pres = presList.get(count);
		}
		else if(req.getParameter("whig") !=null) {
			count = 0;
			presList = dao.getPresidentsByParty("Whig");
			pres = presList.get(count);
		}
		else if(req.getParameter("reset") != null) {
			count =0;  
			presList =  dao.getListPresidents(); 
			pres = presList.get(count);
		}
		else if(req.getParameter("ListOfPresidents") != null) {
			presList = dao.getListPresidents();
			termAndParty(req.getParameter("ListOfPresidents"));
		}
		else {
			termAndParty(searchBar);
		}
		session.setAttribute("pres", pres);
		req.setAttribute("count", count);
		req.setAttribute("presList", presList);
		req.getRequestDispatcher("/index.jsp").forward(req, res);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}
	private void forwardButton() {
		if(count == presList.size()-1) {
			count = 0; 
			pres = presList.get(count);
		}
		else {
			count++;
			pres = presList.get(count);			
		}
	}
	private void backButton() {
		if(count == 0) {
			count = presList.size()-1; 
			pres = presList.get(count);
		}
		else {
			count--;
			pres = presList.get(count);		
		}
	}
	private void termAndParty(String searchBar) {
		try {
			if(searchBar != null) {
				System.out.println(searchBar);
				termInt = Integer.parseInt(searchBar);
				if(termInt >= 0 &&  termInt <= presList.size()) {
					termInt--;
						count=termInt;
						pres = presList.get(count);				
				}
				else {
					throw new NumberFormatException();
				}
			} 	
		}
		catch(NumberFormatException nfe) {
			switch(searchBar) {
			case"Democrat": 
				presList=dao.getPresidentsByParty(searchBar);
				count= 0; 
				pres = presList.get(count);
				break;
			case"Republican":
				presList=dao.getPresidentsByParty(searchBar);
				count = 0; 
				pres = presList.get(count);
				break;
			case"Democratic-Republican":
				presList=dao.getPresidentsByParty(searchBar);
				count = 0;
				pres = presList.get(count);
				break;
			case"Federalist":
				presList=dao.getPresidentsByParty(searchBar);
				count = 0; 
				pres = presList.get(count);
				break;
			case"Independent":
				presList=dao.getPresidentsByParty(searchBar);
				count =0; 
				pres = presList.get(count);
				break;
			case "Whig":
				presList=dao.getPresidentsByParty(searchBar);
				count =0; 
				pres = presList.get(count);
				break;	
			 default:
				 presList= dao.getListPresidents();
				 count = 0; 
				 pres = presList.get(count);	
			}	
		}	
	}
}
