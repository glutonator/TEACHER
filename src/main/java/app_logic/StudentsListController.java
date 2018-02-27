package app_logic;

import bd.Teacher;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mapping.OcenyKoncoweEntity;
import mapping.PrzedmiotyEntity;
import mapping.RealizacjeEntity;
import mapping.StudenciEntity;
import oracle.sql.NUMBER;

public class StudentsListController implements Initializable {

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Button button1;

    @FXML
    private TableView tableViewFinalDegree;

    @FXML
    private TableColumn<OcenyKoncoweEntity, String> tableViewFinalDegree_nr_index;

    @FXML
    private TableColumn<OcenyKoncoweEntity, String> tableViewFinalDegree_surname;

    @FXML
    private TableColumn<OcenyKoncoweEntity, String> tableViewFinalDegree_name;

    @FXML
    private TableColumn<OcenyKoncoweEntity, Number> tableViewFinalDegree_fdegree;


    private SubjectsFormController parent_controller;

    public void setParent_controller(SubjectsFormController parent_controller) {
        this.parent_controller = parent_controller;
    }

    private StudentsListController my_controller;

    public void setMy_controller(StudentsListController my_controller) {
        this.my_controller = my_controller;
    }

    private RealizacjeEntity realizacjeEntity_tmp;

    public void setRealizacjeEntity_tmp(RealizacjeEntity realizacjeEntity_tmp) {
        this.realizacjeEntity_tmp = realizacjeEntity_tmp;
    }

    public StudentsListController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //setup doubleclick on row in tableview
        tableViewFinalDegree.setRowFactory(tv -> {
            TableRow<OcenyKoncoweEntity> row = new TableRow<OcenyKoncoweEntity>();
            row.setOnMouseClicked((MouseEvent event) -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    OcenyKoncoweEntity rowData = row.getItem();
                    onDoubleClickWindow(rowData);
                }
            });
            return row ;
        });
    }


    public void setLabel(Label label, String text) {
        label.setText(text);
    }

    public void setAllLabels(RealizacjeEntity realizacjeEntity) {
        setLabel(label1,realizacjeEntity.getKodPrzedmiotu());
        setLabel(label2,String.valueOf(realizacjeEntity.getRok()));
        setLabel(label3,realizacjeEntity.getRodzajSemestru());
    }

    public void onClickButton() {
    }
    public void setTableViewFinalDegree(ArrayList<OcenyKoncoweEntity> final_degree) {
        ObservableList obList2 = FXCollections.observableList(final_degree);

        tableViewFinalDegree.setItems(obList2);
        tableViewFinalDegree_nr_index.setCellValueFactory(cellData  -> new ReadOnlyStringWrapper(cellData.getValue().getStudenciByIdStudenta().getNrAlbumu()));
        tableViewFinalDegree_surname.setCellValueFactory(cellData  -> new ReadOnlyStringWrapper(cellData.getValue().getStudenciByIdStudenta().getNazwisko()));
        tableViewFinalDegree_name.setCellValueFactory(cellData  -> new ReadOnlyStringWrapper(cellData.getValue().getStudenciByIdStudenta().getImie()));
        tableViewFinalDegree_fdegree.setCellValueFactory(cellData  -> new ReadOnlyDoubleWrapper(cellData.getValue().getOcenaKoncowa()));

    }

    public void onDoubleClickWindow (OcenyKoncoweEntity ocenyKoncoweEntity) {

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/app/degreesForm.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Llsta ocen");
            stage.setScene(new Scene(root1));
            stage.show();
            DegreesFormController controller = (DegreesFormController) fxmlLoader.getController();
            controller.setParent_controller(my_controller);
            controller.setMy_controller(controller);
            controller.setAllLabels(ocenyKoncoweEntity);
            controller.setOcenyEntity_tmp(ocenyKoncoweEntity);
            //event on closing window - update of tableview
            stage.setOnCloseRequest(e->controller.shutdown());
            controller.setTableViewDegree(Teacher.getInstance().listOceny(ocenyKoncoweEntity.getKodPrzedmiotu(),ocenyKoncoweEntity.getRok(),ocenyKoncoweEntity.getRodzajSemestru(),ocenyKoncoweEntity.getIdStudenta()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateTableView() {
        setTableViewFinalDegree(Teacher.getInstance().listOcenyKoncowe(realizacjeEntity_tmp.getKodPrzedmiotu(),realizacjeEntity_tmp.getRok(),realizacjeEntity_tmp.getRodzajSemestru()));
    }

}
