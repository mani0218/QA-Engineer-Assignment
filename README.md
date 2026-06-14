**Hybrid Automation Framework — Firefly III (UI) & JSONPlaceholder (API)**

**Project Overview**

This project demonstrates a **hybrid automation framework** by combining:
- **UI automation** on the **Firefly III demo application**, launched locally using Docker containers.
- **API automation** on the **JSONPlaceholder demo service**, a free REST API for testing and prototyping.

---

**Framework and Language**
- **Language:** Java  
- **Testing Framework:** TestNG  
- **UI Automation:** Selenium WebDriver (Page Object Model design)  
- **API Automation:** Rest Assured  
- **Build Tool:** Maven  
- **Reporting:** TestNG default reports  
- **Utilities:** Initially Apache POI (Excel test data). Later switched to **TestNG DataProviders** for dynamic datasets (e.g., creating multiple accounts and transactions)., using centralized waitutils handling synchronization. 

---

**How to Run the Tests**

**Prerequisites**
- JDK 8+ installed  
- Maven installed and configured (`mvn -v` should work)  
- Docker running with Firefly III container accessible at `http://localhost:8080`  

**Commands**

**Run all tests** → mvn clean test

**Run UI Tests** → mvn clean test -DsuiteXmlFile=uitests.xml

**Run API Tests** → mvn clean test -DsuiteXmlFile=apitests.xml
  
