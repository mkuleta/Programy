import java.awt.AWTEventMulticaster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class generator extends Thread implements PulseSource{

	private ActionListener al;
	private boolean alive;
	private boolean isalive;
	private static byte trybpracy;
	private int burst;
	private int wybor;
	private int countTick;
	public int opoznienie;
	Cortex_M0_SysTic SysTick = new Cortex_M0_SysTic();

	public generator()
	{
		
		burst=3;			
		start();
		trigger();
		setMode((byte) trybpracy);
		setPulseCount(burst);
		
	}


	public void run()
	{
		while(alive)
		{
			try {
				if(isalive=true) {
				Thread.sleep(opoznienie);			//ustawia opoznienie wątku
				System.out.println("tick");
				countTick++;
				if(al!=null)
				{
					al.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Tick"));
				}
				else
					Thread.sleep(1);
				
				
				}
				} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}


	@Override
	public void addActionListener(ActionListener pl) 
	{
		al=AWTEventMulticaster.add(al, pl);											//synchronizacja wątków
	}

	@Override
	public void removeActionListener(ActionListener pl) 
	{
		al=AWTEventMulticaster.remove(al, pl);										
	}

	@Override
	public void trigger() {
		isalive=true;
		
	}

	@Override
	public void setMode(byte mode) {

		if(mode==0)
		{
			trybpracy=0;
		}
		else
		{
			trybpracy=1;
		}
		
	}

	@Override
	public byte getMode() {

		return trybpracy;
	}

	@Override
	public void halt() {

		SysTick.setDisable();
	}

	@Override
	public void setPulseDelay(int ms) {

		opoznienie=ms;
	}

	@Override
	public int getPulseDelay() {

		return opoznienie;
	}

	@Override
	public void setPulseCount(int burst) {
		
		countTick=burst;
	
	}


	@Override
	public void killThread() {
		
		alive = false;
	}
	
}
