/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiFiles;

import SourceFiles.Main;
import SourceFiles.Staff;
import javax.swing.JOptionPane;

/**
 *
 * @author jhw
 */
public class AddStaff extends javax.swing.JFrame {

    /**
     * Creates new form AddStaff
     */
    public AddStaff() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaAddr = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        cmbType = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtSpec = new javax.swing.JTextField();
        ClearButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtnic = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        DOB = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Add Staff");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("First Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));
        jPanel1.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 320, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Last Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));
        jPanel1.add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 320, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Contact Number");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Home");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        txtHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHomeActionPerformed(evt);
            }
        });
        jPanel1.add(txtHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 240, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Mobile");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));
        jPanel1.add(txtMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 240, -1));

        jLabel7.setText("Address");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        txtaAddr.setColumns(20);
        txtaAddr.setRows(5);
        jScrollPane1.setViewportView(txtaAddr);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 240, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Type");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, -1));

        SaveButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SaveButton.setText("SAVE");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 640, -1, -1));

        BackButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BackButton.setText("BACK");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        jPanel1.add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 640, -1, -1));

        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doctor", "Nurse", "Attendent", "Maintainence Staff" }));
        jPanel1.add(cmbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Specialization");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, -1, -1));
        jPanel1.add(txtSpec, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 240, -1));

        ClearButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ClearButton.setText("CLEAR");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 640, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("ID");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));
        jPanel1.add(txtnic, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 230, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Date of Birth");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));
        jPanel1.add(DOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 150, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Gender");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, 20));

        buttonGroup1.add(rbMale);
        rbMale.setText("Male");
        jPanel1.add(rbMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        buttonGroup1.add(rbFemale);
        rbFemale.setText("Female");
        jPanel1.add(rbFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHomeActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        Staff stf = new Staff(0,Integer.parseInt(txtnic.getText()),txtFname.getText(),txtLname.getText(),String.format("%1$tY-%1$tm-%1$td", DOB.getDate()),(rbMale.isSelected()?"Male":"Female"),cmbType.getSelectedItem().toString(),Integer.parseInt(txtHome.getText()),Integer.parseInt(txtMobile.getText()),txtaAddr.getText(),txtSpec.getText());
        try {
            int id = stf.addToDb();
            JOptionPane.showMessageDialog(null,"Staff added successfully");
            System.out.println(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        txtnic.setText("");
        txtFname.setText("");
        txtLname.setText("");
        DOB.setDate(null);
        rbFemale.setSelected(false);
        rbMale.setSelected(false);
        txtHome.setText("");
        txtMobile.setText("");
        txtaAddr.setText("");
        txtSpec.setText("");
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        Main.mainFrame.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ClearButton;
    private com.toedter.calendar.JDateChooser DOB;
    private javax.swing.JButton SaveButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtHome;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtSpec;
    private javax.swing.JTextArea txtaAddr;
    private javax.swing.JTextField txtnic;
    // End of variables declaration//GEN-END:variables
}
