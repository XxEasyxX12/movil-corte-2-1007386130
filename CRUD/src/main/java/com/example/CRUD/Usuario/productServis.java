package com.example.CRUD.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import java.util.Optional;

@Service
public class productServis {

    HashMap<String,Object> datos;

    private final productRepositorio productRepositorio;

    @Autowired
    public productServis(productRepositorio productRepositorio) {
        this.productRepositorio = productRepositorio;
    }

    public List<Usuario> getproduct() {
        return productRepositorio.findAll();
    }


    public ResponseEntity<Object> newProduct(Usuario product) {

        Optional<Usuario> buscar = productRepositorio.findByNombre(product.getNombre());
         datos = new HashMap<>();

        if (buscar.isPresent() && product.getId() == null) {
            datos.put("Error",true);
            datos.put("Message","Ya Hay Un Usuario Con Ese Nombre");
             return new ResponseEntity<>(
                     datos,
                    HttpStatus.CONFLICT
            );

        }
        datos.put("message","Se Guardó Correctamente");
        if (product.getId() != null) {
            datos.put("message","Se Actualizó Correctamente");
        }
        productRepositorio.save(product);
        datos.put("Datos",product);
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED);
    }

    public ResponseEntity<Object> EliminarProduct(Long id){
        datos = new HashMap<>();
       Boolean existe = this.productRepositorio.existsById(id);
       if (!existe) {
           datos.put("Error",true);
           datos.put("Message","No Existe El Usuario Con Ese ID");
           return new ResponseEntity<>(
                   datos,
                   HttpStatus.CONFLICT
           );
       }
       productRepositorio.deleteById(id);
        datos.put("Message","El Usuario Se Elimino Correctamente");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }

}


