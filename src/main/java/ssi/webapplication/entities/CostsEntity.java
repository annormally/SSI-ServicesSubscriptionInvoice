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

    private String supportDocument;

    @Column(length = 10)
    private String currency;

    @Column(length = 20)
    private Double value;

    private Double tva;

    private Double tvaValeu;

    private Double totalValeuPlusTva;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
