package com.strel.townsmen.game.map

import com.strel.townsmen.engine.utils.IsometricConverter
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.objects.GameObject
import com.strel.townsmen.game.objects.tiles.EmptyTile
import com.strel.townsmen.game.objects.tiles.GrassTile
import groovy.transform.InheritConstructors

/**
 * Created by strel on 13.06.15.
 */
@InheritConstructors
class TileMap extends Map {

    @Override
    GameObject parseTile(int id, int x, int y) {


        int cart_x = y * 8 // (GameConfig.TILE_SIZE / 2 - 1) + GameConfig.MAP_START_X;
        int cart_y = x * 8 // (GameConfig.TILE_SIZE / 2 - 1) + GameConfig.MAP_START_Y;

        switch (id) {
            case GameConfig.GRASS_TILE:
                return new GrassTile(x: cart_x, y: cart_y)

            default:
                return new EmptyTile(x: cart_x, y: cart_y)
        }
    }

    @Override
    void update() {

    }
}
