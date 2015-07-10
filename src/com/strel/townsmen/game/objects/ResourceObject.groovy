package com.strel.townsmen.game.objects

import com.strel.townsmen.game.map.ObjectMap
import com.strel.townsmen.game.objects.resources.Resource

/**
 * Created by strel on 14.06.15.
 */
abstract class ResourceObject extends GameObject {

    Resource resource



    Resource drop(ObjectMap map, int amount) {
        Resource droped = (Resource) resource.clone()
        if (amount < resource.amount) {
            resource.amount -= amount
            droped.amount = amount
        }
        else {
            map.removeObject( this )
        }

        return droped
    }
}
