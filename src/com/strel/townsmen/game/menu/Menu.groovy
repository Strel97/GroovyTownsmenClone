package com.strel.townsmen.game.menu

import com.strel.townsmen.engine.GameFont
import com.strel.townsmen.engine.Point
import com.strel.townsmen.engine.game.Controllable
import com.strel.townsmen.engine.input.InputHandler
import com.strel.townsmen.game.GameConfig

import java.awt.Graphics2D
import java.awt.event.KeyEvent

/**
 * Created by strel on 13.06.15.
 */
abstract class Menu implements Controllable {

    protected String[] options
    protected int current


    Menu() {
        options = []
        current = -1
    }

    @Override
    void handleInput(InputHandler input) {
        if (input.keyDown(KeyEvent.VK_DOWN) && current != options.length - 1) {
            current++;
        }
        else if (input.keyDown(KeyEvent.VK_UP) && current != 0) {
            current--;
        }
    }

    @Override
    void update(InputHandler input) {
        handleInput(input)
    }

    void drawOptions(Graphics2D g, int x, int y) {

        GameFont font = GameConfig.FONT
        def y_step = y;

        options.each { option ->
            // Pick out current option
            if (option == options[current])
                option = "> " + option;

            font.draw(g, option, x, y_step);
            y_step += GameConfig.MENU_OPTIONS_LEADING;
        }
    }

    void drawOptions(Graphics2D g, Point coord) {
        drawOptions(g, coord.x, coord.y)
    }
}
