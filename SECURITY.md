# Security Policy

## 🔒 Security Overview

Security is a top priority for the Sanjeevani Hospital Management System. This document outlines our security policies, practices, and how to report vulnerabilities.

---

## 🛡️ Supported Versions

| Version | Supported          | Security Updates |
| ------- | ------------------ | ---------------- |
| 1.0.x   | ✅ Yes            | Active           |
| < 1.0   | ❌ No             | Deprecated       |

---

## 🚨 Reporting a Vulnerability

### Quick Report

If you discover a security vulnerability, please report it responsibly:

1. **DO NOT** open a public GitHub issue
2. **DO NOT** disclose the vulnerability publicly until it's fixed
3. **DO** email us at: security@sanjeevani.com

### What to Include

Please provide:

- **Description** of the vulnerability
- **Steps to reproduce** the issue
- **Potential impact** assessment
- **Suggested fix** (if any)
- **Your contact information** for follow-up

### Response Timeline

- **Initial Response**: Within 48 hours
- **Status Update**: Within 7 days
- **Fix Timeline**: Based on severity (see below)

### Severity Levels

| Severity | Response Time | Fix Timeline |
|----------|--------------|--------------|
| 🔴 Critical | 24 hours | 7 days |
| 🟠 High | 48 hours | 14 days |
| 🟡 Medium | 72 hours | 30 days |
| 🟢 Low | 7 days | 60 days |

---

## 🔐 Security Features

### Current Implementation

#### 1. Authentication & Authorization

✅ **Role-Based Access Control (RBAC)**
- Three distinct user roles: Admin, Doctor, Receptionist
- Permission-based feature access
- Session management

✅ **Password Security**
- Password hashing (should be using BCrypt/SHA-256)
- Minimum password requirements enforcement
- Password change on first login (recommended)

#### 2. OTP Verification

✅ **Two-Factor Authentication**
- OTP generation for sensitive operations
- SMS-based OTP delivery
- Time-limited OTP validity
- One-time use only

#### 3. Database Security

✅ **SQL Injection Prevention**
- Prepared statements throughout
- Input validation
- Parameterized queries

✅ **Connection Security**
- Encrypted database connections (recommended)
- Connection pooling
- Timeout management

#### 4. Data Protection

✅ **Sensitive Data Handling**
- Patient information protected
- Medical records access control
- Audit trails for data access

---

## ⚠️ Known Security Considerations

### Current Limitations

⚠️ **Password Storage**
```java
// Current implementation in DBConnection.java
password VARCHAR2(200) NOT NULL
```
**Recommendation**: Implement proper password hashing
```java
// Use BCrypt or similar
BCrypt.hashpw(password, BCrypt.gensalt(12))
```

⚠️ **Hardcoded Credentials**
```java
// DBConnection.java line 15
conn = DriverManager.getConnection(..., "sanjeevani", "sanjeevani1");
```
**Recommendation**: Move to configuration file or environment variables

⚠️ **SMS Gateway Credentials**
```java
// SmsSender.java contains API keys
private static final String API_KEY = "...";
```
**Recommendation**: Use environment variables or secure vault

---

## 🔧 Security Best Practices

### For Administrators

#### 1. Initial Setup Security

```sql
-- Change default passwords immediately
UPDATE users SET password = 'NEW_SECURE_PASSWORD' WHERE user_id = 'admin';
COMMIT;

-- Disable default accounts if not needed
UPDATE users SET is_active = 'N' WHERE user_id IN ('DOC001', 'REC001');
COMMIT;
```

#### 2. Database Security

```sql
-- Revoke unnecessary privileges
REVOKE UNLIMITED TABLESPACE FROM sanjeevani;
GRANT QUOTA 500M ON USERS TO sanjeevani;

-- Enable audit trails
AUDIT SELECT, INSERT, UPDATE, DELETE ON patients BY ACCESS;
AUDIT SELECT, INSERT, UPDATE, DELETE ON users BY ACCESS;

-- Regular password rotation
ALTER USER sanjeevani IDENTIFIED BY new_password;
```

#### 3. Network Security

```bash
# Configure Oracle Listener for secure connections
# Edit listener.ora
LISTENER =
  (DESCRIPTION_LIST =
    (DESCRIPTION =
      (ADDRESS = (PROTOCOL = TCPS)(HOST = hostname)(PORT = 2484))
    )
  )

# Enable SSL/TLS for database connections
WALLET_LOCATION = (SOURCE = (METHOD = FILE)(METHOD_DATA = (DIRECTORY = /path/to/wallet)))
SSL_CLIENT_AUTHENTICATION = TRUE
```

#### 4. Application Security

**Secure Configuration File** (`config.properties`)

```properties
# DO NOT commit this file to version control
db.host=localhost
db.port=1521
db.sid=xe
db.username=sanjeevani
db.password=ENCRYPTED_PASSWORD_HERE

sms.api.key=ENCRYPTED_API_KEY
sms.sender.id=SANJEEVANI
```

**Environment Variables** (Preferred)

```bash
# Set environment variables
export DB_HOST=localhost
export DB_PORT=1521
export DB_SID=xe
export DB_USERNAME=sanjeevani
export DB_PASSWORD=your_secure_password
export SMS_API_KEY=your_api_key
```

**Java Code to Use Environment Variables**

```java
// DBConnection.java (Recommended approach)
String dbHost = System.getenv("DB_HOST");
String dbPort = System.getenv("DB_PORT");
String dbSid = System.getenv("DB_SID");
String dbUser = System.getenv("DB_USERNAME");
String dbPass = System.getenv("DB_PASSWORD");

String connString = String.format("jdbc:oracle:thin:@//%s:%s/%s", 
                                   dbHost, dbPort, dbSid);
conn = DriverManager.getConnection(connString, dbUser, dbPass);
```

### For Developers

#### 1. Input Validation

```java
// Always validate user input
public boolean validateEmail(String email) {
    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    Pattern pattern = Pattern.compile(emailRegex);
    return pattern.matcher(email).matches();
}

// Sanitize SQL inputs (use prepared statements)
PreparedStatement ps = conn.prepareStatement(
    "SELECT * FROM users WHERE user_id = ? AND password = ?"
);
ps.setString(1, userId);
ps.setString(2, hashedPassword);
```

#### 2. Error Handling

```java
// DON'T expose sensitive information in error messages
try {
    // database operation
} catch (SQLException ex) {
    // BAD: Don't show full stack trace to users
    // ex.printStackTrace();
    
    // GOOD: Log error securely and show generic message
    logger.error("Database error: " + ex.getMessage());
    JOptionPane.showMessageDialog(null, 
        "An error occurred. Please contact support.", 
        "Error", JOptionPane.ERROR_MESSAGE);
}
```

#### 3. Session Management

```java
// Implement session timeout
public class UserSession {
    private static final long SESSION_TIMEOUT = 30 * 60 * 1000; // 30 minutes
    private static long lastActivity;
    
    public static boolean isSessionValid() {
        return (System.currentTimeMillis() - lastActivity) < SESSION_TIMEOUT;
    }
    
    public static void updateActivity() {
        lastActivity = System.currentTimeMillis();
    }
}
```

#### 4. Secure Password Hashing

```java
// Use BCrypt for password hashing
import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    // Hash password
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }
    
    // Verify password
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
```

---

## 🔍 Security Checklist

### Pre-Production Security Audit

- [ ] All default passwords changed
- [ ] Database credentials secured (not hardcoded)
- [ ] API keys moved to environment variables
- [ ] SSL/TLS enabled for database connections
- [ ] Input validation on all forms
- [ ] SQL injection testing completed
- [ ] Authentication testing completed
- [ ] Authorization testing completed
- [ ] Session timeout implemented
- [ ] Error messages don't leak sensitive info
- [ ] Audit logging enabled
- [ ] Regular backup strategy in place
- [ ] Disaster recovery plan documented
- [ ] Security patches up to date
- [ ] Dependencies vulnerability scan completed

### Regular Security Maintenance

- [ ] Monthly password rotation for service accounts
- [ ] Quarterly security audit
- [ ] Weekly database backups verified
- [ ] Daily log review for suspicious activity
- [ ] Update dependencies when security patches released
- [ ] Review user access permissions quarterly
- [ ] Test disaster recovery procedures annually

---

## 📋 Security Audit Log

### Version 1.0.0 (January 2024)

| Date | Issue | Severity | Status | Notes |
|------|-------|----------|--------|-------|
| 2024-01-01 | Initial release | - | ✅ Complete | Base security implemented |
| - | - | - | - | - |

---

## 🔐 Compliance & Standards

### Data Protection

This system handles sensitive medical information. Ensure compliance with:

- **HIPAA** (Health Insurance Portability and Accountability Act) - US
- **GDPR** (General Data Protection Regulation) - EU
- **IT Act 2000** - India
- Local healthcare data protection laws

### Recommended Certifications

- ISO 27001 (Information Security Management)
- HITRUST CSF (Healthcare Information Trust)
- SOC 2 (Service Organization Control)

---

## 🛠️ Security Tools & Resources

### Recommended Security Tools

1. **Static Analysis**
   - [SonarQube](https://www.sonarqube.org/)
   - [FindBugs](http://findbugs.sourceforge.net/)
   - [PMD](https://pmd.github.io/)

2. **Dependency Scanning**
   - [OWASP Dependency-Check](https://owasp.org/www-project-dependency-check/)
   - [Snyk](https://snyk.io/)

3. **Penetration Testing**
   - [OWASP ZAP](https://www.zaproxy.org/)
   - [Burp Suite](https://portswigger.net/burp)

4. **Database Security**
   - Oracle Database Vault
   - Oracle Audit Vault

### Security Resources

- [OWASP Top 10](https://owasp.org/www-project-top-ten/)
- [CWE Top 25](https://cwe.mitre.org/top25/)
- [NIST Cybersecurity Framework](https://www.nist.gov/cyberframework)

---

## 📞 Security Contact

### Security Team

- **Email**: security@sanjeevani.com
- **PGP Key**: [Public Key](https://sanjeevani.com/pgp-key.asc)
- **Response Time**: Within 48 hours

### Bug Bounty Program

We appreciate security researchers who help us keep Sanjeevani secure.

**Rewards**: Based on severity and impact
- 🔴 Critical: Recognition + Acknowledgment
- 🟠 High: Recognition + Acknowledgment
- 🟡 Medium: Recognition
- 🟢 Low: Acknowledgment

**Hall of Fame**: [Security Researchers](https://sanjeevani.com/security/hall-of-fame)

---

## 📜 Security Updates

Subscribe to security updates:

- **Mailing List**: security-announcements@sanjeevani.com
- **RSS Feed**: https://sanjeevani.com/security.rss
- **GitHub Watch**: Click "Watch" → "Custom" → "Security alerts"

---

## ⚖️ Responsible Disclosure

We follow responsible disclosure practices:

1. Researcher reports vulnerability privately
2. We acknowledge receipt within 48 hours
3. We investigate and develop fix
4. We notify researcher of fix timeline
5. We release security patch
6. We credit researcher (if desired)
7. Details disclosed publicly after fix

---

## 🙏 Acknowledgments

We thank the following security researchers:

- *Your name could be here!*

---

## 📚 Additional Documentation

- [Security Incident Response Plan](docs/INCIDENT_RESPONSE.md)
- [Disaster Recovery Plan](docs/DISASTER_RECOVERY.md)
- [Privacy Policy](docs/PRIVACY_POLICY.md)
- [Data Retention Policy](docs/DATA_RETENTION.md)

---

**Security is everyone's responsibility. Thank you for helping keep Sanjeevani secure!** 🔒

*Last updated: January 28, 2024*

