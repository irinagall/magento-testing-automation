# Magento software testing board project

A simple project testing the magento software testing board website using cucumber and java.

Currently, the critical user journeys of setting up an account, locating a product and purchasing a product are being tested.

## Getting Started


### Prerequisites

The things you need before installing the software.

* Find your Chrome version and [download](https://googlechromelabs.github.io/chrome-for-testing/) the chrome drivers which matches your version
* * chromedriver.exe
* * LICENSE.chromedriver
* Intellij is the recommended IDE for this project

### Installation

A step by step guide that will tell you how to get the development environment up and running.


* Move the chromedriver and license files downloaded above to "src/test/resources"
* Create a new file test.properties inside "src/test/resources"
* Add driver.location=src/test/resources/chromedriver to test.properties or a different location where your web driver is located


## Usage

* Go to "src/test/java/webtestframework/stepdefs/TestRunner.java" and run the TestRunner class

## Metrics

To see the latest test metrics, see [the report](reports/testReport.html).
