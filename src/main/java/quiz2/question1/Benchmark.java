package quiz2.question1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2016-12-18.
 */
public class Benchmark {

    private long timeMilis=0;
    private static int SIZE = 1000;
    private static int CHANNELS = 32;
    private static int NO_OF_OPERATIONS = 100;

    private static SpatialOptimisedHyperspectralImageImpl spatialOptimisedImage;
    private static ColorOptimisedHyperspectralImageImpl colorOptimisedImage;

    static  {
        spatialOptimisedImage = new SpatialOptimisedHyperspectralImageImpl(SIZE, SIZE, CHANNELS);
        spatialOptimisedImage.initWithRandomValues();

        colorOptimisedImage = new ColorOptimisedHyperspectralImageImpl(SIZE, SIZE, CHANNELS);
        colorOptimisedImage.initWithRandomValues();
    }

    @Test
    public void compareGetChannelOperation() throws Exception{
        long spatialOptimisedTimeExecution;
        long colorOptimisedTimeExecution;

        startMeasureExecution();
        for(int i=0;i<NO_OF_OPERATIONS;i++)
            spatialOptimisedImage.getChannel(5);
        spatialOptimisedTimeExecution = stopMeasureExecution();

        startMeasureExecution();
        for(int i=0;i<NO_OF_OPERATIONS;i++)
            colorOptimisedImage.getChannel(5);
        colorOptimisedTimeExecution = stopMeasureExecution();

        Assert.assertTrue("Color optimisation time is not shorter than spatial optimisation!", colorOptimisedTimeExecution < spatialOptimisedTimeExecution);

    }

    @Test
    public void compareGetPixelOperation() throws Exception{
        long spatialOptimisedTimeExecution;
        long colorOptimisedTimeExecution;


        startMeasureExecution();
        for(int i=0;i<NO_OF_OPERATIONS;i++)
            spatialOptimisedImage.getPixel(100,100);
        spatialOptimisedTimeExecution = stopMeasureExecution();

        startMeasureExecution();
        for(int i=0;i<NO_OF_OPERATIONS;i++)
            colorOptimisedImage.getPixel(100,100);
        colorOptimisedTimeExecution = stopMeasureExecution();

        Assert.assertTrue("Spatial optimisation time is not shorter than color optimisation!",  spatialOptimisedTimeExecution < colorOptimisedTimeExecution );

    }


    private void startMeasureExecution() {
        timeMilis = 0;
        timeMilis = System.nanoTime();
    }

    private long stopMeasureExecution() {
        return System.nanoTime() - timeMilis;
    }
}
