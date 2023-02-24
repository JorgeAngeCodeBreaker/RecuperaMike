package mx.edu.utez.recupera.controllers.usuario;

import mx.edu.utez.recupera.controllers.usuario.dtos.UsuarioDto;
import mx.edu.utez.recupera.models.usuario.Usuario;
import mx.edu.utez.recupera.services.usuario.UsuarioService;
import mx.edu.utez.recupera.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-recupera/usuario")
@CrossOrigin(origins = {"*"})
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(
            @PathVariable("id") Long id
    ) {
        System.out.println(id);
        return new ResponseEntity( this.service.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity save(
            @RequestBody UsuarioDto usuario
    ) {
        return new ResponseEntity( this.service.insert(usuario.parseToUsuario()), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity update(
            @RequestBody UsuarioDto usuario
    ) {
        return new ResponseEntity( this.service.update(usuario.parseToUsuario()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity( this.service.delete(id), HttpStatus.OK);
    }
}
