package ssi.webapplication.model;

import java.sql.Date;

public class CostsModel {

    /**
     * Fields.
     */

    private Integer costId;
    private String username;
    private Date date;
    private String currency;
    private Double value;

    /**
     * Getter and Setter
     */

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}

