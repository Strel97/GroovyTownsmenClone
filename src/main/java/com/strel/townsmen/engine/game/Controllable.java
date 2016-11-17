package com.strel.townsmen.engine.game;

import com.strel.townsmen.engine.input.InputHandler;

import java.awt.*;

/**
 * Created by strel on 13.06.15.
 */
public interface Controllable {

    public void handleInput(InputHandler input);
    public void update(InputHandler input);
    public void draw(Graphics2D  g);

}
