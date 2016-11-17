package com.strel.townsmen.game.objects.entities

import com.strel.townsmen.engine.game.Playable
import com.strel.townsmen.game.map.ObjectMap

import java.awt.Graphics2D

/**
 * Created by strel on 14.06.15.
 */
abstract class EntityState {

    protected Gatherer entity

    abstract void update(ObjectMap map)
    abstract void draw(Graphics2D g)
}
