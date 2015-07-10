package com.strel.townsmen.game.map

import com.strel.townsmen.game.objects.GameObject
import com.strel.townsmen.game.objects.entities.woodcutter.Woodcutter

/**
 * Created by strel on 14.06.15.
 */
class ObjectMapTest extends GroovyTestCase {

    ObjectMap map


    @Override
    void setUp() {
        super.setUp();

        map = new ObjectMap()
        map.loadFromFile('resources/obj_map')
    }

    void testFindNearestTo() {
        Woodcutter w = testAddObject()
        println "Nearest Object = ${map.findNearestTo(w)}"
    }

    void testParseTile() {

    }

    Woodcutter testAddObject() {
        Woodcutter w = new Woodcutter(x: 32, y: 0)
        map.addObject(w, 4, 0)

        return w
    }

    void testGetObject() {
        println "Get Object = ${map.getObject(10, 0)}"
    }

    void testDistance() {

    }

    void testUpdate() {

    }

    void testRemoveObject() {
        GameObject obj = map.getObject(10, 0)
        map.removeObject(obj)

        println "After remove = ${map.getObject(10, 0)}"
    }

    void testToMapCoords() {

    }
}
