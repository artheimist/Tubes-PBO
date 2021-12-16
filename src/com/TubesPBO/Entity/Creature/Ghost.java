package com.TubesPBO.Entity.Creature;

import com.TubesPBO.Game.Handler;
import com.TubesPBO.Grapichs.Animation;
import com.TubesPBO.Grapichs.Assets;
import com.TubesPBO.Tile.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Ghost extends  Creature{
    private String moveType;
    private int moveRange,moveSpeed,currentMove=0,lastFrame=4;
    private  boolean direction;
    private Animation animationDown,animationUp,animationRight,animationLeft;

    public Ghost(Handler handler, float x, float y,String moveType, int rangeMove,int moveSpeed) {
        super(handler, x, y, Tiles.tileWidth, Tiles.tileHeight);
        bounds.x=16;
        bounds.y=32;
        bounds.width=32;
        bounds.height=32;
        this.moveType = moveType;
        this.moveRange = rangeMove;
        this.moveSpeed = moveSpeed;
        this.direction = true;
        deadly=true;
        init();

    }
    public void init(){
        animationDown= new Animation(200,Assets.ghost_down);
        animationUp= new Animation(200,Assets.ghost_up);
        animationRight= new Animation(200,Assets.ghost_right);
        animationLeft= new Animation(200,Assets.ghost_left);
    }
    public void animationUpdate(){
        animationDown.update();
        animationUp.update();
        animationRight.update();
        animationLeft.update();
    }
    public void update(){
        animationUpdate();
        movement();
        move();
    }

    @Override
    public void die() {

    }
    public void move(){
        currentMove++;
        if(checkEntityCollision(moveX,0)||stayStill==true||currentMove>moveRange){
            direction=!direction;
            currentMove=0;
        }else if(checkEntityCollision(0,moveY)||stayStill==true||currentMove>moveRange){
            direction=!direction;
            currentMove=0;
        }

        if(moveType.equals( "horizontal")){ //dri parameter monster, gerak horizontal
            if(direction){
                moveX = moveSpeed;
            }else{
                moveX = -moveSpeed;
            }

        } else if (moveType.equals("vertical") ){
            if(direction){
                moveY = moveSpeed;
            }else{
                moveY = -moveSpeed;
            }
        }
    }
    public void render(Graphics g){
        g.drawImage(getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()),width,height,null);
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }

    public String getMoveType() {
        return moveType;
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
