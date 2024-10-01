package com.mycompany;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet("/suggest")
public class StudentSuggestionServlet extends HttpServlet {
    private final List<String> studentNames = Arrays.asList(
        "Alice", "Bob", "Charlie", "David", "Eve",
        "Frank", "Grace", "Heidi", "Ivy", "Judy"
    );

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getParameter("query").toLowerCase();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");

        // Find matching names
        List<String> suggestions = studentNames.stream()
            .filter(name -> name.toLowerCase().startsWith(query))
            .toList();

        out.println(suggestions);
    }
}
