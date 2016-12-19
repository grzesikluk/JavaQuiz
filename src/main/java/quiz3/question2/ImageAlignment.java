package quiz3.question2;


import com.sun.media.jai.codec.FileSeekableStream;

import javax.media.jai.*;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.IOException;

/**
 * Created by Lukasz on 2016-12-18.
 */

public class ImageAlignment {
    private String nisInputFile;
    private String virInputFile;
    private String outputFile;

    /**
     * The main method.
     */
    public static void main(String[] args) throws IOException {

        ImageAlignment imageAlignment = new ImageAlignment();
        imageAlignment.getArguments(args);

        RenderedOp image1 = imageAlignment.readImageFromFile(imageAlignment.nisInputFile);
        RenderedOp image2 = imageAlignment.readImageFromFile(imageAlignment.virInputFile);

        RenderedOp outputImage1 = JAI.create("max",
                imageAlignment.gradientMagnitudeOperation(image1),
                imageAlignment.gradientMagnitudeOperation(image2));


        imageAlignment.storeImageToFile(imageAlignment.gradientMagnitudeOperation(outputImage1), imageAlignment.outputFile);

        System.out.println(imageAlignment.meanValue(outputImage1));
    }


    private void getArguments(String[] args) {
        nisInputFile = args[0];
        virInputFile = args[1];
        outputFile = args[2];
    }


    private RenderedOp readImageFromFile(String fileName) {
        return JAI.create("fileload", fileName);

    }

    private void storeImageToFile(RenderedOp image, String fileName) {
        FileSeekableStream stream = null;
        JAI.create("filestore", image, fileName, "TIFF", null);
    }


    private RenderedOp gradientMagnitudeOperation(PlanarImage input) {

        KernelJAI kern_h = new KernelJAI(3, 3, getEdgeEnhancementOperationMatrix("FreiChen")[0]);
        KernelJAI kern_v = new KernelJAI(3, 3, getEdgeEnhancementOperationMatrix("FreiChen")[1]);

        return JAI.create("gradientmagnitude", input, kern_h, kern_v);

    }

    private float[][] getEdgeEnhancementOperationMatrix(String name) {
        float[] h_data;
        float[] v_data;
        float[][] result = new float[2][];

        switch (name) {
            case "Roberts": {

                result[0] = new float[]{0.0F, 0.0F, -1.0F,
                        0.0F, 1.0F, 0.0F,
                        0.0F, 0.0F, 0.0F
                };

                result[1] = new float[]{-1.0F, 0.0F, 0.0F,
                        0.0F, 1.0F, 0.0F,
                        0.0F, 0.0F, 0.0F
                };
                break;
            }

            case "Previtt": {
                result[0] = new float[]{1.0F, 0.0F, -1.0F,
                        1.0F, 0.0F, -1.0F,
                        1.0F, 0.0F, -1.0F
                };
                result[1] = new float[]{-1.0F, -1.0F, -1.0F,
                        0.0F, 0.0F, 0.0F,
                        1.0F, 1.0F, 1.0F
                };
                break;
            }

            case "FreiChen": {
                result[0] = new float[]{1.0F, 0.0F, -1.0F,
                        1.414F, 0.0F, -1.414F,
                        1.0F, 0.0F, -1.0F};
                result[1] = new float[]{-1.0F, -1.414F, -1.0F,
                        0.0F, 0.0F, 0.0F,
                        1.0F, 1.414F, 1.0F};
                break;
            }


            default: {

            }
        }

        return result;

    }


    private RenderedOp transformImage(RenderedOp input, float mx, float my) {

        ParameterBlock pb = new ParameterBlock();
        pb.addSource(input); // The source image
        pb.add((float) -mx); // The x translation
        pb.add((float) -my); // The y translation
        pb.add(new InterpolationBicubic(2)); // The interpolation


        return JAI.create("translate", pb, null);
    }

    private double meanValue(RenderedOp input) {

        ParameterBlock pb = new ParameterBlock();
        pb.addSource(input);
        pb.add(null);
        pb.add(1);
        pb.add(1);

        RenderedImage meanImage = JAI.create("mean", pb, null);

        return getMeanValue((double[]) meanImage.getProperty("mean"));

    }

    private double getMeanValue(double[] input) {
        double result = 0;

        for(int i=0;i<input.length;i++)
            result+=input[i];

        return result/input.length;
    }
}
