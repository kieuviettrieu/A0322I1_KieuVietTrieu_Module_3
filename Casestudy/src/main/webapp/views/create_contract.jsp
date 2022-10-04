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
      <a href="/furama?action=create_contractdetail">Create Contract Detail</a>
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
            <legend>Contract information</legend>
            <table>
              <tr>
                <td>Start Date: </td>
                <td><input type="date" name="contract_start_date" id="contract_start_date"></td>
              </tr>
              <tr>
                <td>End Date: </td>
                <td><input type="date" name="contract_end_date" id="contract_end_date"></td>
              </tr>
              <tr>
                <td>Deposit: </td>
                <td><input type="number" name="contract_deposit" id="contract_deposit"></td>
              </tr>
              <tr>
                <td>Total Money: </td>
                <td><input type="number" name="contract_total_money" id="contract_total_money"></td>
              </tr>
              <tr>
                <td>Employee ID: </td>
                <td><input type="text" name="employee_id" class="employee_id"></td>
              </tr>
              <tr>
                <td>Customer ID: </td>
                <td><input type="text" name="customer_id" id="customer_id"></td>
              </tr>
              <tr>
                <td>Service ID: </td>
                <td><input type="number" name="service_id" class="service_id"></td>
              </tr>
              <tr>
                <td></td>
                <td><input type="submit" value="Create contract"></td>
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
