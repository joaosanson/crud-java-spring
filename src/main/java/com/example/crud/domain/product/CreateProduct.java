package com.example.crud.domain.product;

public record CreateProduct(String name, Float price) {
    public CreateProduct {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (price == null || price.doubleValue() <= 0) {
            throw new IllegalArgumentException("Price cannot be null or less than or equal to zero");
        }
    }
}
