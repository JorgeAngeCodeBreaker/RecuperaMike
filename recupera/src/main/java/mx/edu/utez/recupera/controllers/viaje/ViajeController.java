package mx.edu.utez.recupera.controllers.viaje;

import mx.edu.utez.recupera.controllers.viaje.dtos.ViajeDto;
import mx.edu.utez.recupera.services.viaje.ViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api-recupera/viaje")
@CrossOrigin(origins = {"*"})
public class ViajeController {
    @Autowired
    private ViajesService service;

    @GetMapping("/")
    public ResponseEntity getAll() {
        return new ResponseEntity(this.service.getAll(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable("id") Long id) {
        System.out.println(id);
        return new ResponseEntity(this.service.getOne(id)
                , HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity save(@RequestBody ViajeDto viaje) {
        return new ResponseEntity(this.service.insert(viaje.parseToViaje()), HttpStatus.CREATED);
    }

    @PutMapping ("/")
    public ResponseEntity update(@RequestBody ViajeDto viaje) {
        return new ResponseEntity(this.service.update(viaje.parseToViaje()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return new ResponseEntity(this.service.delete(id), HttpStatus.OK);
    }
}
