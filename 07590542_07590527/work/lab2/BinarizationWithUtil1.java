package lab2;

import imageutil.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;

/**
 * BinarizationWithUtil1
 */
public class BinarizationWithUtil1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("eiei new ");
        String inputPath = scan.nextLine();
        BufferedImage img = Util.loadImage(inputPath);

        String outputPath = scan.nextLine();
        Util.saveImage(img ,outputPath);
    }

}
