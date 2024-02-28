package com.bytebazaar.mapper;

import com.bytebazaar.models.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM productos WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "nombre"),
            @Result(property = "description", column = "descripcion"),
            @Result(property = "price", column = "precio"),
            @Result(property = "stock", column = "stock"),
    })
    Product findById(@Param("id") int id);

    @Select("SELECT * FROM productos")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "nombre"),
            @Result(property = "description", column = "descripcion"),
            @Result(property = "price", column = "precio"),
            @Result(property = "stock", column = "stock"),
    })
    List<Product> findAll();

    @Insert("INSERT INTO productos(nombre,descripcion,precio,stock) VALUES (#{name},#{description},#{price},#{stock})")
    int save(Product product);

    @Update("UPDATE productos SET nombre=#{name}, descripcion=#{description}, precio=#{price}, stock=#{stock} WHERE id=#{id}")
    int update(Product product);

    @Delete("DELETE FROM productos WHERE id = #{id}")
    int deleteById(@Param("id") int id);

    @Select("SELECT COUNT(*) FROM detalleventas WHERE id_producto = #{id};")
    int isProductDeletable(int id);
}
