<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>Rooms</title>
    <link rel="stylesheet" href="../css/home.css">
</head>
<body>
<div style="top: -8px; position: relative">
    <div id="header">
        <div>
            <img class="logo" src="http://static.ybox.vn/2020/9/2/1600775672450-icon_1024x1024.png">
        </div>
    </div>
    <div id="menu">
        <c:if test="${check==1}">
            <form class="menu-search" method="post" action="/controller?action=search" >
                <input
                        name="name_search"
                        type="search"
                        placeholder="Name"
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
                        placeholder="Name"
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
            <c:if test="${createIN==10}">
                <h4 >Create successful!</h4>
            </c:if>

            <c:if test="${createIN==20}">
                <h4 >Delete successful!</h4>
            </c:if>
            <c:if test="${editIN==10}">
                <h4 >Edit successful!</h4>
            </c:if>
            <a href="/controller?action=list">List Rooms</a>
            <br>
            <a href="/controller?action=create">Add new Rooms</a>
            <br><br>
            <caption><h2>List Rooms</h2></caption>
            <c:if test="${list.size()>0}">
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Name People</th>
                        <th>Phone Number</th>
                        <th>Date</th>
                        <th>Payment</th>
                        <th>Note</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items='${list}' var="rooms">
                        <tr>
                            <td>${rooms.roomID}</td>
                            <td>${rooms.namePeople}</td>
                            <td>${rooms.phoneNumber}</td>
                            <td>${rooms.firstDate}</td>
                            <td>${rooms.payment}</td>
                            <td>${rooms.note}</td>
                            <td><a href="/controller?action=delete&id=${rooms.roomID}">delete</a></td>
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
