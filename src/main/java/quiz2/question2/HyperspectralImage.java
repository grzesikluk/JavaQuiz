package quiz2.question2;

/**
 * Created by Lukasz on 2016-12-18.
 */
public interface HyperspectralImage {

    public void initWithRandomValues();

    //define the operations that can be done on the image

    /**
     * This is color operation. We set color information for one channel.
     *
     * @param channel - channel information
     * @param channelNo - channel number to whic we want to to set the info.
     */
    public void setChannel(int[][] channel, int channelNo);

    /**
     * Get color information for picture.
     *
     * @param channelNo
     * @return  - matrix of values for all pixels.
     */
    public int[][] getChannel(int channelNo);


    /**
     * Spatial operation. Set info for one pixel.
     *
     * @param x
     * @param y
     * @param channel
     */
    public void setPixel(int x, int y, int[] channel);

    /**
     * Spatial operation. Get info for all channels for one pixel.
     * @param x
     * @param y
     * @return channel values for pixel.
     */
    public int[] getPixel(int x, int y);



}
