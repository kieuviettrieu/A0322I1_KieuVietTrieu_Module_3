package com.Casestudy.repository.service.impl;

import com.Casestudy.model.person.Customer;
import com.Casestudy.repository.service.inter.CustomerInterface;
import com.Casestudy.repository.utils.Conec;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImpCustomerService implements CustomerInterface {

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getCustomer_id());
            preparedStatement.setInt(2, customer.getCustomer_type_id());
            preparedStatement.setString(3, customer.getCustomer_name());

            preparedStatement.setDate(4, (Date) customer.getCustomer_birthday());
            preparedStatement.setBoolean(5, customer.isCustomer_gender());
            preparedStatement.setString(6, customer.getCustomer_id_card());
            preparedStatement.setString(7, customer.getCustomer_phone());
            preparedStatement.setString(8, customer.getCustomer_email());
            preparedStatement.setString(9, customer.getCustomer_address());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Customer selectCustomer(String customer_id) {
        Customer customer = null;

        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setString(1,customer_id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int customer_type_id=rs.getInt(2);
                String customer_name=rs.getString(3);
                java.util.Date customer_birthday=rs.getDate(4);
                boolean customer_gender=rs.getBoolean(5);
                String customer_id_card=rs.getString(6);
                String customer_phone=rs.getString(7);
                String customer_email=rs.getString(8);
                String customer_address=rs.getString(9);
                customer=new Customer(customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,
                        customer_id_card,customer_phone,customer_email,customer_address);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return customer;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> list=new ArrayList<>();

        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String customer_id=rs.getString(1);
                int customer_type_id=rs.getInt(2);
                String customer_name=rs.getString(3);
                java.util.Date customer_birthday=rs.getDate(4);
                boolean customer_gender=rs.getBoolean(5);
                String customer_id_card=rs.getString(6);
                String customer_phone=rs.getString(7);
                String customer_email=rs.getString(8);
                String customer_address=rs.getString(9);
                list.add(new Customer(customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,
                        customer_id_card,customer_phone,customer_email,customer_address));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public List<Customer> selectAllCustomerContract() {
        List<Customer> list=new ArrayList<>();

        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_CONTRACT);) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String customer_id=rs.getString(1);
                int customer_type_id=rs.getInt(2);
                String customer_name=rs.getString(3);
                java.util.Date customer_birthday=rs.getDate(4);
                boolean customer_gender=rs.getBoolean(5);
                String customer_id_card=rs.getString(6);
                String customer_phone=rs.getString(7);
                String customer_email=rs.getString(8);
                String customer_address=rs.getString(9);
                list.add(new Customer(customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,
                        customer_id_card,customer_phone,customer_email,customer_address));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public boolean deleteCustomer(String customer_id) {
        boolean rowDeleted = false;
        try (Connection connection = (Connection) Conec.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_ID);) {
            statement.setString(1, customer_id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated = false;
        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_ID);) {

            preparedStatement.setInt(1, customer.getCustomer_type_id());
            preparedStatement.setString(2, customer.getCustomer_name());
            preparedStatement.setDate(3, (Date) customer.getCustomer_birthday());
            preparedStatement.setBoolean(4, customer.isCustomer_gender());
            preparedStatement.setString(5, customer.getCustomer_id_card());
            preparedStatement.setString(6, customer.getCustomer_phone());
            preparedStatement.setString(7, customer.getCustomer_email());
            preparedStatement.setString(8, customer.getCustomer_address());
            preparedStatement.setString(9, customer.getCustomer_id());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
