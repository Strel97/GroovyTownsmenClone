package com.strel.townsmen.game.objects.entities.woodcutter

import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.map.ObjectMap
import com.strel.townsmen.game.objects.GameObject
import com.strel.townsmen.game.objects.entities.EntityState
import com.strel.townsmen.game.objects.entities.Gatherer

import java.awt.Graphics2D

/**
 * Created by strel on 14.06.15.
 */
class IdleState extends EntityState {

    IdleState(Gatherer owner) {
        entity = owner
    }

    @Override
    void update(ObjectMap map) {
        GameObject obj = map.findNearestTo(entity, GameConfig.TREE_OBJ)

        if (obj != null)
            entity.state = new GatherState(entity, obj)
    }

    @Override
    void draw(Graphics2D g) {

    }
}
