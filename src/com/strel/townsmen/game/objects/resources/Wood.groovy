package com.strel.townsmen.game.objects.resources

import com.strel.townsmen.game.GameConfig

import java.awt.Graphics2D

/**
 * Created by strel on 13.06.15.
 */
class Wood extends Resource {

    Wood(int amount) {
        this.amount = amount
        id = GameConfig.RES_WOOD
    }

    Wood plus(Wood other) {
        return new Wood(amount + other.amount)
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        new Wood(amount)
    }
}
