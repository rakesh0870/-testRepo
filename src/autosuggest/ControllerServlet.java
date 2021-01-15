package autosuggest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhoneBookDAO phoneBookDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		phoneBookDAO = new PhoneBookDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			autoSuggestPhoneNum(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void autoSuggestPhoneNum(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name = request.getParameter("name");
		List<String> names = phoneBookDAO.getAutoSuggestBooks(name);
		request.setAttribute("names", names);
		RequestDispatcher dispatcher = request.getRequestDispatcher("phoneBook.jsp");
		dispatcher.forward(request, response);
	}
}
