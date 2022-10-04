package com.Casestudy.repository.service.impl;

import com.Casestudy.model.Contract;
import com.Casestudy.model.ContractDetail;
import com.Casestudy.model.person.Customer;
import com.Casestudy.repository.service.inter.ContractInterface;
import com.Casestudy.repository.utils.Conec;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImpContractService implements ContractInterface {

    @Override
    public List<Contract> selectAllContract() {
        List<Contract> list=new ArrayList<>();
        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
             ResultSet rs = preparedStatement.executeQuery();) {

            while (rs.next()) {
                int contract_id=rs.getInt("contract_id");
                java.util.Date contract_start_date=rs.getDate("contract_start_date");
                java.util.Date contract_end_date=rs.getDate("contract_end_date");
                double contract_deposit=rs.getDouble("contract_deposit");
                double contract_total_money=rs.getDouble("contract_total_money");
                int employee_id=rs.getInt("employee_id");
                int customer_id=rs.getInt("customer_id");
                int service_id=rs.getInt("service_id");
                list.add(new Contract(contract_id,contract_start_date,contract_end_date,contract_deposit,
                        contract_total_money,employee_id,customer_id,service_id));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public List<ContractDetail> selectAllContractDetail() {
        List<ContractDetail> list=new ArrayList<>();
        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
             ResultSet rs = preparedStatement.executeQuery();) {

            while (rs.next()) {
                int contract_detail_id=rs.getInt("contract_detail_id");
                int contract_id=rs.getInt("contract_id");
                int attach_service_id=rs.getInt("attach_service_id");
                int quantity=rs.getInt("quantity");
                list.add(new ContractDetail(contract_detail_id,contract_id,attach_service_id,quantity));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public void insertContract(Contract contract) throws SQLException {
        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT)) {
            preparedStatement.setDate(1, (Date) contract.getContract_start_date());
            preparedStatement.setDate(2, (Date) contract.getContract_end_date());
            preparedStatement.setDouble(3, contract.getContract_deposit());
            preparedStatement.setDouble(4, contract.getContract_total_money());

            preparedStatement.setInt(5, contract.getEmployee_id());
            preparedStatement.setInt(6, contract.getCustomer_id());
            preparedStatement.setInt(7, contract.getService_id());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void insertContractDetail(ContractDetail contractDetail) throws SQLException {
        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_DETAIL)) {
            preparedStatement.setInt(1,contractDetail.getContract_id());
            preparedStatement.setInt(2,contractDetail.getAttach_service_id());
            preparedStatement.setInt(3,contractDetail.getQuantity());
            preparedStatement.executeUpdate();
        }
    }
}
