package quiz2.question2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Lukasz on 2016-12-18.
 */
public class SparseHyperspectralImageImpl implements HyperspectralImage{

    private static final int MAX_SPARSE_FACTOR = 100;

    private List<Pixel> pixelList;
    private int densityFactor;
    private int imageSize;
    private int noOfChannels;

    /**
     * Init class.
     *
     * @param densityFactor - 1-100. 1 means 1% full - 100 means 100% full.
     * @param imageSize
     * @param noOfChannels
     */
    SparseHyperspectralImageImpl(int densityFactor, int imageSize, int noOfChannels) {
        pixelList = new ArrayList<Pixel>();
        this.densityFactor = densityFactor;
        this.noOfChannels = noOfChannels;
        this.imageSize = imageSize;
        if(densityFactor>MAX_SPARSE_FACTOR)
            throw  new IllegalArgumentException("Density factor must be less than " + MAX_SPARSE_FACTOR) ;
    }

    private int generateRandomNumber(int sparseFactor) {
        Random rn = new Random();
        int randomNumber = rn.nextInt(MAX_SPARSE_FACTOR);
        return (randomNumber<=sparseFactor)?new Random().nextInt():0;
    }

    private int[] generateRandomArray(int sparseFactor, int size) {
        Random rn = new Random();
        int[] result = new int[size];

        for(int i=0;i<size;i++) {
            result[i] = rn.nextInt();
        }

        return result;
    }



    public void initWithRandomValues() {

        for(int i=0;i<imageSize;i++)
            for(int j=0;j<imageSize;j++) {

                if(generateRandomNumber(densityFactor) != 0) {
                    int[] channels = generateRandomArray(densityFactor, noOfChannels);
                    setPixel(i,j,channels);
                }
            }
    }

    public void setChannel(int[][] channel, int channelNo) {
           //do something interesting
    }

    public int[][] getChannel(int channelNo) {
        //do something interesting
        return new int[0][];
    }

    public void setPixel(int x, int y, int[] channel) {
        Pixel newPixel = new Pixel(x,y,channel);

        if(!pixelList.contains(newPixel))
            pixelList.add(newPixel);
    }

    public int[] getPixel(int x, int y) {
        Pixel searchedPixel = new Pixel(x,y,null);

        int i=0;
        while(i < pixelList.size())
            if(pixelList.get(i).equals(searchedPixel))
                return  pixelList.get(i).getChannels();

        return null;
    }
}
