# Student Management System

A full-stack student management application built with Java, Spring Boot, MongoDB, React, and Tailwind CSS. The application allows authenticated users to create, view, update, and delete student records through a responsive web interface.

## Technologies

- Java 17
- Spring Boot
- Spring Web
- Spring Data MongoDB
- MongoDB
- Maven
- React
- Vite
- Tailwind CSS
- JUnit 5
- Mockito
- MockMvc
- Postman

## Project Architecture

The application follows a layered architecture:

Controller → Service → Repository → MongoDB

- **Controller** - Handles incoming HTTP requests.
- **Service** - Contains the application's business logic.
- **Repository** - Handles communication with MongoDB.
- **Model** - Represents student data.

## Features

- User login with role-based user data
- Protected frontend routes for authenticated users
- Retrieve all students
- Create a new student
- Automatically generate the next student ID
- Update student name, age, and major
- Delete a student
- Add a course to an existing student
- Store student data in MongoDB
- React-based frontend interface
- Student creation confirmation card
- Error handling and validation
- Logout functionality


## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/login` | Authenticate a user |
| GET | `/api/getstudent` | Retrieve all students |
| POST | `/api/createstudent` | Create a new student |
| PUT | `/api/updatestudent` | Update student details |
| PUT | `/api/addcourse` | Add a course to a student |
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

The application includes automated testing using:

- JUnit 5
- Mockito
- MockMvc
- Maven test runner

## Tests cover

- Successful user login
- Invalid password
- Unknown email
- Student creation
- Student retrieval
- Student update
- Update when student is not found
- Student deletion
- Delete when student is not found
- Successful login controller response
- Unauthorized login controller response


## Project Status

The core full-stack student management system is complete, including authentication, protected routes, student CRUD operations, MongoDB persistence, frontend integration, and automated testing.

## How to Run the Project

### 1. Start MongoDB

Make sure MongoDB is running locally.

The backend connects to:

```text
mongodb://localhost:27017/studentapi

./mvnw spring-boot:run

cd frontend
npm install
npm run dev
http://localhost:5173

./mvnw test
