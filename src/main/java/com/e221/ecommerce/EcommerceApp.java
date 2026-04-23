package com.e221.ecommerce;

import com.e221.ecommerce.model.Money;
import com.e221.ecommerce.model.Product;
import com.e221.ecommerce.model.SKU;

import java.math.BigDecimal;

public class EcommerceApp {
    public static void main(String[] args) {

        System.out.println("=== DÉMONSTRATION ===");

        try {
            Product smartphone = new Product(
                    new SKU("TEC-987654"),
                    "iPhone 15",
                    new Money(new BigDecimal("2300"), "EUR")
            );
            System.out.println(" Produit Créé : " + smartphone);

            smartphone.applyDiscount(new BigDecimal("20"));
            System.out.println(" Après -20% : " + smartphone.getPrice().amount() + " EUR");

            System.out.println("\n--- Test piratage : Nom vide ---");
            new Product(new SKU("ABC-1234"), "", new Money(new BigDecimal("10"), "EUR"));

        } catch (Exception e) {
            System.out.println(" Une erreur est survenue : " + e.getMessage());
        }
    }
}