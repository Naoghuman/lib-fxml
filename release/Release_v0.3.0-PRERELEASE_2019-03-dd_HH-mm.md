Welcome to `Lib-FXML` with the new release `v0.3.0-PRERELEASE`.

`Lib-FXML` allows the developer to load [JavaFX] relevant files (.fxml, .css, .properties) 
and connect them to a controller (called the presenter).



#### Summary
* ...
* ...



#### Feature
#61 [api] Create new class FXMLAction which hide functionalities from Lib-Action.
#56 [api] Add new interface 'FXMLRegisterable'.
#45 [api] Create new interface FXMLModelable.



#### Enhancement
#65 [api] Extend FXMLAction with new method for Function'T,R'.
#60 [api] Extend FXMLModel with new method 'registerOnAction(String, Consumer'T').
#58 [api] Extend FXMLModel with metadata.
#57 [api] Extend FXMLController 'configure' feature.
#55 [api] Add new method getController(Class'T') to FXMLView.
#50 [api] Enhance FXMLModel.get(Class'T', String) to return an Optional'T'.
#48 [test] Enhance the method DefaultFXMLValidator.requireEndsWith(...).
#47 [api] Create 'FXMLModel.EMPTY' instance in the class FXMLModel.
#42 [test] Rename the demo applications to fit the necessities from the api.



#### Bug



#### Documentation
#49 [doc] Write new concept 'SaveToDatabase'.



#### Refactoring
#64 [cleanup] Refactore the methods in 'FXMLModel'.
#59 [Cleanup] Move all demos into the 'fxml' package.
#54 [cleanup] Rewrite the 'toString()' method from FXMLModel, -View.
#51 [cleanup] Rename the class FXMLPresenter to FXMLController.
#46 [cleanup] Rewrite the 'create(...)' methods in FXMLView.
#44 [cleanup] Rename 'data' in FXMLModel.
#43 [cleanup] Refactore the usage from the method ResourceBundle.getBundle(...) in FXMLView.



#### Additional



Greetings
Naoghuman



[//]: # (Issues which will be integrated in this release)
#52 [test] Add new demo 'DemoAllInOnes'. // Feature



[//]: # (Links)
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
