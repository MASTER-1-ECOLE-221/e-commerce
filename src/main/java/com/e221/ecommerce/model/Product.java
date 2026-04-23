package com.e221.ecommerce.model;

import com.e221.ecommerce.exception.BusinessRuleException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

public class Product {
    private final UUID id;
    private final SKU sku;
    private final String name;
    private Money price;

    public Product(SKU sku, String name, Money price) {
        if (sku == null) throw new BusinessRuleException("Le SKU est obligatoire.");
        if (name == null || name.isBlank()) throw new BusinessRuleException("Le nom ne peut pas être vide.");
        if (price == null) throw new BusinessRuleException("Le prix est obligatoire.");

        this.id = UUID.randomUUID();
        this.sku = sku;
        this.name = name;
        this.price = price;
    }


    public void applyDiscount(BigDecimal percentage) {
        if (percentage == null ||
                percentage.compareTo(new BigDecimal("0.1")) < 0 ||
                percentage.compareTo(new BigDecimal("100")) > 0) {
            throw new BusinessRuleException("La remise doit être comprise entre 0.1% et 100%.");
        }

        BigDecimal discountFactor = BigDecimal.ONE.subtract(
                percentage.divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP)
        );

        BigDecimal newAmount = this.price.amount().multiply(discountFactor);

        this.price = new Money(newAmount, this.price.currency());
    }

    public UUID getId() { return id; }
    public SKU getSku() { return sku; }
    public String getName() { return name; }
    public Money getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("Produit: %s | SKU: %s | Prix: %s %s | ID: %s",
                name, sku.value(), price.amount(), price.currency(), id);
    }
}
