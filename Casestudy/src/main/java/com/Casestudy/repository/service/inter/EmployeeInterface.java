package com.Casestudy.repository.service.inter;

import com.Casestudy.model.person.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeInterface {
//    employee_id varchar(15) primary key,
//    employee_name varchar(45),
//    employee_birthday date,
//    employee_id_card varchar(45),
//    employee_salary double,
//    employee_phone varchar(45),
//    employee_email varchar(45),
//    employee_address varchar(45),
//    position_id int,
//    education_degree_id int,
//    division_id int ,
//    username varchar(255),
    String INSERT_EMPLOYEE_SQL="INSERT INTO employee (employee_id, employee_name, employee_birthday, employee_id_card," +
            " employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username) " +
            "VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    String SELECT_EMPLOYEE_BY_ID="select employee_id, employee_name, employee_birthday, employee_id_card," +
            " employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, " +
            "division_id, username from employee where employee_id=?;";
    String SELECT_ALL_EMPLOYEE="select employee_id, employee_name, employee_birthday, employee_id_card," +
            " employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, " +
            "division_id, username from employee;";
    String DELETE_EMPLOYEE_ID="delete from employee where employee_id = ?;";
    String UPDATE_EMPLOYEE_ID="update employee set  employee_name = ?, employee_birthday = ?, employee_id_card = ?," +
            " employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, " +
            "education_degree_id = ?, division_id = ?, username = ? where employee_id = ?;";

    void insertEmployee(Employee employee) throws SQLException;

    Employee selectEmployee(String employee_id);

    List<Employee> selectAllEmployee();

    boolean deleteEmployee(String employee_id);

    boolean updateEmployee(Employee employee) throws SQLException;
}
