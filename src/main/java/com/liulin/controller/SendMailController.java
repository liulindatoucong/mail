package com.liulin.controller;

import com.liulin.pojo.Area;
import com.liulin.service.InitService;
import com.liulin.utils.ControllerMaps;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.util.List;
import java.util.stream.Collectors;

public class SendMailController {

    @FXML
    private ChoiceBox mailarea;

    private final InitService initService = new InitService();


    public void initialize() {
        ControllerMaps.controllerMaps.put(this.getClass().getSimpleName(), this);
        initArea();
    }

    private void initArea() {
        mailarea.getItems().clear();
        List<Area> areas = initService.getAllAreas();
        List<String> fullAreaNames = areas.stream().map(areaInfo -> areaInfo.getAreaname()+'_'+areaInfo.getChinesename()).collect(Collectors.toList());
        mailarea.getItems().addAll(fullAreaNames);
    }

    public void resetArea() {
        initArea();
    }


    private void initListener() {

    }


}
