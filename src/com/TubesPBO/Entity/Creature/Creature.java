package com.TubesPBO.Entity.Creature;

import com.TubesPBO.Entity.Entity;
import com.TubesPBO.Game.Handler;
import com.TubesPBO.Tile.Tiles;

import java.awt.*;

public abstract class Creature extends Entity {

    public static final float deafult_Speed= 5.0F;
    public static  final int deafult_creature_width=64;
    public static final int deafult_creature_height=64;

    protected float speed;
    protected float moveX;
    protected float moveY;
    protected boolean stayStill=false;

    public Creature(Handler handler, float x, float y, int width, int height){
        super(handler,width,height,x,y);
        speed=deafult_Speed;
        moveX=0;
        moveY=0;
    }
    public void movement(){
        if(!checkEntityCollision(moveX,0))
            moveX();
        if(!checkEntityCollision(0,moveY))
            moveY();
    }
    public void moveX(){
        int tx;
        if(moveX>0){ //kanan
            tx=(int)(x+moveX+ bounds.x+bounds.width)/ Tiles.tileWidth;
            if(!collision(tx,(int)(y+bounds.y)/Tiles.tileHeight)&&!collision(tx,(int)(y+bounds.y+bounds.height)/Tiles.tileHeight)){
                x+=moveX;
                stayStill=false;
            }else{
//                x = tx * Tiles.tileWidth - bounds.x - bounds.width -1;
                stayStill=true;
            }
        }else if (moveX<0){ //kiri
            tx=(int)(x+moveX+ bounds.x)/ Tiles.tileWidth;
            if(!collision(tx,(int)(y+bounds.y)/Tiles.tileHeight)&&!collision(tx,(int)(y+bounds.y+bounds.height)/Tiles.tileHeight)){
                x+=moveX;
                stayStill=false;
            }
            else{
                x = tx * Tiles.tileWidth + Tiles.tileWidth - bounds.x;
                stayStill=true;
            }
        }
    }
    public void moveY(){
        if(moveY<0){ //atas
            int ty=(int)(y+moveY+ bounds.y)/Tiles.tileHeight;
            if(!collision((int)(x+ bounds.x)/Tiles.tileWidth,ty)&& !collision((int)(x+ bounds.x+ bounds.width)/Tiles.tileWidth,ty)){
                y+=moveY;
                stayStill=false;
            }else {
                y = ty * Tiles.tileHeight + Tiles.tileHeight - bounds.y;
                stayStill = true;
            }

        }else if ( moveY>0){ //bawah
            int ty=(int)(y+moveY+ bounds.y+ bounds.height)/Tiles.tileHeight;
            if(!collision((int)(x+ bounds.x)/Tiles.tileWidth,ty)&& !collision((int)(x+ bounds.x+ bounds.width)/Tiles.tileWidth,ty)){
                y+=moveY;
                stayStill=false;
            }else{
                y = ty * Tiles.tileHeight - bounds.y - bounds.height - 1;
                stayStill = true;
            }
        }

    }
    public boolean collision(int x , int y){
        return handler.getWorld().getTile(x,y).isSolid();
    }

    //
    public void setMoveX(float moveX) {
        this.moveX = moveX;
    }

    public void setMoveY(float moveY) {
        this.moveY = moveY;
    }

    public float getMoveX() {
        return moveX;
    }

    public float getMoveY() {
        return moveY;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
