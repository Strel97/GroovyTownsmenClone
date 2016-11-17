package com.strel.townsmen.engine.game;

import com.strel.townsmen.game.GameConfig;
import com.strel.townsmen.engine.GamePanel;
import com.strel.townsmen.engine.input.InputHandler;

import java.awt.image.BufferedImage;

/**
 * Created by strel on 18.05.15.
 */
public class GameCore implements Runnable {

    protected GamePanel canvas;
    protected InputHandler input;
    protected BufferedImage img;

    private boolean running;
    private Thread  thread;
    private int     fps;



    protected GameCore() {
        canvas = new GamePanel();
        input = new InputHandler();

        canvas.addKeyListener(input);

        int width = Math.round(canvas.getWidth() / GameConfig.SCALE);
        int height = Math.round(canvas.getHeight() / GameConfig.SCALE);
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        if (!running)
            return;

        running = false;
    }

    @Override
    public void run() {

        long startTime = System.currentTimeMillis();
        long currTime = startTime;

        int frames = 0;
        long time = 0;

        while (running) {
            long elapsedTime = System.currentTimeMillis() - currTime;
            currTime += elapsedTime;
            time += elapsedTime;

            if (time >= 1000) {
                fps = frames;

                frames = 0;
                time = 0;
            }

            update(elapsedTime);
            render();

            frames++;


            try {
                Thread.sleep(50);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

        System.exit(0);
    }

    public void handleInput() {
    }

    public void update(long elapsedTime) {
    }

    public void render() {
    }


    public GamePanel getCanvas() {
        return canvas;
    }

    public InputHandler getInputHandler() {
        return input;
    }

    public boolean isRunning() {
        return running;
    }
}
