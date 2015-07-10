package com.strel.townsmen.game.objects.entities.woodcutter

import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.map.ObjectMap
import com.strel.townsmen.game.objects.buildings.Storage
import com.strel.townsmen.game.objects.entities.EntityState
import com.strel.townsmen.game.objects.entities.Gatherer

import java.awt.Graphics2D

/**
 * Created by strel on 14.06.15.
 */
class BringResource extends EntityState {

    private Storage target


    BringResource(Gatherer owner) {
        entity = owner
    }

    @Override
    void update(ObjectMap map) {
        if (!target)
            target = map.findNearestTo(entity, GameConfig.STORAGE_OBJ)

        entity.stepTo(target)
        if (entity.reached(target)) {
            target.store(entity.dropResource())
            entity.state = new IdleState(entity)
        }
    }

    @Override
    void draw(Graphics2D g) {

    }
}
