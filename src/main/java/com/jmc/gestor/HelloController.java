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
}