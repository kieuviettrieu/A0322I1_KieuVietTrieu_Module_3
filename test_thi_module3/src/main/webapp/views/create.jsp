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
    </div>
    <div id="menu"></div>
    </div>

    <div>
        <div id="body_left"></div>

        <div id="body_right">
            <br><br>
            <div>
                <c:if test="${result==0}">
                    <h4 style="color: red">Unsuccessful!</h4>
                </c:if>

                <form method="post">
                    <fieldset>
                        <legend>Room information</legend>
                        <table>
                            <tr>
                                <td>Name People: </td>
                                <td><input type="text" name="namePeople" minlength="5" maxlength="50" required></td>
                            </tr>
                            <tr>
                                <td>Phone number: </td>
                                <td><input type="number" name="phoneNumber" minlength="10" maxlength="10" required></td>
                            </tr>
                            <tr>
                                <td>First Date: </td>
                                <td><input type="date" name="firstDate" required></td>
                            </tr>
                            <tr>
                                <td>Payment: </td>
                                <td>
                                    <select name="paymentID">
                                        <c:forEach items='${requestScope["listPayment"]}' var="payment">
                                            <option value="${payment.paymentID}">${payment.payment}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Note: </td>
                                <td><input type="text" name="note" minlength="1" maxlength="200" required></td>
                            </tr>
                            <tr>
                                <td><input type="submit" value="Create"></td>
                                <td><a href="/controller?action=list">Back to</a></td>
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
