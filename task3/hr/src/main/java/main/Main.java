package main;

import accounts.AccountService;
import dbService.DBService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;

/**
 * Created by lb on 17.08.17.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService();
        SignUpServlet signUpServlet = new SignUpServlet(accountService);
        SignInServlet signInServlet = new SignInServlet(accountService);

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(signUpServlet), "/signup");
        contextHandler.addServlet(new ServletHolder(signInServlet), "/signin");

        Server server = new Server(8088 );
        server.setHandler(contextHandler);
        server.start();
        System.out.println("Server started");
        server.join();
    }
}
