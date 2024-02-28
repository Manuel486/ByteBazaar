package com.bytebazaar.mapper;

import com.bytebazaar.models.Client;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClientMapper {

    @Select("SELECT * FROM clientes WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "nombre"),
            @Result(property = "lastname", column = "apellidos"),
            @Result(property = "dni", column = "dni"),
            @Result(property = "email", column = "email"),
            @Result(property = "address", column = "direccion"),
    })
    Client findById(@Param("id") int id);

    @Select("SELECT * FROM clientes")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "nombre"),
            @Result(property = "lastname", column = "apellidos"),
            @Result(property = "dni", column = "dni"),
            @Result(property = "email", column = "email"),
            @Result(property = "address", column = "direccion"),
    })
    List<Client> findAll();

    @Insert("INSERT INTO clientes(nombre,apellidos,dni,email,direccion) VALUES (#{name}, #{lastname}, #{dni}, #{email}, #{address})")
    int save(Client client);

    @Update("UPDATE clientes SET nombre=#{name}, apellidos=#{lastname}, dni=#{dni}, email=#{email}, direccion=#{address} WHERE id=#{id}")
    int update(Client client);

    @Delete("DELETE FROM clientes WHERE id = #{id}")
    int deleteById(@Param("id") int id);

    @Select("SELECT COUNT(*) FROM ventas WHERE id_cliente = #{id};")
    int isClientDeletable(int id);

}
