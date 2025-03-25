package com.google.utils.config;

import java.util.Optional;

public enum ConfigProperties {
    BASE_URL("Google.baseUrl"),

    BROWSER("browser"),
    PAGE_LOAD_STRATEGY("pageLoadStrategy");

    private final String key;

    ConfigProperties(String key) {
        this.key = key;
    }


    public String getValue() {
        return Optional.ofNullable(System.getenv(key))
                .filter(value -> !value.isBlank())
                .orElseGet(() -> ConfigReader.getConfigProperty(key));
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}

