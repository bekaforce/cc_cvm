package com.offers.cvm_cc_tariffs.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TariffOffer {
    @Id
    @GeneratedValue
    long Id;
    String Date; //0
    String SubsKey; //1
    String activation_date; //2
    String SubId;//3
    String subscriberNumber; //4
    String channel; //5
    Date operation_date; //6
    String current_tariff; //7
    String previous_tariff; //8
    String comparison; //9
    String rev_until_total; //10
    String rev_after_total; //11
    String two_weeks_condition; //12
    String thirty_days_condition; //13
    String sixty_days_condition; //14
    String date_of_first_payment; //15
    String amount_of_payment; //16
    String agent; //17
    String subAgent; //18
    String channel_group; //19
    String motivational_number; //20
    String USSD_number; //21
    String region_of_max; //22
    Integer upsell; //23
    String seven_days_condition; //24
    String offer_name; //25
    Integer offer_payment; //26
    String current_tariff_category; //27
    String previous_tariff_category; //28
    String current_tariff_payment; //29
    String previous_tariff_payment; //30
    String Upsell_CVM; //31
    String offer_id; //32
    Date offer_date; //33
    String login; //34
    String offer_status; //35
    String eight_days; //36

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSubsKey() {
        return SubsKey;
    }

    public void setSubsKey(String subsKey) {
        SubsKey = subsKey;
    }

    public String getActivation_date() {
        return activation_date;
    }

    public void setActivation_date(String activation_date) {
        this.activation_date = activation_date;
    }

    public String getSubId() {
        return SubId;
    }

    public void setSubId(String subId) {
        SubId = subId;
    }

    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    public void setSubscriberNumber(String subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Date getOperation_date() {
        return operation_date;
    }

    public void setOperation_date(Date operation_date) {
        this.operation_date = operation_date;
    }

    public String getCurrent_tariff() {
        return current_tariff;
    }

    public void setCurrent_tariff(String current_tariff) {
        this.current_tariff = current_tariff;
    }

    public String getPrevious_tariff() {
        return previous_tariff;
    }

    public void setPrevious_tariff(String previous_tariff) {
        this.previous_tariff = previous_tariff;
    }

    public String getComparison() {
        return comparison;
    }

    public void setComparison(String comparison) {
        this.comparison = comparison;
    }

    public String getRev_until_total() {
        return rev_until_total;
    }

    public void setRev_until_total(String rev_until_total) {
        this.rev_until_total = rev_until_total;
    }

    public String getRev_after_total() {
        return rev_after_total;
    }

    public void setRev_after_total(String rev_after_total) {
        this.rev_after_total = rev_after_total;
    }

    public String getTwo_weeks_condition() {
        return two_weeks_condition;
    }

    public void setTwo_weeks_condition(String two_weeks_condition) {
        this.two_weeks_condition = two_weeks_condition;
    }

    public String getThirty_days_condition() {
        return thirty_days_condition;
    }

    public void setThirty_days_condition(String thirty_days_condition) {
        this.thirty_days_condition = thirty_days_condition;
    }

    public String getSixty_days_condition() {
        return sixty_days_condition;
    }

    public void setSixty_days_condition(String sixty_days_condition) {
        this.sixty_days_condition = sixty_days_condition;
    }

    public String getDate_of_first_payment() {
        return date_of_first_payment;
    }

    public void setDate_of_first_payment(String date_of_payment) {
        this.date_of_first_payment = date_of_payment;
    }

    public String getAmount_of_payment() {
        return amount_of_payment;
    }

    public void setAmount_of_payment(String amount_of_payment) {
        this.amount_of_payment = amount_of_payment;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getSubAgent() {
        return subAgent;
    }

    public void setSubAgent(String subAgent) {
        this.subAgent = subAgent;
    }

    public String getChannel_group() {
        return channel_group;
    }

    public void setChannel_group(String channel_group) {
        this.channel_group = channel_group;
    }

    public String getMotivational_number() {
        return motivational_number;
    }

    public void setMotivational_number(String motivational_number) {
        this.motivational_number = motivational_number;
    }

    public String getUSSD_number() {
        return USSD_number;
    }

    public void setUSSD_number(String USSD_number) {
        this.USSD_number = USSD_number;
    }

    public String getRegion_of_max() {
        return region_of_max;
    }

    public void setRegion_of_max(String region_of_max) {
        this.region_of_max = region_of_max;
    }

    public Integer getUpsell() {
        return upsell;
    }

    public void setUpsell(Integer upsell) {
        this.upsell = upsell;
    }

    public String getSeven_days_condition() {
        return seven_days_condition;
    }

    public void setSeven_days_condition(String seven_days_condition) {
        this.seven_days_condition = seven_days_condition;
    }

    public String getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(String offer_id) {
        this.offer_id = offer_id;
    }

    public String getOffer_name() {
        return offer_name;
    }

    public void setOffer_name(String offer_name) {
        this.offer_name = offer_name;
    }

    public Integer getOffer_payment() {
        return offer_payment;
    }

    public void setOffer_payment(Integer offer_payment) {
        this.offer_payment = offer_payment;
    }

    public String getCurrent_tariff_category() {
        return current_tariff_category;
    }

    public void setCurrent_tariff_category(String current_tariff_category) {
        this.current_tariff_category = current_tariff_category;
    }

    public String getPrevious_tariff_category() {
        return previous_tariff_category;
    }

    public void setPrevious_tariff_category(String previous_tariff_category) {
        this.previous_tariff_category = previous_tariff_category;
    }

    public String getCurrent_tariff_payment() {
        return current_tariff_payment;
    }

    public void setCurrent_tariff_payment(String current_tariff_payment) {
        this.current_tariff_payment = current_tariff_payment;
    }

    public String getPrevious_tariff_payment() {
        return previous_tariff_payment;
    }

    public void setPrevious_tariff_payment(String previous_tariff_payment) {
        this.previous_tariff_payment = previous_tariff_payment;
    }

    public String getUpsell_CVM() {
        return Upsell_CVM;
    }

    public void setUpsell_CVM(String upsell_CVM) {
        Upsell_CVM = upsell_CVM;
    }

    public Date getOffer_date() {
        return offer_date;
    }

    public void setOffer_date(Date offer_date) {
        this.offer_date = offer_date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getOffer_status() {
        return offer_status;
    }

    public void setOffer_status(String offer_status) {
        this.offer_status = offer_status;
    }

    public String getEight_days() {
        return eight_days;
    }

    public void setEight_days(String eight_days) {
        this.eight_days = eight_days;
    }

}
