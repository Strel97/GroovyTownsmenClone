package com.strel.townsmen.game.objects.resources

import com.strel.townsmen.game.GameConfig

/**
 * Created by strel on 25.06.15.
 */
class Stone extends Resource {

    Stone(int amount) {
        this.amount = amount
        id = GameConfig.RES_CAVE
    }

    Stone plus(Stone other) {
        return new Stone(amount + other.amount)
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        new Stone(amount)
    }
}
