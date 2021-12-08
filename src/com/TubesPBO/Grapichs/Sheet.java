package com.TubesPBO.Grapichs;

import java.awt.image.BufferedImage;

public class Sheet {
    private BufferedImage sheet;
    public Sheet (BufferedImage sheet){
        this.sheet=sheet;
    }
    public BufferedImage crop (int x, int y, int width, int height){
        return sheet.getSubimage(x,y,width,height);
    }
}
