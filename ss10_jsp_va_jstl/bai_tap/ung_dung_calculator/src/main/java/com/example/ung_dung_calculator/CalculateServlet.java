package com.example.ung_dung_calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateServlet", value = "/calculate")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Float.parseFloat(request.getParameter("firstOpera"));
        float secondOperand = Float.parseFloat(request.getParameter("secondOpera"));
        char operator = request.getParameter("operator").charAt(0);
        double result = 0;
        if (!(secondOperand==0 && operator=='/')) {
            switch (operator) {
                case '+':
                    result = firstOperand + secondOperand;
                    break;
                case '-':
                    result = firstOperand - secondOperand;
                    break;
                case '*':
                    result = firstOperand * secondOperand;
                    break;
                case '/':
                    result = firstOperand / secondOperand;
                    break;
            }
        }

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result:</h1>");

        if (secondOperand == 0 && operator == '/') {
            writer.println("/by zero");
        } else {
            writer.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
        }

        writer.println("</html>");
    }
}
