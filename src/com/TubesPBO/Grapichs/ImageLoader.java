package com.TubesPBO.Grapichs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
    public static BufferedImage loadimage(String path){
        try {
            return ImageIO.read(ImageLoader.class.getResource(path)); //important line
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
