package com.example.login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
    description = "Login Servlet Testing",
    urlPatterns = { "/LoginServlet" },
    initParams = {
        @WebInitParam(name = "user", value = "Sindhu"),
        @WebInitParam(name = "password", value = "BridgeLabz@1")
    }
)
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get request parameters for user ID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        // Get servlet config init params
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Validate user name pattern (must start with capital letter)
        if (!user.matches("^[A-Z][a-zA-Z]{2,}$")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            out.println("<font color='red'>Name must start with a capital letter and have at least 3 letters.</font>");
            rd.include(request, response);
            return;
        }

        // Validate credentials
        if (userID.equals(user) && password.equals(pwd)) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            out.println("<font color='red'>Either username or password is wrong.</font>");
            rd.include(request, response);
        }
    }
}
