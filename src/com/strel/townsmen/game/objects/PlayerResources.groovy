package com.strel.townsmen.game.objects

import com.strel.townsmen.engine.GameFont
import com.strel.townsmen.engine.game.Drawable
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.objects.resources.Resource

import java.awt.Graphics2D

/**
 * Created by strel on 16.06.15.
 */
class PlayerResources implements Drawable {

    Map<Integer, Resource> resources
    int capacity


    PlayerResources() {
        resources = [:]
        capacity = GameConfig.MAX_STORAGE_CAPACITY
    }

    def canStore(Resource res) {
        capacity >= res.amount
    }

    def store(Resource res) {
        if (canStore(res)) {
            if (resources[res.id])
                resources[res.id] += res
            else
                resources[res.id] = res

            capacity -= res.amount
        }
    }

    def canBuy( int price ) {
        if (resources[GameConfig.RES_WOOD])
            return price <= resources[GameConfig.RES_WOOD].amount

        return false
    }

    def buy( int price ) {
        resources[GameConfig.RES_WOOD].amount -= price
    }

    @Override
    void draw(Graphics2D g) {
        GameFont font = GameConfig.FONT

        g.drawImage(GameConfig.IMG_RESOURCE_WOOD, 10, 5, 15, 13, null)
        font.draw(
                g,
                "${resources[GameConfig.RES_WOOD] ? resources[GameConfig.RES_WOOD].amount.toString() : 0} / " +
                        "${GameConfig.MAX_STORAGE_CAPACITY}",
                30, 9)

        g.drawImage(GameConfig.IMG_RESOURCE_POPULATION, 10, 25, 15, 13, null)
        font.draw(
                g,
                "${resources[GameConfig.RES_POPULATION] ? resources[GameConfig.RES_POPULATION].amount.toString() : 0} / " +
                        "${GameConfig.MAX_STORAGE_CAPACITY}",
                30, 29)
    }
}
