## Build status
[![Build and Test](https://github.com/tonymich19/SDET-Backend/actions/workflows/test-execution.yml/badge.svg?branch=master)](https://github.com/tonymich19/SDET-Backend/actions/workflows/test-execution.yml)
[![pages-build-deployment](https://github.com/tonymich19/SDET-Backend/actions/workflows/pages/pages-build-deployment/badge.svg?branch=gh-pages)](https://github.com/tonymich19/SDET-Backend/actions/workflows/pages/pages-build-deployment)

# SDET-test
## Challenge
Create pilot Java test framework for testing NASA's open API >>>> Create pilot Java test framework for testing NASA’s open API

NASA has an open API: https://api.nasa.gov/index.html#getting-started. It grants access to different features e.g: Astronomy Picture of the Day, Mars Rover Photos, etc.

We would like to test different scenarios that the API offers:
1. Retrieve the first 10 Mars photos made by "Curiosity" on 1000 Martian sol.
2. Retrieve the first 10 Mars photos made by "Curiosity" on Earth date equal to 1000 Martian sol.
3. Retrieve and compare the first 10 Mars photos made by "Curiosity" on 1000 sol and on Earth date equal to 1000 Martian sol.
4. Validate that the amounts of pictures that each "Curiosity" camera took on 1000 Mars sol is not greater than 10 times the amount taken by other cameras on the same date.
5. Write integration tests around the core functionality, not functional tests.


