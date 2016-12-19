package quiz2.question2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2016-12-18.
 */
public class Benchmark {
    private static int SIZE = 1000;
    private static int CHANNELS = 50;
    private static DenseHyperspectralImageImpl denseHyperspectralImage;
    private static SparseHyperspectralImageImpl sparseHyperspectralImage;

    static  {
        sparseHyperspectralImage = new SparseHyperspectralImageImpl(10,SIZE,CHANNELS);  //10%dense image
        denseHyperspectralImage = new DenseHyperspectralImageImpl(10,SIZE,CHANNELS);  //10%dense image
    }

    @Test
    public void compareSparseImageSize() throws Exception{
        Assert.assertEquals(0,getObjectSize(sparseHyperspectralImage)<getObjectSize(sparseHyperspectralImage));
    }

    private long getObjectSize(HyperspectralImage image) {
        return ObjectSizeFetcher.getObjectSize(image);
    }

}

