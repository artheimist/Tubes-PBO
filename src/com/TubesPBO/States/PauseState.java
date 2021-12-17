package com.TubesPBO.States;

import com.TubesPBO.Game.Handler;
import com.TubesPBO.Grapichs.Assets;
import com.TubesPBO.Ui.Click;
import com.TubesPBO.Ui.UiButton;
import com.TubesPBO.Ui.UiManager;

import java.awt.*;

public class PauseState extends State{
    public UiManager uiManager;
    public PauseState(Handler handler) {
        super(handler);
        uiManager= new UiManager(handler);

        uiManager.addObject(new UiButton(230, 150, 190, 100, Assets.continue1, new Click() {
            @Override
            public void onClick() {

                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
        uiManager.addObject(new UiButton(230, 250, 190, 100, Assets.exit, new Click() {
            @Override
            public void onClick() {
                handler.getGame().menuState.switched();
                State.setState(handler.getGame().menuState);
            }
        }));
    }

    @Override
    public void update() {
        uiManager.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.pauseBg,0,0,640,480,null);
        g.drawImage(Assets.killAll,170, 50,190,100,null);
        g.drawImage(Assets.enemies,340, 50,190,100,null);

        uiManager.render(g);
    }

    @Override
    public void switched() {
        handler.getMouseManager().setUiManager(uiManager);
    }

    public UiManager getUiManager() {
        return uiManager;
    }
}
