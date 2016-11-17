package com.strel.townsmen.engine.utils;

import com.strel.townsmen.engine.Point;
import com.strel.townsmen.game.GameConfig;

/**
 * Created by strel on 13.06.15.
 */
public class IsometricConverter {

    public static Point toIsometric(int x, int y) {

        // Coordinates in isometric system
        int iso_x = x - y;
        int iso_y = (x + y) / 2;

        return new Point(iso_x, iso_y);
    }

    public static Point toMapCoords(int iso_x, int iso_y) {
        int cart_x = iso_y + iso_x / 2;
        int cart_y = iso_y - iso_x / 2;

        int x = cart_x / (GameConfig.TILE_SIZE / 2 - 1);
        int y = cart_y / (GameConfig.TILE_SIZE / 2 - 1);

        return new Point(x, y);
    }
}
