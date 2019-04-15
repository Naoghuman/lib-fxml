Lib-FXML
===

[![Build Status](https://travis-ci.org/Naoghuman/lib-fxml.svg?branch=master)](https://travis-ci.org/Naoghuman/lib-fxml)
[![license: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![GitHub release](https://img.shields.io/github/release/Naoghuman/lib-fxml.svg)](https://GitHub.com/Naoghuman/lib-fxml/releases/)



Intention
---

The `Lib-FXML` library simplifies the loading of [JavaFX] relevant files (model, 
view, controller, .fxml, .css, .properties) and enables a standardized handling 
of the data flow to (in, from) the gui.

Inspired by [Adam Bien]'s library [afterburner.fx], which unfortunately hasn't been 
developed since 2015, the library `Lib-FXML` simplifies the daily developer tasks 
in context from the aboved mentioned two main points:
 * Simplifying the loading of `JavaFX` relevant files and
 * offering a standardized data flow to (from) the gui.

_Image:_ Overview Lib-FXML  
![Overview-UML_Lib-FXML_v0.3.0-PRERELEASE_2019-04-14_23-39.png][Overview-UML_Lib-FXML_v0.3.0-PRERELEASE_2019-04-14_23-39]



Content
---

* [Demos](#Demos)
    * [Demo 'All in Ones'](#DeAlInOn)
    * [Demo 'With all files'](#DeWiAlFi)
    * [Demo 'Without .css file'](#DeWiCsFi)
    * [Demo 'Without .properties file'](#DeWiPrFi)
* [Conventions](#Conventions)
* [Features](#Features)
* [JavaDoc](#JavaDoc)
* [Download](#Download)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Demos<a name="Demos" />
---

The various demo applications in this chapter shows specific aspects, conventions 
and features of the library Lib-FXML.


### Demo 'All in Ones'<a name="DeAlInOn" />

___Intention___

_Image:_ Demo 'All in Ones'  

___Demo files___
The following demo files are involved:
* DemoAllInOnes.java
* DemoAllInOnesController.java
* DemoAllInOnesEntity.java
* DemoAllInOnesSqlEntity.java
* demoallinones.css
* demoallinones.fxml
* demoallinones.properties

___How it works!___


### Demo 'With all files'<a name="DeWiAlFi" />

___Intention___

_Image:_ Demo 'With all files'  

___Demo files___
The following demo files are involved:
* DemoWithAllFiles.java
* DemoWithAllFilesController.java
* demowithallfiles.css
* demowithallfiles.fxml
* demowithallfiles.properties

___How it works!___


### Demo 'Without .css file'<a name="DeWiCsFi" />

___Intention___

_Image:_ Demo 'Without .css file'  

___Demo files___
The following demo files are involved:
* DemoWithoutCssFile.java
* DemoWithoutCssFileController.java
* demowithoutcssfile.fxml
* demowithoutcssfile.properties

___How it works!___


### Demo 'Without .properties file'<a name="DeWiPrFi" />

___Intention___

_Image:_ Demo 'Without .properties file'  

___Demo files___
The following demo files are involved:
* DemoWithoutPropertiesFile.java
* DemoWithoutPropertiesFileController.java
* demowithoutpropertiesfile.css
* demowithoutpropertiesfile.fxml

___How it works!___



Conventions<a name="Conventions" />
---

In this chapter, the interested developer can find out all about the conventions 
in the library `Lib-FXML`.
* ...
* ...



Features<a name="Features" />
---

`Lib-FXML` have many nice features which simplify the developers task to 
store and access simple data in a Java(FX) application:
* ...
* ...



JavaDoc<a name="JavaDoc" />
---

The [JavaDoc] from the library `Lib-FXML` can be explored here: [JavaDoc Lib-FXML] _(in work)_

_Image:_ JavaDoc Lib-FXML v0.2.0-PRERELEASE
TODO
 


Download<a name="Download" />
---

Current `version` is `0.2.0-PRERELEASE`. Main points in this release are:
* Extend the api from Lib-FXML with more methods, tests and internal validations.
* Prepare the documentation for the future releases.

Download:
* [Release v0.2.0-PRERELEASE] (02.24.2019 / MM.dd.yyyy)

An `overview` about all existings releases can be found here:
* [Overview] from all releases in Lib-FXML.



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [lib-fxml-0.1.0-PRERELEASE](#Installation).

In the library following dependencies are registered:
* The library [lib-logger-0.6.0.jar](#Installation).
  * Included in `Lib-Logger` is the library [log4j-api-2.10.0.jar].
  * Included is `Lib-Logger` is the library [log4j-core-2.10.0.jar].



Installation<a name="Installation" />
---

* If not installed download the [JRE 8] or the [JDK 8].
  * Optional: To work better with [FXML] files in a [JavaFX] application 
    download the [JavaFX Scene Builder] under 'Additional Resources'.
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for development.
* Download or clone [Lib-FXML].
* Download or clone [Lib-Logger].
* Open the projects in your IDE and run them.



Contribution<a name="Contribution" />
---

* If you find a `Bug` I will be glad if you could report an [Issue].
* If you want to contribute to the project plz fork the project and do a [Pull Request].



License<a name="License" />
---

The project `Lib-FXML` is licensed under [General Public License 3.0].



Autor<a name="Autor" />
---

The project `Lib-FXML` is maintained by me, Naoghuman (Peter Rogge). See [Contact](#Contact).



Contact<a name="Contact" />
---

You can reach me under <peter.rogge@yahoo.de>.





[//]: # (Images)
[Overview-UML_Lib-FXML_v0.3.0-PRERELEASE_2019-04-14_23-39]:https://user-images.githubusercontent.com/8161815/56099552-d0df8080-5f0e-11e9-8709-62470c9b5f63.png



[//]: # (Links)
[Adam Bien]:http://adambien.blog/roller/
[afterburner.fx]:https://github.com/AdamBien/afterburner.fx
[Eclipse]:https://www.eclipse.org/
[FXML]:http://docs.oracle.com/javafx/2/fxml_get_started/jfxpub-fxml_get_started.htm
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[IntelliJ IDEA]:http://www.jetbrains.com/idea/
[Issue]:https://github.com/Naoghuman/lib-fxml/issues
[JavaDoc]:http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html
[JavaDoc Lib-FXML]:http://naoghuman.github.io/lib-fxml/apidocs
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX Scene Builder]:http://www.oracle.com/technetwork/java/javase/downloads/index.html
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Lib-FXML]:https://github.com/Naoghuman/lib-fxml
[Lib-Logger]:https://github.com/Naoghuman/lib-logger
[log4j-api-2.10.0.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.10.0.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Overview]:https://github.com/Naoghuman/lib-fxml/releases
[Release v0.2.0-PRERELEASE]:https://github.com/Naoghuman/lib-fxml/releases/tag/v0.2.0-PRERELEASE
[Pull Request]:https://help.github.com/articles/using-pull-requests
