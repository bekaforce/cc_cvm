package com.offers.cvm_cc_tariffs.model;

import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ServiceOffer {
    @Id
    @GeneratedValue
    private long ID; //0
    private String describer_number; //1
    private String date_of_fix; //2
    private String offer_id; //3
    private String campaign_offer_name; //4
    private String employee; //5
    private String offer_status; //6
    private String subdivision; //7
    private String package_name; //8
    private String connection_fact; //9
    private String payment_date; //10
    private String payment; //11

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getDescriber_number() {
        return describer_number;
    }

    public void setDescriber_number(String describer_number) {
        this.describer_number = describer_number;
    }

    public String getDate_of_fix() {
        return date_of_fix;
    }

    public void setDate_of_fix(String date_of_fix) {
        this.date_of_fix = date_of_fix;
    }

    public String getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(String offer_id) {
        this.offer_id = offer_id;
    }

    public String getCampaign_offer_name() {
        return campaign_offer_name;
    }

    public void setCampaign_offer_name(String campaign_offer_name) {
        this.campaign_offer_name = campaign_offer_name;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getOffer_status() {
        return offer_status;
    }

    public void setOffer_status(String offer_status) {
        this.offer_status = offer_status;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public String getConnection_fact() {
        return connection_fact;
    }

    public void setConnection_fact(String connection_fact) {
        this.connection_fact = connection_fact;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
