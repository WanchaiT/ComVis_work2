package imageutil;

public class Thresholder {

    public static void binarize(int[][] I, final int T, int outputLow, int outputHigh){
        for (int row = 0; row < I.length; ++row) {
            for (int col = 0; col < I[0].length; ++col) {
                if (I[row][col] < T)
                    I[row][col] = outputLow;
                else
                    I[row][col] = outputHigh;
            }
        }
    }
}