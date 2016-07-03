package web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbsController {

	private static final String REQUEST_BYTE_DECODE = "ISO_8859_1";

	private static final String REQUEST_CHAR_CODE = "UTF-8";

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
	abstract protected String process (Map<String, String> requeestMap);

	/**
	 *
	 * @param request
	 * @return
	 */
	private Map<String, String> createRequeestMap (HttpServletRequest request) {

		try {
			Map<String, String> map = new HashMap<>();

			Enumeration<String> paramNames = request.getParameterNames();

			while (paramNames.hasMoreElements()) {

				String paramName = paramNames.nextElement();

				map.put(paramName, new String(request.getParameter(paramName).getBytes(REQUEST_BYTE_DECODE), REQUEST_CHAR_CODE));

			}

			System.out.println(map);

			return map;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
