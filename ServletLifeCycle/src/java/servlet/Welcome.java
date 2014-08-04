package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Welcome extends HttpServlet {

    private int count;//<-- variable to track number of requests.

    /*invoked only once for one object when a fresh request is made*/
    @Override
    public void init() throws ServletException {
        count = 0;
        System.out.println("Welcome servlet's init(), object created !");
    }

    /*invoked whenever a request is made*/
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count ++;
        System.out.println("Welcome servlet's service(), page requested!");
        resp.getWriter().printf("Welcome servlet's service(), page requested for %d time(s)", count);
        resp.getWriter().close();
    }

    /*invoked only once for one object when its no longer needed*/
    @Override
    public void destroy() {
        count = 0;
        System.out.println("Welcome servlet's destroy(), object will be destroyed !");
    }
}
