package quiz2.question1;

import java.util.Random;

/**
 * Created by Lukasz on 2016-12-18.
 */
public class SpatialOptimisedHyperspectralImageImpl implements HyperspectralImage {
    private int[][][] pixelStructure;
    private int sizeX;
    private int sizeY;
    private int sizeChannel;


    public SpatialOptimisedHyperspectralImageImpl(int sizeX, int sizeY, int sizeChannel) {
        this.sizeY = sizeY;
        this.sizeX = sizeX;
        this.sizeChannel = sizeChannel;

        pixelStructure = new int[sizeX][sizeY][sizeChannel];
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

        for(int i=0;i<channel.length;i++)
            for(int j=0;j<channel.length;j++)
                pixelStructure[i][j][channelNo] = channel[i][j];
    }

    public int[][] getChannel(int channelNo) {
        int[][] result = new int[sizeX][sizeY];

        for(int i=0;i<sizeX;i++)
            for(int j=0;j<sizeY;j++)
                result[i][j] = pixelStructure[i][j][channelNo];

        return result;
    }

    public void setPixel(int x, int y, int[] channel) {
        pixelStructure[x][y] = channel;
    }

    public int[] getPixel(int x, int y) {
        return pixelStructure[x][y];
    }
}
