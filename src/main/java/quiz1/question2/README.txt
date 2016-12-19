You are in the process of writing unit tests for class A. You want to test someMethod that receives
an instance of class B as argument: value == instanceA1.someMethod(instanceB2)
It is extremely difficult to create an instance of ClassB in the test environment. What is the
easiest method of writing this particular unit test for ClassA?

-------

Possible solutions:
- use mock framework to create the instance
- introduce interface which will cover ClassB, then ClassB will implement it. After that create ClassBMock which will
also implement this interface but lightweight.
