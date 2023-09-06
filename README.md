# Songr - Spring Boot Web Application

**Songr** is a simple web application built using Spring Boot, Web, and Thymeleaf. It provides basic functionality for displaying albums and performing text transformations.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Routes](#routes)
- [Project Structure](#project-structure)
- [Album Class](#album-class)
- [Development](#development)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK)** 8 or higher.
- **Spring Initializr** for project setup.
- **Git** for version control.

## Getting Started

1. **Clone the Repository**:
   ```shell
   git clone <repository_url>
   cd songr

2. **Run the Application**
   ```shell
   ./mvnw spring-boot:run

3. **Access Routes**

- http://localhost:8080/hello for the "Hello World" route.
- http://localhost:8080/capitalize/{text} to convert text to uppercase.
- http://localhost:8080/ to get all records from database , then put them in list<AlbumEntity>.
- http://localhost:8080/addnew pass the album object to the form , allowing make new entity to save it later 

   
## Routes
- `/hello`: Displays a basic "Hello World" message.
- `/capitalize/{text}`: Converts the provided text to uppercase and displays it.
- `/`: Displays a list of albums objects as a cards
- `/save` : save the album entity to the database as a record after been filled with fields

## Project Structure
The project structure is organized as follows:

- `src/main/java/com/example/songr`: Java source code.
- `SongrApplication.java`: Entry point of the application.
- `controllers/`: Contains controller classes.
- `models/`: Contains the Album class representing album data.
- src/main/resources/templates/: Thymeleaf templates.
- src/main/resources/static/css/: CSS stylesheets.

## Album Class
The Album class represents an album's information and has the following attributes:

- `title`: The title of the album.
- `artist`: The artist who created the album.
- `songCount`: The number of songs in the album.
- `length`: The length of the album in seconds.
- `imageUrl`: A link to the album's cover art.