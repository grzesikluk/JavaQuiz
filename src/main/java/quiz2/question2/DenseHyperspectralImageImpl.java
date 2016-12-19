package quiz2.question2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Lukasz on 2016-12-18.
 */
public class DenseHyperspectralImageImpl implements quiz2.question1.HyperspectralImage {

    private static final int MAX_SPARSE_FACTOR = 100;

    private List<List<Pixel>> pixelList;
    private int densityFactor;
    private int imageSize;
    private int noOfChannels;

    private int generateRandomNumber(int sparseFactor) {
        Random rn = new Random();
        int randomNumber = rn.nextInt(MAX_SPARSE_FACTOR);
        return (randomNumber <= sparseFactor) ? new Random().nextInt() : 0;
    }

    private int[] generateRandomArray(int sparseFactor, int size) {
        Random rn = new Random();
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = rn.nextInt();
        }

        return result;
    }

    public void initWithRandomValues() {

        for (int i = 0; i < imageSize; i++)
            for (int j = 0; j < imageSize; j++) {

                if (generateRandomNumber(densityFactor) != 0) {
                    int[] channels = generateRandomArray(densityFactor, noOfChannels);
                    setPixel(i, j, channels);
                }
            }
    }

    public DenseHyperspectralImageImpl(int densityFactor, int size, int channels) {
        imageSize = size;
        noOfChannels = channels;
        this.densityFactor = densityFactor;

        if(densityFactor>MAX_SPARSE_FACTOR)
            throw  new IllegalArgumentException("Density factor must be less than " + MAX_SPARSE_FACTOR) ;

        pixelList = new ArrayList<List<Pixel>>();

        for (int i = 0; i < size; i++)
            pixelList.add(new ArrayList<Pixel>());

    }

    public void setChannel(int[][] channel, int channelNo) {
       //some implementation
    }

    public int[][] getChannel(int channelNo) {
        int[][] result = new int[imageSize][imageSize];

        for(int i=0;i<imageSize;i++)
            for(int j=0;j<imageSize;j++)
                result[i][j] = getPixel(i,j)[channelNo];

        return result;
    }

    public void setPixel(int x, int y, int[] channel) {
        pixelList.get(x).set(y, new Pixel(x, y, channel));
    }

    public int[] getPixel(int x, int y) {
        return pixelList.get(x).get(y).getChannels();
    }
}
