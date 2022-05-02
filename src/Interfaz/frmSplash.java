package Interfaz;

import Clases.COMPROBAR_CONEXION;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class frmSplash extends javax.swing.JFrame {

public static Connection  con = null;
COMPROBAR_CONEXION cargando = new COMPROBAR_CONEXION();

    public frmSplash() {

        initComponents();

               conexion();


        this.setLocationRelativeTo(null);


        Cargando Cargando = new Cargando();
        Cargando.start();
        Cargando = null;

        CargandoDatos CargandoDatos = new CargandoDatos();
        CargandoDatos.start();
        CargandoDatos = null;

    }

        public Connection conexion(){
            try {
                if(con == null){
                   con = new Controlador.Conexion().con();
                }
            } catch (Exception e) {
            }
            return con;
        }
    class Cargando extends Thread{
          public Cargando(){super(); }
          @Override
               public void run(){
                      setProgresoMax(130); //120
                      velocidadDeCarga();
               }
    }

        class CargandoDatos extends Thread{
          public CargandoDatos(){super(); }
          @Override
               public void run(){
                      velocidadDeCargaDatos();
               }
    }

    public void setProgresoMax(int maxProgress){
           progressBar.setMaximum(maxProgress);
    }

    public void setProgreso(int progress){
           final int progreso = progress;
           progressBar.setValue(progreso);
    }

    public void velocidadDeCarga(){
           for (int i = 0; i <= 200; i++){
                for (long j=0; j<400000; ++j){ //90000
                     String poop = " " + (j + i);
                }
                setProgreso(i);  // si quieres q muestre los numeros y un mensaje
           }
    }

       @SuppressWarnings("static-access")
    public void velocidadDeCargaDatos() {
        try {
            LinkedList list = cargando.listar(con);
            Iterator It_List = list.iterator();
            Thread.sleep(100); //100
            while (It_List.hasNext()) {
                COMPROBAR_CONEXION artx = (COMPROBAR_CONEXION) It_List.next();
                Thread.sleep(130); //130
                carga.setText(artx.getCm_nombre());
                Thread.sleep(200); //200
            }
            Thread.sleep(200); //200
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        new frm_Login().setVisible(true);
        dispose();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();
        carga = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        progressBar.setForeground(new java.awt.Color(0, 0, 0));
        progressBar.setAlignmentX(0.3F);
        progressBar.setPreferredSize(new java.awt.Dimension(146, 9));

        carga.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        carga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        carga.setText("Realizando Conexion a la BD...");
        carga.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Carga/ajax-loader.gif"))); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/LOGO/Logo.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(carga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmSplash().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
