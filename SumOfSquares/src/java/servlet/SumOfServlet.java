package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SumOfServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("num");//<-- <input name="num"/>
        resp.setContentType("text/html");//output type html
        PrintWriter pw = resp.getWriter();//get writer to give output to user
        try {
            int n = Integer.parseInt(str);
            int s = 0;
            for(int i = 1; n >= i; i ++) {
                s += i * i;
            }
            pw.printf("The sum of square of [%d] is [%d]<br/>", n, s);
        } catch (NumberFormatException ex) {
            pw.printf("Not a number: %s<br/>", str);
        } finally {
            pw.print("[<a href='index.html'>Back</a>]");
            pw.close();//output is complete
        }
    }
    
}
