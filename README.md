# Bookstore Web Application with Docker

## Description
The Bookstore Web Application is a Java Servlet-based web application that allows users to search for books from a MySQL database. The application follows the REST style, enabling users to sort books by category, keyword, or view all books in the catalog.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Technologies Used](#technologies-used)


## Prerequisites
Before you begin, ensure you have the following requirements:

- **Java Development Kit (JDK)**: Make sure you have Java installed on your system.

- **Tom Cat Apache**: Install Docker to containerize the application. You can download it from [docker.com](https://www.docker.com/).

- **MySQL Database**: Set up a MySQL database with the book information. Make note of the connection details; you will need them for the application configuration.

## Installation
Follow these steps to set up the Bookstore Web Application using Docker:

### Step 1: Clone the Repository
```bash
git clone https://github.com/AJDevCode/bookstore.git
```
### Step 2: Configure Database Connection
Update the web/WEB-INF/web.xml file with your MySQL database connection details:
```xml
<param-name>url</param-name>
<param-value>jdbc:mysql://localhost:3306/bookstore</param-value>

<param-name>user</param-name>
<param-value>yourusername</param-value>

<param-name>password</param-name>
<param-value>yourpassword</param-value>
```
### Step 3: Deploy to Apache Tomcat
Use TomCat to run the server locally.

## Usage
Once the application is deployed, you can use the following features:

Search for books by category, keyword, or view all books.

Access book details, including title, author, and category.

## Features
The Bookstore Web Application offers the following key features:

RESTful endpoints for searching and sorting books.

Dynamic loading of book information from the MySQL database.

Simple and intuitive user interface for book searches.

## Technologies Used
Java Servlets
MySQL Database
Apache Tomcat
