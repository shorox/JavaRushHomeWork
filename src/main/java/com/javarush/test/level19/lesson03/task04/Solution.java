package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner data;

        public PersonScannerAdapter(Scanner data){ this.data = data; }

        public Person read() throws IOException{
            String[] line =this.data.nextLine().split(" ");
            String firstName = line[1];
            String middleName = line[2];
            String lastName = line[0];
            try {
                Date birthDate = new SimpleDateFormat("dd MM yyyy").parse(line[3] + " " + line[4] + " " + line[5]);
                return new Person(firstName, middleName, lastName, birthDate);
            } catch (ParseException e) {
                return null;
            }

        }

        public void close() throws IOException{ this.data.close(); }
    }
}
