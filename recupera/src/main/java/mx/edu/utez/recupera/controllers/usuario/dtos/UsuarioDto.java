package mx.edu.utez.recupera.controllers.usuario.dtos;

import lombok.*;
import mx.edu.utez.recupera.models.usuario.Usuario;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioDto {
    private Long id;
    private String name;
    private String email;
    private Date date;

    public Usuario parseToUsuario() {
        return new Usuario(getId(), getName(), getEmail(), getDate(),null);
    }

}
