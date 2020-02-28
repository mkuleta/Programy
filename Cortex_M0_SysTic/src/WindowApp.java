import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class WindowApp extends JFrame implements ActionListener {
	private JButton b=new JButton("Hello");	
	private JButton a=new JButton("World");	
	private Knob k=new Knob();
	generator g=new generator();
	
	/*
	 * 
	 * OPIS PROGRAMU
	 * GENERATOR z pokr�t�em
	 * umozliwia uzytkowanie systicka
	 * okno podzielone na 2 czesci
	 * W lewej wszystko o systicku wlacz wylacz stany itp
	 * po prawej na pol
	 * gora to generator plus jego parametry
	 * jedno zrodlo wyzwalane generatorem drugie tylko przyciskiem
	 * na dole pole tekstowe ktore bedzie wyswietlal stany etc
	 * JAVA FX Help-> NEW SOFT-> swing->
	 *  
	 */
	
	
	public WindowApp() 
	
	{	
		
		g.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Tick obsłużony w okienku");
				
			}
		});
		b.addActionListener(this);
		a.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
			
			}
		});
		Container c = getContentPane();
		Container d = new Container();
		d.setLayout(new FlowLayout());
		c.add(d,BorderLayout.NORTH);
		c.add(k,BorderLayout.CENTER);
		d.add(b);
		d.add(a);
		setSize(new Dimension(500,500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}

	public static void main(String[] args) 
	{
		new WindowApp();

	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(arg0.getSource()==b);


	}

}
