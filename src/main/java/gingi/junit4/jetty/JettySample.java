package gingi.junit4.jetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class JettySample extends AbstractHandler {


	public static void main(String[] args) throws Exception {
		Server server = new Server(8090);
		//server.setHandler(new JettySample());
		server.start();
		server.join();
	}

	public void handle(String arg0, org.eclipse.jetty.server.Request baseRequest,
			HttpServletRequest arg2, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		response.getWriter().println("<h1>Hello World</h1>");
		// TODO Auto-generated method stub

	}
}
