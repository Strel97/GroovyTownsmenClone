package com.strel.townsmen.game.objects.player.commands

import com.strel.townsmen.game.TownsmenGame
import com.strel.townsmen.game.menu.BuildMenu
import com.strel.townsmen.game.objects.player.Player
import com.strel.townsmen.game.states.MenuState

/**
 * Created by strel on 18.06.15.
 */
class BuildCommand extends Command {

    @Override
    void execute(Player player) {
        TownsmenGame.instance.stateMachine.state = new MenuState(new BuildMenu(player: player, map: player.map))
    }
}
