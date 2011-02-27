Goal
----

* GWT Library for other applications
* Create an abstraction on shapes using the beginPath() function
* The abstraction should be layered so that Path's can combine, Shape's can combine and Shapes can be decorated.
* Create an API that would be useful for game programming
* Provide functionality that gives advantages over simply using SVG for vector graphics

Not Goals
---------

* Create a tool that will work in all browsers - you need the 'canvas' element getContext to function

Install
-------

1. Obtain a copy of Java 1.6 SDK, Maven 2.2+
2. Create the jar in the target directory by typing `mvn package`
3. Install the jar's current version in your maven repository by typing `mvn install`