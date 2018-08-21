package com.javarush.test.level39.lesson09.big01;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("./com.javarush.test/level39/lesson09/big01/logs"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        //System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH).format(logParser.getDateWhenUserDoneTask("Vasya Pupkin", 15, null, null)));
        System.out.println(logParser.execute("get event for date = \"30.01.2014 12:56:22\""));
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
    }
}
