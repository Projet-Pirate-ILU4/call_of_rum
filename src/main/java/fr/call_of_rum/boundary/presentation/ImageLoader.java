/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.call_of_rum.boundary.presentation;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author loferga
 */
public class ImageLoader {
    
    private static final ClassLoader classLoader = ImageLoader.class.getClassLoader();
    
    public static BufferedImage loadImage(String pathToResource) {
        try {
            URL resourceURL = classLoader.getResource(pathToResource);
            return ImageIO.read(resourceURL);
        } catch (IOException e) {
            Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, "can''t open {0}", pathToResource);
            return null;
        }
    }
    
}
