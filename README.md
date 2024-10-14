# Project Description

This project implements a coffee management application that defines classes for various types of coffee and a van to manage the coffee inventory. The main class, `App`, provides functionality to add different types of coffee to the van, sort them by price-to-weight ratio, and find coffee based on quality ratings.

## Running the Project

To run the project, follow these steps:

1. Navigate to the `.\src\` directory:
    ```bash
    cd .\src\
    ```

2. Run the command to build and execute the program:
    ```bash
    .\buildrun.cmd App
    ```

## Classes Overview

1. **Coffee**: Abstract class that represents common attributes and behaviors of different types of coffee, including methods for printing details and calculating price-to-weight ratio.
2. **CoffeeBean**: Represents whole coffee beans, extending the `Coffee` class and implementing specific behaviors for bean coffee.
3. **GroundCoffee**: Represents ground coffee, extending the `Coffee` class with specific behaviors for ground coffee.
4. **InstantCoffee**: Represents instant coffee, with additional attributes for packaging, and extends the `Coffee` class.
5. **CoffeeVan**: Manages a collection of `Coffee` objects, tracking the current volume, total value, and providing functionality to add coffee, sort by price-to-weight ratio, and find coffee by quality range.
6. **App**: The main class that orchestrates the coffee management logic, including adding coffee to the van, displaying cargo details, sorting, and filtering based on quality ratings.

## Description of Actions

Upon execution of the program, the following actions will be performed:

- The program initializes a `CoffeeVan` with a specified maximum volume.
- It defines a list of coffee objects to be added to the van.
- The program attempts to add each coffee object to the van, handling any potential exceptions.
- It displays the initial state of the cargo in the van.
- The program sorts the coffee in the van by price-to-weight ratio and displays the updated cargo details.
- Finally, it filters and displays coffee items with a quality rating within a specified range.
