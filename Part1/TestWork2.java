import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Scanner;

class TestWork2{

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("s path = ");
        String sourcePath = scan.nextLine();
        BufferedImage img = null;

        try {
            File imgFile = new File(sourcePath);
            img = ImageIO.read(imgFile);
            System.out.println("Loading Done");
        } catch (IOException e) {
            System.err.println("Error loading image");
            System.exit(0);
        }


        WritableRaster raster = img.getRaster();


        System.out.print("t = ");
        int T = scan.nextInt(); // threshold

        int height = img.getHeight();
        int width = img.getWidth();
        int[] pixelBuffer = new int[1];
///222

        //333 /Users/wanchairoot/Documents/517451 ComVis/Work2/o/img.png


        for(int row = 0; row < height; ++row) {
            for(int col = 0; col < width; ++col) {
                raster.getPixel(col, row, pixelBuffer);
                if(pixelBuffer[0] < T)
                    pixelBuffer[0] = 0;
                else
                    pixelBuffer[0] = 255;
                raster.setPixel(col, row, pixelBuffer);
            }
        }

        System.out.print("d path = ");
        String path = scan.nextLine();
        path = scan.nextLine();
        String[] destPath = path.split("\\.");
        int index = destPath[0].lastIndexOf("/");
        String folder = path.substring(0 ,index);
        File outTest = new File(folder);

        if (!outTest.exists()) {
            System.out.println("Error writing image 1");
            return;
        }

        try {
            File outFile = new File(path);
            ImageIO.write(img, destPath[1] ,outFile);
        } catch(IOException e) {
            System.err.println("Error writing image");
            return ;
        }
    }
}
