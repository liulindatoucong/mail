package com.liulin.controller;

import com.liulin.utils.ControllerMaps;

public class MainController {

    public void initialize() {
        ControllerMaps.controllerMaps.put(this.getClass().getSimpleName(), this);
    }




}
