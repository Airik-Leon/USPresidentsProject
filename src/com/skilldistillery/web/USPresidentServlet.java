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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletContext context = getServletContext();
		PresidentDAO dao = (PresidentDAO) context.getAttribute("dao");		
		HttpSession session = req.getSession();
		
		session.setAttribute("presList", presList);
		String searchBar = req.getParameter("searchBar");
		
		//Forward and backward buttons for photo carousel
		if(req.getParameter("forward") != null) {forwardButton();}
		else if(req.getParameter("back") != null ) { backButton();}
		
		//Button functionality for retrieving party lists
		else if(req.getParameter("Democrat") != null){termAndParty(req.getParameter("Democrat"));}
		else if(req.getParameter("Republican") != null){termAndParty(req.getParameter("Republican"));}
		else if(req.getParameter("Democratic-Republican") != null){termAndParty(req.getParameter("Democratic-Republican"));}
		else if(req.getParameter("Federalist")!= null) {termAndParty(req.getParameter("Federalist"));}
		else if(req.getParameter("Whig") !=null) {termAndParty(req.getParameter("Whig"));}
		else if(req.getParameter("reset") != null) {termAndParty(req.getParameter("reset"));}
		
		// Retrieve the president selected from the dropdown menu
		else if(req.getParameter("ListOfPresidents") != null) {
			presList = dao.getListPresidents();
			termAndParty(req.getParameter("ListOfPresidents"));
		}
		//If none of the above the search bar was used so see was typed in the search bar (termNumber,or party are viable inputs)
		else {
			termAndParty(searchBar);
		}
		
		//Sets a temporary president obj that is changed
		session.setAttribute("pres", pres);
		//counter used to keep track of which president the user is on
		req.setAttribute("count", count);
		//The temp arrayList used to store all of the Presidents changes when by party and all
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
