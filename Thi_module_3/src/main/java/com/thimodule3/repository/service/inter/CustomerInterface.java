package com.thimodule3.repository.service.inter;


import java.sql.SQLException;
import java.util.List;

public interface CustomerInterface {
    String INSERT_CUSTOMER_SQL = "INSERT INTO customer (customer_id, customer_type_id, customer_name, customer_birthday," +
            " customer_gender, customer_id_card, customer_phone, customer_email, customer_address) " +
            "VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    String SELECT_CUSTOMER_BY_ID = "select customer_id, customer_type_id, customer_name," +
            "customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address from customer where customer_id =?";
    String SELECT_ALL_CUSTOMER = "select customer_id, customer_type_id, customer_name," +
            "customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address from customer";
    String DELETE_CUSTOMER_ID="delete from customer where customer_id = ?;";
    String UPDATE_CUSTOMER_ID="update users set customer_type_id = ?,customer_name= ?, customer_birthday =?, " +
            "customer_gender = ?,customer_id_card= ?, customer_phone =?, customer_email = ?,customer_address= ? " +
            "where customer_id = ?;";
    String SELECT_ALL_USERS_COUNTRY = "select * from users where country like ?";

//    void insertCustomer(Customer customer) throws SQLException;
//
//    Customer selectCustomer(String customer_id);
//
//    List<Customer> selectAllCustomer();
//
//
//    boolean deleteCustomer(String customer_id);
//
//    boolean updateCustomer(Customer customer) throws SQLException;
}
