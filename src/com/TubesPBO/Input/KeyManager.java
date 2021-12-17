package com.TubesPBO.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;             // kenapa pakek array, agar dapat bergerak secara diagonal
    public boolean up,down,left,right,esc,enter;
    public boolean arrUp,arrDown,arrLeft,arrRight;

    public KeyManager(){
        keys= new boolean[256];
    }
    public void update(){
        up=keys[KeyEvent.VK_UP];
        down=keys[KeyEvent.VK_DOWN];
        left=keys[KeyEvent.VK_LEFT];
        right=keys[KeyEvent.VK_RIGHT];
        esc=keys[KeyEvent.VK_ESCAPE];
        enter=keys[KeyEvent.VK_ENTER];

        arrUp=keys[KeyEvent.VK_UP];
        arrDown=keys[KeyEvent.VK_DOWN];
        arrLeft=keys[KeyEvent.VK_LEFT];
        arrRight=keys[KeyEvent.VK_RIGHT];
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()]=false;
    }
}
