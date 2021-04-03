# genetic_algorithms

## Configuration

##### 1. Add following jars to the project (download JavaFX sdk from: https://gluonhq.com/products/javafx/):
```
- javafx.base.jar
- javafx.controls.jar
- javafx.fxml.jar
- javafx.graphics.jar
- javafx.web.jar
- decimal4j-1.0.3.jar
```

##### 2. Set following VM options in Run/Debug configuration:
```--module-path "path\to\installed\javafx_sdk\openjfx-17-ea+3_windows-x64_bin-sdk\javafx-sdk-17\lib" --add-modules=javafx.controls,javafx.web```

##### 3. If some errors occur at building project, make sure that you have following properties set:
```
JRE: 1.7
Module SDK: 1.8
Language level: 8
Project SDK: openjdk-15
```
