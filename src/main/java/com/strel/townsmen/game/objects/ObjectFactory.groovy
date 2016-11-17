package com.strel.townsmen.game.objects

import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.objects.buildings.House
import com.strel.townsmen.game.objects.buildings.Mason
import com.strel.townsmen.game.objects.buildings.Storage
import com.strel.townsmen.game.objects.entities.woodcutter.Woodcutter

/**
 * Created by strel on 17.06.15.
 */
class ObjectFactory {
    
    static GameObject create( int x, int y, int obj_id ) {
        switch (obj_id) {
            case GameConfig.TREE_OBJ:
                return new Tree(x: x, y: y)

            case GameConfig.CAVE_OBJ:
                return new Cave(x: x, y: y)

            case GameConfig.HOUSE_OBJ:
                return new House(x: x, y: y)

            case GameConfig.MASON_OBJ:
                return new Mason(x: x, y: y)

            case GameConfig.STORAGE_OBJ:
                return new Storage(x: x, y: y)

            case GameConfig.WOODCUTTER_OBJ:
                return new Woodcutter(x: x, y: y)

            default:
                return null // new EmptyObject(x: x, y: y)
        }
    }
}
