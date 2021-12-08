package com.TubesPBO.Game;

import com.TubesPBO.Display.Display;
import com.TubesPBO.Grapichs.Assets;
import com.TubesPBO.Grapichs.GameCamera;
import com.TubesPBO.Input.KeyManager;
import com.TubesPBO.States.GameState;
import com.TubesPBO.States.State;


import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{ // extend Thread
    private int width, height;
    public String title;
    private boolean running=false;

    private Display display;        // buat displaynya
    private Thread thread;          //thread
    private BufferStrategy bs;      // kayak sebuah screen tempat gambar di render atau di tampilkan sebelum di tampilakn ke layar asli
    private Graphics g;             // paint brush alat buat gambarnya

    private State gameState;        //
    private KeyManager keyManager;  //
    private GameCamera gameCamera;  //
    private Handler handler;
    Game (String title, int width, int height){
        this.width=width;
        this.height=height;
        this.title=title;
        keyManager= new KeyManager();
    }
    public void init(){ // inisialisasi untuk gamenya ex: display
        display=new Display(title,width,height); // nampilin display (Jframe dkk) a.k.a GUI
        //nanti//
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        handler= new Handler(this);
        gameCamera= new GameCamera(handler,0,0);
        //mana yang akan ditampilkan duluan
        gameState= new GameState(handler);
        State.setState(gameState); // set nilai state nya disini klo mau nampilin langsung game nya, klo mau menu jadinya di set menuState
    }
    public void update(){
        keyManager.update();
        if(State.getState()!=null){
            State.getState().update();
        }
    }
    public void render(){
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null){
          display.getCanvas().createBufferStrategy(3);
          return;
        }
        g=bs.getDrawGraphics();
        //start drawing
        g.clearRect(0,0,width,height);

        if(State.getState()!=null){
            State.getState().render(g);
        }
        // end draw
        bs.show();
        g.dispose();
    }
    public void run() {
        init();
        int fps=60;
        double timePerUpdate=1000000000/fps; //nano detik agar lebih presisi
        double delta =0;
        long now;
        long lastTime= System.nanoTime();// ngambil waktu sekarang dalam nano
        while(running){
            now= System.nanoTime();//// ngambil waktu sekarang dalam nano saat looping (?)
            delta+=(now-lastTime)/timePerUpdate;
            lastTime=now;
            if(delta>=1){
                update();
                render();
                delta--;
            }

        }
        stop();
    }
    public synchronized  void start(){
        if(running){
            return;
        }
        running=true;
        thread =new Thread(this);
        thread.start(); //calling run method
    }
    public synchronized  void stop (){
        if(running){
            return;
        }
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
