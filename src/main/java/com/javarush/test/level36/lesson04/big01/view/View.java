package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

/**
 * Created by sharov on 15.03.2016.
 */
public interface View {
    void refresh(ModelData modelData);
    void setController(Controller controller);
}
