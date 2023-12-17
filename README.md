

This repository contains the solution for the ProgressSoft Corporation assignment - developing a clustered data warehouse for Bloomberg to analyze FX deals.

## Table of Contents

- [About](#about)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuration](#configuration)
- [Docker Deployment](#docker-deployment)
- [Testing](#testing)

## About

The assignment involves developing a data warehouse system for Bloomberg to analyze FX deals. The system accepts deal details, performs validations, and persists the data into a database.

## Features

- Accepts deal details including Deal Unique Id, Currency ISO Codes, Deal Timestamp, and Deal Amount.
- Validates the structure of incoming data.
- Prevents importing the same deal twice.
- Persists valid deals into the database.
- Provides error handling, logging, and unit testing.

## Getting Started

Follow these instructions to set up and run the project locally.

### Prerequisites

- [Java](https://www.java.com/) (version 17 or higher)
- [Maven](https://maven.apache.org/) or [Gradle](https://gradle.org/) for building the project
- [Docker](https://www.docker.com/) for containerization

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/progresssoft-assignment.git

2. Build the project using Maven:
   - cd progresssoft-assignment
   - mvn clean install

### Configuration
Adjust the application properties in src/main/resources/application.properties:
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/progresssoft
spring.datasource.username=user
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update

## Docker Deployment
To deploy the application using Docker Compose, run:
- docker-compose up

## Testing
Run unit tests to ensure the correctness of the application:
- mvn test

