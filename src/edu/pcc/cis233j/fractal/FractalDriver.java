package edu.pcc.cis233j.fractal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A program that displays one of a selection of fractals, and allows the user
 * to select which fractal is displayed.
 *
 * @author Cara Tang
 * @version 2013.08.03
 *
 * @Ulices Cardenas
 * @version 2018.25.02
 */
public class FractalDriver
{
    private static final int WIDTH = 350;
    private static final int HEIGHT = 300;
    private static final String CANTOR = "Cantor";
    private static final String CIRCLE = "Circle";
    private static final String MANDELBROT = "Mandelbrot";
    private static final String SIERPINSKI = "Sierpinski";
    private static final String[] allFractals = {CANTOR, CIRCLE, MANDELBROT, SIERPINSKI};
    // TODO: add CIRCLE, MANDELBROT, SIERPINSKI to allFractals (above)

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel fractalCards;
    private JComboBox<String> fractalChooser;


    /**
     * Create a FractalDriver
     */
    public FractalDriver()
    {
        makeFrame();
    }

    /**
     * Create the FractalDriver GUI
     */
    private void makeFrame()
    {
        frame = new JFrame("Fractals!");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createContents();
        frame.setVisible(true);
    }

    /**
     * Create the contents of the main window
     * A combo box at the top controls selection of which fractal panel is displayed
     */
    private void createContents()
    {
        JScrollPane cantorPane = new JScrollPane(new edu.pcc.cis233j.fractal.CantorPanel(6));
        JScrollPane circlesPane = new JScrollPane( new edu.pcc.cis233j.fractal.CirclesPanel( 6));
        JScrollPane mandelbrotPane = new JScrollPane(new edu.pcc.cis233j.fractal.MandelbrotPanel(6));
        JScrollPane sierpinskiPane = new JScrollPane(new edu.pcc.cis233j.fractal.SierpinskiPanel(6));
        // Created circle, mandelbrot, and sierpinski panels in a scroll pane like the line above (3 new lines)

        cardLayout = new CardLayout();
        // Created cardLayout


        // Created fractalCards panel (field already declared above) and set its layout to cardLayout (1-2 lines)
        fractalCards = new JPanel();
        fractalCards.setLayout(cardLayout);

        // Added cantorPane and others to fractalCards, using the CANTOR, CIRCLE, etc. constants
        //       e.g., fractalCards.add(cantorPane, CANTOR); (4 lines)
        fractalCards.add(cantorPane, CANTOR);
        fractalCards.add(circlesPane, CIRCLE);
        fractalCards.add(mandelbrotPane, MANDELBROT);
        fractalCards.add(sierpinskiPane, SIERPINSKI);

        // Created fractalChooser combo box (field already declared above) with allFractals as its choices (1 line)
        fractalChooser = new JComboBox<String>(allFractals);

        // Added a ComboListener to the fractalChooser combo box (listener class already defined below) (1 line)
        fractalChooser.addActionListener(new ComboListener());

        // Added the fractalChooser combo box at NORTH, e.g., frame.add(fractalChooser, BorderLayout.NORTH); (1 line)
        frame.add(fractalChooser,BorderLayout.NORTH);


        // added fractalCards panel at CENTER (1 line)
        frame.add(fractalCards,BorderLayout.CENTER);


    }

    /**
     * Listen to the combo box and switch the displayed fractal when the selection changes
     */
    private class ComboListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //  Got the String of the selected card from the combo box
            // You can use the getSelectedItem method on the fractalChooser combo box (1 line)

            String fractalString = (String) fractalChooser.getSelectedItem();

            // Adjusted the card layout to show the selected card (use the 'show' method) (1 line)
            if( fractalString != null) {
                cardLayout.show(fractalCards, fractalString);
            }
        }
    }

    public static void main(String[] args)
    {
        new FractalDriver();
    }

}

