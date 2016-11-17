package com.strel.townsmen.game.map

import com.strel.townsmen.engine.Point
import com.strel.townsmen.engine.game.Playable
import com.strel.townsmen.engine.utils.IsometricConverter
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.objects.GameObject
import com.strel.townsmen.game.objects.tiles.EmptyTile
import com.strel.townsmen.game.objects.tiles.GrassTile

import java.awt.Graphics2D

/**
 * Created by strel on 13.06.15.
 */
abstract class Map implements Playable {

    protected map


    Map() {
        map = []
    }

    void loadFromFile( String filename ) {
        def file = new File(filename)

        if (!file.exists())
            return

        file.eachWithIndex { String line, int i ->
            def obj_line = []
            line.eachWithIndex { String tile_id, int j ->
                obj_line << parseTile(tile_id.toInteger(), i, j)
            }

            map << obj_line
        }
    }

    abstract GameObject parseTile(int id, int x, int y);

    @Override
    void draw(Graphics2D g) {
        map.each { line ->
            line.each { GameObject obj ->
                obj.draw(g)
            }
        }
    }
}
