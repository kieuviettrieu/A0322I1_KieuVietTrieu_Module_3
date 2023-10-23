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
        <c:if test="${check==1}">
            <form class="menu-search" method="post" action="/controller?action=search" >
                <input
                        name="name_search"
                        type="search"
                        placeholder="Search"
                        aria-label="Search"
                        value="${name_search}"
                        class="margin-15"
                />
                <input type="submit" value="Search">
            </form>
        </c:if>
        <c:if test="${check==0}">
            <form class="menu-search" method="post" action="/controller?action=search" >
                <input
                        name="name_search"
                        type="search"
                        placeholder="Search"
                        aria-label="Search"
                        class="margin-15"
                />
                <input type="submit" value="Search">
            </form>
        </c:if>
    </div>

    <div>
        <div id="body_left"></div>

        <div id="body_right">
            <a href="/controller?action=list">List</a>
            <br>
            <a href="/controller?action=create">Create</a>
            <br><br>
            <caption><h2>List Object</h2></caption>
            <c:if test="${list.size()>0}">
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Birthday</th>
                        <th>Gender</th>
                        <th>ID Card</th>
                        <th>Phone Number</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items='${requestScope["list"]}' var="customer">
                        <tr>
                            <td>${customer.getCustomer_id()}</td>
                            <td>${customer.getCustomer_name()}</td>
                            <td>${customer.getCustomer_birthday()}</td>
                            <td>${customer.isCustomer_gender()}</td>
                            <td>${customer.getCustomer_id_card()}</td>
                            <td>${customer.getCustomer_phone()}</td>
                            <td>${customer.getCustomer_email()}</td>
                            <td>${customer.getCustomer_address()}</td>
                            <td><a href="/controller?action=edit&id=${customer.getCustomer_id()}">edit</a></td>
                            <td><a href="/controller?action=delete&id=${customer.getCustomer_id()}">delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <c:if test="${list.size()==0}">
                <h4>Not found!</h4>
            </c:if>
        </div>
        <div id="bostom"></div>
    </div>
</div>
</body>
</html>
