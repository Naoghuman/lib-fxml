Welcome to `Lib-FXML` with the new release `v0.3.0-PRERELEASE`.

The `Lib-FXML` library simplifies the loading of [JavaFX] relevant files (model, 
view, controller, .fxml, .css, .properties) and enables a standardized handling 
of the data flow to (in, from) the gui.



#### Summary
* Extend the api with exciting features like FXMLAction, FXMLModel.
* Create an extended demo application with all features from the library.



#### Bug



#### Feature
#61 [api] Create new class FXMLAction which hide functionalities from Lib-Action.
#56 [api] Add new interface 'FXMLRegisterable'.
#52 [test] Add new demo 'DemoAllInOnes'.
#45 [api] Create new interface FXMLModelable.



#### Enhancement
#70 [api] Add new method 'configure()' to FXMLController.
#67 [api] Extend the class FXMLAction with new method for handling a Supplier.
#65 [api] Extend FXMLAction with new method for Function'T,R'.
#62 [test] add 'css' styling for the JavaFX components in the demos.
#60 [api] Extend FXMLModel with new method 'registerOnAction(String, Consumer'T').
#58 [api] Extend FXMLModel with metadata.
#57 [api] Extend FXMLController 'configure' feature.
#55 [api] Add new method getController(Class'T') to FXMLView.
#50 [api] Enhance FXMLModel.get(Class'T', String) to return an Optional'T'.
#48 [test] Enhance the method DefaultFXMLValidator.requireEndsWith(...).
#47 [api] Create 'FXMLModel.EMPTY' instance in the class FXMLModel.
#42 [test] Rename the demo applications to fit the necessities from the api.



#### Test



#### Documentation
#73 [doc] Write section 'DemoAllInOnes' in ReadMe.
#71 [doc] Update the GitHub project description.
#69 [doc] Update the header from the UML image in the section 'Intention'.
#63 [doc] Update the section 'Demos' in the ReadMe.
#49 [doc] Write new concept 'SaveToDatabase'.
#41 [doc] Update section 'Intention' in ReadMe.



#### Refactoring
#72 [Cleanup] Refactore FXMLModel. Metadata methods have the keyword in name.
#66 [cleanup] Rename the methods in the interface FXMLModelable.
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



[//]: # (Links)
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
