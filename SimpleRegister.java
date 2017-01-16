/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleregister;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Scanner;
import javax.swing.JFrame;
import simpleregister.gui.SimpleRegisterGUI;

/**
 *
 * @author sean
 */
public class SimpleRegister {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner reader = new Scanner(System.in);
        
        Information information = new Information();
        
        SimpleRegisterGUI registerFrame = new SimpleRegisterGUI();
        registerFrame.setTitle("Simple Population Registry");
        registerFrame.setSize(450,250);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        
        // Get the dimension of the frame
        Dimension GUISize = registerFrame.getSize();
        int x = (screenWidth - GUISize.width)/2;
        int y = (screenHeight - GUISize.height)/2;
        
        registerFrame.setLocation(x, y);
        registerFrame.setVisible(true);
        //UserInterface ui = new UserInterface(reader, information);
        //ui.start();
    }
    
}
