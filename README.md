# 📚 Book Store Management System

A comprehensive Spring Boot application for managing a book store with advanced features including user authentication, search, pagination, image uploads, and data export capabilities.

## ✨ Features

### 🔐 **User Authentication & Security**
- **User Registration**: New users can create accounts
- **User Login**: Secure authentication with Spring Security
- **Password Encryption**: BCrypt password hashing
- **Role-based Access**: Different permissions for users and admins
- **Session Management**: Secure logout functionality

### 🔍 **Search & Filtering**
- **Real-time Search**: Search books by name or author
- **Case-insensitive**: Search works regardless of case
- **Instant Results**: Fast search with JPA repository methods

### 📄 **Pagination**
- **Large Dataset Support**: Handle thousands of books efficiently
- **Configurable Page Size**: Customizable items per page
- **Navigation Controls**: Previous/Next and page number navigation
- **Performance Optimized**: Only loads necessary data

### 🖼️ **Image Management**
- **Book Cover Uploads**: Support for book cover images
- **File Storage**: Secure file handling
- **Image Display**: Show book covers in listings

### 📊 **Data Export**
- **Excel Export**: Download book data as .xlsx files
- **Formatted Data**: Professional spreadsheet formatting
- **Auto-sized Columns**: Optimal column widths
- **Download Support**: Direct file downloads

## 🛠️ **Technology Stack**

- **Backend**: Java 17, Spring Boot 2.7.5
- **Database**: MySQL with JPA/Hibernate
- **Security**: Spring Security with BCrypt
- **Frontend**: Thymeleaf, Bootstrap 5
- **Build Tool**: Maven


## 🚀 **Getting Started**

### Prerequisites
- Java 11 or higher
- MySQL 5.7 or higher
- Maven 3.6+

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd bookStore
   ```

2. **Configure Database**
   - Create MySQL database named `book`
   - Update `application.properties` with your database credentials

3. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the Application**
   - Open browser: `http://localhost:8080`
   - Register a new account
   - Start managing your books!

## 📁 **Project Structure**

```
src/main/java/com/bookStore/
├── BookStoreApplication.java          # Main application class
├── config/
│   └── SecurityConfig.java           # Spring Security configuration
├── controller/
│   ├── AuthController.java           # Authentication endpoints
│   ├── BookController.java           # Book management endpoints
│   └── MyBookListController.java     # Personal book list endpoints
├── entity/
│   ├── Book.java                     # Book entity
│   ├── MyBookList.java               # Personal book list entity
│   └── User.java                     # User entity
├── repository/
│   ├── BookRepository.java           # Book data access
│   ├── MyBookRepository.java         # Personal list data access
│   └── UserRepository.java           # User data access
└── service/
    ├── BookService.java              # Book business logic
    ├── CustomUserDetailsService.java # Security user service
    ├── ExportService.java            # Data export functionality
    └── MyBookListService.java        # Personal list business logic
```

## 🔧 **Configuration**

### Database Configuration
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/book?ServerTimezone=UTC
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Security Configuration
- Default user role: `USER`
- Admin role: `ADMIN` (can be configured)
- Session timeout: Configurable
- CSRF protection: Enabled

## 📱 **API Endpoints**

### Public Endpoints
- `GET /` - Home page
- `GET /login` - Login form
- `POST /login` - Authenticate user
- `GET /register` - Registration form
- `POST /register` - Create new user

### Protected Endpoints
- `GET /available_books` - View all books
- `GET /available_books_paginated` - Paginated book view
- `GET /book_register` - Add new book form
- `POST /save` - Save new book
- `GET /editBook/{id}` - Edit book form
- `GET /deleteBook/{id}` - Delete book
- `GET /my_books` - Personal book list
- `GET /mylist/{id}` - Add book to personal list
- `GET /search` - Search books
- `GET /export/excel` - Export to Excel

## 🎨 **User Interface**


### Navigation
- **Home**: Welcome page with application overview
- **Available Books**: Complete book catalog with search
- **My Books**: Personal book collection
- **New Book Register**: Add new books to the system

## 🔒 **Security Features**

- **Password Hashing**: BCrypt encryption
- **Session Management**: Secure user sessions
- **CSRF Protection**: Cross-site request forgery prevention
- **Input Validation**: Server-side validation
- **SQL Injection Prevention**: JPA parameterized queries

## 📊 **Data Management**

### Book Information
- **ID**: Auto-generated primary key
- **Name**: Book title
- **Author**: Book author
- **Price**: Book price
- **Image URL**: Book cover image path

### User Management
- **Username**: Unique user identifier
- **Password**: Encrypted password
- **Role**: User permissions

## 🚀 **Performance Features**

- **Pagination**: Efficient data loading
- **Database Indexing**: Optimized queries
- **Connection Pooling**: HikariCP for database connections
- **Caching**: Spring Boot caching support

## 🔧 **Development Features**

- **DevTools**: Auto-restart on code changes
- **Hibernate DDL**: Automatic schema updates
- **Logging**: Comprehensive application logging
- **Error Handling**: User-friendly error messages

## 📈 **Future Enhancements**

- **PDF Export**: Generate PDF reports
- **Advanced Search**: Filters and sorting options
- **User Profiles**: Extended user information
- **Book Categories**: Genre-based organization
- **API Documentation**: Swagger/OpenAPI integration
- **Docker Support**: Containerized deployment
- **Cloud Deployment**: AWS/Azure support

## 🤝 **Contributing**

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request


## 👨‍💻 **Author**

Created by KALAVAKURI GANESH - A Spring Boot enthusiast and Java developer.

---

**⭐ Star this repository if you find it helpful!**
#

