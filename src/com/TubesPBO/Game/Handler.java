package com.TubesPBO.Game;

import com.TubesPBO.Grapichs.GameCamera;
import com.TubesPBO.Input.KeyManager;
import com.TubesPBO.Input.MouseManager;
import com.TubesPBO.World.World;

public class Handler {

    private Game game;
    private World world;


    public Handler(Game game){
        this.game=game;
    }
    public int getWidth(){
        return game.getWidth();
    }
    public int getHeight(){
        return game.getWidth();
    }
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }
    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public Game getGame() {
        return game;
    }

    public World getWorld() {
        return world;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setWorld(World world) {
        this.world = world;
    }
    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }
}
