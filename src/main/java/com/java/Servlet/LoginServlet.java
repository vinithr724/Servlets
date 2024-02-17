package com.java.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // You should validate the username and password here
        // For simplicity, we'll assume a hardcoded valid username and password
        if (username.equals("vinith") && password.equals("12345")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("Home.html");
        } else {
            response.sendRedirect("login.html");
        }
    }

    public static class LogoutServlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect("login.html");
        }
    }
}
