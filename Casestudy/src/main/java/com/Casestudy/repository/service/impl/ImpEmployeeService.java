package com.Casestudy.repository.service.impl;

import com.Casestudy.model.person.Customer;
import com.Casestudy.model.person.Employee;
import com.Casestudy.repository.service.inter.EmployeeInterface;
import com.Casestudy.repository.utils.Conec;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImpEmployeeService implements EmployeeInterface {
    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getEmployee_id());
            preparedStatement.setString(2, employee.getEmployee_name());
            preparedStatement.setDate(3, (Date) employee.getEmployee_birthday());

            preparedStatement.setString(4, employee.getEmployee_id_card());
            preparedStatement.setDouble(5, employee.getEmployee_salary());
            preparedStatement.setString(6, employee.getEmployee_phone());
            preparedStatement.setString(7, employee.getEmployee_email());
            preparedStatement.setString(8, employee.getEmployee_address());
            preparedStatement.setInt(9,employee.getPosition_id());
            preparedStatement.setInt(10,employee.getEducation_degree_id());
            preparedStatement.setInt(11,employee.getDivision_id());
            preparedStatement.setString(12, employee.getUsername());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Employee selectEmployee(String employee_id) {
        Employee employee = null;

        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setString(1,employee_id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String employee_name=rs.getString("employee_name");
                java.util.Date employee_birthday=rs.getDate("employee_birthday");
                String employee_id_card=rs.getString("employee_id_card");
                double employee_salary=rs.getDouble("employee_salary");
                String employee_phone=rs.getString("employee_phone");
                String employee_email=rs.getString("employee_email");
                String employee_address=rs.getString("employee_address");
                int position_id=rs.getInt("position_id");
                int education_degree_id=rs.getInt("education_degree_id");
                int division_id=rs.getInt("division_id");
                String username=rs.getString("username");
                employee=new Employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,
                        employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> list=new ArrayList<>();

        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String employee_id=rs.getString("employee_id");
                String employee_name=rs.getString("employee_name");
                java.util.Date employee_birthday=rs.getDate("employee_birthday");
                String employee_id_card=rs.getString("employee_id_card");
                double employee_salary=rs.getDouble("employee_salary");
                String employee_phone=rs.getString("employee_phone");
                String employee_email=rs.getString("employee_email");
                String employee_address=rs.getString("employee_address");
                int position_id=rs.getInt("position_id");
                int education_degree_id=rs.getInt("education_degree_id");
                int division_id=rs.getInt("division_id");
                String username=rs.getString("username");
                list.add(new Employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,
                        employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public boolean deleteEmployee(String employee_id) {
        boolean rowDeleted = false;
        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_ID);) {
            statement.setString(1, employee_id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated = false;
        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_ID);) {

            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setDate(2, (Date) employee.getEmployee_birthday());
            preparedStatement.setString(3, employee.getEmployee_id_card());
            preparedStatement.setDouble(4, employee.getEmployee_salary());
            preparedStatement.setString(5, employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_address());
            preparedStatement.setInt(8,employee.getPosition_id());
            preparedStatement.setInt(9,employee.getEducation_degree_id());
            preparedStatement.setInt(10,employee.getDivision_id());
            preparedStatement.setString(11,employee.getUsername());
            preparedStatement.setString(12,employee.getEmployee_id());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
