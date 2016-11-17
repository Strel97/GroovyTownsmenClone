package com.strel.townsmen.game.objects.entities.woodcutter

import com.strel.townsmen.engine.IsometricDraw
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.map.ObjectMap
import com.strel.townsmen.game.objects.entities.Gatherer

import java.awt.Graphics2D

/**
 * Created by strel on 13.06.15.
 */
class Woodcutter extends Gatherer {

    Woodcutter() {
        state = new IdleState(this)
    }

    @Override
    void update(ObjectMap map) {
        state.update(map)
    }

    @Override
    void draw(Graphics2D g) {
        IsometricDraw.drawImage(g, GameConfig.IMG_WOODCUTTER, x, y - 4)
    }
}
