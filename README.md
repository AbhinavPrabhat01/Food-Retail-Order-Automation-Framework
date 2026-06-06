# 🍕 Food Retail Order Automation Framework

<div align="center">

![Java](https://img.shields.io/badge/Java-11+-orange?style=for-the-badge&logo=openjdk)
![Selenium](https://img.shields.io/badge/Selenium-4-green?style=for-the-badge&logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7-red?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Build-blue?style=for-the-badge&logo=apachemaven)
![ExtentReports](https://img.shields.io/badge/ExtentReports-Reporting-purple?style=for-the-badge)
![Log4j](https://img.shields.io/badge/Log4j-Logging-yellow?style=for-the-badge)

### End-to-End UI Automation Framework for Food Retail Ordering Platforms

A scalable Selenium automation framework built using Java, TestNG, Maven, Page Object Model (POM), Service Layer Design, JSON-driven test data, Extent Reports, and Log4j logging.

</div>

---

# 📖 Overview

This project is a real-world automation framework developed to automate the complete ordering workflow of a food retail application (Papa Johns Environment).

The framework simulates actual customer behavior from launching the application to product selection, cart validation, checkout, and order review.

It has been designed following industry-standard automation practices with a strong focus on:

- Maintainability
- Scalability
- Reusability
- Separation of Concerns
- Configuration-Driven Execution
- Clean Test Architecture

---

# 🚀 Key Features

### ✅ Complete Order Automation

Automates the entire customer ordering journey:

- Location Selection
- Menu Navigation
- Product Selection
- Quantity Management
- Cart Validation
- Checkout Process
- Payment Handling
- Order Review

### ✅ Page Object Model (POM)

All page interactions are isolated inside dedicated page classes for improved maintainability.

### ✅ Service Layer Architecture

Business workflows are separated from UI actions through dedicated service classes.

### ✅ JSON Driven Test Data

Order details, customer information, and checkout configurations are managed externally through JSON files.

### ✅ Configuration Driven Framework

Sensitive data and environment configurations are managed through properties files.

### ✅ Detailed Reporting

Integrated with Extent Reports for professional HTML execution reports.

### ✅ Screenshot Capture

Automatic screenshot capture on test failures.

### ✅ Structured Logging

Comprehensive Log4j logging throughout framework execution.

### ✅ WebDriverManager Integration

Automatic browser driver management.

---

# 🏗 Framework Architecture

```text
┌─────────────────────────────────────────┐
│               Test Layer                │
│              OrderTest.java             │
└─────────────────────────────────────────┘
                    │
                    ▼
┌─────────────────────────────────────────┐
│             Service Layer               │
│                                         │
│  MenuService                            │
│  CheckoutService                        │
└─────────────────────────────────────────┘
                    │
                    ▼
┌─────────────────────────────────────────┐
│              Page Layer                 │
│                                         │
│  Homepage                              │
│  Location                              │
│  Menu                                  │
│  Cart                                  │
│  Checkout                              │
└─────────────────────────────────────────┘
                    │
                    ▼
┌─────────────────────────────────────────┐
│           Framework Utilities           │
│                                         │
│ DriverFactory                           │
│ ConfigReader                            │
│ ElementFinder                           │
│ WaitUtils                               │
│ ScreenshotUtils                         │
│ LocalStorageHandler                     │
│ OrderConfigurationReader                │
│ ExtentReportManager                     │
└─────────────────────────────────────────┘
```

---

# 🛠 Technology Stack

| Technology | Purpose |
|------------|----------|
| Java 11 | Programming Language |
| Selenium WebDriver 4 | Browser Automation |
| TestNG | Test Execution Framework |
| Maven | Dependency Management |
| WebDriverManager | Driver Management |
| Jackson Databind | JSON Parsing |
| Extent Reports | Reporting |
| Log4j2 | Logging |
| Page Object Model | Design Pattern |
| Git | Version Control |
| GitHub | Source Control Hosting |

---

# 📂 Project Structure

```text
PapaJohnsAutomation
│
├── logs
│   └── automation logs
│
├── reports
│   └── extent-report.html
│
├── src
│
│   ├── main
│   │   ├── java
│   │   │   └── org/HCL
│   │   │
│   │   └── resources
│   │       └── log4j2.xml
│   │
│   └── test
│       └── java
│
│           ├── base
│           │   ├── BasePage.java
│           │   └── BaseTest.java
│           │
│           ├── pages
│           │   ├── Homepage.java
│           │   ├── Location.java
│           │   ├── Menu.java
│           │   ├── Cart.java
│           │   └── Checkout.java
│           │
│           ├── services
│           │   ├── MenuService.java
│           │   └── CheckoutService.java
│           │
│           ├── tests
│           │   └── OrderTest.java
│           │
│           ├── resources
│           │   ├── config.properties
│           │   ├── location.json
│           │   └── orderConfiguration.json
│           │
│           └── utils
│               ├── DriverFactory.java
│               ├── ConfigReader.java
│               ├── ElementFinder.java
│               ├── WaitUtils.java
│               ├── ScreenshotUtils.java
│               ├── LocalStorageHandler.java
│               ├── ExtentReportManager.java
│               └── OrderConfigurationReader.java
│
├── pom.xml
│
└── README.md
```

---

# 🎯 Design Patterns & Framework Concepts

## Page Object Model (POM)

Each page of the application is represented by its own class.

Examples:

- Homepage
- Location
- Menu
- Cart
- Checkout

Benefits:

- Better maintainability
- Reduced code duplication
- Cleaner test implementation
- Improved readability

---

## Service Layer Pattern

Business workflows are abstracted from page-level actions.

### MenuService

Responsible for:

- Reading order data
- Product selection
- Cart creation

### CheckoutService

Responsible for:

- Payment workflow
- Customer details
- Checkout process
- Order review

Benefits:

- Cleaner tests
- Better reusability
- Easy workflow maintenance

---

## Factory Pattern

Driver initialization is centralized through DriverFactory.

Benefits:

- Single point of driver creation
- Easy browser scalability
- Better code organization

---

# 🔄 End-to-End Workflow

The framework currently automates the following business flow:

```text
Launch Browser
      │
      ▼
Open Food Retail Website
      │
      ▼
Clear Existing Cart
      │
      ▼
Set Delivery Location
      │
      ▼
Open Menu
      │
      ▼
Read Order Data From JSON
      │
      ▼
Select Products
      │
      ▼
Set Quantity
      │
      ▼
Add Products To Cart
      │
      ▼
Open Cart
      │
      ▼
Proceed To Checkout
      │
      ▼
Select Payment Method
      │
      ▼
Provide Payment Details
      │
      ▼
Enter Customer Information
      │
      ▼
Review Order
      │
      ▼
Generate Report
```

---

# 📊 Test Data Management

The framework follows a data-driven approach.

## Order Configuration

Stored in:

```text
src/test/java/resources/orderConfiguration.json
```

Contains:

- Product Categories
- Product Names
- Quantities
- Checkout Information
- Payment Preferences

---

## Location Configuration

Stored in:

```text
src/test/java/resources/location.json
```

Used for:

- Delivery Address
- Store Selection
- Local Storage Injection

---

## Environment Configuration

Stored in:

```text
src/test/java/resources/config.properties
```

Contains:

- Environment URLs
- Card Details
- Application Configuration

---

# ▶️ Test Execution

## Clone Repository

```bash
git clone https://github.com/AbhinavPrabhat01/Food-Retail-Order-Automation-Framework.git
```

## Navigate To Project

```bash
cd Food-Retail-Order-Automation-Framework
```

## Install Dependencies

```bash
mvn clean install
```

## Run Tests

```bash
mvn test
```

## Clean & Execute

```bash
mvn clean test
```

---

# 📸 Reporting

Extent Reports are automatically generated after execution.

Report includes:

- Test Summary
- Pass / Fail Status
- Execution Duration
- Failure Screenshots
- Detailed Logs

Location:

```text
reports/extent-report.html
```

---

# 📝 Logging

The framework uses Log4j2 for execution logging.

Logs capture:

- Test Execution Steps
- Page Actions
- Product Selections
- Checkout Activities
- Failures & Exceptions

Location:

```text
logs/
```

---

# 🔥 Framework Highlights

### Dynamic Product Selection

Products are selected dynamically based on JSON configuration.

### Dynamic Category Navigation

Category navigation is data-driven and reusable.

### Payment Flow Handling

Supports checkout execution through configurable payment methods.

### Automatic Failure Evidence

Screenshots are captured automatically on test failures.

### Reusable Wait Strategies

Centralized wait implementation for stable execution.

### Local Storage Based Location Handling

Delivery location is injected through Local Storage, enabling faster and more reliable test execution.

---

# 📈 Future Enhancements

- Parallel Test Execution
- Selenium Grid Integration
- Docker Support
- Jenkins CI/CD Pipeline
- GitHub Actions Workflow
- BrowserStack Integration
- Allure Reporting
- API Layer Validation
- Cross Browser Execution
- Environment Switching
- Retry Analyzer Implementation

---

# 👨‍💻 Author

## Abhinav Prabhat

QA Automation Engineer

### Expertise

- Selenium WebDriver
- Java Automation
- TestNG
- Maven
- Automation Framework Development
- Functional Testing
- Regression Testing
- End-to-End Test Automation
- CI/CD Automation

### GitHub

https://github.com/AbhinavPrabhat01

---

# ⭐ Support

If you found this project useful:

⭐ Star the repository

🍴 Fork the repository

🛠 Contribute improvements

📢 Share feedback

---

## License

This project is intended for learning, framework design demonstration, and automation engineering practices.

---

<div align="center">

### 🚀 Building Reliable, Scalable and Maintainable Test Automation Solutions

</div>
