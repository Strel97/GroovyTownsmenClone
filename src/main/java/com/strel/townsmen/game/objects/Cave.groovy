package com.strel.townsmen.game.objects

import com.strel.townsmen.engine.IsometricDraw
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.objects.resources.Stone

import java.awt.Graphics2D

/**
 * Created by strel on 25.06.15.
 */
class Cave extends ResourceObject {

    Cave() {
        id = GameConfig.CAVE_OBJ
        resource = new Stone(GameConfig.RESOURCE_STONE_PER_CAVE)
    }

    @Override
    void draw(Graphics2D g) {
        IsometricDraw.drawImage(g, GameConfig.IMG_CAVE, x - GameConfig.OBJECT_MAP_Z, y - GameConfig.OBJECT_MAP_Z)
    }

    @Override
    void update() {

    }

    @Override
    String toString() {
        return "CAVE at [$x, $y]"
    }
}
