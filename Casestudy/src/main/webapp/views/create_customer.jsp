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
            <a href="/furama?action=Customer">Return list customer</a>
            <br><br>
            <div>
                <c:if test="${result==0}">
                    <h4 style="color: red">Unsuccessful!</h4>
                </c:if>

                <c:if test="${result==1}">
                    <h4 style="color: blue">Successful!</h4>
                </c:if>
                <form method="post">
                    <fieldset>
                        <legend>Customer information</legend>
                        <table>
                            <tr>
                                <td>ID: </td>
                                <td><input type="text" name="customer_id" class="customer_id" placeholder="KH-XXXX"></td>
                            </tr>
                            <tr>
                                <td>Name: </td>
                                <td><input type="text" name="customer_name" id="customer_name"></td>
                            </tr>
                            <tr>
                                <td>Birthday: </td>
                                <td><input type="date" name="customer_birthday" id="customer_birthday"></td>
                            </tr>
                            <tr>
                                <td>Gender: </td>
                                <td>
                                    <select name="customer_gender">
                                        <option>Male</option>
                                        <option>Female</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>ID Card: </td>
                                <td><input type="number" name="customer_id_card" id="customer_id_card"></td>
                            </tr>
                            <tr>
                                <td>Phone number: </td>
                                <td><input type="text" name="customer_phone" id="customer_phone"></td>
                            </tr>
                            <tr>
                                <td>Email: </td>
                                <td><input type="text" name="customer_email" id="customer_email"></td>
                            </tr>
                            <tr>
                                <td>Customer Type ID: </td>
                                <td><input type="number" name="customer_type_id" id="customer_type_id"></td>
                            </tr>
                            <tr>
                                <td>Address: </td>
                                <td><input type="text" name="customer_address" id="customer_address"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Create customer"></td>
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
