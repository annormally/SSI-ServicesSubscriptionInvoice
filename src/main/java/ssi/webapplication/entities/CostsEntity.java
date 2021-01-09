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
    @Column(length = 20)
    private Double value;

    @Column(length = 10)
    private String currency;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CostsEntity{" +
                "costId=" + costId +
                ", value=" + value +
                ", currency='" + currency + '\'' +
                ", date=" + date +
                '}';
    }
}
