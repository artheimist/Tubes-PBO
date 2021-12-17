package com.TubesPBO.Entity;

import com.TubesPBO.Entity.Creature.Ghost;
import com.TubesPBO.Entity.Creature.Player;
import com.TubesPBO.Entity.Creature.Zombie;
import com.TubesPBO.Game.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class EntityManager {
    private Handler handler;
    private Player player;
    public int count=0;
    public boolean isOpen=false;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSort =new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY()+a.getHeight()<b.getY()+b.getHeight()){
                return -1;
            }
            return 1;
        }
    };

    public EntityManager(Handler handler, Player player){
        this.handler=handler;
        this.player=player;
        entities= new ArrayList<>();
        addEntity(player);
    }
    public void update(){
        for (int i=0; i<entities.size();i++){
            Entity e = entities.get(i);
            e.update();
            if(!e.isActive()){
                entities.remove(e);
                count--;
                if(count<=0){
                    isOpen=true;
                }
            }
        }
        entities.sort(renderSort);

    }
    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }

    }
    public void addEntity(Entity e){
        entities.add(e);
        if(e.deadly){
            count++;
        }
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

    public boolean isOpen() {
        return isOpen;
    }
}
