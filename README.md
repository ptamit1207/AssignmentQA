# QA Automation Assignment

## Overview

This repository contains the automation assignment implementation using Java, Selenium WebDriver, TestNG, Maven, and RestAssured.

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- RestAssured

## Assignment 1

### Task 1 – Frames, Windows & Alerts
- Nested Frames handling
- Multiple browser windows handling
- JavaScript Alert accept/dismiss
- Alert message validation

### Task 2 – Selenium Wait Strategies
- Implicit Wait
- Explicit Wait
- Fluent Wait

### Task 3 – API Automation
- GET request
- POST request
- Status code validation
- Response body validation
- Query parameter validation
- Header validation

### Task 4 – SQL
- Find duplicate records
- Find latest/last inserted record
- Join two tables

## Assignment 2

### Task 1 – UI Login Automation
- Page Object Model
- Valid login
- Invalid login
- Assertions

### Task 2 – API Automation
- GET /posts
- Status code validation
- Response structure validation
- Invalid endpoint validation

### Task 3 – Web Table Automation
- Extract rows and columns
- Print specific column values
- Sorting validation
- Dynamic XPath
- Assertions

### Task 4 – E-commerce Automation
- Product search
- Product details validation
- Add product to cart
- Cart count validation
- Reusable methods

## How to Run

### Run all tests

```bash
mvn test

### Run a specific test
mvn -Dtest=LoginTest test

###Run Assignment 1 tests

mvn -Dtest=FrameTest test
mvn -Dtest=WindowTest test
mvn -Dtest=AlertTest test
mvn -Dtest=WaitTest test
mvn -Dtest=Assignment1ApiTest test# AssignmentQA
