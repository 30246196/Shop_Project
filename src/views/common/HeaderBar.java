/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Packages

package views.common;


// Imports

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.EcoPalette;
import utils.ThemeManager;

/**
 * Logo on the left
 * Title styled with ThemeManager
 * Clean spacing and layout
 * EcoPalette background
 * 
 * @author 30246196
 */


public class HeaderBar extends JPanel {
    //create new objects to add the logo and the header
    private final JLabel titleLabel = new JLabel();
    
    public HeaderBar() {
        this("GLASGOW GREEN ENERGY");
    }

    public HeaderBar(String title) {
        
        setBackground(EcoPalette.DUCK_EGG);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));
        
        // Left container (logo + title)
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        leftPanel.setOpaque(false);
        
        // Logo
        JLabel logoLabel = new JLabel( new ImageIcon(getClass().getResource("/images/logo_128x128_no_orange.png")) );
        
        // Title
        titleLabel.setText(title);
        ThemeManager.styleHeading(titleLabel);
          
        titleLabel.setForeground(EcoPalette.ECO_GREEN);// <<< HEADER TEXT COLOUR
        titleLabel.setFont(titleLabel.getFont().deriveFont(20f)); // bigger font

        // Add components to the left panel
        leftPanel.add(logoLabel);
        leftPanel.add(titleLabel);
        
        // Add left panel to header
        add(leftPanel, BorderLayout.WEST);
        
    }
    
    // Method to set the title
    public void setTitle(String title) {
        titleLabel.setText(title);
    }
}
