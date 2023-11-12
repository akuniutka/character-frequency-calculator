# Character Frequency Calculator 

A REST service which calculates character frequencies for an input string. Pass a JSON object 
with a string as the value of `data` property to the service, and it will respond with an 
array of JSON objects which consist of two properties each: `character` and `frequency`. The 
array will be sorted by `frequency` value in descending order.

Examples of an input string:
```json
{
  "data": "Hello, World!"
}
```
and of the response to it:
```json
[
  {
    "character": "l", 
    "frequency": 3
  }, 
  {
    "character": "o",
    "frequency": 2
  },
  {
    "character": " ",
    "frequency": 1
  },
  {
    "character": "!",
    "frequency": 1
  },
  {
    "character": ",",
    "frequency": 1
  },
  {
    "character": "H",
    "frequency": 1
  },
  {
    "character": "W",
    "frequency": 1
  },
  {
    "character": "d",
    "frequency": 1
  },
  {
    "character": "e",
    "frequency": 1
  },
  {
    "character": "r",
    "frequency": 1
  }
]
````

### How to run

The project contains a script to build a Docker image directly from the GitHub repository, 
so you need only `Dockerfile` downloaded and Docker installed.
Execute the following command to build an image:
```shell
docker build . -t character-frequency-calculator
```
Then start a container with the following command:
```shell
docker run -itd --rm -p 8080:8080 --name character-frequency-calculator character-frequency-calculator
```
When you finish, stop the container with the following command:
```shell
docker stop character-frequency-calculator
```

### Endpoints

| Description                  | Endpoint                                                                                                   |
|------------------------------|------------------------------------------------------------------------------------------------------------|
| The service itself           | [http://localhost:8080/calculateCharacterFrequencies](http://localhost:8080/calculateCharacterFrequencies) |
| Spring Boot Actuator         | [http://localhost:8080/actuator](http://localhost:8080/actuator)                                           |
| Spring Boot Actuator Health  | [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)                             |
| API documentation in JSON    | [http://localhost:8080/v2/api-docs](http://localhost:8080/v2/api-docs)                                     |
| API documentation in HTML    | [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)                                     |
