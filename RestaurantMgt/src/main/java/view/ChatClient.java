package view;

/*
 * ChatClient.java
 *
 * Created on February 19, 2010, 12:03 PM
 */



import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author  HoangDung
 */
public class ChatClient extends javax.swing.JFrame {
    
    /** Creates new form ChatClient */
    public ChatClient() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }
        getContentPane().setBackground(new Color(212,208,200));
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlConnect = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        txtClientName = new javax.swing.JTextField();
        btnSignIn = new javax.swing.JButton();
        btnSignOut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaChat = new javax.swing.JTextArea();
        pnlSendMessage = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        scpMessage = new javax.swing.JScrollPane();
        txaMessage = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Client");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 387, 200));

        pnlConnect.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlConnect.setMaximumSize(new java.awt.Dimension(387, 200));
        pnlConnect.setMinimumSize(new java.awt.Dimension(387, 200));

        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Give your name and then click Sign In button");
        lblHeader.setPreferredSize(new java.awt.Dimension(310, 20));
        pnlConnect.add(lblHeader);

        txtClientName.setPreferredSize(new java.awt.Dimension(180, 20));
        pnlConnect.add(txtClientName);

        btnSignIn.setText("Sign In");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        pnlConnect.add(btnSignIn);

        btnSignOut.setText("Sign Out");
        btnSignOut.setPreferredSize(new java.awt.Dimension(100, 25));
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });
        pnlConnect.add(btnSignOut);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(350, 150));

        txaChat.setColumns(20);
        jScrollPane1.setViewportView(txaChat);

        pnlSendMessage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblMessage.setText("Message");
        pnlSendMessage.add(lblMessage);

        scpMessage.setPreferredSize(new java.awt.Dimension(200, 40));

        txaMessage.setColumns(20);
        txaMessage.setRows(5);
        scpMessage.setViewportView(txaMessage);

        pnlSendMessage.add(scpMessage);

        btnSend.setText("Send");
        btnSend.setPreferredSize(new java.awt.Dimension(100, 23));
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        pnlSendMessage.add(btnSend);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(185, 185, 185)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(173, 173, 173)
                        .add(pnlSendMessage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(23, 23, 23)
                        .add(pnlConnect, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 744, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(5, 5, 5)
                .add(pnlConnect, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(5, 5, 5)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(5, 5, 5)
                .add(pnlSendMessage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(810, 361));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
// TODO add your handling code here:
        ps.println("_Bye_");
        System.exit(0);
    }//GEN-LAST:event_btnSignOutActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
// TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String strMessage  = txaMessage.getText();
                ps.println(strMessage);
                txaChat.append(strMessage + "\n");
                txaMessage.setText("");
            }
        });
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
// TODO add your handling code here:
        if(!txtClientName.getText().equals("")){
            clientThread = new ClientThread();
            clientThread.start();
            txaMessage.setEditable(true);
        }else {
            JOptionPane.showMessageDialog(null,"User name is not given");
        }
        
    }//GEN-LAST:event_btnSignInActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatClient().setVisible(true);
            }
        });
    }
    class ClientThread extends Thread {
        String strMsg = "";
        String strName = "";
        boolean blnConnect ;

        public ClientThread() {
            try {
                server = new Socket("localhost",10000);
                br = new BufferedReader(new InputStreamReader(server.getInputStream()));
                ps = new PrintStream(server.getOutputStream());

                strName = txtClientName.getText();
                ps.println(strName);
                txtClientName.setEditable(false);
                btnSignIn.setEnabled(false);
                blnConnect = true;
            } catch (Exception ex) {
                ex.printStackTrace();
                
            } 
        }
        public void run() {
            while(true){
                if(blnConnect){
                    try {
                        if((strMsg = br.readLine())!=null ) {
                            txaChat.append(strMsg + "\n");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        
                    }
                }
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JPanel pnlConnect;
    private javax.swing.JPanel pnlSendMessage;
    private javax.swing.JScrollPane scpMessage;
    private javax.swing.JTextArea txaChat;
    private javax.swing.JTextArea txaMessage;
    private javax.swing.JTextField txtClientName;
    // End of variables declaration//GEN-END:variables
    Socket server;

    BufferedReader br;
    PrintStream ps;

    ClientThread clientThread;
    
}