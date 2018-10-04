# Spring Consumer Driven Contract Development Workbench

This workbench demonstrates how to do consumer driven contract development (CDC) by using
the Spring Cloud Contract Verifier.

It is inspired by a talk from Josh Long given on October, 3rd 2018 on YouTube for the v JUG.

You can find Joshs example using reactive paradigms at [GitHub: bootiful-testing](https://github.com/joshlong/bootiful-testing)

The talk can be watched on [YouTube: Bootiful Testing by Josh Long](https://youtu.be/jTKFBGWhhBA)

This workbench contains an application offering a REST api (producer) and another application
that implements a client to access this service (consumer).

## Building and Testing the Producer and its Stubs

The contract stubs are build and tested by a regular `gradle build`.

If you want to perform the generation of contract tests as a separate task, you can use the following command:
```
$ ./gradlew :contract-producer:generateContractTests :contract-producer:test
```

The following command will then publish the generated (and tested) stubs to the local
maven repository:
```
$ ./gradlew :contract-producer:publishToMavenLocal
```


## Build and Test the Consumer

To build and test the consumer use `./gradlew :contract-consumer:check`. This will pull
the test stubs generated by the producer from the local maven repository and use them for
running the tests.