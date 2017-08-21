package mirror;

import mirror.MirrorWebSocket;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "mirror.WebSocketMirrorServlet", urlPatterns = {"/chat"})
public class WebSocketMirrorServlet extends WebSocketServlet {
    private final static int LOGOUT_TIME = 10 * 60 * 1000;


    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(LOGOUT_TIME);
        factory.setCreator((req, resp) -> new MirrorWebSocket());
    }
}