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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mapping.OcenyEntity;
import mapping.OcenyKoncoweEntity;
import mapping.OcenyKoncoweEntityPK;
import mapping.RealizacjeEntity;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DegreesFormController implements Initializable {

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private TableView tableViewDegrees;

    @FXML
    private TableColumn<OcenyEntity, String> tableViewDegrees_1;

    @FXML
    private TableColumn<OcenyEntity, Number> tableViewDegrees_2;

    @FXML
    private TableColumn<OcenyEntity, Number> tableViewDegrees_3;

    @FXML
    private TableColumn<OcenyEntity, String> tableViewDegrees_4;


    private OcenyKoncoweEntity ocenyKoncoweEntity;

    private StudentsListController parent_controller;

    public void setParent_controller(StudentsListController parent_controller) {
        this.parent_controller = parent_controller;
    }

    public StudentsListController getParent_controller() {
        return parent_controller;
    }

    private DegreesFormController my_controller;

    public void setMy_controller(DegreesFormController my_controller) {
        this.my_controller = my_controller;
    }

    public void setOcenyEntity_tmp(OcenyKoncoweEntity ocenyKoncoweEntity) {
        this.ocenyKoncoweEntity = ocenyKoncoweEntity;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //setup doubleclick on row in tableview
        tableViewDegrees.setRowFactory(tv -> {
            TableRow<OcenyEntity> row = new TableRow<OcenyEntity>();
            row.setOnMouseClicked((MouseEvent event) -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    OcenyEntity rowData = row.getItem();
                    onDoubleClickWindow(rowData);
                }
            });
            return row ;
        });
    }

    public void setLabel(Label label, String text) {
        label.setText(text);
    }

    public void setAllLabels(OcenyKoncoweEntity ocenyKoncoweEntity) {
        setLabel(label1,"Nr Albumu:  " + ocenyKoncoweEntity.getStudenciByIdStudenta().getNrAlbumu());
        setLabel(label2,"Nazwisko:  " + ocenyKoncoweEntity.getStudenciByIdStudenta().getNazwisko());
        setLabel(label3,"Imię:  "+ocenyKoncoweEntity.getStudenciByIdStudenta().getImie());
    }

    public void setTableViewDegree(ArrayList<OcenyEntity> final_degree) {
        ObservableList obList2 = FXCollections.observableList(final_degree);

        tableViewDegrees.setItems(obList2);
        tableViewDegrees_1.setCellValueFactory(cellData  -> new ReadOnlyStringWrapper(cellData.getValue().getTypyOcenByIdTypuOceny().getTemat()));
        tableViewDegrees_2.setCellValueFactory(cellData  -> new ReadOnlyLongWrapper(cellData.getValue().getTypyOcenByIdTypuOceny().getWaga()));
        tableViewDegrees_3.setCellValueFactory(cellData  -> new ReadOnlyDoubleWrapper(cellData.getValue().getWartosc()));
        tableViewDegrees_4.setCellValueFactory(cellData  -> new ReadOnlyStringWrapper(cellData.getValue().getKomentarz()));

    }
    public void onDoubleClickWindow (OcenyEntity ocenyEntity) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/app/updateDegreeForm.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Zmiana oceny");
            stage.setScene(new Scene(root1));
            stage.show();
            updateDegreeFormController controller = (updateDegreeFormController) fxmlLoader.getController();
            controller.setParent_controller(my_controller);
            controller.setMy_controller(controller);
            controller.setAllLabels(ocenyEntity);
            controller.setOcenyEntity_tmp(ocenyEntity);

            //controller.setTableViewDegree(Teacher.getInstance().listOceny(ocenyKoncoweEntity.getKodPrzedmiotu(),ocenyKoncoweEntity.getRok(),ocenyKoncoweEntity.getRodzajSemestru(),ocenyKoncoweEntity.getIdStudenta()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTableView() {
        System.out.println("cos sie dzieje");
        setTableViewDegree(Teacher.getInstance().listOceny(ocenyKoncoweEntity.getKodPrzedmiotu(),ocenyKoncoweEntity.getRok(),ocenyKoncoweEntity.getRodzajSemestru(),ocenyKoncoweEntity.getIdStudenta()));
        //ObservableList<OcenyEntity> data = FXCollections.observableList(ocenyEntity_tmp);
        //tableViewDegrees.setItems(data);
    }

    public void updateAverageInFinalDegree() {
        double average =Teacher.getInstance().averageOcenyEntity(ocenyKoncoweEntity);
        System.out.println(average);

        OcenyKoncoweEntityPK ocenyKoncoweEntityPK=new OcenyKoncoweEntityPK();
        ocenyKoncoweEntityPK.setIdStudenta(ocenyKoncoweEntity.getIdStudenta());
        ocenyKoncoweEntityPK.setKodPrzedmiotu(ocenyKoncoweEntity.getKodPrzedmiotu());
        ocenyKoncoweEntityPK.setRok(ocenyKoncoweEntity.getRok());
        ocenyKoncoweEntityPK.setRodzajSemestru(ocenyKoncoweEntity.getRodzajSemestru());

        Teacher.getInstance().updateFinalDegree(ocenyKoncoweEntityPK,average);

    }

    public void shutdown() {
        System.out.println("to jest tottttttttt");
        parent_controller.updateTableView();
    }
}
