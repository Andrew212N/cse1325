package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.util.ArrayList;
import emporium.Emporium;
import product.IceCreamFlavor;
import product.Item;
import product.MixIn;
import product.MixInAmount;
import product.MixInFlavor;
import product.Scoop;

public class MainWin extends JFrame
{
    private Emporium emporium = new Emporium();
    
    private JTextField flavors;
    private JTextField mixins;
    private JTextField descriptions;
    private JSpinner costs;
    private JSpinner prices;

    public MainWin(String title)
    {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        
        JMenuBar menubar = new JMenuBar();
        
        JMenu file = new JMenu("File");
        JMenuItem quit = new JMenuItem("Quit");
        
        JMenu view = new JMenu("View");
        JMenuItem viewFlavor = new JMenuItem("Ice Cream Flavor");
        JMenuItem viewMixIn = new JMenuItem("Mix In Flavor");
        JMenuItem viewScoop = new JMenuItem("Scoop");
        
        JMenu create = new JMenu("Create");
        JMenuItem createFlavor = new JMenuItem("Ice Cream Flavor");
        JMenuItem createMixIn = new JMenuItem("Mix In Flavor");
        JMenuItem createScoop = new JMenuItem("Scoop");
        
        JMenu help = new JMenu("About");
        JMenuItem about = new JMenuItem("About");
        
        quit.addActionListener(event -> onQuitClick());
        createFlavor.addActionListener(event -> onCreateIceCreamFlavorClick());
        createMixIn.addActionListener(event -> onCreateMixInClick());
        about.addActionListener(event -> onAboutClick());
        
        file.add(quit);
        view.add(viewFlavor);
        view.add(viewMixIn);
        view.add(viewScoop);
        create.add(createFlavor);
        create.add(createMixIn);
        create.add(createScoop);
        help.add(about);
                
        menubar.add(file);
        menubar.add(view);
        menubar.add(create);
        menubar.add(help);
        setJMenuBar(menubar);
        
        setVisible(true);
    }
    
    public void onQuitClick()
    {
        System.exit(0);
    }
    
    public void onCreateIceCreamFlavorClick()
    {
        JLabel flavorLabel = new JLabel("<HTML><br/>Ice Cream Flavor</HTML>");
        flavors = new JTextField(20);
        JLabel descriptionLabel = new JLabel("<HTML><br/>Description</HTML>");
        descriptions = new JTextField(60);
        
        SpinnerModel range = new SpinnerNumberModel(0,0,100,1);
        
        JLabel priceLabel = new JLabel("<HTML><br/>Price</HTML>");
        prices = new JSpinner(range);
        JLabel costLabel = new JLabel("<HTML><br/>Cost</HTML>");
        costs = new JSpinner(range);
        
        Object[] objects = {
            flavorLabel, flavors,
            descriptionLabel, descriptions,
            priceLabel, prices,
            costLabel, costs
        };
        int button = JOptionPane.showConfirmDialog(this, objects, "New Ice Cream Flavor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(button == JOptionPane.OK_OPTION)
        {
            emporium.addIceCreamFlavor(new IceCreamFlavor(flavors.getText(), descriptions.getText(), (Integer)prices.getValue(), (Integer)costs.getValue()));
            JOptionPane.showMessageDialog(this, "Flavor: " + flavors.getText() + "\nDescription: " + descriptions.getText() + "\nPrice: " + prices.getValue() + "\nCost: " + costs.getValue());
        }
    }
    
    public void onCreateMixInClick()
    {
        JLabel mixInLabel = new JLabel("<HTML><br/>Mix In Flavor</HTML>");
        mixins = new JTextField(20);
        JLabel descriptionLabel = new JLabel("<HTML><br/>Description</HTML>");
        descriptions = new JTextField(60);
        
        SpinnerModel range = new SpinnerNumberModel(0,0,100,1);
        
        JLabel priceLabel = new JLabel("<HTML><br/>Price</HTML>");
        prices = new JSpinner(range);
        JLabel costLabel = new JLabel("<HTML><br/>Cost</HTML>");
        costs = new JSpinner(range);
        
        Object[] objects = {
            mixInLabel, mixins,
            descriptionLabel, descriptions,
            priceLabel, prices,
            costLabel, costs
        };
        int button = JOptionPane.showConfirmDialog(this, objects, "New Mix In Flavor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.OK_OPTION)
        {
            emporium.addMixInFlavor(new MixInFlavor(mixins.getText(), descriptions.getText(), (Integer)prices.getValue(), (Integer)costs.getValue()));
            JOptionPane.showMessageDialog(this, "MixIn: " + mixins.getText() + "\nDescription: " + descriptions.getText() + "\nPrice: " + prices.getValue() + "\nCost: " + costs.getValue());
        }
    }
    
    public void onAboutClick()
    {
        JOptionPane.showMessageDialog(null, "MICE v1.0");
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) 
    {
        MainWin myApp = new MainWin("MainWin");
        myApp.setVisible(true);
    }

}
