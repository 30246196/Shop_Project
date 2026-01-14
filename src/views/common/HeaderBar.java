/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.common;

import static java.awt.AWTEventMulticaster.add;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.EcoPalette;
import utils.ThemeManager;

/**
 *
 * @author 30246196
 */


public class HeaderBar extends JPanel {
    private final JLabel logoLabel = new JLabel();
    private final JLabel titleLabel = new JLabel();

    public HeaderBar(String title) {
        setBackground(EcoPalette.DUCK_EGG);
        setLayout(new BorderLayout(12, 0));
        setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));

        // Logo
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo_128x128_no_orange.png"));
        logoLabel.setIcon(icon);

        // Title
        titleLabel.setText(title);
        ThemeManager.styleHeading(titleLabel);

        add(logoLabel, BorderLayout.LINE_START);
        add(titleLabel, BorderLayout.CENTER);
    }

    public void setTitle(String title) {
        titleLabel.setText(title);
    }
}
