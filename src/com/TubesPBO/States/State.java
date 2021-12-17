package com.TubesPBO.States;

import com.TubesPBO.Game.Game;
import com.TubesPBO.Game.Handler;

import java.awt.*;

public abstract class State {// main menu settings dll

    //biar kita tau mana yg akan di render ke screen (gamenya atau menu atau setting,dll)
    private static State currentState= null;
    protected Handler handler;
    public State(Handler handler){
        this.handler=handler;
    }
    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }
    //

    public abstract void update();
    public abstract void render(Graphics g);
    public abstract void switched();
}
