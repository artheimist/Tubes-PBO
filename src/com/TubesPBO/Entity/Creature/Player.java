package com.TubesPBO.Entity.Creature;

import com.TubesPBO.Game.Game;
import com.TubesPBO.Game.Handler;
import com.TubesPBO.Grapichs.Animation;
import com.TubesPBO.Grapichs.Assets;
import com.TubesPBO.States.State;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{
    int lastFrame=4;
    private Animation animationDown,animationUp,animationRight,animationLeft;
    public Player(Handler handler , float x, float y) {
        super(handler,x, y,Creature.deafult_creature_width,Creature.deafult_creature_height);
        bounds.x=16;
        bounds.y=32;
        bounds.width=32;
        bounds.height=32;
        init();
    }
    public void init(){
        animationDown= new Animation(200,Assets.player_down);
        animationUp= new Animation(200,Assets.player_up);
        animationRight= new Animation(200,Assets.player_right);
        animationLeft= new Animation(200,Assets.player_left);
    }
    public void animationUpdate(){
        animationDown.update();
        animationUp.update();
        animationRight.update();
        animationLeft.update();
    }
    @Override
    public void update() {
        animationUpdate();
        input();
        movement();
        die();
        handler.getGameCamera().cameraOnEntity(this);
    }

    @Override
    public void die() {
        if(health==0){
            State.setState(handler.getGame().gameOverState);
            return;
        }
    }
    public void attack(){

    }
    private void input(){
        moveX=0;
        moveY=0;

        if(handler.getKeyManager().up){
            moveY= -speed;
        }if(handler.getKeyManager().down){
            moveY= speed;
        }
        if(handler.getKeyManager().left){
            moveX= -speed;
        }
        if(handler.getKeyManager().right){
            moveX= speed;
        }
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset() ),width,height,null);
//        g.setColor(Color.red);
//        g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),(int)(y+bounds.y-handler.getGameCamera().getyOffset()),bounds.width, bounds.height);
    }
    private BufferedImage getCurrentFrame(){
        if(moveY<0){
            lastFrame=1;
           return animationUp.getCurrentFrame();
        }else if(moveX>0){
            lastFrame=2;
            return animationRight.getCurrentFrame();
        }else if (moveX<0){
            lastFrame=3;
            return animationLeft.getCurrentFrame();
        } else if (moveY>0){
            lastFrame=4;
            return animationDown.getCurrentFrame();
        }
        return getIdleFrame();
    }
    private BufferedImage getIdleFrame(){
        switch(lastFrame){
            case 1:
                return animationUp.getIdleFrame();

            case 2:
                return animationRight.getIdleFrame();

            case 3:
                return animationLeft.getIdleFrame();

            case 4:
                return animationDown.getIdleFrame();

            default:
                return null;
        }
    }
}
