//pokrętło

/*
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class Knob extends JComponent implements MouseListener, MouseMotionListener			
{
	private int knobx;
	private int knoby;
	private int x; 
	private int y;
	private int diameter;
	private int ovaldiameter;				//wielkosc malego pokretełka
	private Color knob;
	private Color oval;
	private Color background;
	private int value;
	private boolean clicked;
	
	public Knob()
	{
		this(0);							//wywołanie innego konstruktora
	}
	
	
	public Knob(int value)
	{
		this.value=value;
		knob=Color.BLUE;
		oval=Color.BLACK;
		background=Color.MAGENTA;
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Dimension d=getSize();
		diameter=Math.min(d.width, d.height);
		ovaldiameter=diameter/10;
		knobx=d.width/2;
		knoby=d.height/2;
		g.setColor(knob);
		g.fillOval(d.width/2-diameter/2, d.height/2-diameter/2, diameter, diameter);
		g.setColor(oval);
		g.fillOval(d.width/2-ovaldiameter/2, d.height/2-diameter/2+ovaldiameter/2, ovaldiameter, ovaldiameter);
		//wartosci 0x0
		x = d.width/2-ovaldiameter/2;
		y = d.height/2-diameter/2+ovaldiameter;
		
		
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {

		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
		Point p=e.getPoint();
		if(p.distance(knobx, knoby)<diameter/2)
		{
			System.out.println("nacisnieto wew");
			clicked = true;
		}
		else
		{
			System.out.println("nacisnieto zew");	
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		clicked=false;
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {

		
	}


	@Override
	public void mouseExited(MouseEvent e) {

		
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		if(clicked)
		{
			System.out.println(arg0.getPoint());
		}
	}


	@Override
	public void mouseMoved(MouseEvent e) {

		
	}
	
	
	
}
*/


//ADI KNOB

import javax.swing.JComponent;
import java.lang.Math;
import java.awt.*;
import java.awt.event.*;



public class Knob extends JComponent implements MouseListener,MouseMotionListener{
	
	//srodki naszego okregu
	private int knobX;
	private int knobY;
	
	private int i;
	
	

	
	
	private int x;
	private int y;
	private int diameter;
	private int ovaldiameter;
	private int value;
	
	private Color knob;
	private Color oval;
	private Color background;
	
	private int mousex; // mouse during mouse event
	private int mousey; // mouse during mouse event
	private int newmousex; // calculated new xy
	private int newmousey; // calculated new xy
	private int R;

	
	
	
	
	//dla testu:
	private int moveWskaznikX;
	private int moveWskaznikY;
	private double cosinus;
	private double sinus;
	private double tangens;
	
	
	private int mnoznik; //pomocnicze
	private int mnoznik2; // pomocnicze
	private int realMnoznik;
	public int mojaOdleglosc;
	private double kacikMatrymonialny;

	
	
	private boolean clicked;
	
	public Knob(){
		
		this(0);
		
	}
	public Knob(int value) {
		
		
		this.value=value;
		knob=Color.BLUE;
		oval=Color.BLACK;
		background=Color.GRAY;
		addMouseListener(this);
		addMouseMotionListener(this);
		clicked=false;
		
	}
	
	
	
	
	//funkcja zwracająca długość odcinka o określonych współrzędnych
	public double dlugosc(int x1, int y1, int x2, int y2) {
		double dlugoscX = Math.pow(x2-x1, 2);
		double dlugoscY = Math.pow(y2-y1, 2);
		double suma = dlugoscX + dlugoscY;
		double zwracam = Math.pow(suma, 0.5);
		return zwracam;
	}
	
	public double getAngleCos(int x, int y, int newx, int newy,double odleglosc) {
		double angle;
		
		angle = (newx - x)/odleglosc;
		
		
		return angle;
		
		
	}
	
	
	public double getAngleSin(int x, int y, int newx, int newy,double odleglosc) {
		double angle;
		
		angle = (newy - y)/odleglosc;
		
		return angle;
		
	}
	// wyliczenie wartości kąta
	public double getAngleTan(int moveWskaznikX, int moveWskaznikY) {
		double angle;
		double tangens;
		tangens = moveWskaznikX/moveWskaznikY;
		angle = moveWskaznikX * moveWskaznikY/1000 - 9;
		return Math.abs(moveWskaznikX - 200);
	}
	

	
	
	// funkcja ktora przejmuje jako argument grafike
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		//wielkosc naszego componentu
		Dimension d= getSize();
		diameter= Math.min(d.width, d.height);
		ovaldiameter=diameter/10;
		knobX=d.width/2;
		knobY=d.height/2;
		
		
		g.setColor(knob);
		//d wielkosc okna
		g.fillOval(d.width/2-diameter/2,d.height/2-diameter/2,diameter,diameter);

		//przypisanie x i y wskaznika (początkowych)
		x = d.width/2-ovaldiameter/2;
		y = d.height/2-diameter/2+ovaldiameter;
		
		//obliczenie wartosci sinus i cosinus
		cosinus = getAngleCos(x,y,mousex,mousey,dlugosc(x,y,mousex,mousey));
		sinus   = getAngleSin(x,y,mousex,mousey,dlugosc(x,y,mousex,mousey));
		
		
	
		// przypisuje współrzędne okręgu punktu regulacyjnego
		if (clicked) {
		moveWskaznikX = x + (int)(R*cosinus);
		moveWskaznikY = d.height/2-diameter/2 + (int)(4.3 * ovaldiameter)  + (int)(R*sinus);
		

		// zostało kliknięte i rysuje wskaznik początkowy 
		mnoznik = (int)dlugosc((int)(d.width/2-ovaldiameter/2),(int)(d.height/2-diameter/2+ovaldiameter - (int)(0.8 * ovaldiameter)),moveWskaznikX,moveWskaznikY);
		System.out.println(mnoznik/10);

		g.setColor(Color.DARK_GRAY);
		//g.fillOval(x, d.height/2-diameter/2 + (int)(4.3 * ovaldiameter) + R, ovaldiameter, ovaldiameter); // punkt na samym dole
		g.fillOval(d.width/2-ovaldiameter/2,
		d.height/2-diameter/2+ovaldiameter - (int)(0.8 * ovaldiameter),ovaldiameter,ovaldiameter);
		//
		//punkt na koniec zakresu
		g.setColor(Color.DARK_GRAY);
		g.fillOval(x, d.height/2-diameter/2 + (int)(4.3 * ovaldiameter) + R, ovaldiameter, ovaldiameter); // punkt na samym dole
		//
		if (moveWskaznikX == x  && moveWskaznikY == d.height/2-diameter/2 + (int)(4.3 * ovaldiameter) + R)
		{
			System.out.println("Koniec zakresu 🙂");
		
			
		}
		//
		} else {
		
		moveWskaznikX = d.width/2-ovaldiameter/2 + mousex;
		moveWskaznikY = d.height/2-diameter/2+ovaldiameter + mousey;
			
		}	
	
		
		//obliczenie długości srodek dużego okregu - środek małego
		R = (int)dlugosc(d.width/2-ovaldiameter/2,d.height/2-diameter/2+ovaldiameter,knobX,knobY);
		
		//
	
		
		
		
		
		g.setColor(oval);
		g.fillOval(moveWskaznikX, moveWskaznikY, ovaldiameter, ovaldiameter);
		

		//wskaznik początkowy
	
		
		
		
		
		
		
		
	
		
		
		
		
		
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	//myszka zostalo nacisnieta, ustawic zmienna w klasi ktora bedzie nam mowila czy zostala nacinieta
	public void mousePressed(MouseEvent mypoint) {
		// TODO Auto-generated method stub
		Point p =mypoint.getPoint();
		//sprawdza czy punkt sie znajduje w srodku okregu
		if(p.distance(knobX,knobY)<diameter/2){
			
			clicked = true;
			mousex = mypoint.getX();
			mousey = mypoint.getY();
			
	
			
			
		}
		
		else {
			
			clicked = false;
			
			
		}
			
		
		repaint();
	}
	@Override
	// zpsya³a nienacisnieta zeby program nie reagowal jak nie zostanie nacisnieta
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		clicked =false;
	}
	@Override
	
	//przesuwanie
	public void mouseDragged(MouseEvent mypoint) {
		// TODO Auto-generated method stub
		if(clicked) {
			
			
			
			mousex = mypoint.getX();
			mousey = mypoint.getY();
			
			
			
			
			repaint();
			
			
		}
		
		
		
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	
	
	
	
	
	
	
}

