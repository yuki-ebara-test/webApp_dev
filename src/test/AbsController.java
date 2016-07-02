package test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbsController {

	/**
	 *
	 * @param request
	 * @param respons
	 */
	protected void processMain (ServletContext context, HttpServletRequest request, HttpServletResponse response, AbsController controller) {

		try {

			String fowardUrl = controller.process(createRequeestMap(request));

			RequestDispatcher requestDispatcher = context.getRequestDispatcher(fowardUrl);

			requestDispatcher.forward(request, response);

		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 *
	 */
	abstract protected String process (Map<String, Object> requeestMap);

	/**
	 *
	 * @param request
	 * @return
	 */
	private Map<String, Object> createRequeestMap (HttpServletRequest request) {

		return new HashMap<>();

	}

}
