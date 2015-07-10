package com.strel.townsmen.game

import javax.swing.JFrame
import javax.swing.WindowConstants

/**
 * Created by strel on 13.06.15.
 */
class Launcher {
    static void main( args ) {
        TownsmenGame game = TownsmenGame.instance

        JFrame frame = new JFrame('TownsmenGame')
        frame.setSize(1000, 500)
        frame.setResizable(false)
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

        frame.add(game.canvas)

        frame.setVisible(true)
        game.start()
    }
}
