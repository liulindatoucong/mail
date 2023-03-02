package com.liulin.controller;

import com.liulin.pojo.Area;
import com.liulin.service.AreaService;
import com.liulin.utils.ControllerMaps;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.apache.commons.lang3.StringUtils;


/**
 * 添加区域的控制器
 */
public class AddAreaController {

    @FXML
    private TextField areaName;

    @FXML
    private Button areaSave;

    @FXML
    private TextField chineseName;

    @FXML
    private Label warnInfo;

    private final AreaService areaService = new AreaService();

    public void initialize() {
        ControllerMaps.controllerMaps.put(this.getClass().getSimpleName(), this);

        areaSave.setOnAction(event -> {
            String areaNameValue = areaName.getText();
            String chineseNameValue = chineseName.getText();
            if(StringUtils.isEmpty(areaName.getText())) {
                areaName.requestFocus();
                warnInfo.setTextFill(Color.RED);
                warnInfo.setText("地区名称不能为空");
                return;
            }
            if(StringUtils.isEmpty(chineseName.getText())) {
                chineseName.requestFocus();
                warnInfo.setTextFill(Color.RED);
                warnInfo.setText("地区中文名称不能为空");
                return;
            }
            areaNameValue = StringUtils.trim(areaNameValue);
            Area area = new Area();
            area.setAreaname(areaNameValue);
            area.setChinesename(chineseNameValue);
            try {
                areaService.addOneArea(area);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误提示");
                alert.setContentText(e.getMessage());
                alert.show();
                return;
            }

            warnInfo.setTextFill(Color.GREEN);
            warnInfo.setText("保存地区成功！");

            ((CompanyController)ControllerMaps.controllerMaps.get("CompanyController")).resetArea();
            ((SendMailController)ControllerMaps.controllerMaps.get("SendMailController")).resetArea();

        });
    }



}
