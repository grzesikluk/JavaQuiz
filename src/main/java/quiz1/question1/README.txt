Question 1:

You are given a class that can handle several operations on extremely large byte arrays. You
are now required to update the class so that it can handle int and float arrays as well.
Provide an example of how you would do it.

----------

The class is handling primitive types and should be extended to handle other primitive types. Probably the easiest way
is just to overload the methods used. See ArrayOperator class which is the example of such class. It can be extended
to the form of ArrayOperatorExtended class.