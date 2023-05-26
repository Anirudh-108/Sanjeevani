/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sanjeevaniapp.gui;

import java.util.Map;
import java.util.Set;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sanjeevaniapp.dao.EmpDao;
import sanjeevaniapp.dao.ReceptionistDao;
import sanjeevaniapp.dao.UserDao;
import sanjeevaniapp.pojo.ReceptionistPojo;
import sanjeevaniapp.pojo.UserPojo;
import sanjeevaniapp.utility.PasswordEncryption;

/**
 *
 * @author ACER
 */
public class AddReceptionist extends javax.swing.JFrame {

    /**
     * Creates new form AddReceptionist
     */
    private Map<String, String> unRegRecepList;
    private String selEmpName, selEmpId, loginId;
    private String password, rePassword;

    public AddReceptionist() {
        initComponents();
        setLocationRelativeTo(null);
        loadReceptionistDetails();
        getNewRecepId();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRecId = new javax.swing.JTextField();
        jcEmpId = new javax.swing.JComboBox<>();
        btnRegisterRecp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRecName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcGender = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        Pwd = new javax.swing.JPasswordField();
        RePwd = new javax.swing.JPasswordField();
        txtLoginId = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Receptionist");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 390, 50));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 35)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Sanjeevani Application");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "Add Receptionist", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Employee ID");

        txtRecId.setEditable(false);
        txtRecId.setBackground(new java.awt.Color(255, 255, 255));
        txtRecId.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtRecId.setForeground(new java.awt.Color(0, 0, 0));
        txtRecId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecIdActionPerformed(evt);
            }
        });

        jcEmpId.setBackground(new java.awt.Color(255, 255, 255));
        jcEmpId.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jcEmpId.setForeground(new java.awt.Color(0, 0, 0));
        jcEmpId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEmpIdActionPerformed(evt);
            }
        });

        btnRegisterRecp.setBackground(new java.awt.Color(204, 204, 204));
        btnRegisterRecp.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnRegisterRecp.setForeground(new java.awt.Color(0, 0, 0));
        btnRegisterRecp.setText("Register");
        btnRegisterRecp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterRecpActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Receptionist ID");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Login ID");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Receptionist Name");

        txtRecName.setEditable(false);
        txtRecName.setBackground(new java.awt.Color(255, 255, 255));
        txtRecName.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtRecName.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Password");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Gender");

        jcGender.setBackground(new java.awt.Color(255, 255, 255));
        jcGender.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jcGender.setForeground(new java.awt.Color(0, 0, 0));
        jcGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));

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

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Retype");

        Pwd.setBackground(new java.awt.Color(255, 255, 255));
        Pwd.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        Pwd.setForeground(new java.awt.Color(0, 0, 0));

        RePwd.setBackground(new java.awt.Color(255, 255, 255));
        RePwd.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        RePwd.setForeground(new java.awt.Color(0, 0, 0));

        txtLoginId.setBackground(new java.awt.Color(255, 255, 255));
        txtLoginId.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtLoginId.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcEmpId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRecId)
                            .addComponent(txtRecName)
                            .addComponent(jcGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(Pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RePwd, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtLoginId))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnRegisterRecp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRecId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtRecName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLoginId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15)
                    .addComponent(Pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RePwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegisterRecp)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnLogout))
                .addGap(22, 22, 22))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 1090, 370));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sanjeevaniapp/images/HomePageBG1.jpg"))); // NOI18N
        jLabel14.setText("jLabel14");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 1050, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?", "Logging Out!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ans == JOptionPane.YES_OPTION) {
            JFrame frame = new LoginScreen();
            frame.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        JFrame frame = new ManageReceptionists();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRegisterRecpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterRecpActionPerformed
        if (validateInputs() == false) {
            JOptionPane.showMessageDialog(null, "Please input all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String result = matchPasswords();
        if (result != null) {
            JOptionPane.showMessageDialog(null, result);
            return;
        }
        try {
            ReceptionistPojo recep = new ReceptionistPojo();
            recep.setReceptionistId(txtRecId.getText());
            recep.setReceptionistName(selEmpName);
            recep.setGender(jcGender.getSelectedItem().toString());
            UserPojo user = new UserPojo();
            user.setLoginId(loginId);
            String encPassword = new String(PasswordEncryption.getEncryptedPassword(password));
            user.setPassword(encPassword);
            user.setUserType("Receptionist");
            user.setUserName(selEmpName);
            boolean resp1 = UserDao.addUser(user);
            boolean resp2 = ReceptionistDao.addReceptionist(recep);
            if (resp1 == true && resp2 == true) {
                JOptionPane.showMessageDialog(null, "Receptionist registered successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearAll();
                this.getNewRecepId();
                return;
            }
            JOptionPane.showMessageDialog(null, "Receptionist not registered", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in DB:" + ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnRegisterRecpActionPerformed

    private void txtRecIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecIdActionPerformed

    }//GEN-LAST:event_txtRecIdActionPerformed

    private void jcEmpIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEmpIdActionPerformed
        if (jcEmpId.getSelectedIndex() == -1) {
            return;
        }
        selEmpId = jcEmpId.getSelectedItem().toString();
        selEmpName = unRegRecepList.get(selEmpId);
        txtRecName.setText(selEmpName);
    }//GEN-LAST:event_jcEmpIdActionPerformed

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
            java.util.logging.Logger.getLogger(AddReceptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddReceptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddReceptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddReceptionist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddReceptionist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Pwd;
    private javax.swing.JPasswordField RePwd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRegisterRecp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jcEmpId;
    private javax.swing.JComboBox<String> jcGender;
    private javax.swing.JTextField txtLoginId;
    private javax.swing.JTextField txtRecId;
    private javax.swing.JTextField txtRecName;
    // End of variables declaration//GEN-END:variables

    private void loadReceptionistDetails() {
        try {
            unRegRecepList = EmpDao.getUnRegisteredReceptionists();
            Set<String> recIdSet = unRegRecepList.keySet();
            for (String id : recIdSet) {
                jcEmpId.addItem(id);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in DB:" + ex);
            ex.printStackTrace();
        }
    }

    private void getNewRecepId() {
        try {
            String recId = ReceptionistDao.getNewRecId();
            txtRecId.setText(recId);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in DB:" + ex);
            ex.printStackTrace();
        }
    }

    private boolean validateInputs() {
        loginId = txtLoginId.getText().trim();
        char[] pw1 = this.Pwd.getPassword();
        char[] pw2 = this.RePwd.getPassword();
        if (loginId.isEmpty() || pw1.length == 0 || pw2.length == 0) {
            return false;
        }
        password = new String(pw1).trim();
        rePassword = new String(pw2).trim();
        return true;
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
        txtLoginId.setText("");
        this.Pwd.setText("");
        this.RePwd.setText("");
        this.unRegRecepList.remove(selEmpId);
        this.jcEmpId.removeItem(selEmpId);
        if (unRegRecepList.size() == 0) {
            JOptionPane.showMessageDialog(null, "All receptionists registered!", "", JOptionPane.INFORMATION_MESSAGE);
            ManageReceptionists manageRecep = new ManageReceptionists();
            manageRecep.setVisible(true);
            this.dispose();
        }
    }
}