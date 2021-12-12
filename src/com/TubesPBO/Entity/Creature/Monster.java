package com.TubesPBO.Entity.Creature;

import com.TubesPBO.Game.Handler;
import com.TubesPBO.Grapichs.Animation;
import com.TubesPBO.Grapichs.Assets;

import java.awt.*;

public class Monster extends  Creature{

    private Animation animationDown,animationUp,animationRight,animationLeft;

    public Monster(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }
    public void init(){

    }
    public void animationUpdate(){

    }
    public void update(){

    }

    @Override
    public void die() {

    }

    public void render(Graphics g){
        g.drawImage(Assets.ghost_down[0],100,100,null);
    }
}
