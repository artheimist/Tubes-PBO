package com.TubesPBO.States;

import com.TubesPBO.Entity.Creature.Player;
import com.TubesPBO.Entity.Static.Tree;
import com.TubesPBO.Game.Game;
import com.TubesPBO.Game.Handler;
import com.TubesPBO.World.World;

import java.awt.*;

public class GameState extends State {// real game state
    private Player player;
    private World world;
    private Tree tree;
    public GameState(Handler handler){
        super(handler);
        world= new  World(handler,"res/Map/Map.txt");
        handler.setWorld(world);
//        player=new Player(handler,50,50);
    }

    @Override
    public void update() {
        world.update();


    }

    @Override
    public void render(Graphics g) {
        world.render(g);

    }

}
