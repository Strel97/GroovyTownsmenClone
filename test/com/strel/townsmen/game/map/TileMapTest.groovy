package com.strel.townsmen.game.map

/**
 * Created by strel on 13.06.15.
 */
class TileMapTest extends GroovyTestCase {

    void testLoadFromFile() {
        def map = new TileMap()
        map.loadFromFile('resources/tile_map')
    }

    void testGetOn() {
        def map = new TileMap()
        map.loadFromFile('resources/tile_map')

        println map.getOn(50, 50).x + ' ' + map.getOn(50, 50).y
    }

    void testParseTile() {
    }
}
