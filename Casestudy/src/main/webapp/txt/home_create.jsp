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
        <c:if test="${action==create_employee}">
          <form method="post">
            <fieldset>
              <legend>Employee information</legend>
              <table>
                <tr>
                  <td>ID: </td>
                  <td><input type="text" name="employee_id" class="employee_id"></td>
                </tr>
                <tr>
                  <td>Name: </td>
                  <td><input type="text" name="employee_name" id="employee_name"></td>
                </tr>
                <tr>
                  <td>Birthday: </td>
                  <td><input type="date" name="employee_birthday" id="employee_birthday"></td>
                </tr>
                <tr>
                  <td>Address: </td>
                  <td><input type="text" name="employee_address" id="employee_address"></td>
                </tr>
                <tr>
                  <td>ID Card: </td>
                  <td><input type="number" name="employee_id_card" id="employee_id_card"></td>
                </tr>
                <tr>
                  <td>Phone number: </td>
                  <td><input type="text" name="employee_phone" id="employee_phone"></td>
                </tr>
                <tr>
                  <td>Email: </td>
                  <td><input type="text" name="employee_email" id="employee_email"></td>
                </tr>
                <tr>
                  <td>Education Degree ID: </td>
                  <td><input type="number" name="education_degree_id" id="education_degree_id"></td>
                </tr>
                <tr>
                  <td>Position ID: </td>
                  <td><input type="number" name="position_id" id="position_id"></td>
                </tr>
                <tr>
                  <td>Division ID: </td>
                  <td><input type="number" name="division_id" id="division_id"></td>
                </tr>
                <tr>
                  <td>Salary: </td>
                  <td><input type="number" name="employee_salary" id="employee_salary"></td>
                </tr>
                <tr>
                  <td>User name: </td>
                  <td><input type="text" name="username" id="username"></td>
                </tr>
                <tr>
                  <td></td>
                  <td><input type="submit" value="Create employee"></td>
                </tr>
              </table>
            </fieldset>
          </form>
        </c:if>


        <c:if test="${action==create_customer}">
        <form method="post">
          <fieldset>
            <legend>Customer information</legend>
            <table>
              <tr>
                <td>ID: </td>
                <td><input type="text" name="customer_id" class="customer_id"></td>
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
        </c:if>


        <c:if test="${action==create_contract}">
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
        </c:if>


        <c:if test="${action==contract_detail}">
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
        </c:if>
      </div>
    </div>
    <div id="bostom"></div>
  </div>
</div>
</body>
</html>
