package sampleproject2.action;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import sampleproject2.dto.SampleDTO;

public class SampleActionTest {

	@Test
	public void testCheckNormal() {
		SampleAction action = new SampleAction();
		HttpServletRequest request = createMock(HttpServletRequest.class);

		expect(request.getParameter("FirstName")).andReturn("firstName");
		expect(request.getParameter("LastName")).andReturn("lastName");

		replay(request);
		boolean result = action.checkParameter(request);
		verify(request);

		assertEquals(result, true);
	}

	@Test
	public void testCheckError1() {
		SampleAction action = new SampleAction();
		HttpServletRequest request = createMock(HttpServletRequest.class);

		expect(request.getParameter("FirstName")).andReturn(null);

		replay(request);
		boolean result = action.checkParameter(request);
		verify(request);

		assertEquals(result, false);
	}

	@Test
	public void testCheckError2() {
		HttpServletRequest request = createMock(HttpServletRequest.class);
		SampleAction action = new SampleAction();

		expect(request.getParameter("FirstName")).andReturn("firstName");
		expect(request.getParameter("LastName")).andReturn(null);

		replay(request);
		boolean result = action.checkParameter(request);
		verify(request);

		assertEquals(result, false);
	}

	@Test
	public void testCheckError3() {
		SampleAction action = new SampleAction();
		HttpServletRequest request = createMock(HttpServletRequest.class);

		expect(request.getParameter("FirstName")).andReturn("");

		replay(request);
		boolean result = action.checkParameter(request);
		verify(request);

		assertEquals(result, false);
	}
	
	@Test
	public void testExecuteNormal() {
		SampleAction action = new SampleAction("firstName", "lastName");

		HttpServletRequest request = createMock(HttpServletRequest.class);
		HttpSession session = createMock(HttpSession.class);
		expect(request.getSession(true)).andReturn(session);
		replay(request);
		
		String result = action.execute(request);

		verify(request);
		assertTrue("./WEB-INF/result.jsp".equals(result));
	}
	
	@Test
	public void testMorningCreatedDTO() throws Exception {
		SampleAction action = new SampleAction("firstName", "lastName");
		action.factory = new CalendarFactory() {

			@Override
			Calendar newCalendar() {
				Calendar cal = Calendar.getInstance();
				cal.set(2013, 05, 07, 10, 0, 0);
				
				return cal;
			}
		};

		HttpServletRequest request = createMock(HttpServletRequest.class);
		HttpSession session = createMock(HttpSession.class);
		expect(request.getSession(true)).andReturn(session);
		
		SampleDTO expectedDTO = new SampleDTO("firstName", "lastName");
		expectedDTO.setMessage("Good morning");
		
		session.setAttribute(eq("dto"), eq(expectedDTO));
		replay(request);
		
		@SuppressWarnings("unused")
		String result = action.execute(request);

		verify(request);
	}

	@Test
	public void testNoonCreatedDTO() throws Exception {
		SampleAction action = new SampleAction("firstName", "lastName");
		action.factory = new CalendarFactory() {

			@Override
			Calendar newCalendar() {
				Calendar cal = Calendar.getInstance();
				cal.set(2013, 05, 07, 12, 0, 0);
				
				return cal;
			}
		};

		HttpServletRequest request = createMock(HttpServletRequest.class);
		HttpSession session = createMock(HttpSession.class);
		expect(request.getSession(true)).andReturn(session);
		
		SampleDTO expectedDTO = new SampleDTO("firstName", "lastName");
		expectedDTO.setMessage("Good afternoon");
		
		session.setAttribute(eq("dto"), eq(expectedDTO));
		replay(request);
		
		@SuppressWarnings("unused")
		String result = action.execute(request);

		verify(request);
	}

	@Test
	public void testAfternoonCreatedDTO() throws Exception {
		SampleAction action = new SampleAction("firstName", "lastName");
		action.factory = new CalendarFactory() {

			@Override
			Calendar newCalendar() {
				Calendar cal = Calendar.getInstance();
				cal.set(2013, 05, 07, 13, 0, 0);
				
				return cal;
			}
		};

		HttpServletRequest request = createMock(HttpServletRequest.class);
		HttpSession session = createMock(HttpSession.class);
		expect(request.getSession(true)).andReturn(session);
		
		SampleDTO expectedDTO = new SampleDTO("firstName", "lastName");
		expectedDTO.setMessage("Good afternoon");
		
		session.setAttribute(eq("dto"), eq(expectedDTO));
		replay(request);
		
		@SuppressWarnings("unused")
		String result = action.execute(request);

		verify(request);
	}

}
