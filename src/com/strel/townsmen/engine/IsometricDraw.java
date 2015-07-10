package com.strel.townsmen.engine;

import com.strel.townsmen.engine.utils.IsometricConverter;
import com.strel.townsmen.game.GameConfig;
import com.strel.townsmen.game.objects.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by strel on 13.06.15.
 */
public class IsometricDraw {

    public  static void drawImage(Graphics2D g, BufferedImage img, int x, int y) {
        Point iso = IsometricConverter.toIsometric(x, y);

        iso.x += GameConfig.MAP_START_X;
        iso.y += GameConfig.MAP_START_Y;

        g.drawImage(img, iso.x, iso.y, null);
    }
}
