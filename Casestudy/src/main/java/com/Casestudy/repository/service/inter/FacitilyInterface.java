package com.Casestudy.repository.service.inter;

import com.Casestudy.model.facitily.House;
import com.Casestudy.model.facitily.Room;
import com.Casestudy.model.facitily.Villa;

import java.sql.SQLException;

public interface FacitilyInterface {

    String INSERT_SERVICE_VILLA="INSERT INTO service (service_id, service_name, service_area, " +
        "service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_covenience, " +
            "pool_area, number_of_floors) VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    String INSERT_SERVICE_HOUSE="INSERT INTO service (service_id, service_name, service_area, " +
            "service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_covenience, " +
            "number_of_floors) VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    String INSERT_SERVICE_ROOM="INSERT INTO service (service_id, service_name, service_area, " +
            "service_cost, service_max_people, rent_type_id, service_type_id, service_free) VALUES  (?, ?, ?, ?, ?, ?, ?, ?);";

    void insertServiceVilla(Villa villa) throws SQLException;

    void insertServiceHouse(House house) throws SQLException;

    void insertServiceRoom(Room room) throws SQLException;
}
