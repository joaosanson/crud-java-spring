package com.example.crud.domain.product;

public record UpdateProduct(String id, String name, Float price) {
    public UpdateProduct {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id cannot be null or empty");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (price == null || price.doubleValue() <= 0) {
            throw new IllegalArgumentException("Price cannot be null or less than or equal to zero");
        }
    }
}
