package quiz2.question1;

import java.util.Random;

/**
 * Created by Lukasz on 2016-12-18.
 */
public class ColorOptimisedHyperspectralImageImpl implements HyperspectralImage {
    private int[][][] pixelStructure;
    private int sizeX;
    private int sizeY;
    private int sizeChannel;


    public ColorOptimisedHyperspectralImageImpl(int sizeX, int sizeY, int sizeChannel) {
        this.sizeY = sizeY;
        this.sizeX = sizeX;
        this.sizeChannel = sizeChannel;

        pixelStructure = new int[sizeChannel][sizeX][sizeY];
    }

    public void initWithRandomValues() {
        Random rn = new Random();

        for(int i=0;i<pixelStructure.length;i++)
            for(int j=0;j<pixelStructure[i].length;j++)
                for(int k=0;k<pixelStructure[i][j].length;k++) {
                     pixelStructure[i][j][k] = rn.nextInt();
                }
    }

    public void setChannel(int[][] channel, int channelNo) {
        pixelStructure[channelNo] = channel;
    }

    public int[][] getChannel(int channelNo) {
        return pixelStructure[channelNo];
    }

    public void setPixel(int x, int y, int[] channel) {

        for(int i=0;i<channel.length;i++)
            pixelStructure[i][x][y] = channel[i];

    }

    public int[] getPixel(int x, int y) {
        int[] result = new int[sizeChannel];

        for(int i=0;i<sizeChannel;i++)
            result[i] = pixelStructure[i][x][y];

        return result;
    }
}
