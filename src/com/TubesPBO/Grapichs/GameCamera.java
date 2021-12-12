package com.TubesPBO.Grapichs;

import com.TubesPBO.Entity.Entity;
import com.TubesPBO.Game.Game;
import com.TubesPBO.Game.Handler;
import com.TubesPBO.Tile.Tiles;

public class GameCamera {

    private float xOffset,yOffset;
    private Handler handler;
    public  GameCamera(Handler handler, float xOffset, float yOffset){
        this.xOffset=xOffset;
        this.yOffset=yOffset;
        this.handler=handler;
    }
    public void checkBlank(){ // saat render tiles di bagian ujung kiri kanan masih ada white tiles atau blank spot
        if(xOffset<0){
            xOffset=0;
        }else if(xOffset>handler.getWorld().getWidth()* Tiles.tileWidth-handler.getWidth()){
            xOffset=handler.getWorld().getWidth()* Tiles.tileWidth-handler.getWidth();
        }
        if(yOffset<0) {
            yOffset = 0;
        }if(yOffset>handler.getWorld().getHeight()* Tiles.tileHeight-handler.getHeight()+160){
            yOffset=handler.getWorld().getHeight()* Tiles.tileHeight-handler.getHeight()+160;
        }
    }
    public void cameraOnEntity(Entity e){                           // setting camera di player atau entity
        xOffset=e.getX()-handler.getWidth()/2+e.getWidth()/2;       //
        yOffset=e.getY()-handler.getHeight()/2+e.getHeight()/2;
        checkBlank();
    }
    public void move (float xAmount, float yAmount){
        xOffset+=xAmount;
        yOffset+=yAmount;
        checkBlank();
    }
    public float getxOffset() {
        return xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }
}
