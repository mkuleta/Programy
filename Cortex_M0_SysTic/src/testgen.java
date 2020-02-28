import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Checkbox;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.io.Console;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JRadioButton;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;


public class testgen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
    public static int src;
    private boolean mode;
    //private int impuls;
	Cortex_M0_SysTic SysTick = new Cortex_M0_SysTic();
	generator gen = new generator();
	
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testgen frame = new testgen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	public testgen() {
		setTitle("SysTick Window App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1293, 765);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Panel panel = new Panel();
		panel.setBounds(655, 10, 612, 297);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(655, 326, 612, 390);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBounds(6, 60, 596, 319);
		panel_2.add(editorPane);
		
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField.setText("0");
		textField.setBounds(496, 229, 106, 57);
		panel.add(textField);
		textField.setColumns(10);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textField.setText(Integer.toString(slider.getValue()));
				
			}
		});
		slider.setValue(0);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(5);
		slider.setMaximum(30);
		slider.setForeground(Color.BLACK);
		slider.setBounds(10, 229, 384, 57);
		panel.add(slider);
		
		JLabel lblNewLabel = new JLabel("Frequency set");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 196, 531, 26);
		panel.add(lblNewLabel);
		
		JLabel lblGenerator = new JLabel("Generator");
		lblGenerator.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblGenerator.setBounds(10, 11, 106, 38);
		panel.add(lblGenerator);
		
		JButton setFreq = new JButton("SET");
		setFreq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SysTick.setImpuls((int)(Integer)slider.getValue());	
				//System.out.println("Liczba impulsów: "+(Integer)slider.getValue());
				editorPane.setText("Internal impulse count: "+(Integer)slider.getValue());
			}
		});
		setFreq.setFont(new Font("Tahoma", Font.PLAIN, 18));
		setFreq.setBounds(406, 229, 80, 57);
		panel.add(setFreq);
		
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(10, 10, 612, 706);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("setCVR");
		btnNewButton.setBounds(10, 74, 118, 53);
		panel_1.add(btnNewButton);
		
		JButton btnSetrvr = new JButton("setRVR");
		btnSetrvr.setBounds(146, 74, 118, 53);
		panel_1.add(btnSetrvr);
		
		
		JLabel lblNewLabel_1 = new JLabel("SysTick");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(10, 11, 531, 52);
		panel_1.add(lblNewLabel_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(10, 157, 118, 53);
		panel_1.add(spinner);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SysTick.setCVR((int)(Integer)spinner.getValue());		
				//System.out.println("CVR: "+(Integer)spinner.getValue());
				editorPane.setText("CVR: "+(Integer)spinner.getValue());
			}
		});
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(146, 157, 118, 53);
		panel_1.add(spinner_1);
		btnSetrvr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				SysTick.setRVR((int)(Integer)spinner_1.getValue());
				//System.out.println("RVR: "+(Integer)spinner_1.getValue());
				editorPane.setText("RVR: "+(Integer)spinner_1.getValue());
			}
		});
		

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(274, 157, 118, 53);
		panel_1.add(spinner_2);

		
		
		JLabel lblWybierz = new JLabel("Wybierz Tick");
		lblWybierz.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWybierz.setBounds(20, 231, 244, 27);
		panel_1.add(lblWybierz);
		
		
		
		
		
		////////////////AREA TEXT//////////////////////
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(30);
		textArea.setTabSize(100);
		textArea.setEditable(false);
		textArea.setBounds(10, 377, 577, 318);
		panel_1.add(textArea);
		
		

		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(6, 11, 106, 38);
		panel_2.add(lblStatus);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 19));
		

		
		
		
		///////////TICK INTERNAL///////////
		
		JButton btnTickInternal = new JButton("Tick Internal");
		btnTickInternal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				src=1;
				SysTick.setSource(true);
				System.out.println("Tick wewnetrzny");
				
			}
		});
		btnTickInternal.setBounds(10, 269, 118, 53);
		panel_1.add(btnTickInternal);
		
		
		///////////TICK EXTERNAL///////////
		
		///IMPULSY
		JButton btnIleImpulsw = new JButton("External Impulse");
		btnIleImpulsw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				SysTick.setImpuls((int)(Integer)spinner_2.getValue());
				editorPane.setText("External impulse: "+SysTick.getImpuls());
				//System.out.println((int)(Integer)spinner_2.getValue());
				
			}
		});
		btnIleImpulsw.setBounds(274, 74, 118, 53);
		panel_1.add(btnIleImpulsw);
		
		
		//////SET TICK EXT/////////
		JButton btnTickExternal = new JButton("Tick External");
		btnTickExternal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				src=2;
				SysTick.setSource(false);
				System.out.println("Tick zewnetrzny");
				
				
			}
		});
		btnTickExternal.setBounds(146, 269, 118, 53);
		panel_1.add(btnTickExternal);
		

		
		JButton clearBTN = new JButton("CLEAR LOG");
		clearBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int clear=0; clear<50; clear++)
					System.out.println("\b");
				
				for(int clear2=0; clear2<10; clear2++)
					System.out.println(" ");
			}
		});
		clearBTN.setForeground(Color.WHITE);
		clearBTN.setBackground(Color.MAGENTA);
		clearBTN.setBounds(402, 269, 118, 53);
		panel_1.add(clearBTN);
		
		JButton STOP = new JButton("STOP GENERATOR");
		STOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gen.halt();
				SysTick.setDisable();
				editorPane.setText("GUI WSTRZYMANE");
			}
		});
		STOP.setBounds(413, 74, 189, 136);
		panel_1.add(STOP);
		STOP.setFont(new Font("Tahoma", Font.BOLD, 11));
		STOP.setBackground(Color.RED);
		STOP.setForeground(Color.WHITE);
		
		JToggleButton modeBTN = new JToggleButton("MODE");
		modeBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			mode = modeBTN.isSelected();
			if(mode)
			{
				gen.setMode((byte)0);
				editorPane.setText("MODE: BURST MODE");
			}
			else
			{
				gen.setMode((byte)1);
				editorPane.setText("MODE: CONTINOUS MODE");
			}
			

				
			}
		});
		modeBTN.setToolTipText("Gdy wciśnięty ustawiony tryb to burst, gdy odciśnięty to tryb wybrany to continues");
		modeBTN.setFont(new Font("Tahoma", Font.PLAIN, 22));
		modeBTN.setBounds(10, 60, 149, 50);
		panel.add(modeBTN);
		
		JSpinner spin_delay = new JSpinner();
		spin_delay.setValue(1000);
		spin_delay.setBounds(496, 60, 106, 50);
		panel.add(spin_delay);
		
		JButton pulsedelaySET = new JButton("SET");
		pulsedelaySET.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gen.setPulseDelay((int)(Integer)spin_delay.getValue());
				editorPane.setText("Pulse delay: "+gen.getPulseDelay());
			}
		});
		pulsedelaySET.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pulsedelaySET.setBounds(397, 60, 89, 50);
		panel.add(pulsedelaySET);
		
		JLabel lblNewLabel_2 = new JLabel("set PulseDelay");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(397, 23, 129, 26);
		panel.add(lblNewLabel_2);
		
		
		///////START/////////
		
		JButton startBTN = new JButton("START");
		startBTN.setToolTipText("Rozpocznij");
		startBTN.setBackground(new Color(0, 255, 0));
		startBTN.setFont(new Font("Tahoma", Font.PLAIN, 27));
		startBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SysTick.setEnable();
				gen.run();
				for(int i=0; i<SysTick.getImpuls(); i++) {
				if(src==1)
				{	
					
					SysTick.tickInternal();
				}
				else if(src==2)
				{
					
					SysTick.tickExternal();
				}
				System.out.println("\n"+SysTick.toString()+"\n");
				//textArea.setText("\n"+SysTick.toString()+"\n");
				//editorPane.setText("\n"+SysTick.toString()+"\n");
				
			}}
		});
		
		startBTN.setBounds(274, 269, 118, 53);
		panel_1.add(startBTN);
		
		
		
	}
}
