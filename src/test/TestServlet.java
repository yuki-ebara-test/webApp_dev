package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		System.out.println("Post");
		this.doProcess(request, response);
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get");
		this.doProcess(request, response);
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws java.io.IOException
	 */
	private void doProcess (HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

		ControllerFactory factory = ControllerFactory.createInstance();

		AbsController controller = factory.createController(request.getRequestURI());

		controller.processMain(getServletContext(), request, response, controller);

	}

}
