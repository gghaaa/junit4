package gingi.junit4.jetty;

import gingi.junit4.client.WebClient;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandler.Context;
import org.eclipse.jetty.util.ByteArrayISO8859Writer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestWebClient {

	@BeforeClass
	public static void setUp() throws Exception{
		Server server = new Server(8090);
		TestWebClient client = new TestWebClient();

		
		ContextHandler contextOKHandler = new ContextHandler(server, "/testGetContentOk");
		contextOKHandler.setHandler(client.new TestGetContentOKHandler());
		System.out.println(contextOKHandler.hashCode());
		
		
		ContextHandler contextNotFoundHandler = new ContextHandler(server, "/testGetContentNotFound");
		contextNotFoundHandler.setHandler(client.new TestgetContentNotFoundHandler());
		System.out.println(contextNotFoundHandler.hashCode());
		
		
		server.setStopAtShutdown(true);
		server.start();
		
	}
	
	@Test
	public void testGetContentOk() throws Exception {
		WebClient client = new WebClient();
		String result = client.getContent(new URL("http://localhost:8090/testGetContentOk"));
		Assert.assertEquals("It works", result);
	}
	
	@Test
	public void testGetContentNotFound() throws Exception {
		WebClient client = new WebClient();
		String result = client.getContent(new URL("http://localhost:8090/testGetContentNotFound"));
		Assert.assertNull(result);
	}
	
	@AfterClass
	public static void tearDown() {
		
	}
	
	private class TestGetContentOKHandler extends AbstractHandler {

		public void handle(String target, Request r,
				HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			OutputStream out = response.getOutputStream();
			ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
			writer.write("It works");
			writer.flush();
			response.setIntHeader(HttpHeaders.CONTENT_LANGUAGE, writer.size());
			writer.writeTo(out);
			out.flush();

		}

	}
	
	private class TestgetContentNotFoundHandler extends AbstractHandler {

		public void handle(String target, Request r, HttpServletRequest request,
				HttpServletResponse response) throws IOException, ServletException {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			
		}
		
	}
}
