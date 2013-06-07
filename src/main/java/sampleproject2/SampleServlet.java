package sampleproject2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sampleproject2.action.SampleAction;

public class SampleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("Shift_JIS");
		
		String path = "./WEB-INF/error.jsp";
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("Shift_JIS");
		
		String path = "./WEB-INF/error.jsp";
		
		String actionName = req.getParameter("action");
		if (actionName != null) {
			SampleAction action = createAction(actionName);
			
			if (action != null) {
				if (action.checkParameter(req)) {
					path = action.execute(req);
				}
			}
		}
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
		requestDispatcher.forward(req, resp);
	}
	
	private SampleAction createAction(final String name) {
		if ("hello".equals(name)) {
			return new SampleAction();
		} else {
			return null;
		}
	}
	
	

}
