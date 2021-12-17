package com.TubesPBO.States;

import com.TubesPBO.Entity.Creature.Player;
import com.TubesPBO.Entity.Static.Tree;
import com.TubesPBO.Game.Game;
import com.TubesPBO.Game.Handler;
import com.TubesPBO.World.World;

import java.awt.*;

public class GameState extends State {// real game state
    private World world;
    public GameState(Handler handler){
        super(handler);
        world= new  World(handler,"res/Map/Map.txt");
        handler.setWorld(world);
//        player=new Player(handler,50,50);
    }

    public void start(){
        world= new  World(handler,"res/Map/Map.txt");
        handler.setWorld(world);
    }
    @Override
    public void update() {
        world.update();
        if(handler.getKeyManager().esc){
            handler.getGame().pauseState.switched();
            State.setState(handler.getGame().pauseState);
        }
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }

    @Override
    public void switched(){
       start();
    }

}
