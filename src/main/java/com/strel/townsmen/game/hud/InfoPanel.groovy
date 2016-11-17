package com.strel.townsmen.game.hud

import com.strel.townsmen.engine.GameFont
import com.strel.townsmen.engine.Point
import com.strel.townsmen.game.GameConfig

import java.awt.Graphics2D

/**
 * Created by strel on 17.06.15.
 */
class InfoPanel {

    private static String[] splitMsg( String msg, int font_size, int panel_width ) {
        def lines = []
        def msg_cursor = 0

        while (msg_cursor < msg.size()) {
            def line = new StringBuilder()
            for (def line_width = 0; line_width < panel_width && msg_cursor < msg.size(); line_width += font_size) {
                line.append(msg[msg_cursor])
                msg_cursor++
            }

            lines << line.toString()
        }

        return lines
    }

    static void draw(Graphics2D g, String msg, int font_size, Point pos, int width, int height) {
        GameFont font = GameConfig.FONT

        g.drawImage(GameConfig.IMG_PANEL, pos.x, pos.y, width, height, null)
        splitMsg(msg, font_size, width - 15).eachWithIndex { String line, int id ->
            font.draw(g, line, font_size, pos.x + 5, pos.y + id * font_size + 10)
        }
    }
}
