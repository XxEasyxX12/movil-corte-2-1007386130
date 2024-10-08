package com.example.CRUD.Usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/usuario")
public class ProductController {

  public productServis productServis;

  @Autowired
    public ProductController(productServis productServis) {
      this.productServis = productServis;
    }

    @GetMapping
    public List<Usuario> getproduct(){
        return productServis.getproduct();
    }

    @PostMapping
  public ResponseEntity<Object> RegistrarProducto(@RequestBody Usuario usuario){
    return this.productServis.newProduct(usuario);

    }
    @PutMapping
  public ResponseEntity<Object> EditarProducto(@RequestBody Usuario usuario){
      return this.productServis.newProduct(usuario);
    }
  @DeleteMapping(path = "{usuarioid}")
  public ResponseEntity<Object> EliminarProducto(@PathVariable ("usuarioid")Long id){
     return this.productServis.EliminarProduct(id);
  }
}

