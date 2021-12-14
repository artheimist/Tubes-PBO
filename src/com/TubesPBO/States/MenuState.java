package com.TubesPBO.States;

import com.TubesPBO.Game.Game;
import com.TubesPBO.Game.Handler;
import com.TubesPBO.Grapichs.Assets;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class MenuState extends State implements MouseListener {
    BufferedImage image= Assets.tree;
    public MenuState(Handler handler){
        super(handler);
    }
    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image,0,0,null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      setState(handler.getGame().gameState);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
