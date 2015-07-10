package com.strel.townsmen.game.states

import com.strel.townsmen.engine.input.InputHandler
import com.strel.townsmen.game.GameConfig
import com.strel.townsmen.game.TownsmenGame
import com.strel.townsmen.game.hud.GameHud
import com.strel.townsmen.game.map.ObjectMap
import com.strel.townsmen.game.map.TileMap
import com.strel.townsmen.game.menu.MainMenu
import com.strel.townsmen.game.objects.player.Player
import com.strel.townsmen.game.objects.PlayerResources
import com.strel.townsmen.game.objects.buildings.Storage

import java.awt.Graphics2D
import java.awt.event.KeyEvent

/**
 * Created by strel on 13.06.15.
 */
class RunningState implements GameState {

    TileMap         tileMap
    ObjectMap       objMap
    Player          player
    PlayerResources resources

    GameHud         hud


    RunningState() {
        tileMap = new TileMap()
        tileMap.loadFromFile('resources/tile_map')

        objMap = new ObjectMap()
        objMap.loadFromFile('resources/obj_map')

        player = new Player(2, 2)
        resources = new PlayerResources()

        // Initialize player. Bad decision :)
        player.map = objMap
        player.resources = resources

        hud = new GameHud()

        // Mapping Player resources to the
        // specific storage
        Storage s = objMap.find(GameConfig.STORAGE_OBJ)
        s.resources = resources
    }

    @Override
    void handleInput(InputHandler input) {
        if (input.keyDownOnce(KeyEvent.VK_BACK_SPACE))
            TownsmenGame.instance.stateMachine.state = new MenuState(new MainMenu())
    }

    @Override
    void update(InputHandler input) {
        handleInput(input)
        objMap.update()
        player.update(input)
    }

    @Override
    void draw(Graphics2D g) {
        hud.draw(g)

        tileMap.draw(g)
        objMap.draw(g)
        player.draw(g)

        resources.draw(g)
    }
}
