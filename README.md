# 🏥 Sanjeevani Hospital Management System

![Java](https://img.shields.io/badge/Java-17-orange?style=flat&logo=java)
![Oracle](https://img.shields.io/badge/Database-Oracle-red?style=flat&logo=oracle)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue?style=flat)
![License](https://img.shields.io/badge/License-MIT-green?style=flat)

**Sanjeevani** (संजीवनी) - meaning "life-giving" in Sanskrit, is a comprehensive Hospital Management System built with Java Swing that streamlines hospital operations, patient management, and appointment scheduling.

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Technology Stack](#-technology-stack)
- [Architecture](#-architecture)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Database Setup](#-database-setup)
- [Configuration](#-configuration)
- [Usage](#-usage)
- [User Roles](#-user-roles)
- [Project Structure](#-project-structure)
- [Screenshots](#-screenshots)
- [Contributing](#-contributing)
- [License](#-license)

---

## 🎯 Overview

Sanjeevani is a desktop-based Hospital Management System designed to digitize and automate hospital operations. It provides a user-friendly interface for managing doctors, patients, receptionists, employees, and appointments with role-based access control.

The system features:
- **Multi-role authentication** (Admin, Doctor, Receptionist)
- **OTP-based verification** for secure operations
- **Appointment management** with request/confirmation workflow
- **Complete CRUD operations** for all entities
- **Real-time SMS notifications** via integrated SMS gateway

---

## ✨ Features

### 👨‍💼 Admin Module
- ✅ Manage Doctors (Add, Update, View, Remove)
- ✅ Manage Employees (Add, Update, View, Remove)
- ✅ Manage Receptionists (Add, Update, View, Remove)
- ✅ View all patients and appointments
- ✅ User management and access control
- ✅ OTP verification for critical operations

### 👨‍⚕️ Doctor Module
- ✅ View appointment requests
- ✅ Confirm/Reject appointments
- ✅ View all confirmed appointments
- ✅ View patient details
- ✅ Access patient medical history
- ✅ Update appointment status

### 👩‍💼 Receptionist Module
- ✅ Register new patients
- ✅ Update patient information
- ✅ View all patients
- ✅ Schedule appointments
- ✅ Manage OPD (Outpatient Department) assignments
- ✅ Remove patient records

### 🔐 Security Features
- Password encryption using secure hashing
- OTP-based verification for sensitive operations
- Role-based access control (RBAC)
- Session management
- Secure database connections

### 📱 Communication Features
- SMS notifications via HTTP SMS gateway
- Email support integration
- OTP delivery through SMS
- Appointment confirmation messages

---

## 🛠️ Technology Stack

| Component | Technology |
|-----------|-----------|
| **Language** | Java 17 |
| **GUI Framework** | Java Swing + AWT |
| **Layout Manager** | Absolute Layout |
| **Database** | Oracle Database 11g/21c |
| **JDBC Driver** | Oracle JDBC (ojdbc11.jar) |
| **Build Tool** | Apache Ant |
| **IDE** | Apache NetBeans |
| **HTTP Client** | Apache HttpClient 4.5.9 |
| **JSON Processing** | org.json (json-20180813) |
| **REST Client** | Unirest Java 2.3.17 |

### External Libraries

```
commons-codec-1.11.jar         # Encoding utilities
commons-logging-1.2.jar        # Logging framework
httpasyncclient-4.1.4.jar      # Async HTTP operations
httpclient-4.5.9.jar           # HTTP client
httpcore-4.4.11.jar            # Core HTTP components
httpcore-nio-4.4.10.jar        # Non-blocking HTTP
httpmime-4.5.9.jar             # MIME support
json-20180813.jar              # JSON parsing
unirest-java-2.3.17.jar        # REST API client
ojdbc11.jar                    # Oracle JDBC driver
```

---

## 🏗️ Architecture

The application follows a **3-tier architecture** pattern:

```
┌─────────────────────────────────────────┐
│         Presentation Layer              │
│         (GUI - Java Swing)              │
│   LoginScreen, AdminOptionsFrame, etc.  │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│         Business Logic Layer            │
│              (DAO Classes)              │
│   UserDao, DoctorDao, PatientDao, etc.  │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│          Data Access Layer              │
│         (POJO + DBConnection)           │
│   DoctorPojo, PatientPojo, etc.         │
└─────────────────────────────────────────┘
```

### Design Patterns Used

- **DAO (Data Access Object)** - Separates business logic from persistence logic
- **POJO (Plain Old Java Objects)** - Data transfer objects
- **Singleton** - Database connection management
- **MVC (Model-View-Controller)** - GUI separation of concerns

---

## 📦 Prerequisites

Before running this application, ensure you have:

- ✅ **Java Development Kit (JDK) 17** or higher
- ✅ **Oracle Database 11g/21c Express Edition** (or compatible version)
- ✅ **Apache NetBeans IDE** (recommended) or any Java IDE
- ✅ **Apache Ant** (for building from command line)
- ✅ **Oracle SQL Developer** (optional, for database management)

### System Requirements

- **OS:** Windows 7/8/10/11, Linux, macOS
- **RAM:** Minimum 2GB (4GB recommended)
- **Disk Space:** 500MB free space
- **Display:** 1024x768 or higher resolution

---

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/sanjeevani.git
cd sanjeevani
```

### 2. Download External Libraries

Create a `lib` directory and download all required JAR files:

```bash
mkdir lib
# Download JAR files listed in Technology Stack section
# Place them in the lib directory
```

Or download them from:
- [Apache HttpClient](https://hc.apache.org/downloads.cgi)
- [Oracle JDBC Driver](https://www.oracle.com/database/technologies/jdbc-ucp-122-downloads.html)
- [Unirest Java](https://github.com/Kong/unirest-java)
- [JSON Java](https://github.com/stleary/JSON-java)

### 3. Update Library Paths

Edit `nbproject/project.properties` and update the JAR file paths:

```properties
file.reference.ojdbc11.jar=/path/to/your/ojdbc11.jar
file.reference.commons-codec-1.11.jar=/path/to/your/commons-codec-1.11.jar
# ... update all other JAR paths
```

### 4. Open Project in NetBeans

1. Open Apache NetBeans IDE
2. File → Open Project
3. Navigate to the `Sanjeevani` folder
4. Click "Open Project"

---

## 🗄️ Database Setup

### 1. Install Oracle Database

Download and install Oracle Database Express Edition from [Oracle's website](https://www.oracle.com/database/technologies/xe-downloads.html).

### 2. Create Database Schema

Connect to Oracle Database and create the schema:

```sql
-- Create User
CREATE USER sanjeevani IDENTIFIED BY sanjeevani1;

-- Grant Privileges
GRANT CONNECT, RESOURCE TO sanjeevani;
GRANT CREATE SESSION TO sanjeevani;
GRANT UNLIMITED TABLESPACE TO sanjeevani;

-- Connect as sanjeevani user
CONNECT sanjeevani/sanjeevani1;
```

### 3. Create Tables

```sql
-- Users Table
CREATE TABLE users (
    user_id VARCHAR2(50) PRIMARY KEY,
    user_name VARCHAR2(100) NOT NULL,
    password VARCHAR2(200) NOT NULL,
    user_type VARCHAR2(20) NOT NULL
);

-- Doctors Table
CREATE TABLE doctors (
    doc_id VARCHAR2(50) PRIMARY KEY,
    doc_name VARCHAR2(100) NOT NULL,
    email_id VARCHAR2(100),
    contact_no VARCHAR2(15),
    qualification VARCHAR2(100),
    gender VARCHAR2(10),
    specialist VARCHAR2(100)
);

-- Patients Table
CREATE TABLE patients (
    patient_id VARCHAR2(50) PRIMARY KEY,
    first_name VARCHAR2(50) NOT NULL,
    last_name VARCHAR2(50),
    age NUMBER(3),
    gender VARCHAR2(10),
    married_status VARCHAR2(20),
    address VARCHAR2(200),
    city VARCHAR2(50),
    mobile_no VARCHAR2(15),
    date_time DATE,
    opd VARCHAR2(50),
    doctor_id VARCHAR2(50),
    otp NUMBER(6),
    apt_status VARCHAR2(20),
    FOREIGN KEY (doctor_id) REFERENCES doctors(doc_id)
);

-- Appointments Table
CREATE TABLE appointments (
    patient_id VARCHAR2(50),
    patient_name VARCHAR2(100),
    status VARCHAR2(20),
    opd VARCHAR2(50),
    date_time VARCHAR2(50),
    doctor_name VARCHAR2(100),
    mobile_no VARCHAR2(15),
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id)
);

-- Receptionists Table
CREATE TABLE receptionists (
    receptionist_id VARCHAR2(50) PRIMARY KEY,
    receptionist_name VARCHAR2(100) NOT NULL,
    email_id VARCHAR2(100),
    contact_no VARCHAR2(15),
    gender VARCHAR2(10),
    qualification VARCHAR2(100)
);

-- Employees Table
CREATE TABLE employees (
    emp_id VARCHAR2(50) PRIMARY KEY,
    emp_name VARCHAR2(100) NOT NULL,
    email_id VARCHAR2(100),
    contact_no VARCHAR2(15),
    gender VARCHAR2(10),
    salary NUMBER(10,2),
    designation VARCHAR2(100)
);
```

### 4. Insert Default Admin User

```sql
-- Insert default admin user (password: admin123)
INSERT INTO users VALUES ('admin', 'Administrator', 'ENCRYPTED_PASSWORD_HERE', 'ADMIN');
COMMIT;
```

---

## ⚙️ Configuration

### Update Database Connection

Edit `src/sanjeevaniapp/dbutil/DBConnection.java`:

```java
conn = DriverManager.getConnection(
    "jdbc:oracle:thin:@//localhost:1521/xe",  // Update host and SID
    "sanjeevani",                              // Database username
    "sanjeevani1"                              // Database password
);
```

### Configure SMS Gateway (Optional)

Edit `src/sanjeevaniapp/utility/SmsSender.java` to configure your SMS gateway API credentials:

```java
// Update with your SMS gateway credentials
private static final String API_KEY = "your_api_key";
private static final String SENDER_ID = "your_sender_id";
```

---

## 🎮 Usage

### Running the Application

#### Option 1: From NetBeans
1. Right-click on the project
2. Select "Run"

#### Option 2: From Command Line
```bash
# Build the project
ant clean build

# Run the application
ant run
```

#### Option 3: Run JAR File
```bash
# Build JAR
ant jar

# Run JAR
java -jar dist/Sanjeevni.jar
```

### First Time Setup

1. **Launch Application** - The splash screen will appear
2. **Login Screen** - Use default admin credentials
3. **Create Users** - Admin should create doctors, receptionists, and employees
4. **Start Operations** - Begin patient registration and appointment scheduling

---

## 👥 User Roles

### 🔴 Admin Access

**Default Login:**
- User ID: `admin`
- Password: `admin123` (change after first login)
- User Type: Admin

**Capabilities:**
- Full system access
- User management (Create, Read, Update, Delete)
- System configuration
- Report generation

### 🔵 Doctor Access

**Login Format:**
- User ID: `DOC001` (assigned by admin)
- Password: (set by admin)
- User Type: Doctor

**Capabilities:**
- View appointment requests
- Confirm/reject appointments
- View patient records
- Update appointment status

### 🟢 Receptionist Access

**Login Format:**
- User ID: `REC001` (assigned by admin)
- Password: (set by admin)
- User Type: Receptionist

**Capabilities:**
- Patient registration
- Appointment scheduling
- Patient record management
- Basic reporting

---

## 📁 Project Structure

```
Sanjeevani/
├── build.xml                    # Ant build configuration
├── manifest.mf                  # JAR manifest file
├── nbproject/                   # NetBeans project files
│   ├── build-impl.xml
│   ├── project.properties
│   └── project.xml
├── src/
│   └── sanjeevaniapp/
│       ├── dao/                 # Data Access Objects
│       │   ├── AppointmentDao.java
│       │   ├── DoctorDao.java
│       │   ├── EmpDao.java
│       │   ├── PatientDao.java
│       │   ├── ReceptionistDao.java
│       │   └── UserDao.java
│       ├── dbutil/              # Database Utilities
│       │   ├── DBConnection.java
│       │   ├── password.java
│       │   └── SendOtp.java
│       ├── gui/                 # GUI Forms (Swing)
│       │   ├── LoginScreen.java
│       │   ├── SplashScreen.java
│       │   ├── AdminOptionsFrame.java
│       │   ├── DoctorOptionsFrame.java
│       │   ├── ReceptionistOptionsFrame.java
│       │   ├── AddDoctor.java
│       │   ├── AddPatient.java
│       │   ├── ManageDoctors.java
│       │   ├── ViewAppointmentRequests.java
│       │   └── ... (30+ GUI files)
│       ├── images/              # Application Images
│       │   ├── login-icon1.png
│       │   ├── doctor.png
│       │   ├── AdminPanel.png
│       │   └── ... (image resources)
│       ├── pojo/                # Plain Old Java Objects
│       │   ├── AppointmentPojo.java
│       │   ├── DoctorPojo.java
│       │   ├── PatientPojo.java
│       │   ├── ReceptionistPojo.java
│       │   ├── EmpPojo.java
│       │   └── UserPojo.java
│       └── utility/             # Utility Classes
│           ├── OTPSender.java
│           ├── PasswordEncryption.java
│           ├── SmsSender.java
│           ├── Sender.java
│           └── UserProfile.java
└── lib/                         # External JAR files (create this)
    ├── ojdbc11.jar
    ├── commons-codec-1.11.jar
    └── ... (other dependencies)
```

---

## 📸 Screenshots

> **Note:** Add screenshots of your application here

### Login Screen
![Login Screen](screenshots/login.png)

### Admin Dashboard
![Admin Dashboard](screenshots/admin-dashboard.png)

### Doctor Panel
![Doctor Panel](screenshots/doctor-panel.png)

### Patient Registration
![Patient Registration](screenshots/patient-registration.png)

---

## 🔧 Troubleshooting

### Common Issues

#### 1. Database Connection Error
```
Error: Cannot establish database connection
```
**Solution:** 
- Verify Oracle Database is running
- Check connection string in `DBConnection.java`
- Ensure Oracle listener is active: `lsnrctl status`

#### 2. ClassNotFoundException: oracle.jdbc.OracleDriver
```
Error: oracle.jdbc.OracleDriver not found
```
**Solution:**
- Add `ojdbc11.jar` to project libraries
- Update library path in `project.properties`

#### 3. OTP Not Sending
```
Error: SMS sending failed
```
**Solution:**
- Check SMS gateway credentials
- Verify internet connection
- Ensure SMS API balance/credits

#### 4. Missing JAR Files
```
Error: Package does not exist
```
**Solution:**
- Download all required JARs
- Add them to project libraries
- Clean and rebuild project

---

## 🚀 Future Enhancements

- [ ] Web-based interface using Spring Boot
- [ ] RESTful API development
- [ ] Mobile application (Android/iOS)
- [ ] Electronic Medical Records (EMR) integration
- [ ] Billing and invoice management
- [ ] Pharmacy management module
- [ ] Laboratory test management
- [ ] Report generation (PDF/Excel)
- [ ] Multi-language support
- [ ] Dark mode theme
- [ ] Real-time notifications
- [ ] Telemedicine integration
- [ ] Analytics dashboard

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. **Fork the Repository**
   ```bash
   git fork https://github.com/yourusername/sanjeevani.git
   ```

2. **Create Feature Branch**
   ```bash
   git checkout -b feature/AmazingFeature
   ```

3. **Commit Changes**
   ```bash
   git commit -m "Add some AmazingFeature"
   ```

4. **Push to Branch**
   ```bash
   git push origin feature/AmazingFeature
   ```

5. **Open Pull Request**

### Code Style Guidelines

- Follow Java naming conventions
- Add JavaDoc comments for public methods
- Write clean, readable code
- Include unit tests for new features
- Update documentation as needed

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

```
MIT License

Copyright (c) 2024 Sanjeevani Hospital Management System

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

## 👨‍💻 Authors & Contributors

- **Developer** - Initial work and development
- **Contributors** - See [CONTRIBUTORS.md](CONTRIBUTORS.md)

---

## 📞 Support & Contact

For support, questions, or suggestions:

- 📧 Email: support@sanjeevani.com
- 🐛 Issues: [GitHub Issues](https://github.com/yourusername/sanjeevani/issues)
- 💬 Discussions: [GitHub Discussions](https://github.com/yourusername/sanjeevani/discussions)

---

## 🙏 Acknowledgments

- Oracle Corporation for the robust database system
- Apache Software Foundation for HttpClient and other libraries
- NetBeans Community for the excellent IDE
- All contributors and testers

---

## 📊 Project Stats

![GitHub repo size](https://img.shields.io/github/repo-size/yourusername/sanjeevani)
![GitHub contributors](https://img.shields.io/github/contributors/yourusername/sanjeevani)
![GitHub stars](https://img.shields.io/github/stars/yourusername/sanjeevani?style=social)
![GitHub forks](https://img.shields.io/github/forks/yourusername/sanjeevani?style=social)

---

<div align="center">

### ⭐ Star this repository if you find it helpful!

Made with ❤️ by the Sanjeevani Team

[Report Bug](https://github.com/yourusername/sanjeevani/issues) · [Request Feature](https://github.com/yourusername/sanjeevani/issues) · [Documentation](https://github.com/yourusername/sanjeevani/wiki)

</div>

