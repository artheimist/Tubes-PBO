package com.TubesPBO.States;

import com.TubesPBO.Database.Database;
import com.TubesPBO.Game.Handler;
import com.TubesPBO.Grapichs.Assets;

import javax.swing.*;
import java.awt.*;

public class GameFinished extends State {
    private String name;
    public GameFinished(Handler handler) {
        super(handler);
    }

    @Override
    public void update() {
        if(handler.getKeyManager().enter){
            setFrame();
            handler.getGame().menuState.switched();
            State.setState(handler.getGame().menuState);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.gamewonBg,0,0,640,480,null);
        g.drawImage(Assets.gamewonTitle,200,70,null);
        g.setColor(Color.lightGray);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Press Enter to continue", 160, 270);

    }
    public void setFrame(){
        if(name == null) {
            name = JOptionPane.showInputDialog("Input your name");
            Database.saveWinner(name);
            return;
        }

    }
    @Override
    public void switched() {

    }
}
