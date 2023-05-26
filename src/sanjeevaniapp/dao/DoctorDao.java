/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanjeevaniapp.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sanjeevaniapp.dbutil.DBConnection;
import sanjeevaniapp.pojo.DoctorPojo;

public class DoctorDao {

    public static void updateName(String currName, String newName) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Update users set user_name=? where user_name=?");
        ps.setString(1, newName);
        ps.setString(2, currName);
        ps.executeUpdate();
    }

    public static void deleteUserByName(String name) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from doctors where doctor_name=?");
        ps.setString(1, name);
        ps.executeUpdate();
    }

    public static boolean addDoctor(DoctorPojo doc) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into doctors values(?,?,?,?,?,?,?)");
        ps.setString(1, doc.getDocId());
        ps.setString(2, doc.getDocName());
        ps.setString(3, doc.getEmailId());
        ps.setString(4, doc.getContactNo());
        ps.setString(5, doc.getQualification());
        ps.setString(7, doc.getSpecialist());
        ps.setString(6, doc.getGender());
        return ps.executeUpdate() == 1;
    }

    public static String getNewDocId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select max(doctor_id) from doctors");
        rs.next();
        int docId = 101;
        String id = rs.getString(1);
        if (id != null) {
            String num = id.substring(3);
            docId = Integer.parseInt(num) + 1;
        }
        return "DOC" + docId;
    }

    public static List<DoctorPojo> getAllDoctorDetails() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from doctors order by doctor_id");
        List<DoctorPojo> docList = new ArrayList<>();
        while (rs.next()) {
            DoctorPojo doc = new DoctorPojo();
            doc.setDocName(rs.getString("doctor_name"));
            doc.setContactNo(rs.getString("contact_no"));
            doc.setDocId(rs.getString("doctor_id"));
            doc.setEmailId(rs.getString("email_id"));
            doc.setQualification(rs.getString("qualification"));
            doc.setGender(rs.getString("gender"));
            doc.setSpecialist(rs.getString("specialist"));
            docList.add(doc);
        }
        return docList;
    }

    public static boolean deleteDoctorById(String docId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select doctor_name from doctors where doctor_id=?");
        ps.setString(1, docId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String docName = rs.getString(1);
        UserDao.deleteUserByName(docName);
        ps = conn.prepareStatement("Delete from doctors where doctor_id=?");
        ps.setString(1, docId);
        return ps.executeUpdate() == 1;
    }
    
    public static DoctorPojo getDoctoretails(String empId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from doctors where doctor_id=?");
        ps.setString(1, empId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        DoctorPojo doc = new DoctorPojo();
        doc.setDocId(rs.getString(1));
        doc.setDocName(rs.getString(2));
        doc.setEmailId(rs.getString(3));
        doc.setContactNo(rs.getString(4));
        doc.setQualification(rs.getString(5));
        doc.setGender(rs.getString(6));
        doc.setSpecialist(rs.getString(7));
        return doc;
    }
    
    public static List<String> getAllDoctorId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select doctor_id from doctors");
        List<String> doctorList = new ArrayList<>();
        while (rs.next()) {
            doctorList.add(rs.getString(1));
        }
        return doctorList;
    }
    
    public static String getDoctorNameById(String docId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select doctor_name from doctors where doctor_id=?");
        ps.setString(1, docId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getString(1);
    }
    
    public static boolean updateDoctor(DoctorPojo doc) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Update doctors set doctor_name=?,email_id=?,contact_no=?,qualification=?,gender=?,specialist=? where doctor_id=?");
        ps.setString(1, doc.getDocName());
        ps.setString(2, doc.getEmailId());
        ps.setString(3, doc.getContactNo());
        ps.setString(4, doc.getQualification());
        ps.setString(5, doc.getGender());
        ps.setString(6, doc.getSpecialist());
        ps.setString(7, doc.getDocId());
        return ps.executeUpdate() == 1;
    }
}
