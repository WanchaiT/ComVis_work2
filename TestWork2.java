import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Scanner;

class TestWork2{

    public static void writeImage(BufferedImage img ,String path){
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


        //WritableRaster raster = img.getRaster();

        System.out.print("t = ");
        int T = scan.nextInt(); // threshold

        int height = img.getHeight();
        int width = img.getWidth();
        int[] pixelBuffer = new int[1];
///222
        for (int i = 0;i<= 255;i++ ) {
            try {
                File imgFile = new File(sourcePath);
                img = ImageIO.read(imgFile);
                System.out.println("Loading Done");
            } catch (IOException e) {
                System.err.println("Error loading image");
                System.exit(0);
            }
            WritableRaster raster = img.getRaster();

            for(int row = 0; row < height; ++row) {
                for(int col = 0; col < width; ++col) {
                    raster.getPixel(col, row, pixelBuffer);
                    if(pixelBuffer[0] <= i)
                        pixelBuffer[0] = 0;
                    else
                        pixelBuffer[0] = 255;
                    raster.setPixel(col, row, pixelBuffer);


                }
            }

            String[] p = sourcePath.split("\\.");
            p[0] += Integer.toString(i) + ".png";
            // try {
            //
            //     File outFile = new File(p[0]);
            //     ImageIO.write(img, p[0] ,outFile);
            //     System.out.println(p[0]);
            // } catch(IOException e) {
            //     System.err.println("Error writing image");
            //     return ;
            // }

            System.out.println(p[0]);
            writeImage(img ,p[0]);
        }

        //333 /Users/wanchairoot/Documents/517451 ComVis/Work2/o/img.png


        
    }
}
