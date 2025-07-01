# 🏥 Hospital Management System - Java & MySQL

The **Hospital Management System** is a comprehensive **Java-based** desktop application built to streamline and automate administrative and clinical workflows within a hospital environment. It offers a centralized interface for managing patient data, doctor records, and administrative tasks, ensuring smooth and efficient hospital operations.

---

## 🚀 Key Features

### 👤 Administrator Module
- Secure admin panel with login authentication.
- Manage doctor and patient registrations.
- View and update staff records.
- Oversee all hospital activities in a centralized dashboard.

### 👨‍⚕️ Doctor Module
- Dedicated portal for doctors with secure login.
- Access assigned patient records and medical histories.
- Manage schedules and availability.
- View personal profiles including specialization and contact info.

### 🧑‍🦰 Patient Module
- Patient registration and secure login.
- View personal medical records and doctor assignments.
- Manage personal details and billing information.
- User-friendly dashboard for improved experience.

---

## 🛠️ Technologies Used

- **Programming Language:** Java (Swing for GUI)
- **Database:** MySQL
- **Architecture:** Object-Oriented Programming (OOP)
- **Connectivity:** JDBC (Java Database Connectivity)

---

## 🗄️ Database Schema Overview

### `Admin` Table
Stores system administrator credentials and essential profile data.

| Column Name     | Data Type | Description                     |
|-----------------|-----------|---------------------------------|
| `admin_id`      | INT       | Primary key                     |
| `username`      | VARCHAR   | Admin login name                |
| `password`      | VARCHAR   | Encrypted admin password        |
| `full_name`     | VARCHAR   | Admin full name                 |

---

### `Doctor` Table
Holds detailed doctor profiles.

| Column Name     | Data Type | Description                     |
|-----------------|-----------|---------------------------------|
| `doctor_id`     | INT       | Primary key                     |
| `name`          | VARCHAR   | Doctor's full name              |
| `specialization`| VARCHAR   | Area of expertise               |
| `contact`       | VARCHAR   | Phone or email                  |
| `password`      | VARCHAR   | Login password                  |

---

### `Patient` Table
Manages patient information and billing.

| Column Name     | Data Type | Description                     |
|-----------------|-----------|---------------------------------|
| `patient_id`    | INT       | Primary key                     |
| `name`          | VARCHAR   | Patient's name                  |
| `contact`       | VARCHAR   | Contact information             |
| `assigned_doctor_id` | INT | Foreign key referencing `Doctor`|
| `medical_history`| TEXT     | Past treatments/notes           |
| `bill_amount`   | DECIMAL   | Patient's bill                  |

---

## ✅ Project Highlights

- Practical use of **Object-Oriented Programming** concepts.
- Real-world implementation of **database management** principles.
- Enhances hospital efficiency and reduces paperwork.
- Modular, extendable, and easy to maintain.

---

## 📌 Future Enhancements (Optional)

- Role-based access control (RBAC) for nurses, pharmacists, etc.
- Appointment scheduling system.
- Report generation (PDF/Excel).
- Email or SMS notifications.

---

## 📷 GUI Snapshots
*(Include screenshots of login screens, dashboards, and tables here if needed.)*

---

## 🧠 Author's Note

This system is an academic-level project aimed at improving hospital data handling using core Java and MySQL. It serves as a foundational platform for more advanced healthcare applications.

