import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Util{

    public static BufferedImage loadImage(String imagePath){
        BufferedImage img = null;

        try {
            File imgFile = new File(imagePath);
            img = ImageIO.read(imgFile);
        } catch (IOException e) {
            System.err.println("Error loading image");
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

}