package ssi.webapplication.entities;

import org.apache.catalina.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "costs")
public class CostsEntity {

    /**
     * Fields.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer costId;

    private String username;

    @DateTimeFormat(pattern = "DD/MM/YYYY")
    private Date date;

    @Column(length = 10)
    private String currency;

    @Column(length = 20)
    private Double value;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
