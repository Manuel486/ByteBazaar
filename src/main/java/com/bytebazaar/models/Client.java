package com.bytebazaar.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private int id;
    @NotBlank(message = "Debe ingresar su nombre")
    private String name;
    @NotBlank(message = "Debe ingresar su apellido")
    private String lastname;
    @NotBlank(message = "Debe ingresar su dni")
    @Size(min = 8, max = 8,message = "El DNI debe tener 8 carácteres")
    private String dni;
    @NotBlank(message = "Debe ingresar su email")
    @Email
    private String email;
    @NotBlank(message = "Debe ingresar su dirección")
    private String address;
}
