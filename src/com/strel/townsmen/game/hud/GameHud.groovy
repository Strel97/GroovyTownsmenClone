package com.strel.townsmen.game.hud

import com.strel.townsmen.engine.game.Playable
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.TownsmenGame

import java.awt.Graphics2D

/**
 * Created by strel on 16.06.15.
 */
class GameHud implements Playable {

    @Override
    void update() {

    }

    @Override
    void draw(Graphics2D g) {
        TownsmenGame game = TownsmenGame.instance
        g.drawImage(GameConfig.IMG_GAME_BACKGROUND, 0, 0, game.wndWidth(), game.wndHeight(), null)
    }
}
