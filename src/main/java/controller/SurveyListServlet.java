package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

public class SurveyListServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String url = "/index.html";
		
		String action = req.getParameter("action");
		
		if (action == null) {
			action = "back";
		}
			
		if (action.equals("back")) {
			url = "/index.html";
		} else if (action.equals("submit")) {
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String email = req.getParameter("email");
			String dOB = req.getParameter("dOB");
			String hear = req.getParameter("hear");
			String checkBoxLike = req.getParameter("checkBoxLike");
			String checkBoxSend = req.getParameter("checkBoxSend");
			String contact = req.getParameter("contact");
			
			if (checkBoxLike == null) {
				checkBoxLike = "No check";
			} else {
				checkBoxLike = "Checked";
			}
			
			if (checkBoxSend == null) {
				checkBoxSend = "No check";
			} else {
				checkBoxSend = "Checked";
			}
			
			User user = new User(firstName, lastName, email, dOB, hear, checkBoxLike, checkBoxSend, contact);
			
			req.setAttribute("user", user);
			
			url = "/thanks.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
