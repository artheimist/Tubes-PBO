package com.TubesPBO.Ui;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UiButton extends  UiObject{
    private BufferedImage image;
    private Click click;
    public UiButton(float x, float y, int width, int height, BufferedImage image,Click click) {
        super(x, y, width, height);
        this.image=image;
        this.click=click;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image,(int)x,(int)y,width,height,null );
    }

    @Override
    public void onClick() {
        click.onClick();
    }
}
