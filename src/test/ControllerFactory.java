package test;

public class ControllerFactory {

	private static ControllerFactory factory;

	private ControllerFactory () {

	}

	/**
	 *
	 * @return
	 */
	public static ControllerFactory createInstance () {
		if (factory == null) factory = new ControllerFactory();
		return factory;
	}

	/**
	 *
	 * @param info
	 * @return
	 */
	public AbsController createController (String requestUrl) {

		System.out.println("★★★" + requestUrl);

		AbsController controller = null;

		if ("/webApp1/servlet/TestServlet".equals(requestUrl)) {

			controller = new UserInputController();

		} else {

			controller = new UserInputController();

		}

		return controller;
	}

}
