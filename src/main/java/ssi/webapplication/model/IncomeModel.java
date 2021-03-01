package ssi.webapplication.model;

import java.sql.Date;

public class IncomeModel {

    private Integer incomeId;
    private Date date;
    private String supportDocument;
    private String currency;
    private Double value;
    private Double tva;
    private Double tvaValue;
    private Double totalValuePlusTva;

    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSupportDocument() {
        return supportDocument;
    }

    public void setSupportDocument(String supportDocument) {
        this.supportDocument = supportDocument;
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

    public Double getTva() {
        return tva;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }

    public Double getTvaValue() {
        return tvaValue;
    }

    public void setTvaValue(Double tvaValue) {
        this.tvaValue = tvaValue;
    }

    public Double getTotalValuePlusTva() {
        return totalValuePlusTva;
    }

    public void setTotalValuePlusTva(Double totalValuePlusTva) {
        this.totalValuePlusTva = totalValuePlusTva;
    }
}
