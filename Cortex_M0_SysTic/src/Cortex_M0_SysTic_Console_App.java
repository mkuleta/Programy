import java.util.Scanner;

public class Cortex_M0_SysTic_Console_App
{
    // instance variables - replace the example below with your own
    Cortex_M0_SysTic myCounter;
    public static int scn;
    public static int cvrconsole;
    public static int rvrconsole;
    public static int impuls;
    public Cortex_M0_SysTic_Console_App()
    {
        myCounter = new Cortex_M0_SysTic();
        ConsoleShow();
        	
    }
    
    
    private void ConsoleShow()
    {	
    	System.out.println("Wybierz zrodlo zegara\n");
        System.out.println("1. TickInternal\n");
        System.out.println("2. TickExternal\n");
        System.out.println("3. Exit\n"); 
        Scanner sc = new Scanner(System.in);
        scn = sc.nextInt();
        
       	
        switch(scn) {
    	case 1:					//tickIN
    		myCounter.setSource(true);
    		break;
    	case 2:					//tickEX
    		myCounter.setSource(false);
    		break;
    	case 3:
    		System.out.println("Do zobaczenia!");
    		System.exit(0);
     		break;
    	default:
    		System.out.println("Wybierz spo�r�d 1/2/3 !!!");
    	break;
        }
     
        if(scn==1 || scn==2)
        {
        System.out.println("Rozpoczynamy pokaz");
        myCounter.setEnable();
        System.out.println("Wprowadz wartosc RVR");
        rvrconsole=sc.nextInt();
        myCounter.setRVR(rvrconsole);
        System.out.println("Wprowadz wartosc CVR");
        cvrconsole=sc.nextInt();
        myCounter.setCVR(cvrconsole);
        System.out.println("Wprowadz ilosc impuls�w");
        myCounter.setImpuls(impuls);
        impuls=sc.nextInt();
        
    	for(int i = 0; i < impuls; i++) {
    	if(scn==1)
    		{
    			myCounter.tickInternal();
    		}
    	else if(scn==2)
    		{
    			myCounter.tickExternal();
    		}
        System.out.println("\n" + myCounter.toString() + "\n");
        }
               	
        
    }

    }
    public static void main(String[] arg)
    {
        new Cortex_M0_SysTic_Console_App();
    }
}