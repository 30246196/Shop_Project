/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Color;

/**
 * Palette Eco with colours:
 *  duck egg for the background
 *  ECO_GREEN for soft actions: back,...
 *  LEAF_GREEN for k, buy, .. actions
 *  STONE_GRAY for text
 *  COTTON_WHITE for other
 * 
 * @author 30246196
 */
public final class EcoPalette {
    
//    public static final Color DUCK_EGG = new Color(224, 240, 233);// fix imports
//    public static final Color ECO_GREEN = new Color(168, 213, 186);
//    public static final Color LEAF_GREEN = new Color(34, 139, 34);
//    public static final Color STONE_GRAY = new Color(107, 122, 111);
//    public static final Color COTTON_WHITE = new Color(248, 248, 244);

    
/** Central green/neutral palette shared by all screens. */

    private EcoPalette() {}

    public static final Color DUCK_EGG    = new Color(224, 240, 233); // app bg
    public static final Color STONE_GRAY  = new Color(107, 122, 111); // headings
    public static final Color LEAF_GREEN  = new Color(34, 139, 34);   // primary btn
    public static final Color ECO_GREEN   = new Color(168, 213, 186); // secondary btn
    public static final Color TEXT_DARK   = new Color(30, 30, 30);
    public static final Color TEXT_MUTED  = new Color(90, 90, 90);
    public static final Color LIST_BG     = Color.WHITE;
    public static final Color LIST_SEL_BG = new Color(220, 245, 234);
    public static final Color LIST_SEL_FG = new Color(10, 60, 40);
}


