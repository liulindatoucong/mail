package com.liulin.controller;

import com.liulin.pojo.Area;
import com.liulin.service.InitService;
import com.liulin.utils.ControllerMaps;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MainController {
    @FXML
    private ChoiceBox<String> area;

    @FXML
    private ChoiceBox<String> mailarea;

    @FXML
    private Button addAreaDialog;

    private final InitService initService = new InitService();
    public void initialize() {
        ControllerMaps.controllerMaps.put(this.getClass().getSimpleName(), this);
        initArea();
        initListener();
    }

    private void initListener() {
        //添加区域弹出框事件
        addAreaDialog.setOnAction(event -> {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("增加地区");
            try {
                Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/addarea.fxml")));
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误提示");
                alert.setContentText(e.getMessage());
                alert.show();
            }
        });

    }


    //初始化地区数据
    private void initArea() {
        area.getItems().clear();
        mailarea.getItems().clear();
        List<Area> areas = initService.getAllAreas();
        List<String> fullAreaNames = areas.stream().map(areaInfo -> areaInfo.getAreaname()+'_'+areaInfo.getChinesename()).collect(Collectors.toList());
        area.getItems().addAll(fullAreaNames);
        mailarea.getItems().addAll(fullAreaNames);
    }

    public void resetArea() {
        initArea();
    }
}
