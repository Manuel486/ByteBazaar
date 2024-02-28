package com.bytebazaar.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVenta {
    private int id;
    private int id_venta;
    private int id_producto;
    private int cantidad;
    private Double precio;
    private Double importe;
}
