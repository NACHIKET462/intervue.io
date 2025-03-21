# intervue.io

**(Selenium Automation Assignment)**

**Project Overview**

This project automates the login process and follows a predefined scenario using Selenium WebDriver, TestNG, and Page Object Model (POM) in Java. It includes capturing screenshots and validating successful login.

Tech Stack

Java 17

Selenium WebDriver 4.28.0

TestNG 7.10.2

WebDriver Manager 5.9.1

Extent Reports 5.0.9

Lombok 1.18.30

**Project Structure**

project-root/
│── src/main/java/com/demo/
│   ├── App.java                # Main application class
│   ├── Login.java              # Login automation script
│── src/test/java/com/demo/
│   ├── AppTest.java            # Test cases for automation
│── src/main/java/com/demo/Utils/
│   ├── ScreenshotUtil.java     # Screenshot utility for capturing failures
│── pom.xml                     # Maven configuration file
│── README.md                   # Project documentation

**Prerequisites**

Before running the automation script, ensure you have:

Java 17+ installed and configured (JAVA_HOME set)

Maven installed (mvn -v to verify)

Google Chrome and corresponding ChromeDriver

Internet connection (for WebDriver Manager to download required drivers)

Setup Instructions

**Clone the repository:**

git clone <repo_url>
cd project-root

Build the project:

mvn clean install

Run the test cases:

mvn test

**Features Implemented**

Automated login flow

Explicit waits for elements

Page Object Model (POM) implementation

Screenshot capture on test failure

Test reports using Extent Reports

**Test Execution**

Running the Login Test

Update login credentials in Login.java if necessary.

**Run the test using TestNG or Maven:**

mvn test

View test results in the target/surefire-reports folder.

**Screenshot Capture**

If the test fails, a screenshot will be saved in the project root directory.

**Extent Reports**

After execution, Extent Reports will be generated in:

target/extent-reports/ExtentReport.html

Open the file in a browser to view the test report.

**Future Enhancements**

Implement data-driven testing using Excel or JSON.

Extend test scenarios for invalid login cases.

Integrate with CI/CD pipelines for automated execution.


Author

Nachiket N K
nachikchita@gmail.com
7619276400
QA Automation Engineer
