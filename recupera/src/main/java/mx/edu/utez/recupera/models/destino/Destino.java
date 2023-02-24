package mx.edu.utez.recupera.models.destino;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.recupera.models.usuario.Usuario;

import javax.persistence.*;
@Entity
@Table(name = "destinos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Destino {
    /*ID del destino (entero, clave primaria)
Nombre del destino (texto)
Descripción (texto)
Precio (decimal)
Calificación (decimal)
Disponibilidad (booleano)
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Double rating;
    private Boolean availability;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

}
