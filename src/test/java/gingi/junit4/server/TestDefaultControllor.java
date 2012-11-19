package gingi.junit4.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import gingi.junit4.Server.DefaultController;
import gingi.junit4.Server.ErrorResponse;
import gingi.junit4.Server.Request;
import gingi.junit4.Server.RequestHandler;
import gingi.junit4.Server.Response;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestDefaultControllor {

	private DefaultController controller;
	private Request request;
	private RequestHandler handler;

	@Before
	public void instantiate() throws Exception {
		controller = new DefaultController();
		request = new SampleRequest();
		handler = new SampleHandler();
		controller.addHandler(request, handler);
	}

	@Test
	@Ignore(value = "Ignore")
	public void testMethod() {
		throw new RuntimeException("implement me");
	}

	@Test
	public void testAddHandler() {

		/*
		 * instance initalize Request request = new SampleRequest();
		 * RequestHandler handler = new SampleHandler();
		 * controller.addHandler(request, handler);
		 */
		RequestHandler handler2 = controller.getHandler(request);
		assertSame(
				"Handler we set in controller should be the same handler we get",
				handler2, handler);
	}

	@Test
	public void testProcessRequest() {

		/*
		 * instance init Request request = new SampleRequest(); RequestHandler
		 * handler = new SampleHandler(); controller.addHandler(request,
		 * handler);
		 */
		Response response = controller.processRequest(request);
		assertNotNull("Muset not return a null response", response);
		assertEquals("Response should be of type SampleResponse",
				SampleResponse.class, response.getClass());
		assertEquals("Response should be of type SampleResponse",
				new SampleResponse(), response);
	}

	@Test
	public void testPorcessRequestAnswersErrorResponse() {
		SampleRequest request = new SampleRequest("testError");
		SampleExceptionHandler handler = new SampleExceptionHandler();
		controller.addHandler(request, handler);
		Response response = controller.processRequest(request);
		assertNotNull("Must not return a null response", response);
		assertEquals(ErrorResponse.class, response.getClass());
	}

	@Test(expected = RuntimeException.class)
	public void testGetHandlerNotDefined() {
		SampleRequest request = new SampleRequest("testNotDefinded");
		// 　다음줄에서 RuntimeExceptiom을 발생시킬 것이다.
		controller.getHandler(request);
	}

	@Test(expected = RuntimeException.class)
	public void testAddRequestDuplicateName() {
		SampleRequest request = new SampleRequest();
		SampleHandler handler = new SampleHandler();

		// 　다음줄에서 RuntimeExceptiom을 발생시킬 것이다.
		controller.addHandler(request, handler);
	}
	
	//　test 건너뛰
	@Test(timeout = 130)
	@Ignore(value = "Ignore for now until new decide a decent time - limit")
	public void testProcessMultipleRequestsTimeout() {
		Request request;
		Response response = new SampleResponse();
		RequestHandler handler = new SampleHandler();
		for (int i = 0; i < 99999 ; i++) {
			request = new SampleRequest(String.valueOf(i));
			controller.addHandler(request, handler);
			response = controller.processRequest(request);
			assertNotNull(response);
			assertNotSame(ErrorResponse.class, response.getClass());
		}
	}

	private class SampleRequest implements Request {
		private static final String DEFAULT_NAME = "Test";
		private String name;

		public SampleRequest(String name) {
			this.name = name;
		}

		public SampleRequest() {
			this(DEFAULT_NAME);
		}

		public String getName() {
			// TODO Auto-generated method stub
			return this.name;
		}
	}

	private class SampleHandler implements RequestHandler {
		public Response process(Request request) throws Exception {
			return new SampleResponse();
		}
	}

	private class SampleResponse implements Response {
		private static final String NAME = "test";

		public String getName() {
			return NAME;
		}

		public boolean equals(Object object) {
			boolean result = false;
			if (object instanceof SampleResponse) {
				result = ((SampleResponse) object).getName().equals(getName());
			}
			return result;
		}
	}

	private class SampleExceptionHandler implements RequestHandler {

		public Response process(Request request) throws Exception {
			// TODO Auto-generated method stub
			return (Response) new Exception("error processing request");
		}

	}

}
