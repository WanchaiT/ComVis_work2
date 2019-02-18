package lab2;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Scanner;

import imageutil.Util;

/**
 * BinarizationWithUtil1
 */
public class BinarizationWithUtil1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("source path = ");
        String inputPath = scan.nextLine();

        BufferedImage img = Util.loadImage(inputPath);
        int height = img.getHeight();
        int width = img.getWidth();
        int[] pixelBuffer = new int[1];

        System.out.print("T = ");
        int T = scan.nextInt();

        WritableRaster raster = img.getRaster();

        for (int row = 0; row < height; ++row) {
            for (int col = 0; col < width; ++col) {
                raster.getPixel(col, row, pixelBuffer);
                if (pixelBuffer[0] < T)
                    pixelBuffer[0] = 0;
                else
                    pixelBuffer[0] = 255;
                raster.setPixel(col, row, pixelBuffer);
            }
        }

        System.out.print("dest path = ");
        String temp = scan.nextLine();
        String outputPath = scan.nextLine();
        Util.saveImage(img, outputPath);
    }

}
