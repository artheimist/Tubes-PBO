package com.TubesPBO.Input;

import com.TubesPBO.Ui.UiManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed,rightPressed;
    private int mouseX,mouseY;
    private UiManager uiManager;
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1){
            leftPressed=true;
        }else if(e.getButton()==MouseEvent.BUTTON3){
            rightPressed=true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1){
            leftPressed=false;
        }else if(e.getButton()==MouseEvent.BUTTON3){
            rightPressed=false;
        }
        if(uiManager != null){
            uiManager.onMouseRelease(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        if(uiManager != null){
            uiManager.onMouseMove(e);
        }
    }

    public void setUiManager(UiManager uiManager) {
        this.uiManager = uiManager;
    }
}
