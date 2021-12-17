package com.TubesPBO.Entity.Static;

import com.TubesPBO.Game.Handler;
import com.TubesPBO.Grapichs.Assets;


import java.awt.*;

public class Tree extends StaticEntity{
    public Tree(Handler handler, float x, float y) {
        super(handler, 64, 128, x, y);
        bounds.x=20;
        bounds.y=(int)(height/1.5f);
        bounds.width=width-40;
        bounds.height=(int)(height-height/1.5f);
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
        g.drawImage(Assets.tree,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
    }
}
