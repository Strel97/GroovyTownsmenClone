package com.strel.townsmen.game.objects

import com.strel.townsmen.engine.IsometricDraw
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.objects.resources.Wood

import java.awt.Graphics2D

/**
 * Created by strel on 13.06.15.
 */
class Tree extends ResourceObject {

    Tree() {
        id = GameConfig.TREE_OBJ
        resource = new Wood(GameConfig.RESOURCE_WOOD_PER_TREE)
    }

    @Override
    void update() {

    }

    @Override
    void draw(Graphics2D g) {
        IsometricDraw.drawImage(g, GameConfig.IMG_TREE, x - GameConfig.OBJECT_MAP_Z, y - GameConfig.OBJECT_MAP_Z)
    }


    @Override
    String toString() {
        return "TREE at [$x, $y]"
    }
}
