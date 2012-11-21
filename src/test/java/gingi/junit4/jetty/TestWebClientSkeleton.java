package gingi.junit4.jetty;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gingi.junit4.client.WebClient;

import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.ByteArrayISO8859Writer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestWebClientSkeleton {
	@Before
	public void setUp() {
		Server server = new Server();
		
		
	}

	@After
	public void tearDown() {

	}

	@Test
	public void testGetContentOk() throws Exception {
		WebClient client = new WebClient();
		String result = client.getContent(new URL("http://localhost:8090/"));
		Assert.assertEquals("It works", result);
	}

	private class TestGetContentOKHandler extends AbstractHandler {

		public void handle(String target, Request r,
				HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			// TODO Auto-generated method stub
			OutputStream out = response.getOutputStream();
			ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
			writer.write("It works");
			writer.flush();
			response.setIntHeader(HttpHeaders.CONTENT_LANGUAGE, writer.size());
			writer.writeTo(out);
			out.flush();

		}

	}
}
