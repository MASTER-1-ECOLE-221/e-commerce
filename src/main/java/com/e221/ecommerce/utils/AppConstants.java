package com.e221.ecommerce.utils;

import java.util.Set;
import java.util.regex.Pattern;

public class AppConstants {
    public AppConstants() {}

    public static final Set<String> AUTHORIZED_CURRENCIES = Set.of("FCFA", "EUR");
    public static final Pattern SKU_PATTERN = Pattern.compile("^[A-Z]{3}-\\d{4,6}$");
}
