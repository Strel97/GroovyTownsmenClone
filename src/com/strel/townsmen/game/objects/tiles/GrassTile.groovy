package com.strel.townsmen.game.objects.tiles

import com.strel.townsmen.engine.IsometricDraw
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.objects.GameObject

import java.awt.Graphics2D

/**
 * Created by strel on 13.06.15.
 */
class GrassTile extends GameObject {


    @Override
    void update() {

    }

    @Override
    void draw(Graphics2D g) {
        IsometricDraw.drawImage(g, GameConfig.IMG_GRASS, x, y)
    }
}
