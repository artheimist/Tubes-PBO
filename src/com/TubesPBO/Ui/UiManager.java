package com.TubesPBO.Ui;

import com.TubesPBO.Game.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UiManager {

    private Handler handler;
    private ArrayList<UiObject> object;
    public UiManager(Handler handler){
        this.handler=handler;
        object= new ArrayList<>();

    }
    public void update(){
        for (UiObject o :object){
            o.update();
        }
    }
    public void render(Graphics g){
        for (UiObject o :object){
            o.render(g);
        }
    }
    public void onMouseMove(MouseEvent e){
        for (UiObject o :object){
            o.onMouseMove(e);
        }
    }
    public void onMouseRelease(MouseEvent e){
        for (UiObject o :object){
            o.onMouseRelease(e);
        }
    }
    public void addObject(UiObject o){
        object.add(o);
    }
    public void removeObject(UiObject o){
        object.remove(o);
    }
}
