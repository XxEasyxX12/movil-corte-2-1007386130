package com.example.CRUD.Actividades;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ServiciosActividad {

    HashMap<String,Object> informe;

    private final RepositorioActividad repositorioActividad;

    @Autowired
    public ServiciosActividad(RepositorioActividad repositorioActividad) {
        this.repositorioActividad = repositorioActividad;
    }

    public List<Actividades> getActividades(){
        return repositorioActividad.findAll();
    }

    public ResponseEntity<Object> newActividad(Actividades actividade) {

        Optional<Actividades> buscar = repositorioActividad.findByNombre(actividade.getNombre());
        informe = new HashMap<>();

        if (buscar.isPresent() && actividade.getCodigo() == null) {
            informe.put("Error",true);
            informe.put("Message","Ya Hay Un actividad Con Ese Nombre");
            return new ResponseEntity<>(
                    informe,
                    HttpStatus.CONFLICT
            );

        }
        informe.put("message","Se Guardó Correctamente");
        if (actividade != null) {
            informe.put("message","Se Actualizó Correctamente");
        }
        repositorioActividad.save(actividade);
        informe.put("Datos",actividade);
        return new ResponseEntity<>(
                informe,
                HttpStatus.CREATED);
    }

    public ResponseEntity<Object> EliminarActividad(Long id){
        informe = new HashMap<>();
        Boolean existe = this.repositorioActividad.existsById(id);
        if (!existe) {
            informe.put("Error",true);
            informe.put("Message","No Existe La Actividad Con Ese ID");
            return new ResponseEntity<>(
                    informe,
                    HttpStatus.CONFLICT
            );
        }
        repositorioActividad.deleteById(id);
        informe.put("Message","La Actividad Se Elimino Correctamente");
        return new ResponseEntity<>(
                informe,
                HttpStatus.ACCEPTED
        );
    }


}






