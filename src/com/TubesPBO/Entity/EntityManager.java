package com.TubesPBO.Entity;

import com.TubesPBO.Entity.Creature.Player;
import com.TubesPBO.Game.Handler;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler, Player player){
        this.handler=handler;
        this.player=player;
        entities= new ArrayList<Entity>();
        addEntity(player);
    }
    public void update(){
        for (int i=0; i<entities.size();i++){
            Entity e = entities.get(i);
            e.update();
        }

    }
    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }

    }
    public void addEntity(Entity e){
        entities.add(e);
    }
    public Player getPlayer() {
        return player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
