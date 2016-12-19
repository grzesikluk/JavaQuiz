Given the following program:
for (int var = start; var <= start + 1; var++) {}

How does start need to be initialized so that the code above runs indefinitely?

-----------

int start = Integer.MAX_VALUE-1;
