package com.TubesPBO.Entity.Creature;

import com.TubesPBO.Entity.Entity;
import com.TubesPBO.Game.Handler;
import com.TubesPBO.Tile.Tiles;

import java.awt.*;

public abstract class Creature extends Entity {

    public static final int Deafult_Health=3;
    public static final float deafult_Speed= 10.0F;
    public static  final int deafult_creature_width=64;
    public static final int deafult_creature_height=64;

    protected int health;
    protected float speed;
    protected float moveX;
    protected float moveY;

    public Creature(Handler handler, float x, float y, int width, int height){
        super(handler,width,height,x,y);
        health=Deafult_Health;
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
        if(moveX>0){ //kanan
            int tx=(int)(x+moveX+ bounds.x+bounds.width)/ Tiles.tileWidth;
            if(!collision(tx,(int)(y+bounds.y)/Tiles.tileHeight)&&!collision(tx,(int)(y+bounds.y+bounds.height)/Tiles.tileHeight)){
                x+=moveX;
            }
        }else if (moveX<0){ //kiri
            int tx=(int)(x+moveX+ bounds.x)/ Tiles.tileWidth;
            if(!collision(tx,(int)(y+bounds.y)/Tiles.tileHeight)&&!collision(tx,(int)(y+bounds.y+bounds.height)/Tiles.tileHeight)){
                x+=moveX;
            }
        }
    }
    public void moveY(){
        if(moveY<0){ //atas
            int ty=(int)(y+moveY+ bounds.y)/Tiles.tileHeight;
            if(!collision((int)(x+ bounds.x)/Tiles.tileWidth,ty)&& !collision((int)(x+ bounds.x+ bounds.width)/Tiles.tileWidth,ty)){
                y+=moveY;
            }
        }else if ( moveY>0){ //bawah
            int ty=(int)(y+moveY+ bounds.y+ bounds.height)/Tiles.tileHeight;
            if(!collision((int)(x+ bounds.x)/Tiles.tileWidth,ty)&& !collision((int)(x+ bounds.x+ bounds.width)/Tiles.tileWidth,ty)){
                y+=moveY;
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
