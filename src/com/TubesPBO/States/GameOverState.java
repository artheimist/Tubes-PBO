package com.TubesPBO.States;

import com.TubesPBO.Game.Handler;
import com.TubesPBO.Grapichs.Assets;
import com.TubesPBO.Ui.UiManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOverState extends State{
    private UiManager uiManager;
    public GameOverState(Handler handler) {
        super(handler);
        uiManager= new UiManager(handler);

    }

    @Override
    public void update() {
        if(handler.getKeyManager().enter){
            handler.getGame().menuState.switched();
            State.setState(handler.getGame().menuState);
        }
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.gameOverBg,0,0, 640,480,null);
        g.drawImage(Assets.gameOverTitle,200,100,null);
        g.setColor(Color.gray);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Press Enter to continue", 160, 300);
    }

    @Override
    public void switched() {

    }

}
