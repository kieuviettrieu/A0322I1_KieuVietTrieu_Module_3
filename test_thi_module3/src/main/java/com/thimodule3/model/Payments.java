package com.thimodule3.model;

public class
Payments {
    private int paymentID;
    private String payment;

    public Payments() {
    }

    public Payments(int paymentID, String payment) {
        this.paymentID = paymentID;
        this.payment = payment;
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
}
