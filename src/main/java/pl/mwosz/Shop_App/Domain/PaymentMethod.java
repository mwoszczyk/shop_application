package pl.mwosz.Shop_App.Domain;

import javax.persistence.Entity;

//@Entity
public enum PaymentMethod {
    CASH,
    CREDIT_CARD,
    BLIK,
    INSTANT_TRANSFER;
}
