package gingi.junit4.Server;

import java.util.HashMap;
import java.util.Map;

public class DefaultController implements Controller {

	private Map<String, RequestHandler> requestHandlers = new HashMap<String, RequestHandler>();

	public RequestHandler getHandler(Request request) {
		// TODO Auto-generated method stub
		if (!this.requestHandlers.containsKey(request.getName())) {
			String message = "Cannot find handler for request name " + "[" + request.getName() + "]";
			throw new RuntimeException(message);
		}
		
		return this.requestHandlers.get(request.getName());
	}

	public void addHandler(Request request, RequestHandler requestHandler) {
		// TODO Auto-generated method stub
		if (this.requestHandlers.containsKey(request.getName())) {
			throw new RuntimeException(
					"A request handler has already been registered for request name ["
							+ request.getName() + "]");
		} else {
			this.requestHandlers.put(request.getName(), requestHandler);
		}

	}

	public Response processRequest(Request request) {
		// TODO Auto-generated method stub
		Response response;
		try {
			response = getHandler(request).process(request);
		} catch (Exception exception) {
			response = new ErrorResponse(request, exception);
		}
		return response;
	}

}
