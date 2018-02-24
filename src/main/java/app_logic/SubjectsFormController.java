package app_logic;


import bd.Teacher;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import mapping.PrzedmiotyEntity;
import javafx.util.Callback;
import mapping.RealizacjeEntity;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable.*;
import java.util.ResourceBundle;


public class SubjectsFormController implements Initializable {

    @FXML
    private ComboBox comboBoxSubjects;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private TableView tableViewSubjects;
    @FXML
    private TableColumn <RealizacjeEntity,Number> tableViewSubjects_year;
    @FXML
    private TableColumn <RealizacjeEntity,String> tableViewSubjects_term;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addToComboBox();
    }

    public void addToComboBox() {
        List<PrzedmiotyEntity> subject_list = Teacher.getInstance().listPrzedmioty();
        System.out.println("ttttest");

        ObservableList obList = FXCollections.observableList(subject_list);

        comboBoxSubjects.setItems(obList);
        comboBoxSubjects.setCellFactory(new Callback<ListView, ListCell>() {
            @Override
            public ListCell call(ListView param) {
                return new ListCell() {
                    @Override
                    protected void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(((PrzedmiotyEntity)item).getKodPrzedmiotu());
                        }
                    }
                };
            }
        });
    }

    public void onClickComboBox() {
        PrzedmiotyEntity value = (PrzedmiotyEntity) comboBoxSubjects.getValue();
        comboBoxSubjects.setPromptText(value.getKodPrzedmiotu());
        comboBoxSubjects.setAccessibleText(value.getKodPrzedmiotu());
        System.out.println(value.getKodPrzedmiotu());
        setLabel(label1,value.getKodPrzedmiotu());
        setLabel(label2,value.getNazwa());
        setLabel(label3,value.getOpis());
        setTableViewSubjects(value);
    }

    public void setLabel(Label label, String text) {
        label.setText(text);
    }

    public void setTableViewSubjects(PrzedmiotyEntity subject) {
        Collection<RealizacjeEntity> realizacjesByKodPrzedmiotu = subject.getRealizacjesByKodPrzedmiotu();
        for ( RealizacjeEntity yyy: realizacjesByKodPrzedmiotu) {
            System.out.println(yyy);
        }
        ObservableList obList2 = FXCollections.observableList(new ArrayList<RealizacjeEntity>(realizacjesByKodPrzedmiotu));

        tableViewSubjects.setItems(obList2);
        tableViewSubjects_year.setCellValueFactory(cellData  -> new ReadOnlyLongWrapper(cellData.getValue().getRok()));
        tableViewSubjects_term.setCellValueFactory(cellData  -> new ReadOnlyStringWrapper(cellData.getValue().getRodzajSemestru()));

    }
}
