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
        g.drawImage(Assets.belati1,470,20,30,30,null);
        g.drawString(handler.getWorld().getEntityManager().getPlayer().getWeaponZombie(),510, 47);
    }
    public void weaponGhost(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawImage(Assets.salib1,360,20,30,30,null);
        g.drawString(handler.getWorld().getEntityManager().getPlayer().getWeaponGhost(),400, 47);
    }
}
