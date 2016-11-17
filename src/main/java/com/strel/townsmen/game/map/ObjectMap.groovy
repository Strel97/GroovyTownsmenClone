package com.strel.townsmen.game.map

import com.strel.townsmen.engine.game.Playable
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.objects.GameObject
import com.strel.townsmen.game.objects.ObjectFactory
import com.strel.townsmen.game.objects.buildings.House
import com.strel.townsmen.game.objects.buildings.Storage
import com.strel.townsmen.game.objects.Tree
import com.strel.townsmen.game.objects.entities.Entity
import com.strel.townsmen.game.objects.entities.woodcutter.Woodcutter
import groovy.transform.InheritConstructors

import java.awt.Graphics2D

/**
 * Created by strel on 13.06.15.
 */
@InheritConstructors
class ObjectMap implements Playable {

    private List<GameObject> map


    ObjectMap() {
        map = []
    }

    def loadFromFile(String filename) {
        def file = new File(filename)

        if (!file.exists())
            return

        file.eachWithIndex { String line, int i ->
            line.eachWithIndex { String tile_id, int j ->
                GameObject obj = parseTile(tile_id.toInteger(), i, j)
                if (obj != null)
                    map << obj
            }
        }
    }

    GameObject parseTile(int id, int i, int j) {
        int cart_x = j * 8
        int cart_y = i * 8

        return ObjectFactory.create(cart_x, cart_y, id)
    }

    void addObject(int obj_id, int x, int y) {
        map << ObjectFactory.create(x, y, obj_id)
    }

    void addObject(GameObject obj) {
        map << obj
    }

    void removeObject(GameObject obj) {
        map -= obj
    }

    GameObject findNearestTo(GameObject source, int obj_id) {
        def current_nearest = null
        def current_min_distance = GameConfig.DEFAULT_WIDTH

        map.each { obj ->
            if (!obj.is(source) && obj.id == obj_id) {
                if (distance(source, obj) < current_min_distance) {
                    current_nearest = obj
                    current_min_distance = distance(source, current_nearest)
                }
            }
        }

        return current_nearest
    }

    def find( int obj_id ) {
        def searched = null
        map.each { obj ->
            if (obj.id == obj_id) {
                searched = obj
            }
        }

        return searched
    }

    def getAll( int obj_id ) {
        def searched = []
        map.each { obj ->
            if (obj.id == obj_id)
                searched << obj
        }

        return searched
    }

    double distance(GameObject source, GameObject target) {
        return Math.sqrt((target.x - source.x)**2 + (target.y - source.y)**2)
    }

    @Override
    void update() {
        for (int i = 0; i < map.size(); i++) {
            def obj = map[i]
            if (obj instanceof Entity)
                obj.update(this)
            else
                obj.update()
        }
    }

    @Override
    void draw(Graphics2D g) {
        map.each { obj ->
            obj.draw(g)
        }
    }
}
