package com.Casestudy.repository.service.impl;

import com.Casestudy.model.facitily.House;
import com.Casestudy.model.facitily.Room;
import com.Casestudy.model.facitily.Villa;
import com.Casestudy.repository.service.inter.FacitilyInterface;
import com.Casestudy.repository.utils.Conec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImpFacitilyService implements FacitilyInterface {

    @Override
    public void insertServiceVilla(Villa villa) throws SQLException {
        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_VILLA)) {

            preparedStatement.setString(1,villa.getService_id());
            preparedStatement.setString(2,villa.getService_name());
            preparedStatement.setInt(3,villa.getService_area());
            preparedStatement.setDouble(4,villa.getService_cost());
            preparedStatement.setInt(5,villa.getService_max_people());
            preparedStatement.setInt(6,villa.getRent_type_id());
            preparedStatement.setInt(7,villa.getService_type_id());
            preparedStatement.setString(8,villa.getStandard_room());
            preparedStatement.setString(9,villa.getDescription_other_convenience());
            preparedStatement.setDouble(10,villa.getPool_area());
            preparedStatement.setInt(11,villa.getNumber_of_floors());

            preparedStatement.executeUpdate();
        }

    }


    @Override
    public void insertServiceHouse(House house) throws SQLException {
        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_HOUSE)) {

            preparedStatement.setString(1,house.getService_id());
            preparedStatement.setString(2,house.getService_name());
            preparedStatement.setInt(3,house.getService_area());
            preparedStatement.setDouble(4,house.getService_cost());
            preparedStatement.setInt(5,house.getService_max_people());
            preparedStatement.setInt(6,house.getRent_type_id());
            preparedStatement.setInt(7,house.getService_type_id());
            preparedStatement.setString(8,house.getStandard_room());
            preparedStatement.setString(9,house.getDescription_other_convenience());
            preparedStatement.setInt(10,house.getNumber_of_floors());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void insertServiceRoom(Room room) throws SQLException {
        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_HOUSE)) {

            preparedStatement.setString(1,room.getService_id());
            preparedStatement.setString(2,room.getService_name());
            preparedStatement.setInt(3,room.getService_area());
            preparedStatement.setDouble(4,room.getService_cost());
            preparedStatement.setInt(5,room.getService_max_people());
            preparedStatement.setInt(6,room.getRent_type_id());
            preparedStatement.setInt(7,room.getService_type_id());
            preparedStatement.setString(8,room.getService_free());

            preparedStatement.executeUpdate();
        }
    }
}
