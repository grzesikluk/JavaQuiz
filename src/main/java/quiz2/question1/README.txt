You are given hyperspectral images that are 5000 x 5000 pixels x 50 channels. Each pixel
in a channel is 32 bits (4 bytes). You need to process these images. How would you store
this image in memory so that you either

(a) maximize speed on operations requiring access to spatial information
(b) maximize speed on operations requiring access to color information

Provide an explanation for your reasoning

-------
How big is the picture?
5000^2 * 50 * 4 B = 4882812,5 kB = 4768,37158203125 MB = 4,656612873077392578125 GB !

NOTE: I will use arrays of primitives instead of collections here.

Let's define inferface HyperspectralImage which will define basic operations done on image. There will be operations done
for colors which is for example get channel (values for all x,y coordinates for a channel), and pixel operations - get
all channel values for given x,y pixel.

We will create two classes - quiz2.question1.ColorOptimisedHyperspectralImageImpl, and quiz2.question1.SpatialOptimisedHyperspectralImageImpl.
One will be optimised for color operations, other one will be optimised for spatial operations.

The data will be stored in three dimensional int array (32 bits it is enough to store all needed data). The structure of
the data will however differ between optimised for color vs. spatial. First dimention will be either channel or pixel
coordinates. Look into the implementation of both classes to understand the difference.

To compare both - look int Benchmark and launch it (junit). This will show comparison of both methods when doing operations
for spatial and color operations.

NOTE:due to high heap size we do not define 5000x5000 picture but 1000x1000. Still results show the differences.


