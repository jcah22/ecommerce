package com.julscode.ecommerce.controller;

import com.julscode.ecommerce.model.Producto;
import com.julscode.ecommerce.model.Usuario;
import com.julscode.ecommerce.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;



    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @GetMapping("")
    public String show(Model model) {
      // model.addAttribute("productos", productoService.find)
        return "productos/show";

    }

    @GetMapping("/create")
    public String create() {

        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto, Model model) {

        LOGGER.info("ESTE ES EL OBJETO  PRODUCTO {} ", producto);
        Usuario u = new Usuario(1,"","","","","","","", null, null);
        producto.setUsuario(u);


        productoService.save(producto);



        return "redirect:/productos";
    }

}
