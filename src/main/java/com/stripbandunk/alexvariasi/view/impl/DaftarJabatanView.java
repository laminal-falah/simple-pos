/*
 *  Copyright (c) 2011, StripBandunk and/or its affiliates. All rights reserved.
 * 
 *       http://stripbandunk.com/
 * 
 *  STRIPBANDUNK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * DaftarJabatanView.java
 *
 * Created on Nov 23, 2011, 2:54:09 PM
 */
package com.stripbandunk.alexvariasi.view.impl;

import com.stripbandunk.alexvariasi.entity.master.Jabatan;
import com.stripbandunk.alexvariasi.manager.SpringManager;
import com.stripbandunk.alexvariasi.service.JabatanService;
import com.stripbandunk.alexvariasi.view.FormApp;
import com.stripbandunk.alexvariasi.view.View;
import com.stripbandunk.jwidget.JDynamicTable;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.List;

/**
 *
 * @author echo
 */
public class DaftarJabatanView extends javax.swing.JPanel implements View {

    private static final long serialVersionUID = 1L;

    private JDynamicTable jDynamicTable;

    private DynamicTableModel<Jabatan> dynamicTableModel;

    /** Creates new form DaftarJabatanView */
    public DaftarJabatanView() {
        initComponents();

        dynamicTableModel = new DynamicTableModel<>(Jabatan.class);

        jDynamicTable = new JDynamicTable(dynamicTableModel);
        jScrollPaneJabatan.setViewportView(jDynamicTable);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBarJabatan = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jScrollPaneJabatan = new javax.swing.JScrollPane();

        setLayout(new java.awt.BorderLayout());

        jToolBarJabatan.setRollover(true);
        jToolBarJabatan.setName("jToolBarJabatan"); // NOI18N

        jButton1.setText("Tambah Jabatan Baru");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBarJabatan.add(jButton1);

        add(jToolBarJabatan, java.awt.BorderLayout.PAGE_START);

        jScrollPaneJabatan.setName("jScrollPaneJabatan"); // NOI18N
        add(jScrollPaneJabatan, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPaneJabatan;
    private javax.swing.JToolBar jToolBarJabatan;
    // End of variables declaration//GEN-END:variables

    @Override
    public void view(FormApp formApp) {
        JabatanService jabatanService = SpringManager.getInstance().getBean(JabatanService.class);
        dynamicTableModel.clear();

        List<Jabatan> list = jabatanService.findAll();
        for (Jabatan jabatan : list) {
            dynamicTableModel.add(jabatan);
        }
    }
}
