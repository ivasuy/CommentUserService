# Comment Management System

This codebase constitutes a Comment Management System that allows the creation of comments between users and retrieving comments for specific users. It is divided into Controller, Service, and Data Model components to facilitate the handling of user comments.

## **Components**

### **Controller**

The **`Controller`** class consists of two main endpoints:

1. **Add Comment**
    - Endpoint: **`@PostMapping("/add-comment")`**
    - Method: **`createNewUser(@RequestBody UserRequest userRequest)`**
    - Function: Adds a new comment between users. It validates the request and processes the addition of a new comment.
2. **Get All Comments**
    - Endpoint: **`@GetMapping("/get-comment")`**
    - Method: **`getAllComments(@RequestBody CommentRequest commentRequest)`**
    - Function: Retrieves all comments for a specific user based on the provided username.

### **Service**

The **`Service`** class holds the business logic for comment addition and retrieval. It contains the following methods:

1. **Validate User Request**
    - Validates the user request to ensure that the usernames provided for comments are valid according to a defined regex pattern.
2. **Add New Comment**
    - Validates the user request and, if valid, adds a new comment between users. It checks for an existing user and adds the comment accordingly.
3. **Get All Comments**
    - Retrieves all comments for a specific user based on the provided username. It maps the comments into a response object for display.

### **Data Models**

The system comprises two main data models:

1. **User**
    - Represents the users involved in the comment system, containing details about users who post and receive comments.
2. **Comment**
    - Represents the comments exchanged between users, including message content, timestamp, and user details involved in the comment exchange.

## **Usage**

### **Running the Application**

To run the application, follow these steps:

1. Make sure you have Java installed on your system.
2. Clone or download the code from the repository.
3. Configure the database connection properties in the **`application.yaml`** file.
4. Use an Integrated Development Environment (IDE) such as IntelliJ or Eclipse to import the project and run the application.

### **Accessing Swagger**

Once the application is running, you can access the Swagger documentation at [http://localhost:8081/swagger-ui/](http://localhost:8081/swagger-ui/). This endpoint provides a user-friendly interface to interact with the defined API endpoints and understand their functionalities.