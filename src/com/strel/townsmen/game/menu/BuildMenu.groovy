package com.strel.townsmen.game.menu

import com.strel.townsmen.engine.GameFont
import com.strel.townsmen.engine.Point
import com.strel.townsmen.engine.input.InputHandler
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.TownsmenGame
import com.strel.townsmen.game.hud.InfoPanel
import com.strel.townsmen.game.map.ObjectMap
import com.strel.townsmen.game.objects.player.Player
import com.strel.townsmen.game.objects.buildings.House

import java.awt.Graphics2D
import java.awt.event.KeyEvent

/**
 * Created by strel on 17.06.15.
 */
class BuildMenu extends Menu {

    String title = 'Choose building to built'

    def building_descr = [
            "House used to increase population.",
            "Mason controls mining."
    ]

    def building_prices = [ 0, 0, 12, 20 ]

    ObjectMap       map
    Player          player


    BuildMenu() {
        options = [
                "House",
                "Mason"
        ]

        current = 0
    }

    def built( int obj_id ) {
        if (enoughMoney(obj_id)) {
            map.addObject(obj_id, player.x, player.y)
            player.resources.buy( building_prices[obj_id] )

            TownsmenGame.instance.stateMachine.returnToPrevious()
        }
    }

    def enoughMoney( int obj_id ) {
        player.resources.canBuy( building_prices[obj_id] )
    }

    @Override
    void handleInput(InputHandler input) {
        if (input.keyDown(KeyEvent.VK_ENTER)) {
            if (options[current] == "House") {
                if (enoughMoney(GameConfig.HOUSE_OBJ)) {
                    House house =  new House(
                            resources: player.resources,
                            map: map,
                            x: player.x,
                            y: player.y
                    )

                    map.addObject(house)
                    player.resources.buy( building_prices[house.id] )

                    TownsmenGame.instance.stateMachine.returnToPrevious()
                }
            }

            else if (options[current] == "Mason")
                built(GameConfig.MASON_OBJ)
        }
        else if (input.keyDown(KeyEvent.VK_BACK_SPACE))
            TownsmenGame.instance.stateMachine.returnToPrevious()
    }

    @Override
    void update(InputHandler input) {
        super.handleInput(input)
        handleInput(input)
    }

    @Override
    void draw(Graphics2D g) {
        GameFont font = GameConfig.FONT

        g.drawImage(GameConfig.IMG_GAME_BACKGROUND, 0, 0, TownsmenGame.instance.wndWidth(), TownsmenGame.instance.wndHeight(), null)

        font.draw(g, title, 10, new Point(30, 10));
        drawOptions(g, new Point(10, 50));

        // Drawing current building image
        g.drawImage(GameConfig.big_building_images[current], 70, 40, 60, 60, null)

        InfoPanel.draw(g, building_descr[current], GameConfig.FONT_SIZE, new Point(150, 40), 150, 60)
    }
}
