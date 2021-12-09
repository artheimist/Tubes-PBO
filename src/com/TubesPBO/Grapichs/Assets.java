package com.TubesPBO.Grapichs;

import java.awt.image.BufferedImage;

public class Assets {
    public static final int width =32,height =32;
    //tiles
    public static BufferedImage brick,grass,brickGrass;
    //ghost
    public static BufferedImage[]ghost_down,ghost_up,ghost_left,ghost_right;
    //player
    public static BufferedImage[]player_down,player_up,player_left,player_right;
    public static BufferedImage standingStill;
    //zombie
    public static BufferedImage[]zombie;
    //add ons
    public static BufferedImage tree,grave;
    public static void init(){
        Sheet zombie= new Sheet(ImageLoader.loadimage("/Textures/Entity/Zombie.png"));
        Sheet ghost= new Sheet(ImageLoader.loadimage("/Textures/Entity/Ghost.png"));
        Sheet player= new Sheet(ImageLoader.loadimage("/Textures/Entity/player.png"));
        Sheet tiles= new Sheet(ImageLoader.loadimage("/Textures/Tiles/Tiles.png"));
        Sheet addOns= new Sheet(ImageLoader.loadimage("/Textures/StaticEntity/entity.png"));
        ghost_down= new BufferedImage[4];
        ghost_up= new BufferedImage[4];
        ghost_left= new BufferedImage[4];
        ghost_right= new BufferedImage[4];
        //GHOST
        ghost_down[0]= ghost.crop(0,0,128,128);
        ghost_down[1]=ghost.crop(128,0,128,128);
        ghost_down[2]=ghost.crop(128*2,0,128,128);
        ghost_down[3]=ghost.crop(128*3,0,128,128);

        ghost_up[0]= ghost.crop(0,128*3,128,128);
        ghost_up[1]=ghost.crop(128,128*3,128,128);
        ghost_up[2]=ghost.crop(128*2,128*3,128,128);
        ghost_up[3]=ghost.crop(128*3,128*3,128,128);

        ghost_right[0]= ghost.crop(0,128*2,128,128);
        ghost_right[1]=ghost.crop(128,128*2,128,128);
        ghost_right[2]=ghost.crop(128*2,128*2,128,128);
        ghost_right[3]=ghost.crop(128*3,128*2,128,128);

        ghost_left[0]= ghost.crop(0,128,128,128);
        ghost_left[1]=ghost.crop(128,128,128,128);
        ghost_left[2]=ghost.crop(128*2,128,128,128);
        ghost_left[3]=ghost.crop(128*3,128,128,128);

        //player
        player_left= new BufferedImage[4];
        player_up= new BufferedImage[4];
        player_down= new BufferedImage[4];
        player_right= new BufferedImage[4];

        player_down[0]=player.crop(0,0,128,128);
        player_down[1]=player.crop(128,0,128,128);
        player_down[2]=player.crop(128*2,0,128,128);
        player_down[3]=player.crop(128*3,0,128,128);

        player_up[0]= player.crop(0,128,128,128);
        player_up[1]=player.crop(128,128,128,128);
        player_up[2]=player.crop(128*2,128,128,128);
        player_up[3]=player.crop(128*3,128,128,128);

        player_right[0]= player.crop(0,128*3,128,128);
        player_right[1]=player.crop(128,128*3,128,128);
        player_right[2]=player.crop(128*2,128*3,128,128);
        player_right[3]=player.crop(128*3,128*3,128,128);

        player_left[0]= player.crop(0,128*2,128,128);
        player_left[1]=player.crop(128,128*2,128,128);
        player_left[2]=player.crop(128*2,128*2,128,128);
        player_left[3]=player.crop(128*3,128*2,128,128);
        //tiles
        brick= tiles.crop(0,0,128,128);
        brickGrass=tiles.crop(0,128,128,128);
        grass=tiles.crop(128,0,128,128);
        //add ons
        tree=addOns.crop(128,0,128,256);
        grave=addOns.crop(0,0,128,128);
    }
}
