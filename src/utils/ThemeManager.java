/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author 30246196
 */
   

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Applies app-wide theme and provides styling helpers for components.
 * Call ThemeManager.bootstrapLookAndFeel() once in main() before creating frames.
 */
public final class ThemeManager {
    private ThemeManager() {}

    /** Call once in main() right after setting Nimbus LAF. */
    public static void bootstrapLookAndFeel() {
        // Tint Nimbus globally to align with EcoPalette
        UIManager.put("nimbusBase",     new Color(30, 120, 85)); // deep green
        UIManager.put("nimbusBlueGrey", new Color(200, 220, 210));
        UIManager.put("control",        EcoPalette.DUCK_EGG);
        UIManager.put("text",           EcoPalette.TEXT_DARK);
    }

    /** Apply default background/typography for a frame content pane. */
    public static void applyFrameBackground(JFrame frame) {
        frame.getContentPane().setBackground(EcoPalette.DUCK_EGG);
    }

    /** Headings (e.g., section titles). */
    public static void styleHeading(JLabel label) {
        label.setForeground(EcoPalette.STONE_GRAY);
        label.setFont(label.getFont().deriveFont(Font.BOLD, label.getFont().getSize2D() + 2f));
    }

    /** Secondary label text. */
    public static void styleMuted(JLabel label) {
        label.setForeground(EcoPalette.TEXT_MUTED);
    }

    /** Primary action button (green with white text). */
    public static void stylePrimary(JButton b) {
        b.setBackground(EcoPalette.LEAF_GREEN);
        b.setForeground(Color.WHITE);
        baseButton(b);
    }

    /** Secondary action button (soft green, dark text). */
    public static void styleSecondary(JButton b) {
        b.setBackground(EcoPalette.ECO_GREEN);
        b.setForeground(Color.BLACK);
        baseButton(b);
    }

    private static void baseButton(JButton b) {
        b.setFocusPainted(false);
        b.setOpaque(true);
        b.setBorderPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        // Hover effect
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override public void mouseEntered(java.awt.event.MouseEvent e) {
                b.setBackground(b.getBackground().darker());
            }
            @Override public void mouseExited(java.awt.event.MouseEvent e) {
                // lighten back by approximating (not perfect but effective)
                Color bg = b.getBackground();
                b.setBackground(new Color(
                        Math.min(bg.getRed() + 20, 255),
                        Math.min(bg.getGreen() + 20, 255),
                        Math.min(bg.getBlue() + 20, 255)
                ));
            }
        });
        // Normalize size if desired:
        // b.setPreferredSize(new Dimension(160, 36));
    }

    /** Consistent JList look + selection. Call for any list + its scrollpane. */
    public static void styleList(JList<?> list, JScrollPane scroller) {
        list.setBackground(EcoPalette.LIST_BG);
        list.setForeground(EcoPalette.TEXT_DARK);
        list.setSelectionBackground(EcoPalette.LIST_SEL_BG);
        list.setSelectionForeground(EcoPalette.LIST_SEL_FG);
        list.setFixedCellHeight(24);
        list.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));

        scroller.getViewport().setBackground(EcoPalette.LIST_BG);
        scroller.setBorder(new LineBorder(new Color(220, 225, 220)));

        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList<?> lst, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(lst, value, index, isSelected, cellHasFocus);
                if (c instanceof JLabel lbl) {
                    lbl.setOpaque(true);
                    lbl.setForeground(isSelected ? EcoPalette.LIST_SEL_FG : EcoPalette.TEXT_DARK);
                    lbl.setBackground(isSelected ? EcoPalette.LIST_SEL_BG : EcoPalette.LIST_BG);
                    lbl.setBorder(BorderFactory.createEmptyBorder(2, 8, 2, 8));
                }
                return c;
            }
        });
    }
}
 

