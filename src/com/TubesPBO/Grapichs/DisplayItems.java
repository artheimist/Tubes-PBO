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
                g.drawImage(Assets.heart,10,10,30,30,null);
                break;
            case 2:
                g.drawImage(Assets.heart,10,10,30,30,null);
                g.drawImage(Assets.heart,50,10,30,30,null);
                break;
            case 3:
                g.drawImage(Assets.heart,10,10,30,30,null);
                g.drawImage(Assets.heart,50,10,30,30,null);
                g.drawImage(Assets.heart,90,10,30,30,null);
                break;
            default:
                break;
        }
        weaponGhost(g);
    }

    public void weaponGhost(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawImage(Assets.salib,360,20,30,30,null);
        g.drawString(handler.getWorld().getEntityManager().getPlayer().tostring(),400, 47);
    }
}
