package imageutil;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Util{

    public static BufferedImage loadImage(String imagePath){
        BufferedImage img = null;

        try {
            File imgFile = new File(imagePath);
            img = ImageIO.read(imgFile);
        } catch (IOException e) {
            System.err.println("Error loading image");
            System.exit(0);
        }
        return img;
    }

    public static void saveImage(BufferedImage img ,String imagePath){
        String[] destPath = imagePath.split("\\.");
        int index = destPath[0].lastIndexOf("/");
        String folder = imagePath.substring(0 ,index);
        File outTest = new File(folder);

        if (!outTest.exists()) {
            System.out.println("Error writing image 1");
            return;
        }

        try {
            File outFile = new File(imagePath);
            ImageIO.write(img, destPath[1] ,outFile);
        } catch(IOException e) {
            System.err.println("Error writing image");
            return ;
        }
    }

    public static int[][] loadToArray(BufferedImage img){
        Raster raster = img.getRaster();
        int height = img.getHeight();
        int width = img.getWidth();
        int[][] I = new int[height][width];

        int[] pixelBuffer = new int[1];

        for(int row = 0; row < height; ++row) {
            for(int col = 0; col < width; ++col) {
                raster.getPixel(col, row, pixelBuffer);
                I[row][col] = pixelBuffer[0];
            }
        }
        return I;

    }
}
