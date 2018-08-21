package com.javarush.test.level18.lesson08.task03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "input.txt";
    private FileOutputStream original;

    public AmigoOutputStream(FileOutputStream fileOut) throws FileNotFoundException {
        super(fileName);
        this.original = fileOut;
    }

    public void flush() throws IOException{this.original.flush();}

    public void write(int b) throws IOException{this.original.write(b);}

    public void write(byte[] b) throws IOException{this.original.write(b);}

    public void write(byte[] b, int off, int len) throws IOException{this.original.write(b, off, len);}

    @Override
    public void close() throws IOException {
        flush();
        write("JavaRush © 2012-2013 All rights reserved.".getBytes());
        this.original.close();
    }

    public static void main(String[] args) throws IOException {
        new AmigoOutputStream(new FileOutputStream(fileName)).close();
    }

}
