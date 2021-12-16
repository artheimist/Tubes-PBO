package com.TubesPBO.Entity.Static;

import com.TubesPBO.Game.Handler;
import com.TubesPBO.Grapichs.Assets;

import java.awt.*;

public class Chest extends  StaticEntity{
    public boolean weaponTaken,weapon;
    public Chest(Handler handler, float x, float y,boolean weapon) {
        super(handler, 64, 64, x, y);
        health=1;
        bounds.x=10;
        bounds.y=(int)(height/1.5f);
        bounds.width=width-20;
        bounds.height=(int)(height-height/1.2f);
        weaponTaken=false;
        this.weapon=weapon;
    }

    @Override
    public void update() {

    }

    @Override
    public void die() {}

    @Override
    public void render(Graphics g) {
        if (health <= 0) {
            g.drawImage(Assets.chestOpened,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
            if(weapon){
                if(!weaponTaken){
                    handler.getWorld().getEntityManager().getPlayer().setWeapon(1);
                    weaponTaken=true;
                }
            }
        }if(health>0){
            g.drawImage(Assets.chest,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
        }
    }
}
