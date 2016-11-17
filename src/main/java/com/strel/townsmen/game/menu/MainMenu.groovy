package com.strel.townsmen.game.menu

import com.strel.townsmen.engine.GameFont
import com.strel.townsmen.engine.input.InputHandler
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.TownsmenGame
import com.strel.townsmen.game.hud.MainMenuHud

import java.awt.Graphics2D
import java.awt.event.KeyEvent

/**
 * Created by strel on 13.06.15.
 */
class MainMenu extends Menu {

    String logo = 'Townsmen'

    int NEW_GAME_OPTION = 0
    int EXIT_OPTION     = 1

    MainMenuHud hud


    MainMenu() {
        options = [
                'New Game',
                'Exit'
        ]

        current = 0

        hud = new MainMenuHud()
    }

    @Override
    void handleInput(InputHandler input) {
        if (input.keyDown(KeyEvent.VK_ENTER)) {
            if (current == EXIT_OPTION)
                TownsmenGame.instance.stop()

            else if (current == NEW_GAME_OPTION)
                TownsmenGame.instance.newGame()
        }
    }

    @Override
    void update(InputHandler input) {
        super.handleInput(input)
        handleInput(input)
    }

    @Override
    void draw(Graphics2D g) {
        hud.draw(g)

        GameFont font = GameConfig.FONT

        font.draw(g, logo, 20, GameConfig.MENU_MAIN_LOGO_COORDS);
        drawOptions(g, GameConfig.MENU_MAIN_OPTIONS_COORDS);
    }
}
