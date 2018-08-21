package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

import java.io.IOException;

/**
 * Created by sharov on 24.12.2015.
 */
public class Aggregator {
    public static void main(String[] args) throws IOException {
        HtmlView view = new HtmlView();
        Provider[] providers = new Provider[]{
                new Provider(new HHStrategy()),
                new Provider(new MoikrugStrategy())};
        view.setController(new Controller(new Model(view, providers)));
        view.userCitySelectEmulationMethod();
    }
}
