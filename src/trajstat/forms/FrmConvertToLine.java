/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trajstat.forms;

import java.awt.Cursor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.meteoinfo.global.GenericFileFilter;
import org.meteoinfo.ui.CheckBoxListEntry;
import org.meteoinfo.layer.VectorLayer;
import org.meteoinfo.legend.GroupNode;
import org.meteoinfo.legend.LayerNode;
import org.meteoinfo.plugin.IApplication;
import org.meteoinfo.shape.PointZ;
import org.meteoinfo.shape.PolylineZShape;
import trajstat.Main;

/**
 *
 * @author wyq
 */
public class FrmConvertToLine extends javax.swing.JDialog {

    private IApplication app;

    /**
     * Creates new form FrmConvertToLine
     */
    public FrmConvertToLine(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        app = (IApplication) parent;
        GroupNode gNode = app.getMapDocument().getActiveMapFrame().getGroupByName("Trajectory");
        DefaultListModel listModel = new DefaultListModel();
        for (LayerNode lNode : gNode.getLayers()) {
            listModel.addElement(new CheckBoxListEntry(lNode.getMapLayer(), true));
        }
        this.checkBoxList_Data.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        checkBoxList_Data = new org.meteoinfo.ui.JCheckBoxList();
        jLabel1 = new javax.swing.JLabel();
        jButton_SelAll = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField_PointInterval = new javax.swing.JTextField();
        jButton_OK = new javax.swing.JButton();
        jButton_Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        checkBoxList_Data.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(checkBoxList_Data);

        jLabel1.setText("Trajectory layers:");

        jButton_SelAll.setText("Select All");
        jButton_SelAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SelAllActionPerformed(evt);
            }
        });

        jLabel2.setText("Point interval:");

        jTextField_PointInterval.setText("1");

        jButton_OK.setText("OK");
        jButton_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OKActionPerformed(evt);
            }
        });

        jButton_Cancel.setText("Cancel");
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_SelAll, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_PointInterval, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jButton_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Cancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_SelAll)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_PointInterval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_OK)
                    .addComponent(jButton_Cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SelAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SelAllActionPerformed
        // TODO add your handling code here:
        int i;
        DefaultListModel listModel = (DefaultListModel) this.checkBoxList_Data.getModel();
        if (this.jButton_SelAll.getText().equals("Select All")) {
            for (i = 0; i < listModel.getSize(); i++) {
                ((CheckBoxListEntry) listModel.get(i)).setSelected(true);
            }
            this.jButton_SelAll.setText("Unselect All");
        } else {
            for (i = 0; i < listModel.getSize(); i++) {
                ((CheckBoxListEntry) listModel.get(i)).setSelected(false);
            }
            this.jButton_SelAll.setText("Select All");
        }
        this.checkBoxList_Data.repaint();
    }//GEN-LAST:event_jButton_SelAllActionPerformed

    private void jButton_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OKActionPerformed
        // TODO add your handling code here:
        String userPath = System.getProperty("user.dir");
        File pathDir = new File(userPath);
        JFileChooser aDlg = new JFileChooser();
        String[] fileExts = {"lcd"};
        GenericFileFilter pFileFilter = new GenericFileFilter(fileExts, "Line Data File (*.lcd)");
        aDlg.setFileFilter(pFileFilter);
        aDlg.setAcceptAllFileFilterUsed(false);
        aDlg.setCurrentDirectory(pathDir);
        if (JFileChooser.APPROVE_OPTION == aDlg.showOpenDialog((JFrame) app)) {
            File file = aDlg.getSelectedFile();
            String lcdfn = "";
            try {
                lcdfn = file.getCanonicalPath();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.setProperty("user.dir", file.getParent());
            String extent = ((GenericFileFilter) aDlg.getFileFilter()).getFileExtent();
            if (!lcdfn.substring(lcdfn.length() - extent.length()).equals(extent)) {
                lcdfn = lcdfn + "." + extent;
            }

            convertToLineFile(lcdfn);
        }
        this.dispose();
    }//GEN-LAST:event_jButton_OKActionPerformed

    private void convertToLineFile(final String outFile) {
        SwingWorker worker = new SwingWorker<String, String>() {
            @Override
            protected String doInBackground() throws Exception {
                int i, j;
                int aInterval = Integer.parseInt(FrmConvertToLine.this.jTextField_PointInterval.getText());

                //---- Get selected layers
                List<VectorLayer> layers = new ArrayList<VectorLayer>();
                DefaultListModel listModel = (DefaultListModel) FrmConvertToLine.this.checkBoxList_Data.getModel();
                for (i = 0; i < listModel.getSize(); i++) {
                    if (((CheckBoxListEntry) listModel.get(i)).isSelected()) {
                        layers.add((VectorLayer) ((CheckBoxListEntry) listModel.get(i)).getValue());
                    }
                }

                if (layers.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No Trajectory layer was selected!");
                    return "";
                }

                FrmConvertToLine.this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                app.getProgressBar().setVisible(true);
                app.getProgressBar().setValue(0);
                app.getProgressBarLabel().setVisible(true);
                app.getProgressBarLabel().setText("...");

                //---- Loop
                int sNum = 0;                
                Date aDate;
                BufferedWriter sw = new BufferedWriter(new FileWriter(new File(outFile)));
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
                for (VectorLayer layer : layers) {
                    app.getProgressBarLabel().setText(layer.getLayerName());
                    String aLine;
                    PointZ aPoint;
                    sNum = layer.getShapeNum();                    
                    for (i = 0; i < sNum; i++) {
                        aDate = (Date) layer.getCellValue("Date", i);
                        cal.setTime(aDate);
                        int hour = Integer.parseInt(layer.getCellValue("Hour", i).toString());
                        cal.set(Calendar.HOUR_OF_DAY, hour);
                        aLine = format.format(cal.getTime());
                        String height = layer.getCellValue("Height", i).toString();
                        aLine = aLine + "," + height;
                        PolylineZShape aPLZ = (PolylineZShape) layer.getShapes().get(i);
                        for (j = 0; j < aPLZ.getPointNum(); j++) {
                            if (j % aInterval == 0) {
                                aPoint = (PointZ) aPLZ.getPoints().get(j);
                                aLine = aLine + "," + String.format("%.2f", aPoint.Y) + ","
                                        + String.format("%.2f", aPoint.X)
                                        + "," + String.format("%.2f", aPoint.Z);
                            }
                        }
                        sw.write(aLine);
                        sw.newLine();
                        app.getProgressBar().setValue((int) ((double) (i + 1) / sNum * 100));
                    }
                }
                sw.close();

                return "";
            }

            @Override
            protected void done() {
                app.getProgressBar().setVisible(false);
                app.getProgressBarLabel().setVisible(false);
                FrmConvertToLine.this.setCursor(null);
            }
        };
        worker.execute();
    }

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        // TODO add your handling code here:        
        this.dispose();
    }//GEN-LAST:event_jButton_CancelActionPerformed

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
            java.util.logging.Logger.getLogger(FrmConvertToLine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConvertToLine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConvertToLine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConvertToLine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmConvertToLine dialog = new FrmConvertToLine(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.meteoinfo.ui.JCheckBoxList checkBoxList_Data;
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JButton jButton_OK;
    private javax.swing.JButton jButton_SelAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField_PointInterval;
    // End of variables declaration//GEN-END:variables
}