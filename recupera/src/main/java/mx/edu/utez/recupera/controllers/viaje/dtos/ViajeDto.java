package mx.edu.utez.recupera.controllers.viaje.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.recupera.models.usuario.Usuario;
import mx.edu.utez.recupera.models.viaje.Viaje;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ViajeDto {
        /*ID del viaje (entero, clave primaria)
ID del usuario (entero, clave foránea)
ID del destino (entero, clave foránea)
Fecha de salida (fecha)
Fecha de regreso (fecha)
*/
    private Long id;

    private Date salida;
    private Date regreso;

    public Viaje parseToViaje(){
        return new Viaje(getId(),
                getSalida(),getRegreso(), null, null);
    }

}
