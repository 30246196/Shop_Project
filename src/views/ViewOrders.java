/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import javax.swing.DefaultListModel;
import models.Customer;
import models.DBManager;
import utils.EcoPalette;
import utils.ThemeManager;
import views.base.BaseFrame;

/**
 * ViewOrders
 * Shows all orders belonging to the logged‑in customer.
 * 
 * @author 30246196
 */
public class ViewOrders extends BaseFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ViewOrders.class.getName());

    private Customer loggedInCustomer;
    
    // The list model that will hold the formatted order strings from the db
    private DefaultListModel<String> model = new DefaultListModel<>();
    /**
     * Creates new form ViewOrders
     * 
     *  - BaseFrame constructor runs first (super())
     *  - initComponents() builds the UI from the .form file
     *  - applyCommonTheme() adds header/footer + global theme
     *  - applyViewTheme() styles lists and muted text
     *  - applyThemeStyles() styles buttons and headings
     */
    public ViewOrders(Customer c) {
        super(); // calls BaseFrame → sets title, icon, background, header/footer
        this.loggedInCustomer = c;
        
        initComponents();
        
        applyCommonTheme(); // header + footer + background
        applyViewTheme(); // list colours + muted text
        applyThemeStyles(); // button + heading styling
        
        ThemeManager.styleBackButton(btnBack);// fix imports, apply same colour to Back Button
        
        // Personalised title for the customer
        lblTitle.setText("Your orders " + loggedInCustomer.getFirstName() + ": reference, date and total" );
        
        // Attach the list model to the JList
        lstOrders.setModel(model);
        
        // load the orders from the db
        loadOrdersForCustomer();
    }

    // Theme Methods
    
    /** * applyCommonTheme()
     * Called after initComponents().
     * Adds header/footer and styles headings.
     */ 
    @Override protected void applyCommonTheme()
    { 
        super.applyCommonTheme(); // BaseFrame handles header + footer
        ThemeManager.styleHeading(lblTitle); // style the title label
    }
    
    /**
     * applyThemeStyles()
     * Styles buttons and other interactive components.
     */
    private void applyThemeStyles()
    {
        ThemeManager.styleBackButton(btnBack); // eco‑green primary button
    }
    
    /**
     * applyViewTheme()
     * Styles view‑specific components (lists, muted text, etc.)
     */
    private void applyViewTheme()
    {
        // Apply eco‑theme colours to the orders list
        lstOrders.setForeground(EcoPalette.STONE_GRAY);
        lstOrders.setBackground(EcoPalette.DUCK_EGG);
    }
    
    // Method Load customer Orders For Customers
    
    // Load only orders that belong to the logged-in customer
    private void loadOrdersForCustomer()
    {
       model.clear();// reset the list
       
       // validate customer
       String customerUsername =(loggedInCustomer != null)? loggedInCustomer.getUsername() : null;
       if (customerUsername == null || customerUsername.trim().isEmpty() )
       {
           model.addElement("No customer is logged in.");
           return;
       }
       
       // load orders from this customer from DB
       DBManager db = new DBManager();
       //ArrayList<Order> orders = db.loadOrders(customerUsername); // DB filters by username
       java.util.ArrayList<models.Order> orders = db.loadOrders(customerUsername);
       
       // Format currency and dates
       java.text.NumberFormat currency = java.text.NumberFormat.getCurrencyInstance(java.util.Locale.UK);
       java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
       
       // Build readable lines for each order
       for (models.Order o : orders)
        { 
            // Double‑check username match (extra safety)
            if (o.getUsername().equals(loggedInCustomer.getUsername()))
            { 
                //String line = "Order #" + o.getOrderId() + " - £" + o.getOrderTotal();
                //String line = "Order #" + o.getOrderId() + " - " + currency.format(o.getOrderTotal());
                
                String dateStr = sdf.format(o.getOrderDate());
                String line = "Order #" + o.getOrderId() + " | " + dateStr + " | " + currency.format(o.getOrderTotal());
                
                model.addElement(line);// add a new line 
            }
        }
        
        // If no orders found, show a friendly message
        if (model.getSize() == 0)
            {
                model.addElement("No orders found for this customer.");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lstOrders = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(lstOrders);

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setText("Your Orders:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 280, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Events
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // FROM ViewOrders to CustomerHome
        
        CustomerHome ch = new CustomerHome(loggedInCustomer);
        // get visible the new form
        ch.setVisible(true);
        // hide the current form
        //this.setVisible(false);// or 
        dispose();// close this window cleanly
         
    }//GEN-LAST:event_btnBackActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(() -> new ViewOrders().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JList<String> lstOrders;
    // End of variables declaration//GEN-END:variables
}
