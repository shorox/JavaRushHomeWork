package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by sharov on 18.09.2015.
 */
public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes imgTypes){
        if(imgTypes == ImageTypes.BMP)
            return new BmpReader();
        if(imgTypes == ImageTypes.JPG)
            return new JpgReader();
        if(imgTypes == ImageTypes.PNG)
            return new PngReader();
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
