package com.Casestudy.controller;

import com.Casestudy.model.Contract;
import com.Casestudy.model.ContractDetail;
import com.Casestudy.model.facitily.House;
import com.Casestudy.model.facitily.Room;
import com.Casestudy.model.facitily.Villa;
import com.Casestudy.model.person.Customer;
import com.Casestudy.model.person.Employee;
import com.Casestudy.repository.service.impl.ImpContractService;
import com.Casestudy.repository.service.impl.ImpCustomerService;
import com.Casestudy.repository.service.impl.ImpEmployeeService;
import com.Casestudy.repository.service.impl.ImpFacitilyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "FuramaServlet", value = "/furama")
public class FuramaServlet extends HttpServlet {
    private ImpCustomerService impCustomerService;
    private ImpEmployeeService impEmployeeService;
    private ImpContractService impContractService;
    private ImpFacitilyService impFacitilyService;

    public void init()
    {
        impCustomerService=new ImpCustomerService();
        impEmployeeService=new ImpEmployeeService();
        impContractService=new ImpContractService();
        impFacitilyService=new ImpFacitilyService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "Home":
                    showHome(request,response);
                    break;
                case "Employee":
                    listEmployeeForm(request, response);
                    break;
                case "create_employee":
                    showCreateEmployee(request,response);
                    break;
                case "edit_employee":
                    showEditEmployee(request,response);
                    break;
                case "delete_employee":
                    deleteEmployee(request,response);
                    break;




                case "Customer":
                    listCustomerForm(request, response);
                    break;
                case "create_customer":
                    showCreateCustomer(request,response);
                    break;
                case "edit_customer":
                    showEditCustomer(request,response);
                    break;
                case "delete_customer":
                    deleteCustomer(request,response);
                    break;



                case "Service":
                    showService(request,response);
                    break;
                case "create_villa":
                    showCreateVilla(request,response);
                    break;
                case "create_house":
                    showCreateHouse(request,response);
                    break;
                case "create_room":
                    showCreateRoom(request,response);
                    break;



                case "Contract":
                    showCreateContract(request,response);
                    break;
                case "create_contractdetail":
                    showCreateContractDetail(request,response);
                    break;

                case "List_Customer_Contract":
                    listCustomerContract(request,response);
                    break;
                default:
                    showHome(request,response);
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
                case "create_customer":
                    createCustomer(request,response);
                    break;
                case "create_employee":
                    createEmployee(request,response);
                    break;


                case "edit_employee":
                    editEmployee(request,response);
                    break;


                case "edit_customer":
                    editCustomer(request,response);
                    break;

                case "create_villa":
                    createVilla(request,response);
                    break;
                case "create_house":
                    createHouse(request,response);
                    break;
                case "create_room":
                    createRoom(request,response);
                    break;



                case "Contract":
                    createContract(request,response);
                    break;
                case "create_contractdetail":
                    createContractDetail(request,response);
                    break;
            }
    }


    private void listEmployeeForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Employee> list_employee=impEmployeeService.selectAllEmployee();

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/list_employee.jsp");
        request.setAttribute("list_employee", list_employee);
        dispatcher.forward(request, response);

    }

    private void listCustomerForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Customer> list_customer=impCustomerService.selectAllCustomer();

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/list_customer.jsp");
        request.setAttribute("list_customer", list_customer);
        dispatcher.forward(request, response);

    }

    private void listCustomerContract(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Customer> list_customer=impCustomerService.selectAllCustomerContract();

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/list_customer_contract.jsp");
        request.setAttribute("list_customer", list_customer);
        dispatcher.forward(request, response);

    }


    private void showCreateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_employee.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_customer.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String employee_id=request.getParameter("id");
        impEmployeeService.deleteEmployee(employee_id);

        listEmployeeForm(request,response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String customer_id=request.getParameter("id");
        impCustomerService.deleteCustomer(customer_id);

        listCustomerForm(request,response);
    }

    private void showCreateContract(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_contract.jsp");
        dispatcher.forward(request, response);

    }

    private void showCreateContractDetail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_contractdetail.jsp");
        dispatcher.forward(request, response);

    }

    private void showService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_service.jsp");
        dispatcher.forward(request, response);

    }

    private void showCreateVilla(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_service_villa.jsp");
        dispatcher.forward(request, response);

    }

    private void showCreateHouse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_service_house.jsp");
        dispatcher.forward(request, response);

    }

    private void showCreateRoom(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_service_room.jsp");
        dispatcher.forward(request, response);

    }

    private void showHome(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.jsp");
        dispatcher.forward(request, response);

    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {
            String customer_id=request.getParameter("customer_id");
            String customer_name=request.getParameter("customer_name");
            String birthday=request.getParameter("customer_birthday");
            Date customer_birthday= java.sql.Date.valueOf(birthday);
            boolean customer_gender= Boolean.parseBoolean(request.getParameter("customer_gender"));
            String customer_id_card=request.getParameter("customer_id_card");
            String customer_phone=request.getParameter("customer_phone");
            String customer_email=request.getParameter("customer_email");
            int customer_type_id= Integer.parseInt(request.getParameter("customer_type_id"));
            String customer_address=request.getParameter("customer_address");

            Customer customer=new Customer(customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,
                    customer_id_card,customer_phone,customer_email,customer_address);
            impCustomerService.insertCustomer(customer);
        } catch (SQLException throwables) {
            request.setAttribute("result",0);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_customer.jsp");
            dispatcher.forward(request, response);
            return;
        }

        request.setAttribute("result",1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_customer.jsp");
        dispatcher.forward(request, response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {
            String employee_id=request.getParameter("employee_id");
            String employee_name=request.getParameter("employee_name");
            String birthday=request.getParameter("employee_birthday");
            Date employee_birthday= java.sql.Date.valueOf(birthday);
            String employee_address=request.getParameter("employee_address");
            String employee_id_card=request.getParameter("employee_id_card");
            String employee_phone=request.getParameter("employee_phone");
            String employee_email=request.getParameter("employee_email");
            int education_degree_id= Integer.parseInt(request.getParameter("education_degree_id"));
            int position_id= Integer.parseInt(request.getParameter("position_id"));
            int division_id= Integer.parseInt(request.getParameter("division_id"));
            double employee_salary= Double.parseDouble(request.getParameter("employee_salary"));
            String username=request.getParameter("username");

            Employee employee=new Employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,
                    employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username);

            impEmployeeService.insertEmployee(employee);
        } catch (SQLException throwables) {
            request.setAttribute("result",0);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_employee.jsp");
            dispatcher.forward(request, response);
            return;
        }

        request.setAttribute("result",1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_employee.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String employee_id=request.getParameter("id");

        Employee employee=impEmployeeService.selectEmployee(employee_id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/edit_employee.jsp");
        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Employee employee=null;
        try {
            String employee_id=request.getParameter("employee_id");
            String employee_name=request.getParameter("employee_name");
            String birthday=request.getParameter("employee_birthday");
            Date employee_birthday= java.sql.Date.valueOf(birthday);
            String employee_address=request.getParameter("employee_address");
            String employee_id_card=request.getParameter("employee_id_card");
            String employee_phone=request.getParameter("employee_phone");
            String employee_email=request.getParameter("employee_email");
            int education_degree_id= Integer.parseInt(request.getParameter("education_degree_id"));
            int position_id= Integer.parseInt(request.getParameter("position_id"));
            int division_id= Integer.parseInt(request.getParameter("division_id"));
            double employee_salary= Double.parseDouble(request.getParameter("employee_salary"));
            String username=request.getParameter("username");

            employee=new Employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,
                    employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username);

            impEmployeeService.updateEmployee(employee);
            request.setAttribute("result",1);
            showEditEmployee(request,response);

        } catch (SQLException throwables) {

            request.setAttribute("employee",employee);
            request.setAttribute("result",0);

            RequestDispatcher dispatcher = request.getRequestDispatcher("views/edit_employee.jsp");
            dispatcher.forward(request, response);
            return;
        }

    }



    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String customer_id=request.getParameter("id");

        Customer customer=impCustomerService.selectCustomer(customer_id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/edit_customer.jsp");
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);
    }



    private void editCustomer(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Customer customer = null;
        try {
            String customer_id = request.getParameter("customer_id");
            String customer_name = request.getParameter("customer_name");
            String birthday = request.getParameter("customer_birthday");
            Date customer_birthday = java.sql.Date.valueOf(birthday);
            boolean customer_gender = Boolean.parseBoolean(request.getParameter("customer_gender"));
            String customer_id_card = request.getParameter("customer_id_card");
            String customer_phone = request.getParameter("customer_phone");
            String customer_email = request.getParameter("customer_email");
            int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
            String customer_address = request.getParameter("customer_address");

            customer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender,
                    customer_id_card, customer_phone, customer_email, customer_address);

            impCustomerService.updateCustomer(customer);
            request.setAttribute("result", 1);
            showEditCustomer(request, response);

        } catch (SQLException throwables) {

            request.setAttribute("customer", customer);
            request.setAttribute("result", 0);

            RequestDispatcher dispatcher = request.getRequestDispatcher("views/edit_customer.jsp");
            dispatcher.forward(request, response);
            return;
        }
    }

    private void createVilla(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {

            String service_id=request.getParameter("service_id");
            String service_name=request.getParameter("service_name");
            int service_area=Integer.parseInt(request.getParameter("service_area"));
            double service_cost=Double.parseDouble(request.getParameter("service_cost"));
            int service_max_people=Integer.parseInt(request.getParameter("service_max_people"));
            int rent_type_id=Integer.parseInt(request.getParameter("rent_type_id"));
            int service_type_id=Integer.parseInt(request.getParameter("service_type_id"));
            String standard_room=request.getParameter("standard_room");
            String description_other_convenience=request.getParameter("description_other_convenience");
            double pool_area=Double.parseDouble(request.getParameter("pool_area"));
            int number_of_floors=Integer.parseInt(request.getParameter("number_of_floors"));

            Villa villa=new Villa(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,
                    service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors);
            impFacitilyService.insertServiceVilla(villa);
        } catch (SQLException throwables) {
            request.setAttribute("result",0);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_service_villa.jsp");
            dispatcher.forward(request, response);
            return;
        }

        request.setAttribute("result",1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_service_villa.jsp");
        dispatcher.forward(request, response);
    }


    private void createHouse(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {

            String service_id=request.getParameter("service_id");
            String service_name=request.getParameter("service_name");
            int service_area=Integer.parseInt(request.getParameter("service_area"));
            double service_cost=Double.parseDouble(request.getParameter("service_cost"));
            int service_max_people=Integer.parseInt(request.getParameter("service_max_people"));
            int rent_type_id=Integer.parseInt(request.getParameter("rent_type_id"));
            int service_type_id=Integer.parseInt(request.getParameter("service_type_id"));
            String standard_room=request.getParameter("standard_room");
            String description_other_convenience=request.getParameter("description_other_convenience");
            int number_of_floors=Integer.parseInt(request.getParameter("number_of_floors"));

            House house=new House(service_id, service_name, service_area, service_cost, service_max_people,
                    rent_type_id, service_type_id, standard_room, description_other_convenience, number_of_floors);

            impFacitilyService.insertServiceHouse(house);
        } catch (SQLException throwables) {
            request.setAttribute("result",0);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_service_house.jsp");
            dispatcher.forward(request, response);
            return;
        }

        request.setAttribute("result",1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_service_house.jsp");
        dispatcher.forward(request, response);
    }

    private void createRoom(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {
            String service_id=request.getParameter("service_id");
            String service_name=request.getParameter("service_name");
            int service_area=Integer.parseInt(request.getParameter("service_area"));
            double service_cost=Double.parseDouble(request.getParameter("service_cost"));
            int service_max_people=Integer.parseInt(request.getParameter("service_max_people"));
            int rent_type_id=Integer.parseInt(request.getParameter("rent_type_id"));
            int service_type_id=Integer.parseInt(request.getParameter("service_type_id"));
            String service_free=request.getParameter("service_free");

            Room room=new Room(service_id, service_name, service_area, service_cost, service_max_people,
                    rent_type_id, service_type_id, service_free);

            impFacitilyService.insertServiceRoom(room);
        } catch (SQLException throwables) {
            request.setAttribute("result",0);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_service_room.jsp");
            dispatcher.forward(request, response);
            return;
        }

        request.setAttribute("result",1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_service_room.jsp");
        dispatcher.forward(request, response);
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {

            String dateST=request.getParameter("contract_start_date");
            Date contract_start_date=java.sql.Date.valueOf(dateST);
            String dateED=request.getParameter("contract_end_date");
            Date contract_end_date=java.sql.Date.valueOf(dateED);

            double contract_deposit=Double.parseDouble(request.getParameter("contract_deposit"));
            double contract_total_money=Double.parseDouble(request.getParameter("contract_total_money"));

            int employee_id=Integer.parseInt(request.getParameter("employee_id"));
            int customer_id=Integer.parseInt(request.getParameter("customer_id"));
            int service_id=Integer.parseInt(request.getParameter("service_id"));

            Contract contract=new Contract(contract_start_date, contract_end_date, contract_deposit,
             contract_total_money, employee_id, customer_id, service_id);

            impContractService.insertContract(contract);
        } catch (SQLException throwables) {
            request.setAttribute("result",0);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_contract.jsp");
            dispatcher.forward(request, response);
            return;
        }

        request.setAttribute("result",1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_contract.jsp");
        dispatcher.forward(request, response);
    }


    private void createContractDetail(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {
            int contract_id=Integer.parseInt(request.getParameter("contract_id"));
            int attach_service_id=Integer.parseInt(request.getParameter("attach_service_id"));
            int quantity=Integer.parseInt(request.getParameter("quantity"));

            ContractDetail contractDetail=new ContractDetail(contract_id,attach_service_id,quantity);
            impContractService.insertContractDetail(contractDetail);
        } catch (SQLException throwables) {
            request.setAttribute("result",0);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_contractdetail.jsp");
            dispatcher.forward(request, response);
            return;
        }

        request.setAttribute("result",1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create_contractdetail.jsp");
        dispatcher.forward(request, response);
    }
}
