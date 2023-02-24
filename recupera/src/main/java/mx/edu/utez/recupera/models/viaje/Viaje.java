package mx.edu.utez.recupera.models.viaje;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.recupera.models.destino.Destino;
import mx.edu.utez.recupera.models.usuario.Usuario;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "viajes")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Viaje {
    /*ID del viaje (entero, clave primaria)
ID del usuario (entero, clave foránea)
ID del destino (entero, clave foránea)
Fecha de salida (fecha)
Fecha de regreso (fecha)
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date salida;
    private Date regreso;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "destino_id")
    @JsonIgnore
    private Destino destino;





}
