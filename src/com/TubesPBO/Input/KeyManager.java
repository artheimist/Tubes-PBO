package com.TubesPBO.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;             // kenapa pakek array, agar dapat bergerak secara diagonal
    public boolean up,down,left,right;
    public boolean arrUp,arrDown,arrLeft,arrRight;

    public KeyManager(){
        keys= new boolean[256];
    }
    public void update(){
        up=keys[KeyEvent.VK_UP];
        down=keys[KeyEvent.VK_DOWN];
        left=keys[KeyEvent.VK_LEFT];
        right=keys[KeyEvent.VK_RIGHT];

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
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }
}
