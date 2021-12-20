package com.TubesPBO.Entity.Creature;

import com.TubesPBO.Entity.Entity;
import com.TubesPBO.Entity.Static.Chest;
import com.TubesPBO.Game.Handler;
import com.TubesPBO.Grapichs.Animation;
import com.TubesPBO.Grapichs.Assets;
import com.TubesPBO.Grapichs.DisplayItems;
import com.TubesPBO.States.PauseState;
import com.TubesPBO.States.State;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{
    int lastFrame=4;
    private int health,weapon;
    private DisplayItems displayItems;
    private Animation animationDown,animationUp,animationRight,animationLeft;
    public Player(Handler handler , float x, float y) {
        super(handler,x, y,Creature.deafult_creature_width,Creature.deafult_creature_height);
        bounds.x=16;
        bounds.y=32;
        bounds.width=32;
        bounds.height=32;
        health=3;
        weapon=0;
        init();
        displayItems= new DisplayItems(handler);
    }
    public void init(){
        animationDown= new Animation(200,Assets.player_down);
        animationUp= new Animation(200,Assets.player_up);
        animationRight= new Animation(200,Assets.player_right);
        animationLeft= new Animation(200,Assets.player_left);
    }
    public void animationUpdate(){
        animationDown.update();
        animationUp.update();
        animationRight.update();
        animationLeft.update();
    }
    @Override
    public void update() {
        animationUpdate();
        input();
        movement();
        die();
        handler.getGameCamera().cameraOnEntity(this);
        displayItems.update();
        attack();
    }

    @Override
    public void die() {
        if(health==0){
            State.setState(handler.getGame().gameOverState);
        }
        Rectangle playerBody = getCollisionBoundsEnemy(0, 0);
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(playerBody.intersects(e.getCollisionBoundsEnemy(0, 0)) && e.isDeadly() ){
                this.health--;
                //set posisi player ke tmpt awal tiap kali dia mati
                handler.getWorld().getEntityManager().getPlayer().setX(handler.getWorld().getSpawnX());
                handler.getWorld().getEntityManager().getPlayer().setY(handler.getWorld().getSpawnY());
            }if(playerBody.intersects(e.getCollisionBoundsEnemy(0, 0))&& e.isEndGame()){
                State.setState(handler.getGame().gameFinished);
                return;
            }

        }
    }
    public void attack(){
        Rectangle att= new Rectangle();
        Rectangle collision= getCollisionBounds(0,0);
        int attackArea=20;
        att.width=attackArea;
        att.height=attackArea;

        if(handler.getKeyManager().arrUp){
            att.x=collision.x+collision.width/2-attackArea/2;
            att.y=collision.y-attackArea;
        }else if(handler.getKeyManager().arrDown){
            att.x=collision.x+collision.width/2-attackArea/2;
            att.y=collision.y+collision.height;
        }else if(handler.getKeyManager().arrLeft){
            att.x=collision.x-attackArea;
            att.y=collision.y+collision.height/2-attackArea/2;
        }else if(handler.getKeyManager().arrRight){
            att.x=collision.x+collision.width;
            att.y=collision.y+collision.height/2-attackArea/2;
        }else {
            return;
        }
//        for (int i=0;i<handler.getWorld().getEntityManager().getEntities().size();i++){
//            Entity e = handler.getWorld().getEntityManager().getEntities().get(i);
//        }
        for(Entity e: handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }if(e.getCollisionBoundsEnemy(0,0).intersects(att)&&e.isDeadly()&&this.weapon>0){
                e.receiveDamage(1);
                return;
            }else if(e.getCollisionBoundsEnemy(0,0).intersects(att)&&!e.isDeadly()){
                e.receiveDamage(1);
                return;
            }

        }

    }
    private void input(){
        moveX=0;
        moveY=0;

        if(handler.getKeyManager().up){
            moveY= -speed;
        }if(handler.getKeyManager().down){
            moveY= speed;
        }
        if(handler.getKeyManager().left){
            moveX= -speed;
        }
        if(handler.getKeyManager().right){
            moveX= speed;
        }
    }
    @Override
    public void render(Graphics g) {
        displayItems.render(g);
        g.drawImage(getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset() ),width,height,null);
//        g.setColor(Color.red);
//        g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),(int)(y+bounds.y-handler.getGameCamera().getyOffset()),bounds.width, bounds.height);
    }
    private BufferedImage getCurrentFrame(){
        if(moveY<0){
            lastFrame=1;
           return animationUp.getCurrentFrame();
        }else if(moveX>0){
            lastFrame=2;
            return animationRight.getCurrentFrame();
        }else if (moveX<0){
            lastFrame=3;
            return animationLeft.getCurrentFrame();
        } else if (moveY>0){
            lastFrame=4;
            return animationDown.getCurrentFrame();
        }
        return getIdleFrame();
    }
    private BufferedImage getIdleFrame(){
        switch(lastFrame){
            case 1:
                return animationUp.getIdleFrame();

            case 2:
                return animationRight.getIdleFrame();

            case 3:
                return animationLeft.getIdleFrame();

            case 4:
                return animationDown.getIdleFrame();

            default:
                return null;
        }
    }

    @Override
    public int getHealth() {
        return health;
    }

    public int getWeapon() {
        return weapon;
    }
    public String tostring(){
        String s=Integer.toString(getWeapon());
        return s;
    }
    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }
}
