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

![help](https://user-images.githubusercontent.com/122821639/221960796-72e1d7e1-5130-40a0-950e-ac68c4a20ea6.png)

#### Specify the path to two json or yaml files and select the format (stylish by default) for displaying information about the differences: 

#### Output example in stylish format:

![stylish](https://user-images.githubusercontent.com/122821639/221957686-98f003c1-ac0b-4488-87eb-b58c6ab2af99.png)

#### Output example in plain format:

![plain](https://user-images.githubusercontent.com/122821639/221958077-ac030872-9353-404d-a7ec-ecf9b14f88d1.png)

#### Output example in json format:

![json](https://user-images.githubusercontent.com/122821639/221958367-8899c052-5832-4856-9b67-4321960320df.png)
