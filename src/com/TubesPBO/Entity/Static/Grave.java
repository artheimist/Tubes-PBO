package com.TubesPBO.Entity.Static;

import com.TubesPBO.Game.Handler;
import com.TubesPBO.Grapichs.Assets;

import java.awt.*;

public class Grave extends StaticEntity{

    public Grave(Handler handler, float x, float y) {
        super(handler, 64, 64, x, y);
        bounds.x=10;
        bounds.y=(int)(height-50/1.5f);
        bounds.width=width-20;
        bounds.height=(int)(height-height/3.0f);
        deadly=false;
    }

    @Override
    public void update() {

    }

    @Override
    public void die() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.grave,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
//        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
//        g.setColor(Color.red);
    }
}
