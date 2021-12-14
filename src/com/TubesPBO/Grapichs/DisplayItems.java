package com.TubesPBO.Grapichs;

import com.TubesPBO.Game.Game;
import com.TubesPBO.Game.Handler;

import java.awt.*;

public class DisplayItems {
    private Handler handler;
    public DisplayItems(Handler handler){
        this.handler=handler;
    }

    public void update(){

    }
    public void render(Graphics g){
        switch (handler.getWorld().getEntityManager().getPlayer().getHealth()){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
        weaponGhost(g);
        weaponZombie(g);
    }
    public void weaponZombie (Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
    }
    public void weaponGhost(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(handler.getWorld().getEntityManager().getPlayer().getWeaponGhost(),400, 47);
    }
}
