### Hexlet tests and linter status:
[![Actions Status](https://github.com/a-oselkov/java-project-71/workflows/hexlet-check/badge.svg)](https://github.com/a-oselkov/java-project-71/actions)
![Java CI](https://github.com/a-oselkov/java-project-71/workflows/Java%20CI/badge.svg)
[![Maintainability](https://api.codeclimate.com/v1/badges/dca3f212580f81ad7a82/maintainability)](https://codeclimate.com/github/a-oselkov/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/dca3f212580f81ad7a82/test_coverage)](https://codeclimate.com/github/a-oselkov/java-project-71/test_coverage)

#### Description:

"Difference Calculator" is a program that determines the difference between two data structures. A similar mechanism is used when outputting tests or when automatically tracking changes in configuration files.

Utility Features:

- Support for different input formats: yaml and json

- Generating a report in the form of plain text, stylish and json

#### When run without parameters, the result of comparing two test json files will be displayed.


### Setup
```sh
make install
```


#### When launching the application without parameters, the result of comparing two json text files will be shown.


#### For reference information, use the <strong>-h</strong> key:

![help](https://user-images.githubusercontent.com/122821639/222505600-e9c0f448-57f1-4b93-b733-47b0514b9a7b.png)


#### Specify the path to two json or yaml files and select the format (stylish by default) for displaying information about the differences: 

#### Output example in stylish format:

![stylish](https://user-images.githubusercontent.com/122821639/222505712-bd6395b9-2640-411d-8407-bb004d1c3a10.png)


#### Output example in plain format:

![plain](https://user-images.githubusercontent.com/122821639/222505835-200e74dd-9bea-4c0b-ac0f-f404e64bd872.png)


#### Output example in json format:

![json](https://user-images.githubusercontent.com/122821639/222505949-f612a42b-5c7d-4f6a-afc7-7ed2206f6bfe.png)

