-- ============================================================================
-- Sanjeevani Hospital Management System - Database Setup Script
-- ============================================================================
-- Description: This script creates all necessary database objects for the
--              Sanjeevani Hospital Management System
-- Database: Oracle Database 11g/21c or higher
-- Author: Sanjeevani Development Team
-- Version: 1.0.0
-- ============================================================================

-- Connect as SYSTEM or admin user to create the schema
-- ALTER SESSION SET "_ORACLE_SCRIPT"=true;  -- Uncomment for Oracle 21c+

-- ============================================================================
-- SECTION 1: USER CREATION
-- ============================================================================

-- Drop user if exists (for clean reinstall)
-- DROP USER sanjeevani CASCADE;

-- Create user
CREATE USER sanjeevani IDENTIFIED BY sanjeevani1;

-- Grant necessary privileges
GRANT CONNECT TO sanjeevani;
GRANT RESOURCE TO sanjeevani;
GRANT CREATE SESSION TO sanjeevani;
GRANT CREATE TABLE TO sanjeevani;
GRANT CREATE VIEW TO sanjeevani;
GRANT CREATE SEQUENCE TO sanjeevani;
GRANT UNLIMITED TABLESPACE TO sanjeevani;

-- Connect as sanjeevani user for table creation
-- CONNECT sanjeevani/sanjeevani1;

-- ============================================================================
-- SECTION 2: TABLE CREATION
-- ============================================================================

-- ----------------------------------------------------------------------------
-- USERS TABLE - Stores login credentials for all user types
-- ----------------------------------------------------------------------------
CREATE TABLE users (
    user_id VARCHAR2(50) PRIMARY KEY,
    user_name VARCHAR2(100) NOT NULL,
    password VARCHAR2(200) NOT NULL,
    user_type VARCHAR2(20) NOT NULL CHECK (user_type IN ('ADMIN', 'DOCTOR', 'RECEPTIONIST')),
    created_date DATE DEFAULT SYSDATE,
    last_login DATE,
    is_active CHAR(1) DEFAULT 'Y' CHECK (is_active IN ('Y', 'N'))
);

-- ----------------------------------------------------------------------------
-- DOCTORS TABLE - Stores doctor information
-- ----------------------------------------------------------------------------
CREATE TABLE doctors (
    doc_id VARCHAR2(50) PRIMARY KEY,
    doc_name VARCHAR2(100) NOT NULL,
    email_id VARCHAR2(100) UNIQUE,
    contact_no VARCHAR2(15) NOT NULL,
    qualification VARCHAR2(100),
    gender VARCHAR2(10) CHECK (gender IN ('Male', 'Female', 'Other')),
    specialist VARCHAR2(100),
    created_date DATE DEFAULT SYSDATE,
    updated_date DATE,
    CONSTRAINT fk_doctor_user FOREIGN KEY (doc_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- ----------------------------------------------------------------------------
-- RECEPTIONISTS TABLE - Stores receptionist information
-- ----------------------------------------------------------------------------
CREATE TABLE receptionists (
    receptionist_id VARCHAR2(50) PRIMARY KEY,
    receptionist_name VARCHAR2(100) NOT NULL,
    email_id VARCHAR2(100) UNIQUE,
    contact_no VARCHAR2(15) NOT NULL,
    gender VARCHAR2(10) CHECK (gender IN ('Male', 'Female', 'Other')),
    qualification VARCHAR2(100),
    created_date DATE DEFAULT SYSDATE,
    updated_date DATE,
    CONSTRAINT fk_receptionist_user FOREIGN KEY (receptionist_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- ----------------------------------------------------------------------------
-- EMPLOYEES TABLE - Stores employee information
-- ----------------------------------------------------------------------------
CREATE TABLE employees (
    emp_id VARCHAR2(50) PRIMARY KEY,
    emp_name VARCHAR2(100) NOT NULL,
    email_id VARCHAR2(100) UNIQUE,
    contact_no VARCHAR2(15) NOT NULL,
    gender VARCHAR2(10) CHECK (gender IN ('Male', 'Female', 'Other')),
    salary NUMBER(10,2),
    designation VARCHAR2(100),
    department VARCHAR2(100),
    joining_date DATE DEFAULT SYSDATE,
    created_date DATE DEFAULT SYSDATE,
    updated_date DATE
);

-- ----------------------------------------------------------------------------
-- PATIENTS TABLE - Stores patient information
-- ----------------------------------------------------------------------------
CREATE TABLE patients (
    patient_id VARCHAR2(50) PRIMARY KEY,
    first_name VARCHAR2(50) NOT NULL,
    last_name VARCHAR2(50),
    age NUMBER(3) CHECK (age > 0 AND age < 150),
    gender VARCHAR2(10) CHECK (gender IN ('Male', 'Female', 'Other')),
    married_status VARCHAR2(20) CHECK (married_status IN ('Single', 'Married', 'Divorced', 'Widowed')),
    address VARCHAR2(200),
    city VARCHAR2(50),
    mobile_no VARCHAR2(15) NOT NULL,
    date_time DATE DEFAULT SYSDATE,
    opd VARCHAR2(50),
    doctor_id VARCHAR2(50),
    otp NUMBER(6),
    apt_status VARCHAR2(20) DEFAULT 'PENDING' CHECK (apt_status IN ('PENDING', 'REQUEST', 'CONFIRMED', 'COMPLETED', 'CANCELLED')),
    blood_group VARCHAR2(5),
    emergency_contact VARCHAR2(15),
    created_date DATE DEFAULT SYSDATE,
    updated_date DATE,
    CONSTRAINT fk_patient_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(doc_id) ON DELETE SET NULL
);

-- ----------------------------------------------------------------------------
-- APPOINTMENTS TABLE - Stores appointment information
-- ----------------------------------------------------------------------------
CREATE TABLE appointments (
    appointment_id VARCHAR2(50) PRIMARY KEY,
    patient_id VARCHAR2(50) NOT NULL,
    patient_name VARCHAR2(100) NOT NULL,
    status VARCHAR2(20) DEFAULT 'REQUEST' CHECK (status IN ('REQUEST', 'CONFIRMED', 'COMPLETED', 'CANCELLED')),
    opd VARCHAR2(50),
    date_time VARCHAR2(50) NOT NULL,
    doctor_name VARCHAR2(100) NOT NULL,
    mobile_no VARCHAR2(15) NOT NULL,
    created_date DATE DEFAULT SYSDATE,
    updated_date DATE,
    notes VARCHAR2(500),
    CONSTRAINT fk_appointment_patient FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ON DELETE CASCADE
);

-- ============================================================================
-- SECTION 3: SEQUENCES FOR AUTO-GENERATION OF IDs
-- ============================================================================

CREATE SEQUENCE seq_patient_id START WITH 1001 INCREMENT BY 1;
CREATE SEQUENCE seq_doctor_id START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_receptionist_id START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_employee_id START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_appointment_id START WITH 1 INCREMENT BY 1;

-- ============================================================================
-- SECTION 4: INDEXES FOR PERFORMANCE
-- ============================================================================

-- Index on frequently searched columns
CREATE INDEX idx_patient_name ON patients(first_name, last_name);
CREATE INDEX idx_patient_mobile ON patients(mobile_no);
CREATE INDEX idx_doctor_name ON doctors(doc_name);
CREATE INDEX idx_doctor_specialist ON doctors(specialist);
CREATE INDEX idx_appointment_date ON appointments(date_time);
CREATE INDEX idx_appointment_status ON appointments(status);
CREATE INDEX idx_patient_doctor ON patients(doctor_id);

-- ============================================================================
-- SECTION 5: INITIAL DATA INSERTION
-- ============================================================================

-- Insert default admin user
-- Note: Password should be encrypted in the application
-- Default password: admin123 (please change after first login)
INSERT INTO users (user_id, user_name, password, user_type) 
VALUES ('admin', 'System Administrator', 'admin123', 'ADMIN');

-- Insert sample doctor
INSERT INTO users (user_id, user_name, password, user_type) 
VALUES ('DOC001', 'Dr. Rajesh Kumar', 'doctor123', 'DOCTOR');

INSERT INTO doctors (doc_id, doc_name, email_id, contact_no, qualification, gender, specialist)
VALUES ('DOC001', 'Dr. Rajesh Kumar', 'rajesh.kumar@sanjeevani.com', '9876543210', 
        'MBBS, MD', 'Male', 'General Physician');

-- Insert sample receptionist
INSERT INTO users (user_id, user_name, password, user_type) 
VALUES ('REC001', 'Priya Sharma', 'rec123', 'RECEPTIONIST');

INSERT INTO receptionists (receptionist_id, receptionist_name, email_id, contact_no, gender, qualification)
VALUES ('REC001', 'Priya Sharma', 'priya.sharma@sanjeevani.com', '9876543211', 
        'Female', 'B.Com');

-- Insert sample employee
INSERT INTO employees (emp_id, emp_name, email_id, contact_no, gender, salary, designation, department)
VALUES ('EMP001', 'Amit Patel', 'amit.patel@sanjeevani.com', '9876543212', 
        'Male', 25000.00, 'Assistant', 'Administration');

-- Commit all changes
COMMIT;

-- ============================================================================
-- SECTION 6: VIEWS FOR REPORTING
-- ============================================================================

-- View: Active Appointments
CREATE OR REPLACE VIEW v_active_appointments AS
SELECT 
    a.appointment_id,
    a.patient_id,
    a.patient_name,
    a.doctor_name,
    a.date_time,
    a.status,
    a.opd,
    p.age,
    p.gender,
    p.mobile_no
FROM appointments a
JOIN patients p ON a.patient_id = p.patient_id
WHERE a.status IN ('REQUEST', 'CONFIRMED');

-- View: Doctor Statistics
CREATE OR REPLACE VIEW v_doctor_stats AS
SELECT 
    d.doc_id,
    d.doc_name,
    d.specialist,
    COUNT(DISTINCT p.patient_id) as total_patients,
    COUNT(DISTINCT a.appointment_id) as total_appointments,
    COUNT(DISTINCT CASE WHEN a.status = 'CONFIRMED' THEN a.appointment_id END) as confirmed_appointments
FROM doctors d
LEFT JOIN patients p ON d.doc_id = p.doctor_id
LEFT JOIN appointments a ON d.doc_name = a.doctor_name
GROUP BY d.doc_id, d.doc_name, d.specialist;

-- View: Patient Summary
CREATE OR REPLACE VIEW v_patient_summary AS
SELECT 
    p.patient_id,
    p.first_name || ' ' || p.last_name as full_name,
    p.age,
    p.gender,
    p.mobile_no,
    p.city,
    d.doc_name as assigned_doctor,
    p.apt_status,
    p.created_date as registration_date
FROM patients p
LEFT JOIN doctors d ON p.doctor_id = d.doc_id;

-- ============================================================================
-- SECTION 7: STORED PROCEDURES (Optional)
-- ============================================================================

-- Procedure to generate Patient ID
CREATE OR REPLACE PROCEDURE sp_generate_patient_id (
    p_patient_id OUT VARCHAR2
) AS
BEGIN
    SELECT 'P' || LPAD(seq_patient_id.NEXTVAL, 5, '0') INTO p_patient_id FROM DUAL;
END;
/

-- ============================================================================
-- SECTION 8: TRIGGERS
-- ============================================================================

-- Trigger to update last_login in users table
CREATE OR REPLACE TRIGGER trg_update_last_login
BEFORE UPDATE OF password ON users
FOR EACH ROW
BEGIN
    :NEW.last_login := SYSDATE;
END;
/

-- Trigger to set updated_date automatically
CREATE OR REPLACE TRIGGER trg_doctors_update_date
BEFORE UPDATE ON doctors
FOR EACH ROW
BEGIN
    :NEW.updated_date := SYSDATE;
END;
/

CREATE OR REPLACE TRIGGER trg_patients_update_date
BEFORE UPDATE ON patients
FOR EACH ROW
BEGIN
    :NEW.updated_date := SYSDATE;
END;
/

CREATE OR REPLACE TRIGGER trg_appointments_update_date
BEFORE UPDATE ON appointments
FOR EACH ROW
BEGIN
    :NEW.updated_date := SYSDATE;
END;
/

-- ============================================================================
-- VERIFICATION QUERIES
-- ============================================================================

-- Check table creation
SELECT table_name FROM user_tables ORDER BY table_name;

-- Check initial data
SELECT * FROM users;
SELECT * FROM doctors;
SELECT * FROM receptionists;
SELECT * FROM employees;

-- Check sequences
SELECT sequence_name, last_number FROM user_sequences;

-- Check indexes
SELECT index_name, table_name FROM user_indexes WHERE table_name IN 
    ('PATIENTS', 'DOCTORS', 'APPOINTMENTS', 'USERS');

-- ============================================================================
-- CLEANUP SCRIPT (Use only for complete removal)
-- ============================================================================
-- WARNING: This will delete all data and drop the user
-- Uncomment below to use

/*
DROP USER sanjeevani CASCADE;
*/

-- ============================================================================
-- NOTES
-- ============================================================================
-- 1. Update passwords after initial setup
-- 2. Modify connection string in DBConnection.java to match your setup
-- 3. Ensure Oracle listener is running before connecting
-- 4. Grant additional privileges if needed for specific operations
-- 5. Regular backup of database is recommended
-- 6. Monitor and optimize queries based on usage patterns
-- ============================================================================

SELECT 'Database setup completed successfully!' AS STATUS FROM DUAL;

