package test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {


	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, java.io.IOException {
		 System.out.println("start  1");

		//(2)ServletContextオブジェクトを取得します。
		ServletContext sc = getServletContext();
		//(3)RequestDispatcherオブジェクトを取得します。
		RequestDispatcher rd = sc.getRequestDispatcher("/result.html");
		//(4)forwardメソッドで、処理をExForward2Servletに転送します。
		rd.forward(request, response);
		 System.out.println("end  1");
    }


}
