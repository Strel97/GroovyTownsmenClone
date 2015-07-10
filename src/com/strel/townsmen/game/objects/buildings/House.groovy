package com.strel.townsmen.game.objects.buildings

import com.strel.townsmen.engine.IsometricDraw
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.map.ObjectMap
import com.strel.townsmen.game.objects.GameObject
import com.strel.townsmen.game.objects.PlayerResources
import com.strel.townsmen.game.objects.resources.Population

import java.awt.Graphics2D

/**
 * Created by strel on 13.06.15.
 */
class House extends GameObject {

    static def population = 0
    boolean firstSet

    PlayerResources resources
    ObjectMap       map


    House() {
        id = GameConfig.HOUSE_OBJ
        firstSet = false
    }

    @Override
    void update() {
        if (!firstSet) {
            resources.store(new Population(GameConfig.RESOURCE_POPULATION_PER_HOUSE))
            population += GameConfig.RESOURCE_POPULATION_PER_HOUSE

            firstSet = true
        }

        if (population > 0) {
            map.addObject(GameConfig.WOODCUTTER_OBJ, x, y)
            population--
        }
    }

    @Override
    void draw(Graphics2D g) {
        IsometricDraw.drawImage(g, GameConfig.IMG_HOUSE, x - GameConfig.OBJECT_MAP_Z, y - GameConfig.OBJECT_MAP_Z)
    }
}
