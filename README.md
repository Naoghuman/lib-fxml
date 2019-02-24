Lib-FXML
===

[![Build Status](https://travis-ci.org/Naoghuman/lib-fxml.svg?branch=master)](https://travis-ci.org/Naoghuman/lib-fxml)
[![license: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![GitHub release](https://img.shields.io/github/release/Naoghuman/lib-fxml.svg)](https://GitHub.com/Naoghuman/lib-fxml/releases/)



Intention
---

`Lib-FXML` allows the developer to load [JavaFX] relevant files (.fxml, .css, .properties) 
and connect them to a controller (called the presenter).

[Adam Bien]'s GitHub project [afterburner.fx] has not been developed for over 3 years (in 2018).  
So I'm going to develop my own lightweight implementation of afterburner.fx for my own 
`libraries`, `frameworks` and `applications`.

Finally, I want to make it clear that I did not just copy the source code from Adam, 
but used the conventions, ideas of afterburner.fx for my own implementation.

_Image:_ Overview basic concept from `Lib-FXML` 
![Overview_Lib-FXML_MVP_v0.1.0-PRERELEASE_2018-12-20.png][Overview_Lib-FXML_MVP_v0.1.0-PRERELEASE_2018-12-20]



* [Examples](#Examples)
    * [Example 1](#Example1)
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



Conventions<a name="Conventions" />
---

In this chapter, the interested developer can find out about all the conventions 
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
[Overview_Lib-FXML_MVP_v0.1.0-PRERELEASE_2018-12-20]:https://user-images.githubusercontent.com/8161815/50287987-e8c55d00-0464-11e9-879e-9942a9eaf765.png



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
