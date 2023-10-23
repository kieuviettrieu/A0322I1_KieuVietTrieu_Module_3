package com.thimodule3.service.inter;

import com.thimodule3.model.Payments;
import com.thimodule3.model.Rooms;

import java.sql.SQLException;
import java.util.List;

public interface RoomsInterface {
    String SELECT_ALL_ROOMS = "select * from rooms join payments using(paymentID);";

    String SELECT_ALL_PAYMENTS = "select * from payments;";

    String INSERT_ROOMS_SQL = "insert into rooms(namePeople, phoneNumber, firstDate, paymentID, note) " +
            "VALUES  (?, ?, ?, ?, ?);";

    String DELETE_ROOMS_ID="delete from rooms where roomID = ?;";

    String SELECT_ALL_ROOMS_BY_NAME = "select * from rooms join payments using(paymentID) where namePeople like ?;";

    List<Rooms> selectAllRooms();

    List<Rooms> selectAllRoomsByName(String nameSearch);

    List<Rooms> selectAllRoomsByPhone(double phoneSearch);

    List<Payments> selectAllPayment();

    void insertRooms(Rooms rooms) throws SQLException;

    boolean deleteRooms(int id);
}
