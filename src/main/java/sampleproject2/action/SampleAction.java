package sampleproject2.action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import sampleproject2.dto.SampleDTO;


/**
 * Action class for SampleServlet.
 */
public class SampleAction {
    /**
     * First name of the user.
     */
	private String firstName;
    /**
     * Last name of the user.
     */
	private String lastName;
	
    /**
     * Constructor of SampleAction.
     */
	public SampleAction() {
		this(null, null);
	}
	
	CalendarFactory factory = new CalendarFactory();
	
    /**
     * Constructor of SampleAction.
     * @param fstName first name of the user
     * @param lstName last name of the user
     */
	public SampleAction(String fstName, String lstName) {
		this.firstName = fstName;
		this.lastName = lstName;
	}
	
    /**
     * Check parameter of http servlet request.
     * @param request HttpServletRequest
     * @return check result
     */
	public final boolean checkParameter(final HttpServletRequest request) {
		firstName = request.getParameter("FirstName");
		if (firstName == null || firstName.equals("")) {
			return false;
		}
		
		lastName = request.getParameter("LastName");
		if (lastName == null || lastName.equals("")) {
			return false;
		}
		
		return true;
	}
	
    /**
     * Execute action.
     * @param request HttpServletRequest
     * @return result jsp file path
     */
	public final String execute(final HttpServletRequest request) {
		SampleDTO dto = new SampleDTO(firstName, lastName);
		
		// Select the greeting messsage according to the time
		Calendar cal = factory.newCalendar();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		
		if (hour < 12) {
			dto.setMessage("Good morning");
		} else {
			dto.setMessage("Good afternoon");
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("dto", dto);
		
		return "./WEB-INF/result.jsp";
	}
}
