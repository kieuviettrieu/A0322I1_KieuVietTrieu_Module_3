package com.thimodule3.service.impl;

import com.thimodule3.model.Payments;
import com.thimodule3.model.Rooms;
import com.thimodule3.service.inter.RoomsInterface;
import com.thimodule3.utils.Conec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImpRoomsInter implements RoomsInterface {
    @Override
    public List<Rooms> selectAllRooms() {
        List<Rooms> list=new ArrayList<>();

        try (Connection connection = Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOMS);
        ) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int roomID=rs.getInt("roomID");
                String namePeople=rs.getString("namePeople");
                String phoneNumber=rs.getString("phoneNumber");
//                java.util.Date contract_start_date=rs.getDate("contract_start_date");
                java.util.Date firstDate=rs.getDate("firstDate");
                int paymentID=rs.getInt("paymentID");
                String payment=rs.getString("payment");
                String note=rs.getString("note");

                list.add(new Rooms(roomID,namePeople,phoneNumber,firstDate,paymentID,payment,note));
            }
        } catch (SQLException throwables) {
            throwables.getMessage();
        }
        return list;
    }

    @Override
    public List<Rooms> selectAllRoomsByName(String nameSearch) {
        List<Rooms> list = new ArrayList<>();

        String search="%"+nameSearch+"%";
        try (Connection connection = Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOMS_BY_NAME)) {

            preparedStatement.setString(1,search);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int roomID=rs.getInt("roomID");
                String namePeople=rs.getString("namePeople");
                String phoneNumber=rs.getString("phoneNumber");
//                java.util.Date contract_start_date=rs.getDate("contract_start_date");
                java.util.Date firstDate=rs.getDate("firstDate");
                int paymentID=rs.getInt("paymentID");
                String payment=rs.getString("payment");
                String note=rs.getString("note");


                list.add(new Rooms(roomID,namePeople,phoneNumber,firstDate,paymentID,payment,note));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }

    @Override
    public List<Rooms> selectAllRoomsByPhone(double phoneSearch) {
        return null;
    }

    @Override
    public List<Payments> selectAllPayment() {
        List<Payments> list=new ArrayList<>();

        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PAYMENTS);
        ) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int paymentID=rs.getInt("paymentID");
                String payment=rs.getString("payment");

                list.add(new Payments(paymentID,payment));
            }
        } catch (SQLException throwables) {
            throwables.getMessage();
        }
        return list;
    }

    @Override
    public void insertRooms(Rooms rooms) throws SQLException {
        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOMS_SQL);) {

            preparedStatement.setString(1,rooms.getNamePeople());
            preparedStatement.setString(2,rooms.getPhoneNumber());
            preparedStatement.setDate(3, new java.sql.Date(rooms.getFirstDate().getTime()));
            preparedStatement.setInt(4,rooms.getPaymentID());
            preparedStatement.setString(5,rooms.getNote());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public boolean deleteRooms(int id) {
        boolean rowDeleted = false;
        try (Connection connection = (Connection) Conec.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ROOMS_ID);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }
}
