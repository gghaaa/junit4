package gingi.junit4.Server;

public interface Controller {
	Response processRequest (Request request);
	void addHandler (Request request, RequestHandler requestHandler);
}
