package com.TubesPBO.Entity;

import com.TubesPBO.Game.Game;
import com.TubesPBO.Game.Handler;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected float x,y;
    protected int width,height;
    protected Rectangle bounds;
    protected  int health;
    public boolean active=true,deadly=false,endGame=false;
    public Entity(Handler handler,int width,int height,float x, float y){
        this.handler=handler;
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
        bounds= new Rectangle(0,0,width,height);
    }
    public  Boolean checkEntityCollision(float xOffset,float yOffset){
        for (int i=0; i<handler.getWorld().getEntityManager().getEntities().size();i++){
            Entity e=handler.getWorld().getEntityManager().getEntities().get(i);
        }
        for(Entity e: handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }
            if(e.getCollisionBounds(0,0).intersects(getCollisionBounds(xOffset,yOffset))){
                return true;
            }
        }
            return false;
    }
    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return  new Rectangle((int)(x+bounds.x+xOffset),(int)(y+bounds.y+yOffset),bounds.width,bounds.height);
    }
    public Rectangle getCollisionBoundsEnemy(float xOffset, float yOffset){
        return new Rectangle((int) (x + bounds.x + xOffset - 1), (int) (y + bounds.y + yOffset -1), bounds.width + 3, bounds.height + 3);
    }
    public void receiveDamage(int damage){
        health-=damage;
        if(health<=0&&deadly){
            active=false;
        }
        die();
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isDeadly() {
        return deadly;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public abstract void update();
    public abstract void die();
    public abstract void render(Graphics g);

}
