package cn.starzyn.vcode;

import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    @Test
    public void fun() throws IOException {
        Vcode vcode = new Vcode();
        BufferedImage img = vcode.getImage();
        Vcode.saveImage(img,new FileOutputStream("/home/starzyn/Desktop/a.jpg"));
    }
}
