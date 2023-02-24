package mx.edu.utez.recupera.models.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.recupera.models.destino.Destino;
import mx.edu.utez.recupera.models.viaje.Viaje;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Usuario {
    /*ID del usuario (entero, clave primaria)
Nombre del usuario (texto)
Correo electrónico (texto)
Fecha de nacimiento (fecha)
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Date date;


    @OneToMany(mappedBy = "usuario")
    private List<Viaje> viajes;

}
