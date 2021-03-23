package ssi.webapplication.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "costs")
public class CostsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer costId;

    @DateTimeFormat(pattern = "DD/MM/YYYY")
    private Date date;

    @Column(length = 10)
    private String currency;

    @Column(length = 20)
    private Double value;

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
