package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import dbService.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lb on 17.08.17.
 */
public class SignInServlet extends HttpServlet {

    private final AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        response.setContentType("text/html;charset=utf-8");

        if (login == null || pass == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        UserProfile profile = null;
        try {
            profile = accountService.getUserByLogin(login);
        } catch (DBException e) {
            e.printStackTrace();
        }
        if (profile == null || !profile.getPassword().equals(pass)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Unauthorized");
            return;
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("Authorized: " + login);
    }
}
