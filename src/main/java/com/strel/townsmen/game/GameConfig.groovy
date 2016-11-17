package com.strel.townsmen.game

import com.strel.townsmen.engine.GameFont
import com.strel.townsmen.engine.Point
import com.strel.townsmen.engine.utils.ImageLoader

import java.awt.Color
import java.awt.image.BufferedImage
import java.nio.Buffer


/**
 * Created by strel on 13.06.15.
 */
interface GameConfig {
    // Game window config
    int DEFAULT_WIDTH            = 1000;
    int DEFAULT_HEIGHT           = 500;
    int SCALE                    = 3;

    Color COLOR_BACKGROUND       = new Color(0x000000);


    // Map constants
    int MAP_START_X = DEFAULT_WIDTH / (2 * SCALE) - 10
    int MAP_START_Y = DEFAULT_HEIGHT / (2 * SCALE) - 40

    // Map tiles constants
    int TILE_SIZE = 16;
    int TILE_DISTANCE = TILE_SIZE / 2 - 1

    int GRASS_TILE = 0;


    // Object map constants
    int TREE_OBJ = 1
    int HOUSE_OBJ = 2
    int MASON_OBJ = 3
    int STORAGE_OBJ = 4
    int CAVE_OBJ = 6

    int WOODCUTTER_OBJ = 5
    int GATHERER_BAG_CAPACITY = 12

    int OBJECT_MAP_Z = 11


    // Resource config
    int RESOURCE_WOOD_PER_TREE = 30
    int RESOURCE_STONE_PER_CAVE = 100
    int RESOURCE_POPULATION_PER_HOUSE = 1

    int RES_POPULATION = 0
    int RES_WOOD = 1
    int RES_CAVE = 2

    int MAX_STORAGE_CAPACITY = 60


    // Player config
    public int PLAYER_DX = 8;
    public int PLAYER_DY = 8;


    // Game utilities config
    GameFont FONT = new GameFont('resources/font.png')


    // Font config
    int FONT_SIZE = 8


    // Menu config
    int MENU_OPTIONS_LEADING = 20

    Point MENU_MAIN_LOGO_COORDS       = new Point(80, 30)
    Point MENU_MAIN_OPTIONS_COORDS    = new Point(100, 100)


    // Game images
    BufferedImage IMG_GRASS = ImageLoader.loadImage("resources/block.png")
    BufferedImage IMG_TREE = ImageLoader.loadImage("resources/tree.png")
    BufferedImage IMG_CAVE = ImageLoader.loadImage("resources/cave.png")
    BufferedImage IMG_PLAYER = ImageLoader.loadImage("resources/player.png")

    BufferedImage IMG_HOUSE = ImageLoader.loadImage("resources/house.png")
    BufferedImage IMG_MASON = ImageLoader.loadImage("resources/mason.png")
    BufferedImage IMG_STORAGE = ImageLoader.loadImage("resources/storage.png")

    BufferedImage IMG_WOODCUTTER = ImageLoader.loadImage("resources/woodcutter.png")
    BufferedImage IMG_HUD_MAIN_MENU = ImageLoader.loadImage("resources/main_menu_hud.png")
    BufferedImage IMG_MAIN_MENU_BACKGROUND = ImageLoader.loadImage("resources/main_menu_background.jpg")
    BufferedImage IMG_GAME_BACKGROUND = ImageLoader.loadImage("resources/game_background.jpg")
    BufferedImage IMG_GAME_RESOURCE_PANEL = ImageLoader.loadImage("resources/resource_panel.png")

    BufferedImage IMG_RESOURCE_WOOD = ImageLoader.loadImage("resources/wood.png")
    BufferedImage IMG_RESOURCE_POPULATION = ImageLoader.loadImage("resources/population.png")

    BufferedImage IMG_PANEL = ImageLoader.loadImage("resources/panel.png")
    BufferedImage[] big_building_images = [
         ImageLoader.loadImage("resources/house_big_img.png"),  // BufferedImage IMG_HOUSE_BIG =
         ImageLoader.loadImage("resources/mason_big_img.png")   // BufferedImage IMG_MASON_BIG =
    ]
}