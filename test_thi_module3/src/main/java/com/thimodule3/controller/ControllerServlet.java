package com.thimodule3.controller;

import com.thimodule3.model.Payments;
import com.thimodule3.model.Rooms;
import com.thimodule3.service.impl.ImpRoomsInter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ControllerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {
    private ImpRoomsInter impRoomsInter;

    public void init()
    {
        impRoomsInter=new ImpRoomsInter();
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
        List<Rooms> list=impRoomsInter.selectAllRooms();

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/list.jsp");
        request.setAttribute("list", list);
        request.setAttribute("check",0);
        request.setAttribute("createIN",0);
        dispatcher.forward(request, response);
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String search=request.getParameter("name_search");

        List<Rooms> list=impRoomsInter.selectAllRoomsByName(search);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/list.jsp");
        request.setAttribute("name_search",search);
        request.setAttribute("list", list);
        request.setAttribute("check",1);
        dispatcher.forward(request, response);

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        request.setAttribute("result",1);
        List<Payments> listPayment=impRoomsInter.selectAllPayment();
        request.setAttribute("listPayment",listPayment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create.jsp");
        dispatcher.forward(request, response);
    }



    private void showDelete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        request.setAttribute("createIN",20);

        impRoomsInter.deleteRooms(id);

        List<Rooms> list=impRoomsInter.selectAllRooms();

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/list.jsp");
        request.setAttribute("list", list);
        request.setAttribute("check",0);
        dispatcher.forward(request, response);
    }





    private void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Rooms rooms=null;
        try {

            String namePeople = request.getParameter("namePeople").trim();
            String phoneNumber = request.getParameter("phoneNumber");

            String date= request.getParameter("firstDate");

            Date firstDate=java.sql.Date.valueOf(date);

            int paymentID = Integer.parseInt(request.getParameter("paymentID"));
            String note=request.getParameter("note");
            rooms=new Rooms(namePeople,phoneNumber,firstDate,paymentID,note);

            if(phoneNumber.length()!=10)
            {
                throw new Exception();
            }

            if(!(namePeople.length()>=5 && namePeople.length()<=50))
            {
                throw new Exception();
            }

            if(note.length()>200)
            {
                throw new Exception();
            }

            impRoomsInter.insertRooms(rooms);

            request.setAttribute("createIN",10);
            List<Rooms> list=impRoomsInter.selectAllRooms();

            RequestDispatcher dispatcher = request.getRequestDispatcher("views/list.jsp");
            request.setAttribute("list", list);
            request.setAttribute("check",0);
            dispatcher.forward(request, response);
        } catch (SQLException throwables) {

            request.setAttribute("result", 0);

            request.setAttribute("listPayment",impRoomsInter.selectAllPayment());
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/create.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e)
        {
            request.setAttribute("result", 0);
            request.setAttribute("listPayment",impRoomsInter.selectAllPayment());
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/create.jsp");
            dispatcher.forward(request, response);
        }
    }


}
