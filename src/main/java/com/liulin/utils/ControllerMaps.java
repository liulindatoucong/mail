package com.liulin.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有的controller存储地点，因为没有找到controller组件间通信的好方法，就暂时用这个方式。
 */
public class ControllerMaps {
    public static final Map<String, Object> controllerMaps = new HashMap<String, Object>();
}
