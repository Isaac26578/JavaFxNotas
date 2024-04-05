package co.edu.uniquindio.notas.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class NotaPrincipal {

    // atributos encapsulados
    private ArrayList<Nota> notas;

    // constructor vacio

    public NotaPrincipal() {
        // inicializamos el arraylist
        notas = new ArrayList<>();

    }

    // Metodo para agregar una nueva nota

    public void agregarNota (String titulo, String decsripcion, String categoria, LocalDateTime recordatorio) throws Exception {

        // verificamos que ningun campo este vacio para crear el objeto
        if (titulo== null || titulo.isBlank()){
            // lanzamos una excepcion
            throw new Exception("Todos los campos son obligatorios");

        }

        // verificamos la descripcion
        if (decsripcion == null || decsripcion.isBlank()){
            // lanzamos la excepcion
            throw new Exception("Todos los campos son obligatorios");

        }

        // verificamos la categoria
        if (categoria== null || categoria.isBlank()){
            // lanzamos la excepcion
            throw new Exception("Todos los campos son obligatorios");

        }

        // veridcamos la fecha
        if (recordatorio.isBefore(LocalDateTime.now())){
            // lanzamos la excepcion
            throw new Exception("No puede ser menor a la fecha actual");

        }

        // vamos a crear el objeto
         Nota nota = Nota.builder()
                 .id(UUID.randomUUID().toString())
                 .titulo(titulo)
                 .descripcion(decsripcion)
                 .categoria(categoria)
                 .recordatorio(recordatorio)
                 .fechaCreacion(LocalDateTime.now())
                 .build();

        // lo añadimos a nuestra lista de notas {
        notas.add(nota);
    }


    // metodo para listar categorias
    public ArrayList<String> listarCategorias (){

        // creamos el arrayList
        ArrayList<String> categorias = new ArrayList<>();
        categorias.add("Trabajo");
        categorias.add("Estudio");
        categorias.add("Personal");

        return categorias;
    }


    // metodo para listar notas
    public ArrayList<Nota> listarNotas(){
        return notas;
    }


} // ultimo
