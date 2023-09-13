package edu.ifrs;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;

@Entity //adiciona para a classe ser vista como entidade pelo banco
public class Invoice extends PanacheEntity{ //o panache controla a chame primaria

    @NotEmpty
    private String cardNumber;
    @NotEmpty
    private String value;
    private boolean payment;

    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public boolean isPayment() {
        return payment;
    }
    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    
    
}
