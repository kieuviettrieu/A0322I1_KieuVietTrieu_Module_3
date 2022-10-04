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
            <a href="/furama?action=Contract">Go back</a>
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
                        <legend>Contract detail information</legend>
                        <table>
                            <tr>
                                <td>Contract ID: </td>
                                <td><input type="number" name="contract_id" id="contract_id"></td>
                            </tr>
                            <tr>
                                <td>Attach Service ID: </td>
                                <td><input type="number" name="attach_service_id" id="attach_service_id"></td>
                            </tr>
                            <tr>
                                <td>Quantity: </td>
                                <td><input type="number" name="quantity" id="quantity"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Create contract detail"></td>
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
