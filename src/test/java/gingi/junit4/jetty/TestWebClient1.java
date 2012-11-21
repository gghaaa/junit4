package gingi.junit4.jetty;

import gingi.junit4.client.WebClient;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestWebClient1 {

	@BeforeClass
	public static void setUp() {
		TestWebClient1 client = new TestWebClient1();
		URL.setURLStreamHandlerFactory(client.new StubStreamHandlerFactory());
	}
	
	@Test
	public void testGetContentOk() throws Exception {
		WebClient client = new WebClient();
		String result = client.getContent(new URL("http://localhost:8090"));
		Assert.assertEquals("It works", result);
	}
	
	private class StubStreamHandlerFactory implements URLStreamHandlerFactory {

		public URLStreamHandler createURLStreamHandler(String protocol) {
			return new StubHttpURLStreamHandler();
		}
		
	}
	
	private class StubHttpURLStreamHandler extends URLStreamHandler {

		@Override
		protected URLConnection openConnection(URL url) throws IOException {
			return new StubHttpURLConnection(url) ;
		}
	}
}
