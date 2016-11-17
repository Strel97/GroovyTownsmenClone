package com.strel.townsmen.game.objects.resources

import com.strel.townsmen.game.GameConfig

/**
 * Created by strel on 18.06.15.
 */
class Population extends Resource {

    Population(int amount) {
        this.amount = amount
        id = GameConfig.RES_POPULATION
    }
    
    Population plus(Population other) {
        return new Population(amount + other.amount)
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        new Population(amount)
    }
}
