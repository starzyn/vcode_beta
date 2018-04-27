package cn.starzyn.vcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class Vcode {
    private int w = 70;//set the width
    private int h = 35;//set the high
    private Color bgColor = new Color(240,240,240);
    private String charList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private String[] fontType = {"宋体","华文行楷","黑体","隶书","仿宋"};
    private Random rand = new Random();
    private StringBuilder code = new StringBuilder();

    //create the bufferedimage
    private BufferedImage createImage(){
        /**
         * 1:create the image
         * 2:set the background color
         */
        BufferedImage image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        image.getGraphics().setColor(bgColor);
        image.getGraphics().fillRect(0,0,w,h);
        return image;
    }

    /**
     *
     * @return
     */
    public  BufferedImage getImage(){
        BufferedImage image = createImage();
        //draw the image
        Graphics g = image.getGraphics();
        for(int i = 0; i < 4; i++){
            String ch = this.randChar();
            code.append(ch);
            g.setColor(this.randColor());
            g.setFont(this.randFont());
            g.drawString(ch,w/4*i,h-5);

        }

        drawLine(image);
        return image;
    }

    public static void saveImage(BufferedImage img, OutputStream out) throws IOException {
        ImageIO.write(img,"JPEG",out);
    }

    private String randChar(){
        int length = charList.length();
        int index = rand.nextInt(length);
        return  charList.charAt(index) + "";
    }

    private Color randColor(){
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return new Color(r,g,b);
    }

    private Font randFont(){
        int index = rand.nextInt(fontType.length);
        int[] sizes = {26,27,28,29,30};
        String name = fontType[index];
        int style = rand.nextInt(3);
        int size = sizes[index];
        return new Font(name,style,size);
    }

    private void drawLine(Image img){
        Graphics g = img.getGraphics();
        g.setColor(Color.BLACK);
        for(int i = 0; i < 4; i++){
            int x1 = rand.nextInt(w);
            int y1 = rand.nextInt(h);
            int x2 = rand.nextInt(w);
            int y2 = rand.nextInt(h);
            g.drawLine(x1,y1,x2,y2);
        }
    }

    public String getCode(){
//        System.out.print(this.code.toString());
        return this.code.toString();
    }
}
