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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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

    private SubjectsFormController my_controller;

    public void setMy_controller(SubjectsFormController parent_controller) {
        this.my_controller = parent_controller;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addToComboBox();

        //setup doubleclick on row in tableview with subjects
        tableViewSubjects.setRowFactory(tv -> {
            TableRow<RealizacjeEntity> row = new TableRow<RealizacjeEntity>();
            row.setOnMouseClicked((MouseEvent event) -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    RealizacjeEntity rowData = row.getItem();
                    onDoubleClickStudentsListWidnow(rowData);
                }
            });
            return row ;
        });

    }

    public void addToComboBox() {
        List<PrzedmiotyEntity> subject_list = Teacher.getInstance().listPrzedmioty();

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
        setLabel(label1,"Kod przedmiotu:  "+value.getKodPrzedmiotu());
        setLabel(label2,"Nazwa przedmiotu:  "+value.getNazwa());
        setLabel(label3,"Opis przedmiotu:  "+value.getOpis());
        setTableViewSubjects(value);
    }

    public void setLabel(Label label, String text) {
        label.setText(text);
    }

    public void setTableViewSubjects(PrzedmiotyEntity subject) {
        Collection<RealizacjeEntity> realizacjesByKodPrzedmiotu = subject.getRealizacjesByKodPrzedmiotu();

        ObservableList obList2 = FXCollections.observableList(new ArrayList<RealizacjeEntity>(realizacjesByKodPrzedmiotu));

        tableViewSubjects.setItems(obList2);
        tableViewSubjects_year.setCellValueFactory(cellData  -> new ReadOnlyLongWrapper(cellData.getValue().getRok()));
        tableViewSubjects_term.setCellValueFactory(cellData  -> new ReadOnlyStringWrapper(cellData.getValue().getRodzajSemestru()));

    }

    public void onDoubleClickStudentsListWidnow (RealizacjeEntity realizacjeEntity) {

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/app/studentsList.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Lista studentów");
            stage.setScene(new Scene(root1));
            stage.show();
            StudentsListController controller = (StudentsListController) fxmlLoader.getController();
            controller.setParent_controller(my_controller);
            controller.setMy_controller(controller);
            controller.setAllLabels(realizacjeEntity);
            controller.setRealizacjeEntity_tmp(realizacjeEntity);
            controller.setTableViewFinalDegree(Teacher.getInstance().listOcenyKoncowe(realizacjeEntity.getKodPrzedmiotu(),realizacjeEntity.getRok(),realizacjeEntity.getRodzajSemestru()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
