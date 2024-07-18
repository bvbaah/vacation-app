
# Travel Agency Booking Backend
## Overview
This project is a backend solution for a travel agency's vacation booking application, utilizing the Spring Framework to modernize and replace the legacy system. The backend integrates with a MySQL database and an Angular front-end provided in the lab environment.

## Competencies
**Develops Object-Oriented Applications**: Integrated with relational databases.

**Writes Code**: Utilizes the Spring framework.
Implements Design Patterns: Applied in object-oriented applications.

## Introduction
The objective is to develop a Spring Framework Java backend for a travel agency's booking application. This project demonstrates skills essential for creating, customizing, and maintaining applications based on business requirements.

## Scenario
The travel agency's front-end application, recently revamped using Angular and JavaScript, is encountering issues due to an outdated backend. The project aims to migrate critical functionalities from the legacy system to a modern Spring framework.

## Requirements
### Setup
**Spring Initializr Setup**: Create a new Java project with dependencies:

Spring Data JPA

Rest Repositories

MySQL Driver

Lombok

**GitLab Integration**:

Connect your Java project.

Commit and push changes regularly.

**Project Structure**: Create packages for controllers, entities, DAO, services, and config. 
Copy provided configuration files.

## Implementation
**Entities**: Write entity classes and enums as per the UML diagram.

**DAO**: Create repository interfaces extending JpaRepository with cross-origin support.

**Services**: Implement purchase data classes, response classes, and checkout service interfaces.

**Validation**: Ensure input validation for the Angular front-end.
Controllers: Implement REST controller with a post mapping for order placement.

**Sample Data**: Programmatically add five sample customers, ensuring data persistence.

## Testing
**Application Testing**:
Verify no network errors when adding data.
Confirm data addition in MySQL Workbench.