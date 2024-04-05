package co.edu.uniquindio.notas.controlador;


import co.edu.uniquindio.notas.modelo.Nota;
import co.edu.uniquindio.notas.modelo.NotaPrincipal;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;





// va a ser la controladora de la view
public class InicioControlador implements Initializable {

    // encapsulamos


    @FXML
    private TextField txtTitulo;


    @FXML

    private ComboBox<String> txtCategoria;


    @FXML
    private TextArea txtNota;

    @FXML
    private TableView<Nota> tablaNotas;


    @FXML
    private TableColumn<Nota, String> colTitulo;


    @FXML
    private TableColumn<Nota, String> colCategoria;


    @FXML
    private TableColumn<Nota, String> colTexto;


    @FXML
    private TableColumn<Nota, String> colFecha;

    private final NotaPrincipal notaPrincipal;

    // metodo constructor
    public InicioControlador() {
        notaPrincipal =new NotaPrincipal();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colTitulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        colCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));
        colTexto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaCreacion().toString()));
        txtCategoria.setItems( FXCollections.observableArrayList(notaPrincipal.listarCategorias()) );
    }


    // metodo para agregar una nota
    public void crearNota(ActionEvent e) throws Exception {

        try {
            notaPrincipal.agregarNota(txtTitulo.getText(), txtNota.getText(), txtCategoria.getValue(), LocalDateTime.now());
            mostrarAlerta("Nota creada correctamente", Alert.AlertType.INFORMATION);
            tablaNotas.setItems( FXCollections.observableArrayList(notaPrincipal.listarNotas()));
            txtTitulo.clear();
            txtNota.clear();
            txtCategoria.setValue(null);

        } catch (Exception ex){
            mostrarAlerta(ex.getMessage(), Alert.AlertType.ERROR);


        }

        tablaNotas.setItems( FXCollections.observableArrayList(notaPrincipal.listarNotas()));


    }


    private void mostrarAlerta(String mensaje, Alert.AlertType tipo){


        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();


    }








}
