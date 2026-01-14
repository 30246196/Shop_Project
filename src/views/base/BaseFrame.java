/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.base;

/**
 *
 * @author 30246196
 */



import utils.ThemeManager;
import javax.swing.*;

public abstract class BaseFrame extends JFrame {

    protected BaseFrame() {
        super();
        // Apply default frame background right away
        ThemeManager.applyFrameBackground(this);
        // set a common window icon if needed:
        setIconImage(new ImageIcon(getClass().getResource("/images/logo_64x64_no_orange_border.png")).getImage());
    }

    /**
     * Call this after initComponents() in child frames to style common bits.
     * You can override and extend in child classes if needed.
     */
    protected void applyCommonTheme() {
        // Default is just the background via constructor; child classes can style components here.
    }
}

