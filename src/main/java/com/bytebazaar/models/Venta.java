package com.bytebazaar.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWarDeployment;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@ConditionalOnNotWarDeployment
public class Venta {
    private int id;
    private Date fecha;
    private int id_cliente;
    private Double total;
}
