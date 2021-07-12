package test;

import javax.imageio.ImageIO;
import javax.security.auth.login.FailedLoginException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Author:chengzhi
 * @Date:2021/7/11 20:26
 * @Description
 */
public class ImageTest {
    public static void main(String[] args) {
        try {
            //BufferedImage image = ImageIO.read(new File(""));
            BufferedImage images = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            if(null == images){
                 int i = 1/0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
