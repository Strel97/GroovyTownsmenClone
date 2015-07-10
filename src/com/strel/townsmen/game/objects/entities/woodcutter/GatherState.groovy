package com.strel.townsmen.game.objects.entities.woodcutter

import com.strel.townsmen.game.map.ObjectMap
import com.strel.townsmen.game.objects.GameObject
import com.strel.townsmen.game.objects.ResourceObject
import com.strel.townsmen.game.objects.entities.EntityState
import com.strel.townsmen.game.objects.entities.Gatherer

import java.awt.Graphics2D

/**
 * Created by strel on 14.06.15.
 */
class GatherState extends EntityState {

    private ResourceObject target


    GatherState(Gatherer entity, ResourceObject target) {
        this.entity = entity
        this.target = target
    }

    @Override
    void update(ObjectMap map) {
        entity.stepTo(target)
        if (entity.reached(target)) {
            entity.gather(target, map)
            entity.state = new BringResource(entity)
        }
    }

    @Override
    void draw(Graphics2D g) {

    }
}
