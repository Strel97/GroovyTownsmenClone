package com.strel.townsmen.engine.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by strel on 19.05.15.
 */
public class ImageLoader {

    public static BufferedImage loadImage(String filename) {
        BufferedImage img = null;

        try {
            File file = new File(filename);
            if (file.exists())
                img = ImageIO.read(file);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return img;
    }
}
