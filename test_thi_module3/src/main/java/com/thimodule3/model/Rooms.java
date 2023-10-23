package com.thimodule3.model;

import java.util.Date;

public class Rooms {
//    roomID int primary key auto_increment,
//    namePeople varchar(100),
//    phoneNumber varchar(20),
//    firstDate date,
//    paymentID int,
    private int roomID;
    private String namePeople;
    private String phoneNumber;
    private Date firstDate;
    private int paymentID;
    private String payment;
    private String note;

    public Rooms() {
    }

    public Rooms(String namePeople, String phoneNumber, Date firstDate, int paymentID, String note) {
        this.namePeople = namePeople;
        this.phoneNumber = phoneNumber;
        this.firstDate = firstDate;
        this.paymentID = paymentID;
        this.note=note;
    }

    public Rooms(int roomID, String namePeople, String phoneNumber, Date firstDate, int paymentID, String payment, String note) {
        this.roomID = roomID;
        this.namePeople = namePeople;
        this.phoneNumber = phoneNumber;
        this.firstDate = firstDate;
        this.paymentID = paymentID;
        this.payment = payment;
        this.note = note;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getNamePeople() {
        return namePeople;
    }

    public void setNamePeople(String namePeople) {
        this.namePeople = namePeople;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
