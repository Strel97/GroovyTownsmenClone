package com.strel.townsmen.game.objects.player.commands

import com.strel.townsmen.game.objects.player.Player

/**
 * Created by strel on 18.06.15.
 */
abstract class Command {
    abstract void execute(Player player)
}
