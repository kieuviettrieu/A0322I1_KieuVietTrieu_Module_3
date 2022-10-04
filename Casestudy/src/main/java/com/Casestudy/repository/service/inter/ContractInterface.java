package com.Casestudy.repository.service.inter;

import com.Casestudy.model.Contract;
import com.Casestudy.model.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public interface ContractInterface {

    String INSERT_CONTRACT="INSERT INTO contract (contract_start_date, contract_end_date, contract_deposit," +
        " contract_total_money, employee_id, customer_id, service_id) VALUES  (?, ?, ?, ?, ?, ?, ?);";

    String INSERT_CONTRACT_DETAIL="INSERT INTO contract_detail (contract_id, attach_service_id, quantity)" +
            " VALUES  (?, ?, ?);";

    String SELECT_ALL_CONTRACT="select contract_id, contract_start_date, contract_end_date, contract_deposit, " +
        "contract_total_money, employee_id, customer_id, service_id from contract;";

    String SELECT_ALL_CONTRACT_DETAIL="select contract_detail_id, contract_id, attach_service_id, quantity from contract_detail;";

    List<Contract> selectAllContract();

    List<ContractDetail> selectAllContractDetail();

    void insertContract(Contract contract) throws SQLException;

    void insertContractDetail(ContractDetail contractDetail) throws SQLException;
}
