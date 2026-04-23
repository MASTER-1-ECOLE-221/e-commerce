package com.e221.ecommerce.model;

import com.e221.ecommerce.exception.BusinessRuleException;

import static com.e221.ecommerce.utils.AppConstants.SKU_PATTERN;

public record SKU(String value) {

    public SKU {
        if (value == null || value.isBlank()) {
            throw new BusinessRuleException("Le SKU ne doit pas être null.");
        }

        if (!SKU_PATTERN.matcher(value).matches()) {
            throw new BusinessRuleException("Le SKU doit respecter le format 'AAA-9999' ou 'AAA-999999'. Reçu : " + value);
        }
    }
}
