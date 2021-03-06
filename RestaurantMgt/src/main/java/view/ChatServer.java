package view;

/*
 * ChatServer.java
 *
 * Created on February 19, 2010, 11:38 AM
 */



import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author  HoangDung
 */
public class ChatServer extends javax.swing.JFrame {
    
    /** Creates new form ChatServer */
    public ChatServer() {
       
        initComponents();
        new ServerThread().start();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStartServer = new javax.swing.JButton();
        lbtServerStatus = new javax.swing.JLabel();
        scpClientStatus = new javax.swing.JScrollPane();
        txaClientMessage = new javax.swing.JTextArea();
        scpClient = new javax.swing.JScrollPane();
        lstClient = new javax.swing.JList();
        pnlBroadCastMessage = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        txtMessage = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chat Server");

        btnStartServer.setText("Start Server");
        btnStartServer.setPreferredSize(new java.awt.Dimension(150, 23));
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        lbtServerStatus.setText("Logged In");
        lbtServerStatus.setPreferredSize(new java.awt.Dimension(180, 20));

        scpClientStatus.setPreferredSize(new java.awt.Dimension(300, 150));

        txaClientMessage.setColumns(20);
        txaClientMessage.setRows(5);
        scpClientStatus.setViewportView(txaClientMessage);

        scpClient.setPreferredSize(new java.awt.Dimension(130, 150));

        scpClient.setViewportView(lstClient);

        pnlBroadCastMessage.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblMessage.setText("Message");
        lblMessage.setPreferredSize(new java.awt.Dimension(70, 20));

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txtMessage.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout pnlBroadCastMessageLayout = new javax.swing.GroupLayout(pnlBroadCastMessage);
        pnlBroadCastMessage.setLayout(pnlBroadCastMessageLayout);
        pnlBroadCastMessageLayout.setHorizontalGroup(
            pnlBroadCastMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBroadCastMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSend)
                .addContainerGap())
        );
        pnlBroadCastMessageLayout.setVerticalGroup(
            pnlBroadCastMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBroadCastMessageLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlBroadCastMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lbtServerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpClientStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBroadCastMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpClient, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lbtServerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scpClientStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(pnlBroadCastMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scpClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(720, 495));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
 
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String str  = txtMessage.getText();
                ps.println(str);
                txtMessage.setText("");
            }
        });

//       
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartServerActionPerformed
// TODO add your handling code here:
       
        btnStartServer.setEnabled(false);
        //new ServerThread().start();
        
    }//GEN-LAST:event_btnStartServerActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatServer().setVisible(true);
            }
        });
    }

    class ServerThread extends Thread {
        String strMsg = "";
        boolean blnSignIn ;
        boolean blnConnect;


        public ServerThread() {
            try {
                server = new ServerSocket(10000);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public void run() {
            while(true){
                if(!blnConnect){
                    try {
                        client = server.accept();
                        ps = new PrintStream(client.getOutputStream());
                        br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        blnConnect = true;
                        blnSignIn = false;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                try {
                    if ((strMsg = br.readLine()) != null ){
                        if(!blnSignIn){
                            vecUsers.add(strMsg +" has logged in");
                            lstClient.setListData(vecUsers);
                            strUser = strMsg;
                            blnSignIn = true;
                        }else{
                            if (strMsg.equals("_Bye_")){
                               txaClientMessage.append(strUser + " has logged out \n");
                               txaClientMessage.append("...waiting for a new client...\n");
                            }else {
                               txaClientMessage.append(strMsg + "\n");
                            }
                        } 
                    }
                } catch (Exception ex) {
                    blnConnect = false;
                }
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnStartServer;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lbtServerStatus;
    private javax.swing.JList lstClient;
    private javax.swing.JPanel pnlBroadCastMessage;
    private javax.swing.JScrollPane scpClient;
    private javax.swing.JScrollPane scpClientStatus;
    private javax.swing.JTextArea txaClientMessage;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables
    ServerSocket server;
    Socket client;  
    
    BufferedReader br;
    PrintStream ps;
    
    Vector vecUsers = new Vector();
    String strUser;
    
}
