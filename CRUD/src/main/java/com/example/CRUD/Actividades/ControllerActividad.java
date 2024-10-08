package com.example.CRUD.Actividades;

import com.example.CRUD.Usuario.Usuario;
import com.example.CRUD.Usuario.productServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividad")
public class ControllerActividad {

    public ServiciosActividad ServiciosActividad;

    @Autowired
    public ControllerActividad(ServiciosActividad ServiciosActividad) {
        this.ServiciosActividad = ServiciosActividad;
    }

    @GetMapping
    public List<Actividades> getpActividad(){
        return ServiciosActividad.getActividades();
    }

    @PostMapping
    public ResponseEntity<Object> RegistrarActividad(@RequestBody Actividades Actividad){
        return this.ServiciosActividad.newActividad(Actividad);

    }
    @PutMapping
    public ResponseEntity<Object> EditarActividad(@RequestBody Actividades Actividad){
       return this.ServiciosActividad.newActividad(Actividad);
    }
    @DeleteMapping(path = "{usuarioid}")
    public ResponseEntity<Object> EliminarActividad(@PathVariable ("actividadid")Long id){
       return this.ServiciosActividad.EliminarActividad(id);
    }
}
