package com.strel.townsmen.game.objects.player

import com.strel.townsmen.engine.IsometricDraw
import com.strel.townsmen.engine.game.Controllable
import com.strel.townsmen.engine.input.InputHandler
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.TownsmenGame
import com.strel.townsmen.game.map.ObjectMap
import com.strel.townsmen.game.menu.BuildMenu
import com.strel.townsmen.game.objects.PlayerResources
import com.strel.townsmen.game.objects.player.commands.BuildCommand
import com.strel.townsmen.game.objects.player.commands.Command
import com.strel.townsmen.game.states.MenuState

import java.awt.Graphics2D
import java.awt.event.KeyEvent

/**
 * Created by strel on 14.06.15.
 */
class Player implements Controllable {

    int x
    int y

    PlayerResources resources
    ObjectMap       map

    Command buildCmd = new BuildCommand()


    Player(int map_x, int map_y) {
        x = map_x * GameConfig.TILE_SIZE / 2
        y = map_y * GameConfig.TILE_SIZE / 2
    }

    @Override
    void handleInput(InputHandler input) {
        if (input.keyDownOnce(KeyEvent.VK_DOWN)) {
            y += GameConfig.PLAYER_DY;
        }

        else if (input.keyDownOnce(KeyEvent.VK_UP)) {
            y -= GameConfig.PLAYER_DY;
        }

        else if (input.keyDownOnce(KeyEvent.VK_LEFT)) {
            x -= GameConfig.PLAYER_DX;
        }

        else if (input.keyDownOnce(KeyEvent.VK_RIGHT)) {
            x += GameConfig.PLAYER_DX;
        }

        else if (input.keyDownOnce(KeyEvent.VK_SPACE)) {
            buildCmd.execute(this)
        }
    }

    @Override
    void update(InputHandler input) {
        handleInput(input)
    }

    @Override
    void draw(Graphics2D g) {
        IsometricDraw.drawImage(g, GameConfig.IMG_PLAYER, x, y);
    }
}
