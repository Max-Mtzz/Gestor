package com.jmc.gestor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class HelloController {
    @FXML private TableView<Tarea> tablaTareas;
    @FXML private TableColumn<Tarea, Integer> colId;
    @FXML private TableColumn<Tarea, String> colTitulo;
    @FXML private TableColumn<Tarea, String> colDescripcion;
    @FXML private TableColumn<Tarea, String> colPrioridad;
    @FXML private TableColumn<Tarea, LocalDate> colFechaLimite;

    @FXML private TextField txtId;
    @FXML private TextField txtTitulo;
    @FXML private TextArea txtDescripcion;
    @FXML private ComboBox<String> cmbPrioridad;
    @FXML private DatePicker dateFechaLimite;

    private final ObservableList<Tarea> listaTareas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getId()).asObject());
        colTitulo.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTitulo()));
        colDescripcion.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescripcion()));
        colPrioridad.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getPrioridad()));
        colFechaLimite.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getFechaLimite()));

        cmbPrioridad.getItems().addAll("Alta", "Media", "Baja");

        tablaTareas.setItems(listaTareas);

        tablaTareas.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txtId.setText(String.valueOf(newSel.getId()));
                txtTitulo.setText(newSel.getTitulo());
                txtDescripcion.setText(newSel.getDescripcion());
                cmbPrioridad.setValue(newSel.getPrioridad());
                dateFechaLimite.setValue(newSel.getFechaLimite());
            }
        });
    }

}