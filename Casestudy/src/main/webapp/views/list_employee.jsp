<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/25/2022
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Furama resort</title>
    <link rel="stylesheet" href="../css/home.css">
</head>
<body>
<div style="top: -8px; position: relative">
    <div id="header">
        <div>
            <img class="logo" src="http://static.ybox.vn/2020/9/2/1600775672450-icon_1024x1024.png">
        </div>
        <div class="margin-left">
            <button>Login</button>
            <button>Register</button>
        </div>
    </div>
    <div id="menu">
        <ul>
            <li id="margin-left-145">
                <a href="/furama?action=Home">Home</a>
            </li>
            <li>
                <a href="/furama?action=Employee">Employee</a>
            </li>
            <li>
                <a href="/furama?action=Customer">Customer</a>
            </li>
            <li>
                <a href="/furama?action=Service">Service</a>
            </li>
            <li>
                <a href="/furama?action=Contract">Contract</a>
            </li>
            <form class="menu-search">
                <input
                        type="search"
                        placeholder="Search"
                        aria-label="Search"
                />
                <button>
                    Search
                </button>
            </form>
        </ul>
    </div>

    <div>
        <div id="body_left"></div>

        <div id="body_right">
            <a href="/furama?action=create_employee">Create Employee</a><br>
            <c:if test="${list_employee.size()>0}">
                <table border="1">
                    <caption><h2>List of Employee</h2></caption>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Birthday</th>
                        <th>Address</th>
                        <th>ID Card</th>
                        <th>Phone Number</th>
                        <th>Email</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items='${requestScope["list_employee"]}' var="employee">
                        <tr>
                            <td>${employee.getEmployee_id()}</td>
                            <td>${employee.getEmployee_name()}</td>
                            <td>${employee.getEmployee_birthday()}</td>
                            <td>${employee.getEmployee_address()}</td>
                            <td>${employee.getEmployee_id_card()}</td>
                            <td>${employee.getEmployee_phone()}</td>
                            <td>${employee.getEmployee_email()}</td>
                            <td><a href="/furama?action=edit_employee&id=${employee.getEmployee_id()}">edit</a></td>
                            <td><a href="/furama?action=delete_employee&id=${employee.getEmployee_id()}">delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <c:if test="${list_employee.size()==0}">
                <h4>Danh s??ch r???ng!</h4>
            </c:if>

        </div>
        <div id="bostom"></div>
    </div>
</div>
</body>
</html>
