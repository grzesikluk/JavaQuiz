You have a fairly large (100+ classes) multithreaded Java application. You run it and it
hangs. How do you go about debugging this application?

------------
I fill this is general question - "how to do troubleshooting" rather than "how to go about debugging" because
debugging is just launching the program in special mode to be able to understand where are the roots of particular failure.
You can do this to understand where you think the problem is and do step by step troubleshooting even for multiple threads
in IDE but it is one of the last activities when fixing this kind of problems.

I think there is no silver bullet for troubleshooting this kind of problems. You need to go with iterative approach which
means you need to be able to reproduce the problem and investigate some symptoms.

The catch here is where the app fails and what is the impact of failure. If this happens on prod, has big impact and it is
really random - you have to start with setting up env that will be similar and able to reproduce this fault. Also if this
problem is random you need to spend a lot of time to figure out what conditions lead to the failure. This might be the
hardest part sometimes.

But if you are lucky enough to be able to reproduce it safely on non prod environment you can go with below.

The information - "a fairly large (100+ classes)" suggests that the app is complicated and it also asks for some initial
investigation before starting to do "debugging". By this I mean to spot all symptoms and understand from which part of
system they come from.

This requires to understand what is symptom, what might be the root causes. It also requires to understand if there is
single reason of failure or there are many. Also it is good to understand what symptoms are connected to which cause.

After that you need to look at the app itself and narrow down the possible part of system from which you think the problem
comes. You need to gather information that will allow you to do this.

When starting to think about possible reasons of hanging we can start with some hypothesis.
- deadlocks / livelocks
- resource access, DB or IO
- other (connectivity).

Each one requires tools to gather more information:
- introduce log4j everywhere in this app to have proper logging
- introduce JMX beans
- try with JProfiler or JConsole
- add logging to troubleshoot where is the problem
- do heap dump
- do IO or DB troubleshooting.

So in general this is part where you need to do googling supported by coffee to do figure out the root cause. After that
if the problem is fairly easy to fix - do this, otherwise redesing part of system which is more costly.