package com.strel.townsmen.game.states

import com.strel.townsmen.engine.input.InputHandler
import com.strel.townsmen.game.menu.Menu

import java.awt.Graphics2D

/**
 * Created by strel on 13.06.15.
 */
class MenuState implements GameState {

    private Menu menu


    MenuState(Menu menu) {
        this.menu = menu
    }

    @Override
    void handleInput(InputHandler input) {
    }

    @Override
    void update(InputHandler input) {
        menu.update(input)
    }

    @Override
    void draw(Graphics2D g) {
        menu.draw(g)
    }
}
