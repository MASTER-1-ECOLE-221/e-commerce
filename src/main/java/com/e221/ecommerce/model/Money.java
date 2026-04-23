package com.e221.ecommerce.model;

import com.e221.ecommerce.exception.BusinessRuleException;
import com.e221.ecommerce.exception.InvalidCurrencyException;

import java.math.BigDecimal;
import static com.e221.ecommerce.utils.AppConstants.AUTHORIZED_CURRENCIES;

public record Money(BigDecimal amount, String currency) {

    public Money {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessRuleException("Le montant ne peut pas être négatif.");
        }
        if (currency == null || !AUTHORIZED_CURRENCIES.contains(currency)) {
            throw new InvalidCurrencyException("La devise doit être FCFA ou EUR.");
        }
    }

    public Money add(Money other) {
        if (!this.currency.equals(other.currency())) {
            throw new BusinessRuleException("Impossible d'additionner des devises différentes : "
                    + this.currency + " et " + other.currency());
        }
        return new Money(this.amount.add(other.amount()), this.currency);
    }
}
