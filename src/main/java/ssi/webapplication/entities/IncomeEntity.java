package ssi.webapplication.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "income")
public class IncomeEntity {

    @Id
    private Integer id;
    private Double salary;
    private Double otherIncome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(Double otherIncome) {
        this.otherIncome = otherIncome;
    }

    @Override
    public String toString() {
        return "IncomeEntity{" +
                "id=" + id +
                ", salary=" + salary +
                ", otherIncome=" + otherIncome +
                '}';
    }

}
