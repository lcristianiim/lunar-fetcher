A java library that collects lunar data from timeanddate.com
Lunar data consists of:
- **spring equinox**
- **march new moon**
- **march full moon**
- **april new moon**
- **april full moon**
- **march sunsets**
- **april sunsets**

## Installation

```sh
# create jar (build/libs/lunar-fetcher.jar)
./gradlew jar
```

## :clipboard: Example
```sh
# Run the jar lunar-fetcher.jar

java -jar lunar-fetcher.jar 2020 2021 268 switzerland/zurich
```

## :memo: Documentation
### `lunar-fetcher.jar <startYear> <endYear> <locationId> <place>`
Saves lunar data to a jon file.

#### Params

- **int** `startYear`: The year to start collecting data from. i.e 2020
- **int** `endYear`: The end year of collecting data. i.e 2021
- **int** `locationId`: Number representing a location. i.e 110
In order to get the right locationId for you desired location, you must check timeanddate.com
- **String** `place`: String representing a location. i.e israel/jerusalem
In order to get the right place for you desired location, you must check timeanddate.com
