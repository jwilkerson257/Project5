import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;

public class HammingDistFrame extends JFrame
{
	ArrayList<String> STID = new ArrayList<String>();
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 1000;

	//==================================================================================================================
	// Panels for component grouping and organization:
	//==================================================================================================================
	
	JPanel leftpanel = new JPanel();
	
    JPanel rightpanel = new JPanel();
	/** panel for  displaying Hamming Distance text */
    JPanel panel1 = new JPanel();
    /** panel for Hamming Distance Slider */
    JPanel panel2 = new JPanel();
    /** panel for show stations button */
    JPanel panel3 = new JPanel();
    /** panel for the text area with STID values*/
    JPanel panel4 = new JPanel();
    /** panel that holds the dropdown box with the compare with button */
    JPanel panel5 = new JPanel();
    /** panel that holds the button to calculate Hamming Distance */
    JPanel panel6 = new JPanel();
    
    /*
     * Each panel below holds the text field and label for each respective distance
     */
    JPanel dist0 = new JPanel();
    JPanel dist1 = new JPanel();
    JPanel dist2 = new JPanel();
    JPanel dist3 = new JPanel();
    JPanel dist4 = new JPanel();
    
    /** panel that holds the text field and button to add a station */
    JPanel panel8 = new JPanel();
    
    JLabel displayLabel = new JLabel("Enter Hamming Dist: ");
    
    JTextField HammingDistDisplay = new JTextField("1", 6);
    
    JButton showStation = new JButton("Show Station");
    
    JTextArea stations = new JTextArea(15, 15);
    
    JSlider HammingDistSlider = new JSlider(JSlider.HORIZONTAL, 1, 4, 1);
    
    JLabel compare = new JLabel("Compare with: ");
    
    JComboBox<String> dropdown = new JComboBox<String>();
    
    JButton calculateHD = new JButton("Calculate HD");

    JLabel distance0label = new JLabel("Distance 0");
    JTextField distance0 = new JTextField("0", 6);
    
    JLabel distance1label = new JLabel("Distance 1");
    JTextField distance1 = new JTextField("0", 6);
    
    JLabel distance2label = new JLabel("Distance 2");
    JTextField distance2 = new JTextField("0", 6);
    
    JLabel distance3label = new JLabel("Distance 3");
    JTextField distance3 = new JTextField("0", 6);
    
    JLabel distance4label = new JLabel("Distance 4");
    JTextField distance4 = new JTextField("0", 6);
    
    JButton addStation = new JButton("Add Station");
    JTextField stationEntry = new JTextField("ZERO", 8);
    
    JLabel errorMessage = new JLabel("No errors");
    
    
    
	public HammingDistFrame() throws IOException
	{
		super("HammingDistFrame");
		readFile();
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLayout(new BorderLayout());
        
        // BoxLayout is used to have all of the panels by stacked vertically in the left panel
        BoxLayout layout = new BoxLayout(leftpanel, BoxLayout.Y_AXIS);
        leftpanel.setLayout(layout);
        
        // Adds a scroll bar onto the TextArea and enables whell scrolling
        stations.setEditable(false);
        JScrollPane scroll = new JScrollPane(stations, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setWheelScrollingEnabled(true);
        
        // Draws the Ticls marks along the slider and snaps it to the ticks
        HammingDistSlider.setSnapToTicks(true);
        HammingDistSlider.setPaintTicks(true);
        HammingDistSlider.setPaintLabels(true);
        HammingDistSlider.setMajorTickSpacing(1);
        
        HammingDistDisplay.setEditable(false);
        
        // Adds all of the STID values to the dropdown box or ComboBox
        for(String STIDs: STID)
        {
        	dropdown.addItem(STIDs);
        }
        
        
        /*
         *  Each panel is sized and aligned and then its component is added to it
         */
        panel1.setMaximumSize(new Dimension(400,100));
        panel1.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel1.add(displayLabel);
        panel1.add(HammingDistDisplay);
        
        panel2.setMaximumSize(new Dimension(400,100));
        panel2.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel2.setAlignmentY(Component.TOP_ALIGNMENT);
        panel2.add(HammingDistSlider);
        
        panel3.setMaximumSize(new Dimension(400,100));
        panel3.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel3.setAlignmentY(Component.TOP_ALIGNMENT);
        panel3.add(showStation);
        
        panel4.setMaximumSize(new Dimension(400,100));
        panel4.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel4.setAlignmentY(Component.TOP_ALIGNMENT);
        panel4.add(scroll);
        
        panel5.setMaximumSize(new Dimension(400,100));
        panel5.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel5.setAlignmentY(Component.TOP_ALIGNMENT);
        panel5.add(compare);
        panel5.add(dropdown);
        
        panel6.setMaximumSize(new Dimension(400,100));
        panel6.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel6.setAlignmentY(Component.TOP_ALIGNMENT);
        panel6.add(calculateHD);
        
        dist0.setMaximumSize(new Dimension(400,100));
        dist0.setAlignmentX(Component.RIGHT_ALIGNMENT);
        dist0.setAlignmentY(Component.TOP_ALIGNMENT);
        dist0.add(distance0label);
        dist0.add(distance0);
        
        dist1.setMaximumSize(new Dimension(400,100));
        dist1.setAlignmentX(Component.RIGHT_ALIGNMENT);
        dist1.setAlignmentY(Component.TOP_ALIGNMENT);
        dist1.add(distance1label);
        dist1.add(distance1);
        
        dist2.setMaximumSize(new Dimension(400,100));
        dist2.setAlignmentX(Component.RIGHT_ALIGNMENT);
        dist2.setAlignmentY(Component.TOP_ALIGNMENT);
        dist2.add(distance2label);
        dist2.add(distance2);
        
        dist3.setMaximumSize(new Dimension(400,100));
        dist3.setAlignmentX(Component.RIGHT_ALIGNMENT);
        dist3.setAlignmentY(Component.TOP_ALIGNMENT);
        dist3.add(distance3label);
        dist3.add(distance3);
        
        dist4.setMaximumSize(new Dimension(400,100));
        dist4.setAlignmentX(Component.RIGHT_ALIGNMENT);
        dist4.setAlignmentY(Component.TOP_ALIGNMENT);
        dist4.add(distance4label);
        dist4.add(distance4);
        
        panel8.setMaximumSize(new Dimension(400,100));
        panel8.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel8.setAlignmentY(Component.TOP_ALIGNMENT);
        panel8.add(addStation);
        panel8.add(stationEntry);
        
        /*
         *  Each panel is combined into one panel that is aligned to the left side of the frame 
         */
        leftpanel.add(panel1);
        leftpanel.add(panel2);
        leftpanel.add(panel3);
        leftpanel.add(panel4);
        leftpanel.add(panel5);
        leftpanel.add(panel6);
        leftpanel.add(dist0);
        leftpanel.add(dist1);
        leftpanel.add(dist2);
        leftpanel.add(dist3);
        leftpanel.add(dist4);
        leftpanel.add(panel8);
        
        /*
         * The Right side of the frame is aligned to the right side and holds a text field that
         * outputs an error message when a non-desired output is entered in stationEntry
         */
        errorMessage.setAlignmentX(CENTER_ALIGNMENT);
        errorMessage.setAlignmentY(CENTER_ALIGNMENT);
        rightpanel.add(errorMessage);
        
        
        // Adds the panels to the frame
        this.add(rightpanel);
        this.add(leftpanel, BorderLayout.WEST);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        /*
         * Changes the text field with the value selected the slider
         */
        HammingDistSlider.addChangeListener((e) -> {
        	HammingDistDisplay.setText(String.valueOf(HammingDistSlider.getValue()));
		}
		);
        
        /*
    	 *  Finds how many nodes are each hamming distance away fromo the selected station
    	 */
        calculateHD.addActionListener((e) -> {
        	ArrayList<Integer> nodes = findNodes(STID.get(dropdown.getSelectedIndex()));
        	distance0.setText(String.valueOf(nodes.get(0)));
        	distance1.setText(String.valueOf(nodes.get(1)));
        	distance2.setText(String.valueOf(nodes.get(2)));
        	distance3.setText(String.valueOf(nodes.get(3)));
        	distance4.setText(String.valueOf(nodes.get(4)));
        }
        );
        
        /*
    	 *  Checks to see that the input is a String with only characters
    	 *  that are uppercase and that it is 4 letters long
    	 */
        addStation.addActionListener((e) -> {
        	if(!(stationEntry.getText().length() == 4))
        	{
        		errorMessage.setText("The STID value must be 4 characters long");
        	}
        	else if(((int) stationEntry.getText().charAt(0) < 64) || ((int) stationEntry.getText().charAt(0) > 90))
        	{
        		errorMessage.setText("The STID value must only contain Uppercase Characters");
        	}
        	else if(((int) stationEntry.getText().charAt(1) < 64) || ((int) stationEntry.getText().charAt(1) > 90))
        	{
        		errorMessage.setText("The STID value must only contain Uppercase Characters");
        	}
        	else if(((int) stationEntry.getText().charAt(2) < 64) || ((int) stationEntry.getText().charAt(2) > 90))
        	{
        		errorMessage.setText("The STID value must only contain Uppercase Characters");
        	}
        	else if(((int) stationEntry.getText().charAt(3) < 64) || ((int) stationEntry.getText().charAt(3) > 90))
        	{
        		errorMessage.setText("The STID value must only contain Uppercase Characters");
        	}
        	else
        	{
        		errorMessage.setText("No errors");
        		STID.add(stationEntry.getText());
        		dropdown.addItem(stationEntry.getText());
        	}
        }
        );
        
        /*
    	 * Finds the stations that is a certain hamming distance away,
    	 * which is determined by the slider
    	 */
        showStation.addActionListener((e) -> {
        	ArrayList<String> sameHD = new ArrayList<String>();
        	int dist = HammingDistSlider.getValue();
        	String temp = "";
        	for(int k = 0; k < STID.size(); k++)
        	{
        		int hd = findHammingDist(STID.get(dropdown.getSelectedIndex()), STID.get(k));
        		if(hd == dist)
        		{
        			sameHD.add(STID.get(k));
        		}
        	}
        	// Puts all of the STIDs in a string with line breaks after each STID
        	for(int k = 0; k < sameHD.size(); k++)
        	{
        		temp += sameHD.get(k) + "\n";
        	}
        	// Makes sure that the previous output does not remain
        	stations.setText(temp);
        }
        );
	
	}
	
	public void readFile() throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(new File("Mesonet.txt")));
		int count = 0;
		String temp = "";
		// The while loop fills an Array List with STID values
		while (count < 120)
		{
			temp = in.readLine();
			temp = temp.substring(0,4);
			STID.add(temp);
			count++;
		}
		in.close();
	}
	
	public int findHammingDist(String strg1, String strg2)
	{
		int dist = 0;
		for (int k = 0; k < 4; k++)
		{
			//Compares the two STID values inputted
			if (strg1.charAt(k) != strg2.charAt(k))
			{
				dist++;
			}
		}
		return dist;
	}
	
	public ArrayList<Integer> findNodes(String strg)
	{
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		//Adds enough space for each of the node values
		nodes.add(0);
		nodes.add(0);
		nodes.add(0);
		nodes.add(0);
		nodes.add(0);
		int dist = 0;
		//temp is used as a temporary variable to hold the current value of an element at a specific index and then increases it by one
		int temp = 0;
		for (int k = 0; k < STID.size(); k++)
		{
				dist = findHammingDist(strg, STID.get(k));
				temp = nodes.get(dist);
				//The switch statement increases the value of the element in the array that corresponds with hamming distance
				switch (dist)
				{
				case 0:
					nodes.set(0, temp + 1);
					break;
				case 1:
					nodes.set(1, temp + 1);
					break;
				case 2:
					nodes.set(2, temp + 1);
					break;
				case 3:
					nodes.set(3, temp + 1);
					break;
				case 4:
					nodes.set(4, temp + 1);
					break;
				default:
					break;
				}
		}
		return nodes;
	}
	
	
	
	public static void main(String[] args) throws IOException
	{
		HammingDistFrame Frame = new HammingDistFrame();
	}
}
