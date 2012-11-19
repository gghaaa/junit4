package gingi.junit4.Server;

public class ErrorResponse implements Response {
	
	private Request origimalRequest;
	private Exception originalException;
	
	public ErrorResponse(Request request, Exception exception) {
		this.origimalRequest = request;
		this.originalException = exception;
	}

	public Request getOrigimalRequest() {
		return origimalRequest;
	}

	public Exception getOriginalException() {
		return originalException;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
