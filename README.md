      
# Automated Testing of JPetStore Demo Website

## 1. Project Overview

This repository contains the final graduation project for the ITI program, focusing on Web Automation Software Testing. 
The project implements a comprehensive automated testing framework for the **JPetStore demo website**.
The primary goal is to ensure the application's functionality, reliability, and robustness through a well-structured suite of automated tests.

A total of **45 test cases** were designed and automated, covering various features of the application. The suite includes **4 complete End-to-End (E2E) scenarios** to validate the full user journey.

## 2. Key Features

- **Test Framework:** Built using Selenium WebDriver for browser automation.
- **Design Pattern:** Implements the **Page Object Model (POM)** for enhanced test maintenance, readability, and scalability.
- **Comprehensive Test Coverage:** Includes 45 test cases covering:
    - User Login.
    - Product Search and Filtering.
    - Navigation through different category pages.
    - Shopping Cart Management (Add, Update, Remove)
    - Order Placement and Checkout Process
- **End-to-End Scenarios:**
    - **2 Positive Scenarios:** Simulate a successful user journey from browsing products to completing a purchase.
    - **2 Negative Scenarios:** Test the system's error-handling capabilities by simulating invalid inputs and unexpected user actions (e.g., attempting checkout with an empty cart, using invalid login credentials).
- **Reporting:** Generates detailed test execution reports using **Allure Reports** to analyze results and identify failures.

## 3. Technologies & Tools

- **Automation Tool:** Selenium WebDriver & TestNG Framework
- **Programming Language:** Java
- **Test Runner:** TestNG
- **Build & Dependency Management:** Maven
- **Design Pattern:** Page Object Model (POM)

## 4. Project Structure

The project follows the Page Object Model design pattern to ensure a clean separation between test logic and UI interaction code.

  
/src
|-- /main
| -- /java | -- /com
| -- /jpetstore | |-- /pages (Contains Page Objects for each page, e.g., LoginPage, DashboardPage) | |-- /utils (Contains utilities like WebDriver setup, listeners) | -- /base (Contains the base class for test setup/teardown)
|
-- /test -- /java
-- /com -- /jpetstore
`-- /tests (Contains all the test scripts, e.g., LoginTests, E2EScenarios)
code Code
IGNORE_WHEN_COPYING_START
IGNORE_WHEN_COPYING_END

      
## 5. Setup and Installation

**Prerequisites:**
- JDK 21 or higher
- Apache Maven
- Google Chrome

**Instructions:**

1.  **Clone the repository:**
    ```bash
    git clone [your-repository-url]
    cd [your-project-directory]
    ```

2.  **Install dependencies:**
    *(Example for Maven)*
    ```bash
    mvn clean install
    ```

## 6. How to Run Tests
You can execute the entire test suite using the following command:

*(Example for Maven with TestNG)*
```bash
mvn test
```
## 7. Author

- Basant Elsayed -https://www.linkedin.com/in/basant-elsayed-249a6414a/

