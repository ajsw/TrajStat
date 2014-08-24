/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trajstat.forms;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.meteoinfo.global.Extent;
import org.meteoinfo.global.GenericFileFilter;
import org.meteoinfo.global.MIMath;
import org.meteoinfo.global.PointD;
import org.meteoinfo.global.table.DataTypes;
import org.meteoinfo.layer.LayerDrawType;
import org.meteoinfo.layer.MapLayer;
import org.meteoinfo.layer.VectorLayer;
import org.meteoinfo.legend.LegendManage;
import org.meteoinfo.legend.LegendScheme;
import org.meteoinfo.plugin.IApplication;
import org.meteoinfo.shape.PolygonShape;
import org.meteoinfo.shape.ShapeTypes;
import trajstat.Main;

/**
 *
 * @author yaqiang
 */
public class FrmCreateGridLayer extends javax.swing.JDialog {

    private IApplication app;

    /**
     * Creates new form FrmCreateGridLayer
     */
    public FrmCreateGridLayer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        app = (IApplication) parent;
        this.jComboBox_Type.removeAllItems();
        this.jComboBox_Type.addItem("PSCF");
        this.jComboBox_Type.addItem("CWT");
        this.jComboBox_Type.setSelectedIndex(0);

        this.jComboBox_SameAsLayer.removeAllItems();
        this.jComboBox_SameAsLayer.addItem("None");
        for (MapLayer layer : app.getMapDocument().getActiveMapFrame().getMapView().getLayers()) {
            this.jComboBox_SameAsLayer.addItem(layer.getLayerName());
        }
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
        jLabel1 = new javax.swing.JLabel();
        jComboBox_SameAsLayer = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Left = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Right = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_CellSize = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_Bottom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_Top = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_Type = new javax.swing.JComboBox();
        jPanel_CWTField = new javax.swing.JPanel();
        jLabel_Width = new javax.swing.JLabel();
        jSpinner_Width = new javax.swing.JSpinner();
        jLabel_Precision = new javax.swing.JLabel();
        jSpinner_Precision = new javax.swing.JSpinner();
        jButton_CreateLayer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Grid Layer");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Setting"));

        jLabel1.setText("Extent same as:");

        jComboBox_SameAsLayer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_SameAsLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_SameAsLayerActionPerformed(evt);
            }
        });

        jLabel2.setText("Left:");

        jLabel3.setText("Right:");

        jLabel4.setText("Cell Size:");

        jTextField_CellSize.setText("1");

        jLabel5.setText("Bottom:");

        jLabel6.setText("Top:");

        jLabel7.setText("Type:");

        jComboBox_Type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_SameAsLayer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Bottom, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Top, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Left, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Right, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_CellSize, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_Type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox_SameAsLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_Left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_Right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_CellSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jTextField_Top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jComboBox_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField_Bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_CWTField.setBorder(javax.swing.BorderFactory.createTitledBorder("CWT Field"));

        jLabel_Width.setText("Width:");

        jLabel_Precision.setText("Precision:");

        javax.swing.GroupLayout jPanel_CWTFieldLayout = new javax.swing.GroupLayout(jPanel_CWTField);
        jPanel_CWTField.setLayout(jPanel_CWTFieldLayout);
        jPanel_CWTFieldLayout.setHorizontalGroup(
            jPanel_CWTFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_CWTFieldLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel_Width)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner_Width, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_Precision)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner_Precision, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel_CWTFieldLayout.setVerticalGroup(
            jPanel_CWTFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_CWTFieldLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_CWTFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_CWTFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_Precision)
                        .addComponent(jSpinner_Precision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_CWTFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_Width)
                        .addComponent(jSpinner_Width, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_CreateLayer.setText("Create Layer");
        jButton_CreateLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CreateLayerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_CWTField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jButton_CreateLayer, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel_CWTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_CreateLayer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_SameAsLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_SameAsLayerActionPerformed
        // TODO add your handling code here:
        if (this.jComboBox_SameAsLayer.getItemCount() > 0) {
            String layerName = this.jComboBox_SameAsLayer.getSelectedItem().toString();
            if (!layerName.equals("None")) {
                MapLayer layer = app.getMapDocument().getActiveMapFrame().getMapView().getLayerFromName(layerName);
                Extent extent = layer.getExtent();
                this.jTextField_Bottom.setText(String.valueOf(extent.minY));
                this.jTextField_Left.setText(String.valueOf(extent.minX));
                this.jTextField_Right.setText(String.valueOf(extent.maxX));
                this.jTextField_Top.setText(String.valueOf(extent.maxY));
            }
        }
    }//GEN-LAST:event_jComboBox_SameAsLayerActionPerformed

    private void jComboBox_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TypeActionPerformed
        // TODO add your handling code here:
        if (this.jComboBox_Type.getItemCount() > 0) {
            String type = this.jComboBox_Type.getSelectedItem().toString();
            if (type.equals("PSCF")) {
                this.jSpinner_Width.setValue(10);
                this.jSpinner_Precision.setValue(4);
                this.jPanel_CWTField.setEnabled(false);
                this.jLabel_Width.setEnabled(false);
                this.jLabel_Precision.setEnabled(false);
                this.jSpinner_Width.setEnabled(false);
                this.jSpinner_Precision.setEnabled(false);
            } else if (type.equals("CWT")) {
                this.jSpinner_Width.setValue(10);
                this.jSpinner_Precision.setValue(2);
                this.jPanel_CWTField.setEnabled(true);
                this.jLabel_Width.setEnabled(true);
                this.jLabel_Precision.setEnabled(true);
                this.jSpinner_Width.setEnabled(true);
                this.jSpinner_Precision.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jComboBox_TypeActionPerformed

    private void jButton_CreateLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CreateLayerActionPerformed
        // TODO add your handling code here:
        //---- Get the parameters
        if (this.jTextField_Bottom.getText().isEmpty() || this.jTextField_CellSize.getText().isEmpty()
                || this.jTextField_Left.getText().isEmpty() || this.jTextField_Right.getText().isEmpty()
                || this.jTextField_Top.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please finish setting first!");
            return;
        }
        double aLeft = Double.parseDouble(this.jTextField_Left.getText());
        double aRight = Double.parseDouble(this.jTextField_Right.getText());
        double aTop = Double.parseDouble(this.jTextField_Top.getText());
        double aBottom = Double.parseDouble(this.jTextField_Bottom.getText());
        double aCellSize = Double.parseDouble(this.jTextField_CellSize.getText());
        if ((aRight <= aLeft | (aTop <= aBottom))) {
            JOptionPane.showMessageDialog(null, "Invalid extent! Please reinput!");
            return;
        }
        int xNum = (int) ((aRight - aLeft) / aCellSize);
        int yNum = (int) ((aTop - aBottom) / aCellSize);

        //---- Show progressbar
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        //---- Create layer
        String type = this.jComboBox_Type.getSelectedItem().toString();
        if (type.equals("PSCF")) {
            try {
                create_PSCFLayer(xNum, yNum, aLeft, aTop, aCellSize);
            } catch (IOException ex) {
                Logger.getLogger(FrmCreateGridLayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (type.equals("CWT")) {
            try {
                create_CWTLayer(xNum, yNum, aLeft, aTop, aCellSize);
            } catch (IOException ex) {
                Logger.getLogger(FrmCreateGridLayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //---- Hide progressbar
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_jButton_CreateLayerActionPerformed

    private void create_PSCFLayer(int xNum, int yNum, double aLeft, double aTop, double aCellSize) throws IOException {
        //---- Create layer
        //---- Create new shape file
        String userPath = System.getProperty("user.dir");
        File pathDir = new File(userPath);
        JFileChooser aDlg = new JFileChooser();
        String[] fileExts = {"shp"};
        GenericFileFilter pFileFilter = new GenericFileFilter(fileExts, "Shape File (*.shp)");
        aDlg.setFileFilter(pFileFilter);
        aDlg.setAcceptAllFileFilterUsed(false);
        aDlg.setCurrentDirectory(pathDir);
        if (JFileChooser.APPROVE_OPTION == aDlg.showOpenDialog((JFrame)app)) {
            File file = aDlg.getSelectedFile();
            String shpfn = file.getCanonicalPath();
            System.setProperty("user.dir", file.getParent());
            String extent = ((GenericFileFilter) aDlg.getFileFilter()).getFileExtent();
            if (!shpfn.substring(shpfn.length() - extent.length()).equals(extent)) {
                shpfn = shpfn + "." + extent;
                file = new File(shpfn);
            }

            int i = 0;
            int j = 0;
            VectorLayer aLayer = new VectorLayer(ShapeTypes.Polygon);
            aLayer.editAddField("ID", DataTypes.Integer);
            aLayer.editAddField("Nij", DataTypes.Integer);
            aLayer.editAddField("Mij", DataTypes.Integer);
            aLayer.editAddField("PSCF", DataTypes.Double);
            aLayer.editAddField("WPSCF", DataTypes.Double);

            double aX;
            double aY;
            for (j = 0; j <= yNum - 1; j++) {
                for (i = 0; i <= xNum - 1; i++) {
                    PolygonShape aPGS = new PolygonShape();

                    List<PointD> pList = new ArrayList<PointD>();
                    PointD newPt = new PointD();
                    aX = aLeft + i * aCellSize;
                    aY = aTop - j * aCellSize;
                    newPt.X = aX;
                    newPt.Y = aY;
                    pList.add(newPt);
                    newPt = new PointD();
                    aX = aX + aCellSize;
                    newPt.X = aX;
                    newPt.Y = aY;
                    pList.add(newPt);
                    newPt = new PointD();
                    aY = aY - aCellSize;
                    newPt.X = aX;
                    newPt.Y = aY;
                    pList.add(newPt);
                    newPt = new PointD();
                    aX = aX - aCellSize;
                    newPt.X = aX;
                    newPt.Y = aY;
                    pList.add(newPt);
                    pList.add(pList.get(0));

                    aPGS.setPoints(pList);
                    aPGS.setExtent(MIMath.getPointsExtent(aPGS.getPoints()));
                    int shapeNum = aLayer.getShapeNum();
                    try {
                        if (aLayer.editInsertShape(aPGS, shapeNum)) {
                            aLayer.editCellValue("ID", shapeNum, shapeNum + 1);
                            aLayer.editCellValue("Nij", shapeNum, 0);
                            aLayer.editCellValue("Mij", shapeNum, 0);
                            aLayer.editCellValue("PSCF", shapeNum, 0.0);
                            aLayer.editCellValue("WPSCF", shapeNum, 0.0);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(FrmCreateGridLayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            if (aLayer.getShapeNum() > 0) {
                aLayer.setLayerName(file.getName());
                LegendScheme aLS = LegendManage.createSingleSymbolLegendScheme(ShapeTypes.Polygon, Color.yellow, 1.0f);
                aLS.setFieldName("ID");
                aLayer.setLegendScheme(aLS);
                aLayer.setLayerDrawType(LayerDrawType.GridFill);
                aLayer.setFileName(shpfn);
                aLayer.saveFile(shpfn);
            } else {
                JOptionPane.showMessageDialog(null, "No valid shapes created.");
                return;
            }

            //---- Add layer to legend
            Main.addLayer(aLayer, app.getMapDocument().getActiveMapFrame(), "PSCF");
        }
    }

    private void create_CWTLayer(int xNum, int yNum, double aLeft, double aTop, double aCellSize) throws IOException {
        //---- Create layer
        //---- Create new shape file
        String userPath = System.getProperty("user.dir");
        File pathDir = new File(userPath);
        JFileChooser aDlg = new JFileChooser();
        String[] fileExts = {"shp"};
        GenericFileFilter pFileFilter = new GenericFileFilter(fileExts, "Shape File (*.shp)");
        aDlg.setFileFilter(pFileFilter);
        aDlg.setAcceptAllFileFilterUsed(false);
        aDlg.setCurrentDirectory(pathDir);
        if (JFileChooser.APPROVE_OPTION == aDlg.showOpenDialog((JFrame)app)) {
            File file = aDlg.getSelectedFile();
            String shpfn = file.getCanonicalPath();
            System.setProperty("user.dir", file.getParent());
            String extent = ((GenericFileFilter) aDlg.getFileFilter()).getFileExtent();
            if (!shpfn.substring(shpfn.length() - extent.length()).equals(extent)) {
                shpfn = shpfn + "." + extent;
                file = new File(shpfn);
            }

            int i = 0;
            int j = 0;
            VectorLayer aLayer = new VectorLayer(ShapeTypes.Polygon);
            aLayer.editAddField("ID", DataTypes.Integer);
            aLayer.editAddField("Nij", DataTypes.Integer);
            aLayer.editAddField("CWT", DataTypes.Double);
            aLayer.editAddField("WCWT", DataTypes.Double);

            double aX;
            double aY;
            for (j = 0; j <= yNum - 1; j++) {
                for (i = 0; i <= xNum - 1; i++) {
                    PolygonShape aPGS = new PolygonShape();
                    List<PointD> pList = new ArrayList<PointD>();
                    PointD newPt = new PointD();
                    aX = aLeft + i * aCellSize;
                    aY = aTop - j * aCellSize;
                    newPt.X = aX;
                    newPt.Y = aY;
                    pList.add(newPt);
                    newPt = new PointD();
                    aX = aX + aCellSize;
                    newPt.X = aX;
                    newPt.Y = aY;
                    pList.add(newPt);
                    newPt = new PointD();
                    aY = aY - aCellSize;
                    newPt.X = aX;
                    newPt.Y = aY;
                    pList.add(newPt);
                    newPt = new PointD();
                    aX = aX - aCellSize;
                    newPt.X = aX;
                    newPt.Y = aY;
                    pList.add(newPt);
                    pList.add(pList.get(0));

                    aPGS.setPoints(pList);
                    aPGS.setExtent(MIMath.getPointsExtent(aPGS.getPoints()));
                    int shapeNum = aLayer.getShapeNum();
                    try {
                        if (aLayer.editInsertShape(aPGS, shapeNum)) {
                            aLayer.editCellValue("ID", shapeNum, shapeNum + 1);
                            aLayer.editCellValue("Nij", shapeNum, 0);
                            aLayer.editCellValue("CWT", shapeNum, 0.0);
                            aLayer.editCellValue("WCWT", shapeNum, 0.0);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(FrmCreateGridLayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            if (aLayer.getShapeNum() > 0) {
                aLayer.setLayerName(file.getName());
                LegendScheme aLS = LegendManage.createSingleSymbolLegendScheme(ShapeTypes.Polygon, Color.yellow, 1.0f);
                aLS.setFieldName("ID");
                aLayer.setLegendScheme(aLS);
                aLayer.setLayerDrawType(LayerDrawType.GridFill);
                aLayer.setFileName(shpfn);
                aLayer.saveFile(shpfn);
            } else {
                JOptionPane.showMessageDialog(null, "No valid shapes created.");
                return;
            }

            //---- Add layer to legend
            Main.addLayer(aLayer, app.getMapDocument().getActiveMapFrame(), "CWT");
        }
    }

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
            java.util.logging.Logger.getLogger(FrmCreateGridLayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCreateGridLayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCreateGridLayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCreateGridLayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmCreateGridLayer dialog = new FrmCreateGridLayer(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_CreateLayer;
    private javax.swing.JComboBox jComboBox_SameAsLayer;
    private javax.swing.JComboBox jComboBox_Type;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Precision;
    private javax.swing.JLabel jLabel_Width;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_CWTField;
    private javax.swing.JSpinner jSpinner_Precision;
    private javax.swing.JSpinner jSpinner_Width;
    private javax.swing.JTextField jTextField_Bottom;
    private javax.swing.JTextField jTextField_CellSize;
    private javax.swing.JTextField jTextField_Left;
    private javax.swing.JTextField jTextField_Right;
    private javax.swing.JTextField jTextField_Top;
    // End of variables declaration//GEN-END:variables

    private Component JFrame(IApplication app) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
