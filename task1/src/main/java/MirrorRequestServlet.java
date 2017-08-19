import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by lb on 16.08.17.
 */
public class MirrorRequestServlet extends HttpServlet {
    private String login = "";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = null;

        Map<String, String[]> parameters  = request.getParameterMap();

        if (parameters.entrySet().iterator().hasNext()) {
            key = parameters.entrySet().iterator().next().getKey();
        }

        response.getWriter().println(key != null ? request.getParameter(key) : "");

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
