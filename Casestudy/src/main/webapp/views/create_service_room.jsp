<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <a href="/furama?action=Service">Go back</a>
            <br><br>
            <c:if test="${result==0}">
                <h4 style="color: red">Unsuccessful!</h4>
            </c:if>

            <c:if test="${result==1}">
                <h4 style="color: blue">Successful!</h4>
            </c:if>
            <div>
                <form method="post">
                    <fieldset>
                        <legend>Create Service Room</legend>
                        <table>
                            <tr>
                                <td>ID: </td>
                                <td><input type="text" name="service_id" id="service_id" placeholder="DV-XXXX"></td>
                            </tr>
                            <tr>
                                <td>Name: </td>
                                <td><input type="text" name="service_name" id="service_name"></td>
                            </tr>
                            <tr>
                                <td>Area: </td>
                                <td><input type="number" name="service_area" id="service_area"></td>
                            </tr>
                            <tr>
                                <td>Cost: </td>
                                <td><input type="number" name="service_cost" id="service_cost"></td>
                            </tr>
                            <tr>
                                <td>Max People: </td>
                                <td><input type="number" name="service_max_people" class="service_max_people"></td>
                            </tr>
                            <tr>
                                <td>Rent Type ID: </td>
                                <td><input type="number" name="rent_type_id" id="rent_type_id"></td>
                            </tr>
                            <tr>
                                <td>Service Type ID: </td>
                                <td><input type="number" name="service_type_id" id="service_type_id" readonly value="3"></td>
                            </tr>
                            <tr>
                                <td>Service Free: </td>
                                <td><input type="text" name="service_free" class="service_free"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Create Room"></td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
        <div id="bostom"></div>
    </div>
</div>
</body>
</html>
