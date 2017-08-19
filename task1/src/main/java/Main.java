import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


/**
 * Created by lb on 16.08.17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MirrorRequestServlet servlet = new MirrorRequestServlet();
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
        context.addServlet(new ServletHolder(servlet), "/mirror");

        server.start();
        System.out.println("Server started");
        server.join();
    }
}
