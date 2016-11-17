package com.strel.townsmen.game.objects.entities

import com.strel.townsmen.game.map.ObjectMap
import com.strel.townsmen.game.objects.GameObject

import java.awt.Graphics2D

/**
 * Created by strel on 14.06.15.
 */
abstract class Entity extends GameObject {

    protected int dx
    protected int dy

    EntityState state

    /**
     * We use another version of
     * update method. So just ignore
     * this one.
     */
    @Override
    void update() {
    }

    abstract void update(ObjectMap map)

    void stepTo(GameObject target) {
        dx = Math.signum( target.x - x )
        dy = Math.signum( target.y - y )

        x += dx
        y += dy
    }

    boolean reached(GameObject target) {
        return target.x == x && target.y == y
    }
}
