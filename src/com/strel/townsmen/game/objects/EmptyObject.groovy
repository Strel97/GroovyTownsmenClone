package com.strel.townsmen.game.objects

import java.awt.Graphics2D

/**
 * Created by strel on 13.06.15.
 */
class EmptyObject extends GameObject {

    @Override
    void update() {

    }

    @Override
    void draw(Graphics2D g) {

    }


    @Override
    String toString() {
        return "EMPTY OBJECT at [$x, $y]";
    }
}
