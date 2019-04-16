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
* offering a standardized data flow to (in, from) the gui.

_Image:_ Overview Lib-FXML  
![Overview-UML_Lib-FXML_v0.3.0-PRERELEASE_2019-04-14_23-39.png][Overview-UML_Lib-FXML_v0.3.0-PRERELEASE_2019-04-14_23-39]



Content
---

* [Demo 'All in Ones'](#DeAlInOn)
    - [_Intention_](#DeAlInOnIn)  
      [General features](#DeAlInOnInGeFe)  
      [Extended features](#DeAlInOnInExFe)  
      [Additional features](#DeAlInOnInAdFe)
    - [_Demo files_](#DeAlInOnDeFi)  
      [DemoAllInOnes.java](#DeAlInOnDeFiSt)  
      [DemoAllInOnesController.java](#DeAlInOnDeFiCo)  
      [DemoAllInOnesEntity.java](#DeAlInOnDeFiEn)  
      [DemoAllInOnesSqlEntityProvider.java](#DeAlInOnDeFiSqEn)  
      [demoallinones.css](#DeAlInOnDeFiCs)  
      [demoallinones.fxml](#DeAlInOnDeFiFx)  
      [demoallinones.properties](#DeAlInOnDeFiPr)  
      [DemoInfoWriter.java](#DeInWr)  
      [DemoAllInOnesInfoWriter.java](#DeAlInOnInWr)  
      [DemoAllInOnesPreferencesWriter.java](#DeAlInOnPrWr)
    - [_How it works_](#DeAlInOnHoItWo)  
      [Usage from the singleton class 'FXMLAction'](#DeAlInOnHoItWoAc)  
      [Usage from the abstract class 'FXMLController'](#DeAlInOnHoItWoCo)  
      [Usage from the class 'FXMLModel'](#DeAlInOnHoItWoMo)  
      [Usage from the class 'FXMLView'](#DeAlInOnHoItWoVi)  
      [Usage from the interface 'FXMLModelable'](#DeAlInOnHoItWoMoAb)  
      [Usage from the interface 'FXMLRegistrable'](#DeAlInOnHoItWoRe)
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



Demo 'All in Ones'<a name="DeAlInOn" />
---

_Image:_ Demo 'All in Ones'  
![Lib-FXML_Demo-All-in-Ones_v0.3.0-PRERELEASE_2019-04-15_21-40.png][Lib-FXML_Demo-All-in-Ones_v0.3.0-PRERELEASE_2019-04-15_21-40]


### _Intention_<a name="DeAlInOnIn" />
This demo wants to show, explain how to integrate the various features from the library 'Lib-FXML' into a demo application:

#### General features<a name="DeAlInOnInGeFe" />
* How to use the abstract class 'FXMLController' as a convention to managed the presentation from the 'FXMLModel' data in a concrete implementation from 'FXMLController'.
* How to use the class 'FXMLModel' as a lightweight version from an entity to manage the dataflow to (in, from) the controller.
* How to use the class 'FXMLView' to load the gui declaration (.fxml file) and map it (initialization from the gui) to a controller.

#### Extended features<a name="DeAlInOnInExFe" />
* How to use the singleton 'FXMLAction' to register (handle) lambda methods such like 'Consumer', 'Function' and 'Supplier'.
* How to use the class 'FXMLModel' to add additional methods which extend the original entity behavior. For example 'isUpdatedProperty()'.
* How to use the interface 'FXMLRegisterable' as a convention which allowes developers to register for example action methods.
* How to use the interface 'FXMLModelable' as a convention to create a lightweight version from an entity.

#### Additional features<a name="DeAlInOnInAdFe" />
* How to implement a 'singleton' instance with 'Optional<T>' in 'FXMLAction' and access the class behaviours with the static method 'getDefault()'.
* How to use the 'JavaFX' default binding features to automatically update the 'FXMLModel' (entity) data to (in, from) the controller.
* How to use the 'JavaFX' standard class 'FXMLLoader' in 'FXMLView' to load '.fxml', '.css', '.properties' files and assoziate them with a controller.
* How to style with 'CSS' different 'JavaFX' components such like 'AnchorPane', 'Button', 'TextField', 'ScrollPane'.
* How to use the library 'Lib-Logger' (https://github.com/Naoghuman/lib-logger) to log messages easily to a log-file.


### _Demo files_<a name="DeAlInOnDeFi" />
In this section all files are listed which are involved into this demo. Also their main purpose are explained:

#### DemoAllInOnes.java<a name="DeAlInOnDeFiSt" />
* Shows how to start a 'JavaFX' application :) .
* Shows how to create an instance from the class 'FXMLView' to show then the gui with 'view.getRoot().orElse(new AnchorPane())' in the demo application.
* Shows how the interface 'FXMLRegisterable' can be used as a convention to register the action method from this class.

#### DemoAllInOnesController.java<a name="DeAlInOnDeFiCo" />
* Shows how the developer can access the 'URL' from the '.fxml' file.
* Shows how the developer can access the optional 'ResourceBundle' if defined.
* Shows how to use the classes 'DemoInfoWriter', 'DemoAllInOnesInfoWriter' and 'DemoAllInOnesPreferencesWriter' to write the demo infos.
* Shows how to use the overriden method 'FXMLController#configure(FXMLModel) to bind the data from the 'FXMLModel' to the gui components.
* Shows how the interface 'FXMLRegisterable' can be used as a convention to register the various action methods from this controller.
* Shows how to use the different 'FXMLAction#handle(...)' methods to fit the necessities from this controller.

#### DemoAllInOnesEntity.java<a name="DeAlInOnDeFiEn" />
* Shows how to create a simple 'POJO' with 'JavaFX' properties ('LongProperty' and 'StringProperty').
* Shows the usage from 'JavaFX' properties to bind data which means we don't need to be aware that the data is up-to-date :).
* Shows how to use the interface 'FXMLModelable' which allowed to configure a 'FXMLModel' with selected data properties from the entity.

#### DemoAllInOnesSqlEntityProvider.java<a name="DeAlInOnDeFiSqEn" />
* Shows how to define a simple 'sql' entity provider which simulates the 'crud' operations for an entity to (from) a database.
* Shows how to use the interface 'FXMLRegisterable' as a convention to register the action methods from this class.
* Shows how to use the class 'FXMLAction' to register the (crud) action methods via lambda injection.

#### demoallinones.css<a name="DeAlInOnDeFiCs" />
* Shows how to create a 'CSS' (Cascading Style Sheets) file which styles will be then shown in the demo application.
* Shows how to style with 'CSS' different 'JavaFX' components such like 'AnchorPane', 'Button', 'TextField', 'ScrollPane'.

#### demoallinones.fxml<a name="DeAlInOnDeFiFx" />
* Shows how to define a declaration from the demo gui in form from a special JavaFX 'XML' file so called 'FXML'.
* Shows how then the initialization will be done during the loading and mapping from the '.fxml' file with the corresponding 'controller'.  
  See 'FXMLView#initializeFXMLLoader(FXMLModel)' for more informations.

#### demoallinones.properties<a name="DeAlInOnDeFiPr" />
* Shows how to create a '.properties' file which can contains different 'key/value' String pairs. Over the 'key' the 'value' can retrieved then in the application.
* An alternative is the useage from my Library 'Lib-I18N' (https://github.com/Naoghuman/lib-i18n), which allowed multilingualism depending from an actual 'Locale'.

The next files are used to create the demo informations:

#### DemoInfoWriter.java<a name="DeInWr" />
* The abstract class 'DemoInfoWriter' offers various functions for writing different styled informations into a 'VBox'.
* For example: Styled text (size, FontPosture), 'Button's, 'Separator's and 'TextField's.

#### DemoAllInOnesInfoWriter.java<a name="DeAlInOnInWr" />
* A concrete implementation from the abstract class 'DemoInfoWriter' for this demo.
* All informations about the features from the library 'Lib-FXML' and the demo :) in the left side from the demo are written with this class.

#### DemoAllInOnesPreferencesWriter.java<a name="DeAlInOnPrWr" />
* Another concrete implementation from the abstract class 'DemoInfoWriter'.
* With this class the interactive area on the right side in the demo application is written.


### _How it works_<a name="DeAlInOnHoItWo" />
This section shows how to use the different classes and interfaces from the 'Lib-FXML' api:
        
#### Usage from the singleton class 'FXMLAction'<a name="DeAlInOnHoItWoAc" />
* Used in 'DemoAllInOnes', 'DemoAllInOnesController', 'DemoAllInOnesInfoWriter' and 'DemoAllInOnesSqlEntityProvider'.
* Answers the question how to implement a 'singleton' instance with 'Optional<T>' in 'FXMLAction' and access the class behaviours with the static method 'getDefault()'.
* Answers the question how to register (handle) action methods from type 'Consumer<FXMLModel>', 'EventHandler<ActionEvent>' and 'Function<Long, FXMLModel>'.
* Answers also the question how to register (handle) action methods from type 'EventHandler<ActionEvent>'.
        
#### Usage from the abstract class 'FXMLController'<a name="DeAlInOnHoItWoCo" />
* Used in 'DemoAllInOnesController'.
* Used in 'FXMLView'.
* Answers the question how to use the abstract class as a convention to managed the presentation from the 'FXMLModel' data in a concrete controller.
* Answers the question how the controller (it's attributs) is the initialization from the declaration in the '.fxml' file.
        
#### Usage from the class 'FXMLModel'<a name="DeAlInOnHoItWoMo" />
* Used in 'DemoAllInOnes', 'DemoAllInOnesController', 'DemoAllInOnesEntity' and 'DemoAllInOnesSqlEntityProvider'.
* Used in 'FXMLAction', 'FXMLController', 'FXMLModelable' and 'FXMLView'.
* Answers the question how to use the model to managed the dataflow to (in, from) the gui.
* Answers the question how the 'FXMLModel' will be initialized in the entity 'DemoAllInOnesEntity' with the convention methods from the interface 'FXMLModelable'.
* Answers the question how to add some additional data methods to extend the behavior from the original entity.
        
#### Usage from the class 'FXMLView'<a name="DeAlInOnHoItWoVi" />
* Used in 'DemoAllInOnes'.
* Answers the question how to use the class 'FXMLView' to load the gui declaration (.fxml file) and map it (initialization from the gui) to a controller.
* Answers the question how to use the 'JavaFX' standard class 'FXMLLoader' in 'FXMLView' to load '.fxml', '.css', '.properties' files and assoziate them with a controller.
        
#### Usage from the interface 'FXMLModelable'<a name="DeAlInOnHoItWoMoAb" />
* Used in 'DemoAllInOnesEntity'.
* Answers the question how to use the interface as a convention to initialize a FXMLModel with different entity properties.
        
#### Usage from the interface 'FXMLRegistrable'<a name="DeAlInOnHoItWoRe" />
* Used in 'DemoAllInOnes', 'DemoAllInOnesController' and 'DemoAllInOnesSqlEntityProvider'.
* Answers the question how to use the interface as a convention to register different action methods via 'lambda' injection.



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
[Lib-FXML_Demo-All-in-Ones_v0.3.0-PRERELEASE_2019-04-15_21-40]:https://user-images.githubusercontent.com/8161815/56160350-4870e680-5fc7-11e9-9b95-9ab31d0ce2ec.png
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
