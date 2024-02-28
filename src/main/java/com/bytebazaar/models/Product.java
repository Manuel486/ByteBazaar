package com.bytebazaar.models;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    @NotBlank(message = "Debe ingresar un nombre")
    private String name;
    @NotBlank(message = "Debe ingresar una descripción")
    private String description;
    @NotNull(message = "Debe ingresar el precio")
    @Min(value=1,message = "El valor minímo es 1")
    private Double price;
    @NotNull(message = "Debe ingresar el stock")
    @Min(value=1,message = "El valor minímo es 1")
    private int stock;

    public boolean matchesQuery(String query) {
        return Integer.toString(id).contains(query) ||
                description.toLowerCase().contains(query) ||
                name.toLowerCase().contains(query) ||
                Integer.toString(stock).contains(query);
    }
}
