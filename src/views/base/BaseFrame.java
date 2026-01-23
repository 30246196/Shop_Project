/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Packages

package views.base;

/* BaseFrame provides a consistent window structure for all screens
    *Every frame gets the same header and footer

    *applies the global background
    *
    *sets a shared window icon
    *
    *Child frames only need: initComponents(), applyCommonTheme(), applyThemeStyles()
 * 
 * @author 30246196
 */

// Imports

import java.awt.BorderLayout;
import java.awt.Font;
import java.time.Year;
import utils.ThemeManager;
import javax.swing.*;
import utils.EcoPalette;
import views.common.HeaderBar;

public abstract class BaseFrame extends JFrame
{
    //constant for the app title
    protected static final String APP_TITLE = "GLASGOW GREEN ENERGY";
    
    protected BaseFrame() {
        super(APP_TITLE);
        
        // Apply default frame background right away
        ThemeManager.applyFrameBackground(this);
        
        // set a common window icon 
        setIconImage(new ImageIcon(getClass().getResource("/images/logo_128x128_no_orange.png")).getImage());
        
        // Consistent window behaviour
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        // Center all frames by default
        setLocationRelativeTo(null);
        
        // All screens use BorderLayout
        setLayout(new BorderLayout());
    }

    /**
     * Call this after initComponents() in child frames to style common bits.
     * Adds header + footer + background.
     * You can override and extend in child classes if needed.
     */
    //@Override
    protected void applyCommonTheme() {
        // Default is just the background via constructor;
        //child classes can style components here.
        
        // Header
        HeaderBar header = new HeaderBar(APP_TITLE);
        add(header, BorderLayout.NORTH);
        
        // Add the footer bar
        addFooter();
    }
    
    // Method Footer
    
    protected void addFooter()
    {
        int currentYear = Year.now().getValue();
        
        JLabel footer = new JLabel("Glasgow Green Energy — © " + currentYear, SwingConstants.CENTER);
        
        footer.setOpaque(true);
        footer.setBackground(EcoPalette.DUCK_EGG);
        footer.setForeground(EcoPalette.STONE_GRAY);
        footer.setFont(new Font("SansSerif", Font.PLAIN, 12));
        footer.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
        add(footer, BorderLayout.SOUTH);
    }
}

