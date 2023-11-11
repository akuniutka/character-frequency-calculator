A REST service which calculates frequency for characters in the input string.

### Build Docker container
```shell
docker build . -t character-frequency-calculator
```

### Run Docker container
```shell
docker run -itd --rm -p 8080:8080 --name character-frequency-calculator character-frequency-calculator
```

### How to test

[http://localhost:8080/calculateCharacterFrequencies](http://localhost:8080/calculateCharacterFrequencies)

request
```json
{
  "data": "Hello, World!"
}
```

response
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
