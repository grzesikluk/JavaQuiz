You are given two hyperspectral images of 5000 x 5000 pixels x 50 channels. One is sparsely
populated, while one is densely populated. Provide the data structures that you would use
to store this information.


-------
This question is about data structure not compression I guess, so I will focus on first only.

The question remains - what we want to gain:
1) we want to gain memory capacity?
2) we want to gain processor capacity? - always arrays (not collections).

Let's focus on 1)
For sparsly populated images - store non-zero values only. See SparseHyperspectralImageImpl.
For densely populated images - store all values. For this solution I would recommend array approach too.
See DenseHyperspectralImageImpl.


