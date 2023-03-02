package com.liulin.controller;

import com.liulin.pojo.Area;
import com.liulin.pojo.Company;
import com.liulin.service.CompanyService;
import com.liulin.service.InitService;
import com.liulin.utils.ControllerMaps;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CompanyController {

    @FXML
    private Button saveCompany;
    @FXML
    private Button resetCompany;
    @FXML
    private TextField companyName;
    @FXML
    private TextArea companyEmails;
    @FXML
    private TextArea companyUrl;
    @FXML
    private TextArea companyLocations;
    @FXML
    private TextArea companyTelephones;
    @FXML
    private TextField companyWeixin;
    @FXML
    private TextField companyWeChat;
    @FXML
    private TextArea companyNote;
    @FXML
    private ChoiceBox<String> area;

    @FXML
    private Button addAreaDialog;

    private final InitService initService = new InitService();

    private final CompanyService companyService = new CompanyService();


    public void initialize() {
        ControllerMaps.controllerMaps.put(this.getClass().getSimpleName(), this);
        initArea();
        initListener();
    }

    //初始化地区数据
    private void initArea() {
        area.getItems().clear();
        List<Area> areas = initService.getAllAreas();
        List<String> fullAreaNames = areas.stream().map(areaInfo -> areaInfo.getAreaname()+'_'+areaInfo.getChinesename()).collect(Collectors.toList());
        area.getItems().addAll(fullAreaNames);
    }


    public void resetArea() {
        initArea();
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

        saveCompany.setOnAction(event -> {
            String areaname = area.getValue();
            String companyNameStr = companyName.getText();
            String companyEmailsStr = companyEmails.getText();
            String companyUrlStr = companyUrl.getText();
            String companyLocationsStr = companyLocations.getText();
            String companyTelephonesStr = companyTelephones.getText();
            String companyWeixinStr  = companyWeixin.getText();
            String companyWeChatStr = companyWeChat.getText();
            String companyNoteStr = companyNote.getText();

            if(StringUtils.isEmpty(areaname)||StringUtils.isEmpty(companyNameStr)||StringUtils.isEmpty(companyEmailsStr)
            ||StringUtils.isEmpty(companyNameStr)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("地区，公司名称，公司邮箱，公司网址不能为空！");
                alert.show();
                return;
            }
            Company company = new Company();
            company.setName(companyNameStr);
            company.setEmails(companyEmailsStr);
            company.setUrl(companyUrlStr);
            company.setLocations(companyLocationsStr);
            company.setTelephones(companyTelephonesStr);
            company.setWeixin(companyWeixinStr);
            company.setWeChat(companyWeChatStr);
            company.setNote(companyNoteStr);
            company.setAreaname(areaname.split("_")[0]);
            Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
            try {
                companyService.addCompany(company);
                alertInfo.setContentText("保存公司信息成功！");
            }catch (Exception e) {
                alertInfo.setContentText(e.getMessage());
                alertInfo.setAlertType(Alert.AlertType.WARNING);
            }
            alertInfo.show();
        });

        resetCompany.setOnAction(event -> {
            companyName.setText(null);
            companyEmails.setText(null);
            companyUrl.setText(null);
            companyLocations.setText(null);
            companyTelephones.setText(null);
            companyWeixin.setText(null);
            companyWeChat.setText(null);
            companyNote.setText(null);
        });

    }
}
