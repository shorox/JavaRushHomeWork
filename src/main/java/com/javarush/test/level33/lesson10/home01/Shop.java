package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharov on 25.02.2016.
 */

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    @XmlElementWrapper(name = "goods", nillable = true)
    public List<String> names;
    @XmlElement(name = "count")
    public int count;
    @XmlElement(name = "profit")
    public double profit;
    @XmlElement(name = "secretData")
    public List<String> secretData;

    public Shop() {
        this.names = new ArrayList<>();
        this.secretData = new ArrayList<>();
    }
}
