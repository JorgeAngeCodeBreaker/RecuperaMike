package mx.edu.utez.recupera.services.usuario;

import mx.edu.utez.recupera.models.usuario.Usuario;
import mx.edu.utez.recupera.models.usuario.UsuarioRepository;
import mx.edu.utez.recupera.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;
    public Response getAll() {
        return new Response<List<Usuario>>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
    public Response getOne(Long id) {
        if (this.repository.existsById(id))
            return new Response<Usuario>(
                    this.repository.findById(id).get(),
                    false,
                    200,
                    "OK"
            );
        return new Response(
                null,
                true,
                200,
                "No existe este usuario"
        );
    }
    public Response insert(Usuario usuario) {
        if (this.repository.existsByName(usuario.getName()))
            return new Response(
                    null,
                    true,
                    200,
                    "Ya existe un usuario con este nombre"
            );
        return new Response(
                this.repository.saveAndFlush(usuario),
                false,
                200,
                "Se registro usuario correctamente"
        );
    }
    public Response update(Usuario usuario) {
        if (this.repository.existsById(usuario.getId()))
            return new Response(
                    this.repository.saveAndFlush(usuario),
                    false,
                    200,
                    "Se actualizo usuario correctamente"
            );
        return new Response(
                null,
                true,
                200,
                "No existe este usuario"
        );
    }
    public Response delete(Long id){
        if( this.repository.existsById(id)){
            this.repository.deleteById(id);
            return new Response(
                    null,
                    false,
                    200,
                    "Se elimino usuario correctamente"
            );
        }
        return new Response(
                null,
                true,
                200,
                "No existe este usuario"
        );

    }


}
