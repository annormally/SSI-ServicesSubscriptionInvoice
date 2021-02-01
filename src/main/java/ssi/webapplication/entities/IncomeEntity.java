package ssi.webapplication.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "income")
public class IncomeEntity {

    @Id
    private Integer id;

    @DateTimeFormat(pattern = "DD/MM/YYYY")
    private Date date;

    private String explication;

    private String justificationDocument;

    @Column(length = 10)
    private String currency;

    private Double unitaryPrice;

    @Column(length = 20)
    private Double value;

    private Double tva;

    private Double tvaValeu;

    private Double totalValeuPlusTva;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getExplication() {
        return explication;
    }

    public void setExplication(String explication) {
        this.explication = explication;
    }

    public String getJustificationDocument() {
        return justificationDocument;
    }

    public void setJustificationDocument(String justificationDocument) {
        this.justificationDocument = justificationDocument;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(Double unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
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

    public Double getTvaValeu() {
        return tvaValeu;
    }

    public void setTvaValeu(Double tvaValeu) {
        this.tvaValeu = tvaValeu;
    }

    public Double getTotalValeuPlusTva() {
        return totalValeuPlusTva;
    }

    public void setTotalValeuPlusTva(Double totalValeuPlusTva) {
        this.totalValeuPlusTva = totalValeuPlusTva;
    }
}
