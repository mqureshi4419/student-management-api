# Student Management API

A REST API built with Java, Spring Boot, and MongoDB for managing student information and course assignments.

## Technologies

- Java 17
- Spring Boot
- Spring Web
- Spring Data MongoDB
- MongoDB
- Maven
- Postman

## Project Architecture

The application follows a layered architecture:

Controller → Service → Repository → MongoDB

- **Controller** - Handles incoming HTTP requests.
- **Service** - Contains the application's business logic.
- **Repository** - Handles communication with MongoDB.
- **Model** - Represents student data.

## Features

- Retrieve all students
- Create a new student
- Automatically generate the next student ID
- Add a course to an existing student
- Delete a student
- Store student data in MongoDB

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/getstudent` | Retrieve all students |
| POST | `/api/createstudent` | Create a new student |
| PUT | `/api/updatestudent` | Add a course to a student |
| DELETE | `/api/deletestudent` | Delete a student |

## Student Model

A student contains:

- Student ID
- Name
- Age
- Major
- Course IDs

MongoDB's internal `_id` is stored separately from the application's numeric student ID.

## Database

The application uses a local MongoDB database:

- Database: `studentapi`
- Collection: `students`

## Testing

API endpoints were tested using Postman.

## Project Status

This project is actively being developed as additional features are added.