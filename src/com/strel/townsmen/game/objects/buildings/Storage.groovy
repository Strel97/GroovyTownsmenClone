package com.strel.townsmen.game.objects.buildings

import com.strel.townsmen.engine.GameFont
import com.strel.townsmen.engine.IsometricDraw
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.objects.GameObject
import com.strel.townsmen.game.objects.PlayerResources
import com.strel.townsmen.game.objects.resources.Resource

import java.awt.Color
import java.awt.Graphics2D

/**
 * Created by strel on 16.06.15.
 */
class Storage extends GameObject {

    PlayerResources resources


    Storage() {
        id = GameConfig.STORAGE_OBJ
    }

    def store(Resource res) {
        resources.store(res)
    }

    @Override
    void update() {

    }

    @Override
    void draw(Graphics2D g) {
        IsometricDraw.drawImage(g, GameConfig.IMG_STORAGE, x - GameConfig.OBJECT_MAP_Z, y - GameConfig.OBJECT_MAP_Z)
    }
}
