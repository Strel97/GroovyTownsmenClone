package com.strel.townsmen.engine;

import com.strel.townsmen.game.GameConfig;

import javax.swing.*;
import java.awt.*;

/**
 * Created by strel on 18.05.15.
 */
public class GamePanel extends JPanel {

    public GamePanel() {
        setSize(new Dimension(GameConfig.DEFAULT_WIDTH, GameConfig.DEFAULT_HEIGHT));
        setFocusable(true);

        requestFocus();
    }

    public void render(Graphics2D g) {
        g.setColor(GameConfig.COLOR_BACKGROUND);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
