package lab2;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Scanner;

import imageutil.Util;
import imageutil.Thresholder;

/**
 * BinarizationWithUtil1
 */
public class BinarizationWithUtil2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("source path = ");
        String inputPath = scan.nextLine(); 

        BufferedImage img = Util.loadImage(inputPath);
        int[][] I = Util.loadToArray(img);  //1
        
        

        System.out.print("T = ");
        int T = scan.nextInt();  //2;

      

        Thresholder.binarize(I ,T ,0 ,255);  //3

        Util.saveToImage(I, img); //4

        System.out.print("dest path = ");
        String temp = scan.nextLine();
        String outputPath = scan.nextLine();
        Util.saveImage(outputPath, img);    //5
    }

}
