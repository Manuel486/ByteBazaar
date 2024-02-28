package com.bytebazaar.controller;

import com.bytebazaar.models.Product;
import com.bytebazaar.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bazaar/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping({"/",""})
    public String findAll(@RequestParam(name = "query", required = false) String query, Model model){
        List<Product> products = productService.findAll();;
        List<String> theaders = Arrays.asList("ID","Nombre","Descripción","Precio","Stock");
        int quantityOfProducts = productService.quantityOfProducts(products);
        Product aboutToSellOut = productService.aboutToSellOut(products);
        Product expensiveProduct = productService.mostExpensiveProduct(products);
        products = productService.matchesQuery(products, query);


        model.addAttribute("quantityOfProducts",quantityOfProducts);
        model.addAttribute("aboutToSellOut" ,aboutToSellOut);
        model.addAttribute("expensiveProduct" ,expensiveProduct);
        model.addAttribute("entities",products);
        model.addAttribute("theaders",theaders);
        model.addAttribute("properties", List.of("id", "name", "description", "price", "stock"));


        return "pages/product/list-products";
    }

    @GetMapping("/new-product")
    public String productRegistrationForm(Model model){
        model.addAttribute("product", new Product());

        return "pages/product/new-product";
    }

    @PostMapping("/new-product")
    public String saveProduct(@Validated Product product, BindingResult bindingResult,RedirectAttributes redirect, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("product",product);
            return "pages/product/new-product";
        }

        productService.save(product);
        return "redirect:/bazaar/product";
    }

    @GetMapping("/{id}/edit")
    public String productEditForm(@PathVariable Integer id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "pages/product/new-product";
    }

    @PostMapping("/{id}/edit")
    public String updateProduct(@PathVariable Integer id,@Validated Product product,BindingResult bindingResult,RedirectAttributes redirect,Model model) {
        Product productDB = productService.findById(id);

        if(bindingResult.hasErrors()){
            model.addAttribute("product",product);
            return "pages/product/new-product";
        }

        productDB.setName(product.getName());
        productDB.setStock(product.getStock());
        productDB.setPrice(product.getPrice());
        productDB.setDescription(product.getDescription());


        productService.update(id,productDB);
        return "redirect:/bazaar/product";
    }

    @PostMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Integer id, RedirectAttributes redirect) {
        boolean deletable  = productService.isProductDeletable(id);
        if (deletable){
            productService.deleteById(id);
            redirect.addFlashAttribute("message", "Producto eliminado con éxito");
        } else {
            redirect.addFlashAttribute("message", "El producto no pudo ser eliminado porque esta siendo usado en una venta");
        }
        return "redirect:/bazaar/product";
    }
}

