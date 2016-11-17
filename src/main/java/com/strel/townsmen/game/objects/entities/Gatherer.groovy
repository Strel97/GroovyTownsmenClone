package com.strel.townsmen.game.objects.entities

import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.map.ObjectMap
import com.strel.townsmen.game.objects.ResourceObject
import com.strel.townsmen.game.objects.resources.Resource

/**
 * Created by strel on 14.06.15.
 */
abstract class Gatherer extends Entity {

    Resource resource


    def gather(ResourceObject obj, ObjectMap map) {
        resource = obj.drop(map, GameConfig.GATHERER_BAG_CAPACITY)
    }

    Resource dropResource() {
        def res = resource
        resource = null

        return res
    }
}
