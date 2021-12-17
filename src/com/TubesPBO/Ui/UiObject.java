package com.TubesPBO.Ui;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UiObject {
    protected  float x,y;
    protected  int width,height;
    protected Rectangle bounds;
    protected  boolean hover=false;
    public UiObject(float x, float y, int width, int height ){
        bounds= new Rectangle((int)x,(int)y,width,height);
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
    }
    public abstract void update();
    public abstract void render(Graphics g);
    public abstract void onClick();
    public void onMouseMove(MouseEvent e){
        if(bounds.contains(e.getX(),e.getY())){
            hover=true;
        }else{
            hover=false;
        }
    }
    public void onMouseRelease(MouseEvent e){
        if(hover){
            onClick();
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

}
