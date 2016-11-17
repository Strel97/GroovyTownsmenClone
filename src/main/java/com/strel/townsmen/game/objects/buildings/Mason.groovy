package com.strel.townsmen.game.objects.buildings

import com.strel.townsmen.engine.IsometricDraw
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.objects.GameObject

import java.awt.Graphics2D

/**
 * Created by strel on 17.06.15.
 */
class Mason extends GameObject {

    Mason() {
        id = GameConfig.MASON_OBJ
    }

    @Override
    void update() {

    }

    @Override
    void draw(Graphics2D g) {
        IsometricDraw.drawImage(g, GameConfig.IMG_MASON, x - GameConfig.OBJECT_MAP_Z, y - GameConfig.OBJECT_MAP_Z)
    }
}
