package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Simple Servlet that prints a "Hello World" message.
 * It is mapped to the URL pattern "/hello".
 */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set the content type to HTML
        response.setContentType("text/html");

        // Get the writer to output the response
        PrintWriter out = response.getWriter();

        // Write the HTML content
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>CI/CD Tomcat App</title>");
        out.println("<style>");
        out.println("  body { font-family: 'Arial', sans-serif; background-color: #f0f4f8; text-align: center; padding-top: 50px; }");
        out.println("  .container { background-color: #ffffff; padding: 40px; border-radius: 12px; box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1); display: inline-block; }");
        out.println("  h1 { color: #3b82f6; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Hello from Tomcat CI/CD Pipeline!</h1>");
        out.println("<p>This application was successfully packaged and deployed via Jenkins.</p>");
        out.println("<p>Current Timestamp: " + new java.util.Date() + "</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
