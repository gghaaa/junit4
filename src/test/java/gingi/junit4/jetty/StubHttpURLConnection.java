package gingi.junit4.jetty;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

public class StubHttpURLConnection extends URLConnection {

	private boolean isInput = true;
	
	protected StubHttpURLConnection(URL url) {
		super(url);
		// TODO Auto-generated constructor stub
	}
	
	public InputStream getInputStream() throws IOException {
		if (!isInput) {
			throw new ProtocolException("Cannot read from URLConnection" + " if doInput = false (call setDoInput(true))");
		}
		ByteArrayInputStream stream = new ByteArrayInputStream(new String("In works").getBytes());
		return stream;
	}
	
	@Override
	public void connect() throws IOException {
		// TODO Auto-generated method stub

	}
	
	public void disconnect() {
		
	}
	
	public boolean usingProxy() {
		return false;
	}

}
