package com.thimodule3.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ControllerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {


    public void init()
    {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "list":
                    showList(request,response);
                    break;
                case "create":
                    showCreate(request,response);
                    break;
                case "edit":
                    showEdit(request,response);
                    break;
                case "delete":
                    showDelete(request,response);
                    break;

                default:
                    showList(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "edit":
                edit(request,response);
                break;
            case "create":
                create(request,response);
                break;
            case "search":
                try {
                    showSearch(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }


    private void showList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Object> list=new ArrayList<>();
        //tạo list

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/list.jsp");
        request.setAttribute("list", list);
        request.setAttribute("check",0);
        dispatcher.forward(request, response);

    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Object> list=new ArrayList<>();
        String search=request.getParameter("name_search");

//        Thực hiện tạo list truy vấn

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/list.jsp");
        request.setAttribute("name_search",search);
        request.setAttribute("list", list);
        request.setAttribute("check",1);
        dispatcher.forward(request, response);

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        request.setAttribute("result",1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create.jsp");
        dispatcher.forward(request, response);

    }


    private void showEdit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id=request.getParameter("id");
        //        truyền đối tượng cần edit vào
//        request.setAttribute();
        request.setAttribute("result", 1);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id=request.getParameter("id");
        //Xóa đối tượng

        showList(request,response);
    }






    private void edit(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
//        Customer customer = null;
        try {
            String customer_id = request.getParameter("customer_id");
            String customer_name = request.getParameter("customer_name");

            String birthday = request.getParameter("customer_birthday");
            Date customer_birthday = java.sql.Date.valueOf(birthday);

            boolean customer_gender = Boolean.parseBoolean(request.getParameter("customer_gender"));
            int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
            String customer_address = request.getParameter("customer_address");


//            impCustomerService.updateCustomer(customer);
            showList(request,response);

        } catch (SQLException throwables) {

//            request.setAttribute("customer", customer);
            request.setAttribute("result", 0);

            RequestDispatcher dispatcher = request.getRequestDispatcher("views/edit.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e)
        {
            request.setAttribute("result", 0);

            RequestDispatcher dispatcher = request.getRequestDispatcher("views/edit.jsp");
            dispatcher.forward(request, response);
        }
    }



    private void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
//        Customer customer = null;
        try {
            String customer_id = request.getParameter("customer_id");
            String customer_name = request.getParameter("customer_name");

            String birthday = request.getParameter("customer_birthday");
            Date customer_birthday = java.sql.Date.valueOf(birthday);

            boolean customer_gender = Boolean.parseBoolean(request.getParameter("customer_gender"));
            int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
            String customer_address = request.getParameter("customer_address");


//            impCustomerService.updateCustomer(customer);
            showList(request,response);

        } catch (SQLException throwables) {

            request.setAttribute("result", 0);

            RequestDispatcher dispatcher = request.getRequestDispatcher("views/create.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e)
        {
            request.setAttribute("result", 0);

            RequestDispatcher dispatcher = request.getRequestDispatcher("views/create.jsp");
            dispatcher.forward(request, response);
        }
    }


}
