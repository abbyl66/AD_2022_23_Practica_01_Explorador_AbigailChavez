
package Vista;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controlador.Metodos;
import java.awt.Color;


/**
 *
 * @author Abby
 */
public class ExploradorAc extends javax.swing.JFrame {


    public ExploradorAc() {
        initComponents();
        
        //Deshabilitamos para prevenir algún error
        tArchivos.setEnabled(false);
        txtExtension.setEditable(false);
        bExtension.setEnabled(false);
        lExisteRuta.setVisible(false);
        
        getContentPane().setBackground(Color.WHITE);
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDirectorio = new javax.swing.JTextField();
        txtExtension = new javax.swing.JTextField();
        bDirectorio = new javax.swing.JButton();
        bExtension = new javax.swing.JButton();
        lExisteRuta = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tArchivos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Indique el directorio:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Indique la extensión:");

        txtDirectorio.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDirectorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirectorioKeyTyped(evt);
            }
        });

        txtExtension.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtExtension.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExtensionKeyTyped(evt);
            }
        });

        bDirectorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/buscar.png"))); // NOI18N
        bDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDirectorioActionPerformed(evt);
            }
        });

        bExtension.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/buscar.png"))); // NOI18N
        bExtension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExtensionActionPerformed(evt);
            }
        });

        lExisteRuta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lExisteRuta.setForeground(new java.awt.Color(204, 0, 51));
        lExisteRuta.setText("LA RUTA NO EXISTE");

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel3.setText("EXPLORADOR DE ARCHIVOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDirectorio, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(txtExtension))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(lExisteRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDirectorio)
                    .addComponent(bDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtExtension)
                    .addComponent(bExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(53, 53, 53)
                .addComponent(lExisteRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tArchivos.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tArchivos.setForeground(new java.awt.Color(102, 102, 102));
        tArchivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Extensión", "Tamaño", "F/D"
            }
        ));
        tArchivos.setToolTipText("");
        tArchivos.setGridColor(new java.awt.Color(234, 207, 190));
        tArchivos.setSelectionBackground(new java.awt.Color(234, 207, 190));
        jScrollPane1.setViewportView(tArchivos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDirectorioActionPerformed
        
        tArchivos.removeAll();
        
        //Creamos objeto de tipo Metodos para hacer uso de este.
        Metodos metodos =  new Metodos();
        
        metodos.buscarDirectorio(txtDirectorio.getText(), lExisteRuta, tArchivos, txtExtension, bExtension);
        
        
    }//GEN-LAST:event_bDirectorioActionPerformed

    private void bExtensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExtensionActionPerformed
        
        //Creamos un objeto de tipo Métodos para hacer uso de este.
        Metodos metodos = new Metodos();
        
       metodos.filtroExtension(txtDirectorio.getText(), lExisteRuta, tArchivos, txtExtension, bExtension);
        
        
    }//GEN-LAST:event_bExtensionActionPerformed

    private void txtExtensionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExtensionKeyTyped
        //En caso de que pongan la extensión con el punto. (.pdf) o dejen un espacio en blanco.
        char controlCaracter = evt.getKeyChar();
        
        if( controlCaracter == '.' || controlCaracter == ' '){
            evt.consume(); //No se lo permitirá
        }
    }//GEN-LAST:event_txtExtensionKeyTyped

    private void txtDirectorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirectorioKeyTyped
        //En caso de que pongan la ruta o dejen un espacio en blanco.
        char controlCaracter = evt.getKeyChar();
        
        if(controlCaracter == ' '){
            evt.consume(); //No se lo permitirá
        }
    }//GEN-LAST:event_txtDirectorioKeyTyped


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExploradorAc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDirectorio;
    private javax.swing.JButton bExtension;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lExisteRuta;
    private javax.swing.JTable tArchivos;
    private javax.swing.JTextField txtDirectorio;
    private javax.swing.JTextField txtExtension;
    // End of variables declaration//GEN-END:variables
}
