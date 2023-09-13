package edu.ifrs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Invoice {
    
    private String cardNumber;
    private String value;
    private boolean payment;

}
