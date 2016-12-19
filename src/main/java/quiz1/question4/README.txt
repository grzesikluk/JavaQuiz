What is wrong with this code?

TiffField.getValue can either return a Short, Integer, Double or an array of those elements.

----
The generic method hides the type returned thus making it difficult to use.