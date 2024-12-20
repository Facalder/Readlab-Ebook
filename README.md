# Gluon - Multi View

Gluon Applications are Java application written in JavaFX.
These applications ensure that developers can create high performance, great looking, and cloud connected mobile apps from a single Java code base.

This sample contains a simple Gluon application which can be used to run, test and create a native application for any targeted device.
The sample leverages Glisten Afterburner framework, built on top of [afterburner.fx](http://afterburner.adam-bien.com/), to inject
models and services into Presenter.

## Pre-requisites

Please checkout the prerequisites to run this application [here](https://github.com/gluonhq/gluonfx-maven-plugin#requirements).

## Instructions

> **Note**: The following are command line instructions. For IDE specific instructions please checkout [IDE section](https://docs.gluonhq.com/#_ide) of the Gluon documentation.

These application can run on the JVM on desktop platforms. To run the application, execute the following command:

```
./gradlew run
```

The same application can also run natively for on any targeted OS, including Android, iOS, Linux, Mac and Windows.

To create a native image, execute the following command:

```
./gradlew nativeBuild nativeRun
```

> **Note**: The above commands are target-platform dependent and might change depending on the platform.
For more details, please check
    [GluonFX Gradle Tasks](https://github.com/gluonhq/gluonfx-gradle-plugin/#2-tasks)

## Configuration

To configure the GluonFX plugin, please checkout the [configuration documentation](https://docs.gluonhq.com/#_configuration).

## More information

Here are some helpful links:

* [Gluon documentation](https://docs.gluonhq.com/)
* [GluonFX Maven Plugin](https://github.com/gluonhq/gluonfx-maven-plugin)
* [GluonFX Gradle Plugin](https://github.com/gluonhq/gluonfx-gradle-plugin)
