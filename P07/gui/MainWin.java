package gui;

/***************************************************************************************
*    Title: MainWin
*    Author: George Rice
*    Date: 10/16/2022
*    Code version: 1.0
*    Availability: https://github.com/prof-rice/cse1325-prof/tree/main/P06/gui
*
***************************************************************************************/

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.UIManager;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import product.Item;
import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Scoop;

import emporium.Emporium;

public class MainWin extends JFrame {

    public MainWin() {
        super("Mavs Ice Cream Emporium");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();
        
        JMenu     file         = new JMenu("File");
        JMenuItem quit         = new JMenuItem("Quit");
        JMenu     view         = new JMenu("View");
        JMenuItem viewICF      = new JMenuItem("Ice Cream Flavor");
        JMenuItem viewMIF      = new JMenuItem("Mix In Flavor");
        JMenuItem viewScoop    = new JMenuItem("Scoop");
        JMenu     create       = new JMenu("Create");
        JMenuItem createICF    = new JMenuItem("Ice Cream Flavor");
        JMenuItem createMIF    = new JMenuItem("Mix In Flavor");
                  createScoop  = new JMenuItem("Scoop");
        JMenu     help         = new JMenu("Help");
        JMenuItem about        = new JMenuItem("About");
        
        quit       .addActionListener(event -> onQuitClick());
        viewICF    .addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        viewMIF    .addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
        viewScoop  .addActionListener(event -> view(Screen.SCOOPS));
        createICF  .addActionListener(event -> onCreateIceCreamFlavorClick());
        createMIF  .addActionListener(event -> onCreateMixInFlavorClick());
        createScoop.addActionListener(event -> onCreateScoopClick());
        createScoop.setEnabled(false); // until an ice cream flavor is defined
        about      .addActionListener(event -> onAboutClick());

        file.add(quit);
        view.add(viewICF);
        view.add(viewMIF);
        view.add(viewScoop);
        create.add(createICF);
        create.add(createMIF);
        create.add(createScoop);
        help.add(about);
        
        menubar.add(file);
        menubar.add(view);
        menubar.add(create);
        menubar.add(help);
        
        setJMenuBar(menubar);
        
        // TOOLBAR STUFF
        JToolBar toolbar = new JToolBar("Ice cream yes");
        
        // CONTROL BUTTONS IDK YES PERHAPS
        JButton saveB = new JButton(new ImageIcon("save.png"));
            saveB.setActionCommand("Save");
            saveB.setToolTipText("Save the file");
            saveB.setBorder(null);
            toolbar.add(saveB);
            saveB.addActionListener(event -> onSaveClick());
            
        JButton saveAsB = new JButton(new ImageIcon("saveas.png"));
            saveAsB.setActionCommand("Save As");
            saveAsB.setToolTipText("Save the file as...");
            saveAsB.setBorder(null);
            toolbar.add(saveAsB);
            saveAsB.addActionListener(event -> onSaveAsClick());
            
        JButton openB = new JButton(new ImageIcon("open.png"));
            openB.setActionCommand("Open");
            openB.setToolTipText("Open file...");
            openB.setBorder(null);
            toolbar.add(openB);
            openB.addActionListener(event -> onOpenClick());
            
       // VIEW AND CREATE BUTTONS
       viewICF = new JButton(new ImageIcon("viewflavor.png"));
            viewICF.setActionCommand("View Ice Cream Flavors");
            viewICF.setToolTipText("View Ice Cream Flavors");
            toolbar.add(viewICF);
            viewICF.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
            
        viewMIF = new JButton(new ImageIcon("viewmixin.png"));
            viewMIF.setActionCommand("View Mix In Flavors");
            viewMIF.setToolTipText("View Mix In Flavors");
            toolbar.add(viewMIF);
            viewMIF.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
            
        viewScoop = new JButton(new ImageIcon("viewscoop.png"));
            viewScoop.setActionCommand("View Scoops");
            viewScoop.setToolTipText("View Scoops");
            toolbar.add(viewScoop);
            viewScoop.addActionListener(event -> view(Screen.SCOOPS));
            
        createICF = new JButton(new ImageIcon("newflavor.png"));
            createICF.setActionCommand("Create Ice Cream Flavor");
            createICF.setToolTipText("Create Ice Cream Flavor");
            toolbar.add(createICF);
            createICF.addActionListener(event -> onCreateIceCreamFlavorClick());
            
        createMIF = new JButton(new ImageIcon("newmixin.png"));
            createMIF.setActionCommand("Create Mix In");
            createMIF.setToolTipText("Create Mix In Flavor");
            toolbar.add(createMIF);
            createMIF.addActionListener(event -> onCreateMixInFlavorClick());
            
        createScoop = new JButton(new ImageIcon("newscoop.png"));
            createScoop.setActionCommand("Create Scoop");
            createScoop.setToolTipText("Create Ice Cream Scoop");
            toolbar.add(createScoop);
            createScoop.addActionListener(event -> onCreateScoopClick());
                
       // ///////////////////////////////////////////////////////////////////////
        // M A I N   D I S P L A Y
        // Provide a text entry box to show data
        display = new JLabel();
        display.setFont(new Font("Courier New", Font.BOLD, 18));
        display.setVerticalAlignment(JLabel.TOP);
        add(display, BorderLayout.CENTER);

        // Make everything in the JFrame visible
        setVisible(true);
        
        // Start a new emporium
        emporium = new Emporium();
    }
    
    // Listeners
    protected void onQuitClick() {System.exit(0);}   // Exit the game
    
    protected void onSaveClick();
    
    protected void onSaveAsClick();
    
    protected void onOpenClick();

    protected void onCreateIceCreamFlavorClick() {
        try {
            emporium.addIceCreamFlavor(new IceCreamFlavor(
                JOptionPane.showInputDialog(this, "Name?", 
                    "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE),
                JOptionPane.showInputDialog(this, "Description?", 
                    "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Price?", 
                    "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE)),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Cost?", 
                    "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE))
            ));
        } catch(Exception e) {
        }
        createScoop.setEnabled(true);  // Now we have a flavor, we can create a scoop!
        view(Screen.ICE_CREAM_FLAVORS);         
    }
    protected void onCreateMixInFlavorClick() {
        try {
            emporium.addMixInFlavor(new MixInFlavor(
                JOptionPane.showInputDialog(this, "Name?", 
                    "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE),
                JOptionPane.showInputDialog(this, "Description?", 
                    "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Price?", 
                    "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE)),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Cost?", 
                    "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE))
            ));   
        } catch(Exception e) {
        }
        view(Screen.MIX_IN_FLAVORS);         
    }
    protected void onCreateScoopClick() {
        IceCreamFlavor icf = (IceCreamFlavor) JOptionPane.showInputDialog(this, 
            "Ice Cream Flavor?", "New Scoop", JOptionPane.QUESTION_MESSAGE, null, 
            emporium.iceCreamFlavors(), null);
        if(icf != null) {
            Scoop scoop = new Scoop(icf);
            if(emporium.mixInFlavors().length > 0) {
                String prompt = "<html>" + scoop + "<br/>Add a mix in?</html>";
                while(true) {
                    MixInFlavor mif = (MixInFlavor) JOptionPane.showInputDialog(this, prompt, 
                        "Add Mix In", JOptionPane.QUESTION_MESSAGE, null, 
                        emporium.mixInFlavors(), null);
                    if(mif == null) break;
                    MixInAmount mia = (MixInAmount) JOptionPane.showInputDialog(this, prompt, 
                        "Add Mix In", JOptionPane.QUESTION_MESSAGE, null, 
                        MixInAmount.values(), MixInAmount.Normal);
                    scoop.addMixIn(new MixIn(mif, mia));
                    prompt = "<html>" + scoop + "<br/>Add another mix in?</html>";
                }
            }
            emporium.addScoop(scoop);
            view(Screen.SCOOPS);         
        }
    }
    
    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog(this, "Mavs Ice Cream Emporium");
        about.setLayout(new BoxLayout(about.getContentPane(), BoxLayout.PAGE_AXIS));
              
        try {
            BufferedImage myPicture = ImageIO.read(new File("gui/icecweam.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<br/><p><font size=+4>MICE</font></p>"
          + "</html>", JLabel.CENTER);
        about.add(title);

        JLabel subTitle = new JLabel("<html>"
          + "<br/><p><font size=+1>Mavs Ice Cream Emporium</font></p>"
          + "</html>", JLabel.CENTER);
        about.add(subTitle);

        JLabel artists = new JLabel("<html>"
          + "<br/><p>Version 0.2</p>"
          + "<p>Copyright 2022 by Andrew Nguyen</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "Logo by Andrew Nguyen"
          + "<br/></html>", JLabel.CENTER);
        about.add(artists);

        JPanel panel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        panel.add(ok);
        about.add(panel);
        
        about.add(Box.createVerticalStrut(10));
        
        about.pack();
        about.setVisible(true);
     }
     
     private enum Screen {ICE_CREAM_FLAVORS, MIX_IN_FLAVORS, SCOOPS}
     private void view(Screen screen) {
         String title = "";
         StringBuilder s = new StringBuilder();
         switch(screen) {
             case ICE_CREAM_FLAVORS: 
                 title = "Ice Cream Flavors";
                 for(var t : emporium.iceCreamFlavors()) s.append(t.toString() + "<br/>");
                 break;
             case MIX_IN_FLAVORS: 
                 title = "Mix In Flavors";
                 for(var t : emporium.mixInFlavors()) s.append(t.toString() + "<br/>");
                 break;
             case SCOOPS: 
                 title = "Scoops";
                 for(var t : emporium.scoops()) s.append(t.toString() + "<br/>");
                 break;
             default:
                 display.setText("PANIC: Invalid Displays type: " + display);
         }
         display.setText("<html><font size=+4>" + title + 
                         "<br/></font><font size=+2>" + s.toString() + 
                         "</font></html>");
     }
     
    private Emporium emporium;

    private JMenuItem createScoop;  // defined here so we can disable and enable it
    private JLabel display;                 // Main data display
}
