# College Placement Management System

A comprehensive web-based placement management system built with Spring Boot for managing on-campus placements, student records, company information, and placement statistics.

## 📋 Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Database Setup](#database-setup)
- [Default Login Credentials](#default-login-credentials)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Screenshots](#screenshots)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)

## ✨ Features

### Public Features (No Login Required)
- View placement statistics and dashboard
- Browse all placement records
- Filter placements by department and year
- View department-wise placement analytics
- Company-wise placement statistics

### Admin Features (Faculty & TPO Coordinators)
- **Faculty (Full Access)**
    - Add, edit, and delete placement records
    - Manage students and companies
    - View detailed analytics
    - Full CRUD operations on all data

- **TPO Coordinators (Data Entry)**
    - Add new placement records
    - Add students and companies
    - View all placement data
    - Limited deletion rights

### Key Functionalities
- Role-based access control (RBAC)
- Automatic calculation of department-wise statistics
- Real-time placement count tracking
- CTC and stipend analytics
- Responsive and user-friendly interface
- Secure authentication with BCrypt password encryption

## 🛠️ Tech Stack

**Backend:**
- Java 17+
- Spring Boot 3.1.5
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL Database

**Frontend:**
- Thymeleaf Template Engine
- Bootstrap 5.3
- HTML5/CSS3
- JavaScript
- Font Awesome Icons

**Build Tool:**
- Maven 3.6+

## 📦 Prerequisites

Before running the application, ensure you have:

- **JDK 17 or higher** - [Download here](https://www.oracle.com/java/technologies/downloads/)
- **Maven 3.6+** - [Download here](https://maven.apache.org/download.cgi)
- **MySQL 8.0+** - [Download here](https://dev.mysql.com/downloads/mysql/)
- **IDE** (Optional) - IntelliJ IDEA, Eclipse, or VS Code

## 🚀 Installation

### 1. Clone the Repository

git clone https://github.com/yourusername/college-placement-system.git
cd college-placement-system

text

### 2. Create MySQL Database

mysql -u root -p

text
undefined
CREATE DATABASE college_placement_db;
EXIT;

text

### 3. Configure Database Connection

Edit `src/main/resources/application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/college_placement_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

text

Replace `YOUR_MYSQL_PASSWORD` with your actual MySQL password.

## ⚙️ Configuration

### Application Properties

Key configurations in `application.properties`:

Server Configuration
server.port=8080

Thymeleaf Configuration
spring.thymeleaf.cache=false
spring.thymeleaf.enabled=true

JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Application Name
spring.application.name=College Placement System

text

## 🏃 Running the Application

### Using Maven

mvn clean install
mvn spring-boot:run

text

### Using IDE

1. Import project as Maven project
2. Wait for dependencies to download
3. Run `CollegePlacementWebsiteApplication.java`

### Using JAR

mvn clean package
java -jar target/college-placement-system-0.0.1-SNAPSHOT.jar

text

**Application will start on:** `http://localhost:8080`

## 🗄️ Database Setup

### Automatic Table Creation

Tables are automatically created by Hibernate on first run:
- `faculty`
- `coordinator` (placement_coordinator)
- `student`
- `company`
- `placement`
- `qualification` (if enabled)

### Add Initial Admin Users

USE college_placement_db;

-- Add Faculty (Password: password123)
INSERT INTO faculty (username, password, full_name, email, department, role, active)
VALUES ('faculty1', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhkK',
'Dr. Admin User', 'admin@college.edu', 'Computer Science', 0, 1);

-- Add TPO Coordinator (Password: password123)
INSERT INTO coordinator (username, password, full_name, email, role, active)
VALUES ('tpo1', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhkK',
'TPO Coordinator', 'tpo@college.edu', 1, 1);

text

### Add Sample Data

-- Sample Student
INSERT INTO student (roll_number, full_name, email, department, graduation_year, cgpa, phone)
VALUES ('CS2025001', 'John Doe', 'john@college.edu', 'Computer Science', 2025, 8.5, '9876543210');

-- Sample Company
INSERT INTO company (company_name, industry, location, website)
VALUES ('Google India', 'Information Technology', 'Bangalore', 'https://google.com');

-- Sample Placement
INSERT INTO placement (student_id, company_id, job_title, ctc_amount, placement_date, placement_type, status)
VALUES (1, 1, 'Software Engineer', 18.5, '2025-09-15', 'FULL_TIME', 'OFFERED');

text

## 🔐 Default Login Credentials

### Faculty Login
- **URL:** `http://localhost:8080/login`
- **Username:** `faculty1`
- **Password:** `password123`
- **Access:** Full admin rights

### TPO Coordinator Login
- **URL:** `http://localhost:8080/login`
- **Username:** `tpo1`
- **Password:** `password123`
- **Access:** Data entry and viewing

**⚠️ Important:** Change default passwords in production!

text

## 🌐 API Endpoints

### Public Endpoints (No Authentication)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Homepage with statistics |
| GET | `/placements` | View all placements |
| GET | `/placements?department=CS&year=2025` | Filter placements |
| GET | `/department-stats?dept=CS&year=2025` | Department statistics |
| GET | `/login` | Login page |

### Admin Endpoints (Authentication Required)
| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| GET | `/admin/dashboard` | Admin dashboard | Faculty, TPO |
| GET | `/admin/add-placement` | Add placement form | Faculty, TPO |
| POST | `/admin/add-placement` | Submit placement | Faculty, TPO |
| GET | `/admin/add-student` | Add student form | Faculty, TPO |
| POST | `/admin/add-student` | Submit student | Faculty, TPO |
| GET | `/admin/add-company` | Add company form | Faculty, TPO |
| POST | `/admin/add-company` | Submit company | Faculty, TPO |
| GET | `/admin/manage-placements` | Manage placements | Faculty, TPO |
| POST | `/admin/delete-placement/{id}` | Delete placement | Faculty only |

## 📸 Screenshots

### Public Dashboard
![Dashboard](screenshots/dashboard.png)
*Public homepage showing placement statistics*

### Placements List
![Placements](screenshots/placements.png)
*Browse all placement records with filters*

### Admin Dashboard
![Admin](screenshots/admin-dashboard.png)
*Admin panel for managing placements*

### Add Placement
![Add Placement](screenshots/add-placement.png)
*Form to add new placement records*


## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open Pull Request

## 📝 License

This project is licensed under the GNU License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- **Soumitra Bapat** - *Backend work* - [Soumitra945](https://github.com/Soumitra945)
- **Shreya Hankare** - *Frontend Work* - [Shreya-212004](https://github.com/Shreya-212004)


## 🙏 Acknowledgments

- Spring Boot Documentation
- Thymeleaf Documentation
- Bootstrap Framework
- Font Awesome Icons
- Stack Overflow Community

## 📞 Support

For support, email support@college.edu or create an issue in the repository.

## 🔄 Version History

- **v1.0.0** (2025-10-20)
    - Initial release
    - Basic CRUD operations
    - Role-based access control
    - Public viewing of placements
    - Department-wise statistics

---

**Built with ❤️ for better placement management**