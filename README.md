# genetic_algorithms

## Configuration

##### 1. Add following jars to the project (all required jars are in lib/ directory):
```
- javafx.base.jar
- javafx.graphics.jar
- javafx.web.jar
- decimal4j-1.0.3.jar
- json-simple-1.1.jar
```

##### 2. Set following VM options in Run/Debug configuration:
```--module-path "{path\to\javafxsdk}\lib" --add-modules=javafx.controls,javafx.web```

###### * If some errors occur at building project, make sure that you have following properties set:
```
JRE: 1.8
Module SDK: 1.8
Language level: 8
Project SDK: openjdk-15
```
