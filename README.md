# trading-app

### Description 

This service exposes a rest endpoint to execute trading algorithms given a signal.

This service utilizes Strategy pattern to select the Signal execution flow to be executed 
for the given signal. The concrete signal strategy classes are Spring beans which are stored in 
a Java Map in the SignalStrategyFactory for faster lookup while selecting the strategy.

This design allow new Signals to be added as and when need without touching the existing code. This design also allows 
to associate different Algo implemenation(derived from same base Algo) for each signal execution.

A similar design can also be achieved using Command Pattern.

While this design helps to create a loosely coupled design but as the no of signals grow, the strategies will keep growing.
Another option would be to use combination of metadata and configuration to reduce the no of code.

### Platform, Tools and Libraries
This service is built with Java 17 and Spring boot 2. It uses junit, mockmvc and mockito for testing. 
Lombok has been used to generate boilerplate code for POJOs.

### Build the Project
Gradle wrapper has been provided to build the project
```bash
./gradlew clean build
```

### Running the service
This service runs on port 8080. Running the service locally will provide the following endpoint
```
http://localhost:8080/trading/signals
```
#### Start the service
```bash
./gradlew bootRun
```

### Call the Endpoint using curl 

```bash
curl -v --location "localhost:8080/trading/signals" \
    --header 'Content-Type: application/json' \
    --data '{"value": 1}'
```