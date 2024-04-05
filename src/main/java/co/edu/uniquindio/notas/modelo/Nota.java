package co.edu.uniquindio.notas.modelo;

import javafx.fxml.FXML;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@ToString
@Setter
@Getter
@AllArgsConstructor


public class Nota {
    // encapsular los datos
    private String id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private LocalDateTime fechaCreacion;
    private LocalDateTime recordatorio;



}
