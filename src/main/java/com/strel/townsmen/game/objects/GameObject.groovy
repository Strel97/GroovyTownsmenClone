package com.strel.townsmen.game.objects

import com.strel.townsmen.engine.game.Playable

/**
 * Created by strel on 13.06.15.
 */
abstract class GameObject implements Playable {

    int id

    protected int x
    protected int y

    int getX() {
        return x
    }

    int getY() {
        return y
    }
}
