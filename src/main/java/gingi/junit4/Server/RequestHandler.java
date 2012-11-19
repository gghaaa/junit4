package gingi.junit4.Server;

public interface RequestHandler {
	Response process(Request request) throws Exception;
}
