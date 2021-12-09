package com.TubesPBO.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tiles {
    public static Tiles[] tiles= new Tiles[256];
    public static Tiles grassTile= new GrassTile(1);
    public  static  Tiles brickTile= new BrickTile(0);
    public static Tiles grassWithBrickTiles= new GrassBrick(2);

    public static final int tileWidth=64, tileHeight=64;
    protected BufferedImage texture;
    protected final int id;
    public Tiles(BufferedImage texture,int id){
        this.texture=texture;
        this.id=id;
        tiles[id]=this; // nyimpen grass dirt di array
    }

    public void update(){

    }
    public void render (Graphics g, int x , int y){
        g.drawImage(texture,x,y,tileWidth,tileHeight,null);
    }

    public boolean isSolid(){
        return false;
    }


    public int getId(){
        return id;
    }

}
