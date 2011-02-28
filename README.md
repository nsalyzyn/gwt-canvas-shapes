Goal
----

* Create a GWT Library for use by other applications
* Create an abstraction on shapes using the beginPath() function
* Completely hide the low level API to give these classes full control over save(), restore() and path state
* The abstraction should be layered so that Path's can combine, Shape's can combine and Shapes can be decorated.
* Create an API that would be useful for game programming
* Provide functionality that gives advantages over simply using SVG for vector graphics
* Due to the Canvas API for GWT as of version 2.2 being up the air, this will not rely on it

Not Goals
---------

* Create a tool that will work in all browsers - you need the 'canvas' element getContext to function
* Create a tool with full access to everything that the Canvas elemtn can do.

Install
-------

1. Obtain a copy of Java 1.6 SDK, Maven 2.2+
2. Create the jar in the target directory by typing `mvn package`
3. Install the jar's current version in your maven repository by typing `mvn install`
