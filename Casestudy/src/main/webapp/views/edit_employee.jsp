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
      <div>

        <a href="/furama?action=Employee">Return list employee</a>
        <br><br>
        <c:if test="${result==0}">
          <h4 style="color: red">Unsuccessful!</h4>
        </c:if>

        <c:if test="${result==1}">
          <h4 style="color: blue">Successful!</h4>
        </c:if>

        <form method="post">
          <fieldset>
            <legend>Edit employee</legend>
            <table>
              <tr>
                <td>ID: </td>
                <td><input type="text" name="employee_id" class="employee_id" readonly value="${employee.getEmployee_id()}" ></td>
              </tr>
              <tr>
                <td>Name: </td>
                <td><input type="text" name="employee_name" id="employee_name" value="${employee.getEmployee_name()}"></td>
              </tr>
              <tr>
                <td>Birthday: </td>
                <td><input type="date" name="employee_birthday" id="employee_birthday" value="${employee.getEmployee_birthday()}"></td>
              </tr>
              <tr>
                <td>Address: </td>
                <td><input type="text" name="employee_address" id="employee_address" value="${employee.getEmployee_address()}"></td>
              </tr>
              <tr>
                <td>ID Card: </td>
                <td><input type="number" name="employee_id_card" id="employee_id_card" value="${employee.getEmployee_id_card()}"></td>
              </tr>
              <tr>
                <td>Phone number: </td>
                <td><input type="text" name="employee_phone" id="employee_phone" value="${employee.getEmployee_phone()}"></td>
              </tr>
              <tr>
                <td>Email: </td>
                <td><input type="text" name="employee_email" id="employee_email" value="${employee.getEmployee_email()}"><td>
              </tr>
              <tr>
                <td>Education Degree ID: </td>
                <td><input type="number" name="education_degree_id" id="education_degree_id" value="${employee.getEducation_degree_id()}"></td>
              </tr>
              <tr>
                <td>Position ID: </td>
                <td><input type="number" name="position_id" id="position_id" value="${employee.getPosition_id()}"></td>
              </tr>
              <tr>
                <td>Division ID: </td>
                <td><input type="number" name="division_id" id="division_id" value="${employee.getDivision_id()}"></td>
              </tr>
              <tr>
                <td>Salary: </td>
                <td><input type="number" name="employee_salary" id="employee_salary" value="${employee.getEmployee_salary()}"></td>
              </tr>
              <tr>
                <td>User name: </td>
                <td><input type="text" name="username" id="username" value="${employee.getUsername()}"></td>
              </tr>
              <tr>
                <td></td>
                <td><input type="submit" value="Edit employee"></td>
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
