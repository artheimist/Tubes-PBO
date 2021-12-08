package com.TubesPBO.World;

import com.TubesPBO.Entity.Creature.Player;
import com.TubesPBO.Entity.EntityManager;
import com.TubesPBO.Entity.Static.Tree;
import com.TubesPBO.Game.Game;
import com.TubesPBO.Game.Handler;
import com.TubesPBO.Tile.Tiles;
import com.TubesPBO.Utility.Utils;

import java.awt.*;

public class World {
    private int width,height;
    private int spawnX,spawnY;
    private int[][] tile;
    protected Handler handler;
    private EntityManager entityManager;
    public World(Handler handler, String path){
        this.handler=handler;
        entityManager= new EntityManager(handler,new Player(handler,0,0));
        entityManager.addEntity(new Tree(handler,0,100));
        entityManager.addEntity(new Tree(handler,0,170));
        entityManager.addEntity(new Tree(handler,0,250));
        loadWorld(path);
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }
    public void update(){
        entityManager.update();
    }
    public void render(Graphics g){
        // rendering efficiency (tiles akan di render hanya yg terleihat oleh window user)
        int xStart=(int)Math.max(0,handler.getGameCamera().getxOffset()/Tiles.tileWidth);                          // 0 itu start dari ujung kiri world dan xoffset untuk kamera dari user / tiles widht agar mendapat besarnya dari tiles
        int xEnd=(int)Math.min(width,(handler.getGameCamera().getxOffset()+handler.getWidth())/Tiles.tileWidth+1);
        int yStart=(int)Math.max(0,handler.getGameCamera().getyOffset()/Tiles.tileHeight);
        int yEnd=(int)Math.min(height,(handler.getGameCamera().getyOffset()+handler.getHeight())/Tiles.tileHeight+1);
        //end
        for (int y=yStart; y<yEnd;y++){
            for(int x=xStart;x<xEnd;x++){
                getTile(x,y).render(g,(int)(x*Tiles.tileWidth-handler.getGameCamera().getxOffset()),(int)(y*Tiles.tileHeight-handler.getGameCamera().getyOffset()));
            }
        }
        entityManager.render(g);
    }
    
    public Tiles getTile(int x,int y){
        //mecegah player keluar dr map
        if(x<0|| y<0||x >=width||y>=height){
            return Tiles.grassTile;
        }

        Tiles tile= Tiles.tiles[this.tile[x][y]];
        if(tile==null){
            return Tiles.brickTile;
        }
        return  tile;
    }
    public void loadWorld(String path){
        String file= Utils.loadFileAsString(path);
        String[] token= file.split("\\s+");
        width=Utils.parseInt(token[0]);
        height=Utils.parseInt(token[1]);
        spawnX=Utils.parseInt(token[2]);
        spawnY=Utils.parseInt(token[3]);

        tile=new int[width][height];
        for (int y=0; y<height;y++){
            for (int x=0;x<width;x++){
                tile[x][y]=Utils.parseInt(token[(x+y*width)+4]);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
