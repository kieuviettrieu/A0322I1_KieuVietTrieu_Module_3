package com.Casestudy.model.facitily;

public class Room extends Facitily{
    private String service_free;

    public Room() {
    }

    public Room(String attach_service_free) {
        this.service_free = attach_service_free;
    }

    public Room(String service_id, String service_name, int service_area, double service_cost, int service_max_people,
                int rent_type_id, int service_type_id, String service_free) {
        super(service_id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id);
        this.service_free = service_free;
    }

    public String getService_free() {
        return service_free;
    }

    public void setService_free(String service_free) {
        this.service_free = service_free;
    }
}
