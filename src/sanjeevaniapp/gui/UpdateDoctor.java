/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sanjeevaniapp.gui;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sanjeevaniapp.dao.DoctorDao;
import sanjeevaniapp.dao.ReceptionistDao;
import sanjeevaniapp.dao.UserDao;
import sanjeevaniapp.pojo.DoctorPojo;
import sanjeevaniapp.pojo.UserPojo;
import sanjeevaniapp.utility.PasswordEncryption;

/**
 *
 * @author ACER
 */
public class UpdateDoctor extends javax.swing.JFrame {

    /**
     * Creates new form UpateDoctor
     */
    private String loginId;
    private String password, rePassword;
    private String contactNo, emailId, qualification, specialist;
    
    public UpdateDoctor() {
        initComponents();
        setLocationRelativeTo(null);
        loadDoctorsId();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDoctorName = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLoginId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcGender = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtEmailId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtQualification = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSpecialist = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        pwd = new javax.swing.JPasswordField();
        rePwd = new javax.swing.JPasswordField();
        jcDoctorId = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update Doctor");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 390, 50));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 35)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Sanjeevani Application");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "Update Doctor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Doctor ID");

        txtDoctorName.setBackground(new java.awt.Color(255, 255, 255));
        txtDoctorName.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtDoctorName.setForeground(new java.awt.Color(0, 0, 0));

        btnUpdate.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdate.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Doctor Name");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Login ID");

        txtLoginId.setBackground(new java.awt.Color(255, 255, 255));
        txtLoginId.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtLoginId.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Retype");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Gender");

        jcGender.setBackground(new java.awt.Color(255, 255, 255));
        jcGender.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jcGender.setForeground(new java.awt.Color(0, 0, 0));
        jcGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Contact No.");

        txtEmailId.setBackground(new java.awt.Color(255, 255, 255));
        txtEmailId.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtEmailId.setForeground(new java.awt.Color(0, 0, 0));
        txtEmailId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailIdActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Email ID");

        txtContactNo.setBackground(new java.awt.Color(255, 255, 255));
        txtContactNo.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtContactNo.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Qualificaton");

        txtQualification.setBackground(new java.awt.Color(255, 255, 255));
        txtQualification.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtQualification.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Specialist");

        txtSpecialist.setBackground(new java.awt.Color(255, 255, 255));
        txtSpecialist.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtSpecialist.setForeground(new java.awt.Color(0, 0, 0));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sanjeevaniapp/images/images (2).jpg"))); // NOI18N
        jLabel13.setText("jLabel13");

        btnBack.setBackground(new java.awt.Color(204, 204, 204));
        btnBack.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(204, 204, 204));
        btnLogout.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(0, 0, 0));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        pwd.setBackground(new java.awt.Color(255, 255, 255));
        pwd.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        pwd.setForeground(new java.awt.Color(0, 0, 0));

        rePwd.setBackground(new java.awt.Color(255, 255, 255));
        rePwd.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        rePwd.setForeground(new java.awt.Color(0, 0, 0));
        rePwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rePwdActionPerformed(evt);
            }
        });

        jcDoctorId.setBackground(new java.awt.Color(255, 255, 255));
        jcDoctorId.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jcDoctorId.setForeground(new java.awt.Color(0, 0, 0));
        jcDoctorId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcDoctorIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jcDoctorId, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLoginId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pwd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rePwd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSpecialist, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(23, 23, 23)
                            .addComponent(txtQualification, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(29, 29, 29)
                        .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(103, 103, 103)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jcDoctorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLoginId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtQualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(txtSpecialist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rePwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnLogout))
                .addGap(22, 22, 22))
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 1090, 370));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sanjeevaniapp/images/HomePageBG1.jpg"))); // NOI18N
        jLabel14.setText("jLabel14");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 1050, 400));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        boolean isInputValid = validateInputs();
        if (!isInputValid) {
            JOptionPane.showMessageDialog(null, "Please input all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String result = matchPasswords();
        if (result != null) {
            JOptionPane.showMessageDialog(null, result);
            return;
        }
        try {
            DoctorPojo doc = new DoctorPojo();
            doc.setDocId(jcDoctorId.getSelectedItem().toString());
            doc.setDocName(txtDoctorName.getText());
            String slectedGender = jcGender.getSelectedItem().toString();
            doc.setGender(slectedGender);;
            doc.setEmailId(txtEmailId.getText());
            doc.setQualification(txtQualification.getText());
            doc.setContactNo(txtContactNo.getText());
            doc.setSpecialist(txtSpecialist.getText());
            //-----------------------------------------------------------------
            UserPojo user=new UserPojo();
            user.setLoginId(txtLoginId.getText());
            String encPassword = new String(PasswordEncryption.getEncryptedPassword(password));
            user.setPassword(encPassword);;
            user.setUserType("Doctor");
            user.setUserName(txtDoctorName.getText());
            boolean res1 = UserDao.updateUser(user);
            boolean res2 = DoctorDao.updateDoctor(doc);
            if (res1 && res2) {
                JOptionPane.showMessageDialog(null, "Record updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearAll();
                return;
            }
            JOptionPane.showMessageDialog(null, "Record not updated!", "Failure!", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error In DB" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please input numeric value for salary", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtEmailIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailIdActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        JFrame frame = new ManageDoctors();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?", "Logging Out!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ans == JOptionPane.YES_OPTION) {
            JFrame frame = new LoginScreen();
            frame.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void rePwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rePwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rePwdActionPerformed

    private void jcDoctorIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcDoctorIdActionPerformed
        try {
            String docId = jcDoctorId.getSelectedItem().toString();
            DoctorPojo doc = DoctorDao.getDoctoretails(docId);
            txtDoctorName.setText(doc.getDocName());
            txtEmailId.setText(doc.getEmailId());
            jcGender.setSelectedItem(doc.getGender().toUpperCase());
            txtContactNo.setText(doc.getContactNo());
            txtQualification.setText(doc.getQualification());
            txtSpecialist.setText(doc.getSpecialist());
            String userName=txtDoctorName.getText();
            UserPojo user=UserDao.getUserDetails(userName);
            txtLoginId.setText(user.getLoginId());
            pwd.setText(user.getPassword());
            rePwd.setText(user.getPassword());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error In DB" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jcDoctorIdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jcDoctorId;
    private javax.swing.JComboBox<String> jcGender;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JPasswordField rePwd;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtDoctorName;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtLoginId;
    private javax.swing.JTextField txtQualification;
    private javax.swing.JTextField txtSpecialist;
    // End of variables declaration//GEN-END:variables

    private boolean validateInputs() {
        this.loginId = this.txtLoginId.getText().trim();
        char[] p1 = this.pwd.getPassword();
        char[] p2 = this.rePwd.getPassword();
        this.contactNo = txtContactNo.getText().trim();
        this.qualification = txtQualification.getText().trim();
        this.emailId = txtEmailId.getText().trim();
        this.specialist = txtSpecialist.getText().trim();
        if (loginId.isEmpty() || p1.length == 0 || p2.length == 0 || contactNo.isEmpty() || qualification.isEmpty() || emailId.isEmpty() || specialist.isEmpty()) {
            return false;
        }
        password = new String(p1);
        rePassword = new String(p2);
        return true;
    }
    
    private void loadDoctorsId() {
        try{
            List<String>docList=DoctorDao.getAllDoctorId();
            for(String docId:docList){
                jcDoctorId.addItem(docId);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error in DB:"+ex);
            ex.printStackTrace();
        }
    }
    
    private String matchPasswords() {
        if (password.length() < 3 || rePassword.length() < 3) {
            return "Passwords must be atleast 3 characters long";
        }
        if (password.equals(rePassword) == false) {
            return "Passwords do not match";
        }
        return null;
    }
    
    private void clearAll() {
        this.txtLoginId.setText("");
        this.txtDoctorName.setText("");
        this.rePwd.setText("");
        this.pwd.setText("");
        this.rePwd.setText("");
        this.txtEmailId.setText("");
        this.txtContactNo.setText("");
        this.txtQualification.setText("");
        this.txtSpecialist.setText("");
    }
}
