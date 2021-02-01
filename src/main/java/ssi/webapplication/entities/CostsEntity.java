package ssi.webapplication.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "costs")
public class CostsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer costId;

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

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
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
