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
    //zombie
    public static BufferedImage[]zombie_down,zombie_up,zombie_left,zombie_right;
    //add ons
    public static BufferedImage tree,grave;
    //item
    public static BufferedImage salib,heart,chest,chestOpened,gate,gateOpened;
    public static BufferedImage exit,pauseBg,gameOverBg,title,start,continue1,killAll,enemies,gameOverTitle,gamewonBg,gamewonTitle;
    //bg
    public static BufferedImage menu;
    public static void init(){
        Sheet zombie= new Sheet(ImageLoader.loadimage("/Textures/Entity/zombie.png"));
        Sheet titleGame= new Sheet(ImageLoader.loadimage("/Textures/Ui/gameOverTitle.png"));
        Sheet titlePause= new Sheet(ImageLoader.loadimage("/Textures/Ui/titlepause.png"));
        Sheet pause= new Sheet(ImageLoader.loadimage("/Textures/Ui/pause.png"));
        Sheet items= new Sheet(ImageLoader.loadimage("/Textures/StaticEntity/items.png"));
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
        //zombie
        zombie_up= new BufferedImage[4];
        zombie_down= new BufferedImage[4];
        zombie_left=new BufferedImage[4];
        zombie_right=new BufferedImage[4];

        zombie_down[0]=zombie.crop(0,0,128,128);
        zombie_down[1]=zombie.crop(128,0,128,128);
        zombie_down[2]=zombie.crop(128*2,0,128,128);
        zombie_down[3]=zombie.crop(128*3,0,128,128);

        zombie_up[0]=zombie.crop(0,128,128,128);
        zombie_up[1]=zombie.crop(128,128,128,128);
        zombie_up[2]=zombie.crop(128*2,128,128,128);
        zombie_up[3]=zombie.crop(128*3,128,128,128);

        zombie_left[0]=zombie.crop(0,128*2,128,128);
        zombie_left[1]=zombie.crop(128,128*2,128,128);
        zombie_left[2]=zombie.crop(128*2,128*2,128,128);
        zombie_left[3]=zombie.crop(128*3,128*2,128,128);

        zombie_right[0]=zombie.crop(0,128*3,128,128);
        zombie_right[1]=zombie.crop(128,128*3,128,128);
        zombie_right[2]=zombie.crop(128*2,128*3,128,128);
        zombie_right[3]=zombie.crop(128*3,128*3,128,128);

        //tiles
        brick= tiles.crop(0,0,128,128);
        brickGrass=tiles.crop(0,128,128,128);
        grass=tiles.crop(128,0,128,128);
        //add ons
        tree=addOns.crop(128,0,128,256);
        grave=addOns.crop(0,0,128,128);
        chest= items.crop(0,128*2,128,128);
        chestOpened= items.crop(128,128*2,128,128);
        // item
        salib=items.crop(0,0,128,128);
        heart=items.crop(128,0,128,128);
        gate=items.crop(0,128,128,128);
        gateOpened=items.crop(128,128,128,128);
        //title & stuff
        title=titlePause.crop(0,128*2,256,128);
        start=pause.crop(0,0,256,128);
        continue1=pause.crop(0,128,256,128);
        exit=pause.crop(0,128*2,256,128);
        //bg
        menu=ImageLoader.loadimage("/Textures/Ui/Menu.png");
        pauseBg=ImageLoader.loadimage("/Textures/Ui/PauseBg.png");
        killAll=titlePause.crop(0,0,256,128);
        enemies=titlePause.crop(0,128,256,128);
        gameOverBg=ImageLoader.loadimage("/Textures/Ui/GameOverbg.png");
        gameOverTitle=titleGame.crop(0,128,256,128);
        gamewonBg=ImageLoader.loadimage("/Textures/Ui/GameWon.png");
        gamewonTitle=titleGame.crop(0,0,256,128);
    }
}
