package com.studentapp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class NumberGuessServlet extends HttpServlet {
    private int number = (int) (Math.random() * 100);

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String guess = req.getParameter("guess");
        if (guess != null) {
            int g = Integer.parseInt(guess);
            if (g == number) {
                out.println("<h2>🎉 Correct! The number was " + number + "</h2>");
                number = (int) (Math.random() * 100);
            } else if (g < number) {
                out.println("<h2>Too low! Try again.</h2>");
            } else {
                out.println("<h2>Too high! Try again.</h2>");
            }
        }
        out.println("<form>Guess: <input type='text' name='guess'><input type='submit'></form>");
    }
}

