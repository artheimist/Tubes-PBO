package com.TubesPBO.World;

import com.TubesPBO.Entity.Creature.Ghost;
import com.TubesPBO.Entity.Creature.Player;
import com.TubesPBO.Entity.Creature.Zombie;
import com.TubesPBO.Entity.EntityManager;
import com.TubesPBO.Entity.Static.Chest;
import com.TubesPBO.Entity.Static.Gate;
import com.TubesPBO.Entity.Static.Grave;
import com.TubesPBO.Entity.Static.Tree;
import com.TubesPBO.Game.Game;
import com.TubesPBO.Game.Handler;
import com.TubesPBO.Tile.Tiles;
import com.TubesPBO.Utility.Utils;

import java.awt.*;

public class World {
    private int width,height;
    public int spawnX,spawnY;
    private int[][] tile;
    protected Handler handler;
    private EntityManager entityManager;
    public World(Handler handler, String path){
        this.handler=handler;
        entityManager= new EntityManager(handler,new Player(handler,0,0));
        loadEntity();
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
//        mecegah error saat player keluar dr map
        if(x<0|| y<0||x >=width||y>=height){
            return Tiles.grassTile;
        }
        Tiles tile= Tiles.tiles[this.tile[x][y]];  //
        if(tile==null){
            return Tiles.brickTile;
        }
        return  tile;
    }
    public void loadEntity(){
        entityManager.addEntity(new Tree(handler,50,0));
        entityManager.addEntity(new Tree(handler,0,120));
        entityManager.addEntity(new Grave(handler,60,250));
        entityManager.addEntity(new Tree(handler,0,240));
        entityManager.addEntity(new Tree(handler,0,380));
        entityManager.addEntity(new Tree(handler,0,430));
        entityManager.addEntity(new Tree(handler,60,380));
        entityManager.addEntity(new Tree(handler,120,380));
        entityManager.addEntity(new Tree(handler,178,380));
        entityManager.addEntity(new Grave(handler,238,445));
        entityManager.addEntity(new Grave(handler,238,520));
        entityManager.addEntity(new Grave(handler,385,445));
        entityManager.addEntity(new Tree(handler,0,450));
        entityManager.addEntity(new Tree(handler,0,480));
        entityManager.addEntity(new Tree(handler,0,530));
        entityManager.addEntity(new Tree(handler,0,580));
        entityManager.addEntity(new Tree(handler,0,630));
        entityManager.addEntity(new Tree(handler,0,680));
        entityManager.addEntity(new Tree(handler,0,730));
        entityManager.addEntity(new Tree(handler,0,780));
        entityManager.addEntity(new Tree(handler,0,830));
        entityManager.addEntity(new Tree(handler,0,880));
        entityManager.addEntity(new Tree(handler,0,930));
        entityManager.addEntity(new Tree(handler,385,810));
        entityManager.addEntity(new Tree(handler,385,880));
        entityManager.addEntity(new Tree(handler,325,810));
        entityManager.addEntity(new Grave(handler,70,1020));
        entityManager.addEntity(new Grave(handler,130,1020));
        entityManager.addEntity(new Grave(handler,130,950));
        entityManager.addEntity(new Grave(handler,130,880));
        entityManager.addEntity(new Grave(handler,635,930));
        entityManager.addEntity(new Grave(handler,760,1020));
        entityManager.addEntity(new Grave(handler,760,950));
        entityManager.addEntity(new Grave(handler,960,640));
        entityManager.addEntity(new Grave(handler,1020,640));
        entityManager.addEntity(new Grave(handler,1020,1020));
        entityManager.addEntity(new Grave(handler,1080,1020));
        entityManager.addEntity(new Grave(handler,1080,950));
        entityManager.addEntity(new Grave(handler,1020,705));
        entityManager.addEntity(new Grave(handler,1020,770));
        entityManager.addEntity(new Grave(handler,1020,830));
        entityManager.addEntity(new Grave(handler,1080,705));
        entityManager.addEntity(new Grave(handler,1080,830));
        entityManager.addEntity(new Grave(handler,1790,630));
        entityManager.addEntity(new Grave(handler,1790,700));
        entityManager.addEntity(new Grave(handler,1725,700));
        entityManager.addEntity(new Tree(handler,1855,590));
        entityManager.addEntity(new Tree(handler,1855,645));
        entityManager.addEntity(new Tree(handler,1855,760));
        entityManager.addEntity(new Tree(handler,1855,900));
        entityManager.addEntity(new Tree(handler,1855,970));
        entityManager.addEntity(new Tree(handler,1790,900));
        entityManager.addEntity(new Tree(handler,1725,900));
        entityManager.addEntity(new Tree(handler,1660,900));
        entityManager.addEntity(new Grave(handler,1530,950));


        entityManager.addEntity(new Grave(handler,250,250));
        entityManager.addEntity(new Grave(handler,515,250));
        entityManager.addEntity(new Grave(handler,630,250));
        entityManager.addEntity(new Grave(handler,515,60));
        entityManager.addEntity(new Tree(handler,570,0));
        entityManager.addEntity(new Grave(handler,630,60));
        entityManager.addEntity(new Tree(handler,685,0));
        entityManager.addEntity(new Grave(handler,570,370));
        entityManager.addEntity(new Grave(handler,685,370));
        entityManager.addEntity(new Grave(handler,830,315));
        entityManager.addEntity(new Grave(handler,888,315));
        entityManager.addEntity(new Grave(handler,978,315));
        entityManager.addEntity(new Grave(handler,1036,315));
        entityManager.addEntity(new Grave(handler,1126,315));
        entityManager.addEntity(new Grave(handler,1184,315));
        entityManager.addEntity(new Grave(handler,1454,65));
        entityManager.addEntity(new Grave(handler,1454,135));
        entityManager.addEntity(new Tree(handler,1515,0));
        entityManager.addEntity(new Grave(handler,1576,65));
        entityManager.addEntity(new Grave(handler,1576,135));
        entityManager.addEntity(new Tree(handler,1855,0));
        entityManager.addEntity(new Tree(handler,1855,75));
        entityManager.addEntity(new Tree(handler,1855,135));
        entityManager.addEntity(new Tree(handler,1855,135));
        entityManager.addEntity(new Tree(handler,1855,255));
        entityManager.addEntity(new Tree(handler,1855,320));
        entityManager.addEntity(new Tree(handler,1855,405));
        entityManager.addEntity(new Tree(handler,1855,430));


        entityManager.addEntity(new Grave(handler,1454,375));
        entityManager.addEntity(new Grave(handler,1454,440));
        entityManager.addEntity(new Grave(handler,1454,510));
        entityManager.addEntity(new Grave(handler,1520,510));
        //FLOOR 2
        entityManager.addEntity(new Tree(handler,1855,1030));
        entityManager.addEntity(new Tree(handler,1855,1080));
        entityManager.addEntity(new Tree(handler,1855,1130));
        entityManager.addEntity(new Tree(handler,1855,1180));
        entityManager.addEntity(new Tree(handler,1855,1230));
        entityManager.addEntity(new Tree(handler,1855,1280));
        entityManager.addEntity(new Tree(handler,1855,1330));
        entityManager.addEntity(new Tree(handler,1855,1380));
        entityManager.addEntity(new Tree(handler,1855,1430));
        entityManager.addEntity(new Tree(handler,1855,1480));
        entityManager.addEntity(new Tree(handler,1855,1530));
        entityManager.addEntity(new Tree(handler,1855,1580));
        entityManager.addEntity(new Tree(handler,1855,1630));
        entityManager.addEntity(new Tree(handler,1855,1680));
        entityManager.addEntity(new Tree(handler,1855,1730));
        //KIRI
        entityManager.addEntity(new Tree(handler,0,1080));
        entityManager.addEntity(new Tree(handler,65,1080));
        entityManager.addEntity(new Tree(handler,130,1080));
        entityManager.addEntity(new Grave(handler,255,1150));
        //entityManager.addEntity(new Grave(handler,320,1150));
        entityManager.addEntity(new Tree(handler,450,1110));
        entityManager.addEntity(new Tree(handler,450,1215));
        entityManager.addEntity(new Grave(handler,630,1150));
        entityManager.addEntity(new Grave(handler,895,1150));
        entityManager.addEntity(new Grave(handler,1790,1150));
        entityManager.addEntity(new Grave(handler,1730,1150));
        entityManager.addEntity(new Grave(handler,1790,1215));
        entityManager.addEntity(new Grave(handler,1730,1215));
        entityManager.addEntity(new Grave(handler,1345,1280));
        entityManager.addEntity(new Grave(handler,1215,1280));
        entityManager.addEntity(new Tree(handler,960,1280));
        entityManager.addEntity(new Grave(handler,640,1345));
        entityManager.addEntity(new Grave(handler,510,1410));
        entityManager.addEntity(new Grave(handler,380,1410));
        entityManager.addEntity(new Grave(handler,440,1540));
        entityManager.addEntity(new Grave(handler,510,1725));
        entityManager.addEntity(new Grave(handler,640,1660));
        entityManager.addEntity(new Grave(handler,120,1635));



        entityManager.addEntity(new Tree(handler,0,1130));
        entityManager.addEntity(new Tree(handler,65,1130));
        entityManager.addEntity(new Tree(handler,130,1130));

        entityManager.addEntity(new Tree(handler,0,1180));
        entityManager.addEntity(new Tree(handler,65,1180));
        entityManager.addEntity(new Tree(handler,130,1180));

        entityManager.addEntity(new Tree(handler,0,1230));
        entityManager.addEntity(new Tree(handler,65,1230));
        entityManager.addEntity(new Tree(handler,130,1230));

        entityManager.addEntity(new Tree(handler,65,1280));
        entityManager.addEntity(new Tree(handler,130,1280));
        entityManager.addEntity(new Tree(handler,0,1380));
        entityManager.addEntity(new Tree(handler,0,1410));
        entityManager.addEntity(new Tree(handler,0,1530));
        entityManager.addEntity(new Tree(handler,0,1580));
        entityManager.addEntity(new Tree(handler,0,1630));
        entityManager.addEntity(new Tree(handler,0,1680));
        entityManager.addEntity(new Tree(handler,0,1730));
        entityManager.addEntity(new Grave(handler,1535,1790));
        entityManager.addEntity(new Grave(handler,960,1600));
        entityManager.addEntity(new Tree(handler,1150,1500));
        entityManager.addEntity(new Tree(handler,1600,1315));
        entityManager.addEntity(new Tree(handler,1600,1410));
        entityManager.addEntity(new Tree(handler,1665,1635));
        entityManager.addEntity(new Tree(handler,1665,1730));
        //
        entityManager.addEntity(new Grave(handler,630,125));
        entityManager.addEntity(new Grave(handler,515,125));
        //chest

        //zombie
        entityManager.addEntity((new Zombie(handler,820,130,"vertical",90,2)));
        //hummm
        entityManager.addEntity((new Zombie(handler,1665,50,"vertical",90,2)));
        entityManager.addEntity((new Zombie(handler,60,580,"vertical",180,2)));
        //3 dikiri
        entityManager.addEntity((new Zombie(handler,190,670,"vertical",200,2)));
        // 3 kanan
//        entityManager.addEntity((new Zombie(handler,390,670,"vertical",180,2)));
//        entityManager.addEntity((new Zombie(handler,450,760,"vertical",100,2)));
//        entityManager.addEntity((new Zombie(handler,640,580,"vertical",50,2)));
//        entityManager.addEntity((new Zombie(handler,700,680,"vertical",90,2)));
//        entityManager.addEntity((new Zombie(handler,970,680,"vertical",200,2)));
//        entityManager.addEntity((new Zombie(handler,1140,750,"vertical",150,2)));
//        entityManager.addEntity((new Zombie(handler,1200,650,"vertical",70,2)));
//        entityManager.addEntity((new Zombie(handler,1400,790,"vertical",80,2)));
//        //floor 2
//        entityManager.addEntity((new Zombie(handler,60,1700,"vertical",100,2)));
//        entityManager.addEntity((new Zombie(handler,180,1850,"vertical",100,2)));
//        entityManager.addEntity((new Zombie(handler,250,1200,"vertical",110,2)));
//        entityManager.addEntity((new Zombie(handler,380,1450,"vertical",135,2)));
//        entityManager.addEntity((new Zombie(handler,830,1400,"vertical",115,2)));
//        entityManager.addEntity((new Zombie(handler,950,1200,"vertical",115,2)));
//        entityManager.addEntity((new Zombie(handler,1000,1500,"vertical",115,2)));
//        entityManager.addEntity((new Zombie(handler,1270,1200,"vertical",115,2)));
//        entityManager.addEntity((new Zombie(handler,1480,1850,"vertical",100,2)));
//        entityManager.addEntity((new Zombie(handler,1720,1850,"vertical",50,2)));
//        entityManager.addEntity((new Zombie(handler,1720,1300,"vertical",100,2)));
//
//        //ghost
//        entityManager.addEntity((new Ghost(handler,850,50,"horizontal",200,2)));
//        entityManager.addEntity((new Ghost(handler,1100,50,"horizontal",200,2)));
//        entityManager.addEntity((new Ghost(handler,400,120,"horizontal",200,2)));
//        entityManager.addEntity((new Ghost(handler,120,170,"horizontal",80,2)));
//        entityManager.addEntity((new Ghost(handler,400,170,"horizontal",160,2)));
//        entityManager.addEntity((new Ghost(handler,1350,180,"horizontal",100,2)));
//        entityManager.addEntity((new Ghost(handler,80,315,"horizontal",115,2)));
//        entityManager.addEntity((new Ghost(handler,1350,315,"horizontal",200,2)));
//        entityManager.addEntity((new Ghost(handler,510,430,"horizontal",70,2)));
//        //3 monster di tengah
//        entityManager.addEntity((new Ghost(handler,260,570,"horizontal",80,2)));
//        entityManager.addEntity((new Ghost(handler,1500,620,"horizontal",200,2)));
//        entityManager.addEntity((new Ghost(handler,1400,700,"horizontal",130,2)));
//        // lagi 3 monster
//        entityManager.addEntity((new Ghost(handler,700,890,"horizontal",110,2)));
//        entityManager.addEntity((new Ghost(handler,500,990,"horizontal",70,2)));
//        entityManager.addEntity((new Ghost(handler,1350,1000,"horizontal",180,2)));
//        //floor 2
//        entityManager.addEntity((new Ghost(handler,60,1460,"horizontal",80,2)));
//        entityManager.addEntity((new Ghost(handler,320,1780,"horizontal",550,2)));
//        entityManager.addEntity((new Ghost(handler,1120,1650,"horizontal",130,2)));
//        entityManager.addEntity((new Ghost(handler,980,1450,"horizontal",230,2)));
//        entityManager.addEntity((new Ghost(handler,780,1520,"horizontal",90,2)));
//        entityManager.addEntity((new Ghost(handler,800,1340,"horizontal",90,2)));
//        entityManager.addEntity((new Ghost(handler,520,1260,"horizontal",200,2)));
//        entityManager.addEntity((new Ghost(handler,1000,1340,"horizontal",90,2)));
//        entityManager.addEntity((new Ghost(handler,1000,1140,"horizontal",70,2)));
//        entityManager.addEntity((new Ghost(handler,1200,1200,"horizontal",40,2)));
//        entityManager.addEntity((new Ghost(handler,1550,1200,"horizontal",60,2)));
//        entityManager.addEntity((new Ghost(handler,1700,1600,"horizontal",130,2)));
//        //chest
//        entityManager.addEntity(new Chest(handler,1790,1800,true));
//        entityManager.addEntity(new Chest(handler,60,180,false));
//        entityManager.addEntity(new Chest(handler,60,480,false));
//        entityManager.addEntity(new Chest(handler,700,440,false));
//        entityManager.addEntity(new Chest(handler,970,510,false));
//        entityManager.addEntity(new Chest(handler,830,770,false));
//        entityManager.addEntity(new Chest(handler,1800,510,false));
//        entityManager.addEntity(new Chest(handler,1790,1030,false));
//        entityManager.addEntity(new Chest(handler,120,1800,false));
//        entityManager.addEntity(new Chest(handler,530,1150,false));

        entityManager.addEntity(new Chest(handler,100,100,true));//chest ngecek
        //gate
        entityManager.addEntity(new Gate(handler,1470,1280));
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

    public int getSpawnX() {
        return spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }
}
