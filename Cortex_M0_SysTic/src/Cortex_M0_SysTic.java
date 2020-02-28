//import java.util.concurrent.TimeUnit;

//import com.sun.tools.javac.parser.Scanner;

public class Cortex_M0_SysTic implements Cortex_M0_SysTic_Interface 
{    
    
    public int CVR;
    public int RVR;
    public int CSR;
    public int impuls;
    private boolean EnableFlag;
    private boolean CountFlag;
    private boolean InterruptFlag;
    private boolean Interrupt;
    private boolean InOrEx; 
    private String zrodlo;
    public Cortex_M0_SysTic()
    {

        EnableFlag = false;
        CountFlag = false;
        InterruptFlag = false;
        Interrupt=false;
        
    }
    
    
    @Override
    public void tickInternal()				//source == true
    {
    	if(InOrEx==true) {
    		if(EnableFlag)
    		{
            	if(CVR==0)
            	{
            		CVR=RVR;
            		//Interrupt=true;
            		CountFlag=false;
            		if(RVR==0)
            			setDisable();		//ustawienie metody disable // wy��czenie
            	}
            	else
            	CVR--;				//dekrementacja, zliczanie w d�
            	if(CVR==0)
            	{
            		CountFlag=true;
            	}
        	}
    	}
    }
    
    @Override
    public void tickExternal()				//source == false
    {
    	if(InOrEx==false) 
    	{
    		if(EnableFlag)
    		{
            	if(CVR==0)
            	{
            		CVR=RVR;
            		//Interrupt=true;
            		CountFlag=false;
            		if(RVR==0)
            			setDisable();		//ustawienie metody disable // wy��czenie
            	}
            	else
            	CVR--;				//dekrementacja, zliczanie w d�
            	if(CVR==0)
            	{
            		CountFlag=true;
            	}
        	}
    	}
    }
    
    @Override
    public void setCVR(int limit)
    {
        CountFlag=false;
        
        CVR=limit & 16777215;
    }

    @Override
    public void setCSR(int limit)
    {	
    	CSR=limit;
    }
    
    @Override
    public void setRVR(int limit)			//u2 zastosowa� & // limit & (2^24-1)
    {
    	RVR = limit & 16777215;
    }  
    public void setImpuls(int limit)
    {
    	
    	if(limit==999)
    		impuls++;
    	else
    		impuls=limit;
    }
    @Override
    public void reset()
    {   
    	CVR=0;
    	RVR=0;
    	setDisable();
    }
    
    
    @Override
    public void setEnable() 
    { 
    	CVR=RVR+1;				//regulacja pierwszego impulsu
        EnableFlag=true;
    }


    @Override   
    public void setDisable()
    {
    	EnableFlag=false;
    }
    
    @Override
    public void setSource(boolean source)  //wyb�r tick
    {
    	InOrEx=source;
    	
    	if(source==true)
    	{
    		zrodlo="Tick wewnetrzny";
    	}
    	else
    	{
    		zrodlo="Tick zewnetrzny";
    	}	
    }
    
    @Override
    public void setInterruptEnable()
    {
    	InterruptFlag=true;
    }
    
    @Override
    public void setInterruptDisable()
    {
    	InterruptFlag=false;
    }
    

    @Override 
    public int getCVR()
    {	
    	Interrupt=true;
    	CountFlag=false;
        return CVR;
    }
    @Override
    public int getRVR()
    {
    	CountFlag=true;
        return RVR;
    }
    @Override
    public int getCSR()
    {
    	CountFlag=false;
    	return CSR;
    }
    
    public int getImpuls()
    {
    	return impuls;
    }
    
    @Override
    public boolean getEnabled()
    {
        return EnableFlag;
    }
    
    @Override
    public boolean getInterrupt()
    {
        return Interrupt;
    }
      
    
    @Override
    public boolean isCountFlag()
    {
    	  return CountFlag;
    }
    
    @Override
    public boolean isEnableFlag()
    {
    	  return EnableFlag;
    }
    
    @Override
    public boolean isInterruptFlag()
    {
        return InterruptFlag;
    }
    
    @Override
    public boolean isInterrupt()
    {
    	return Interrupt;

    }
    
    public String toString()
    {
    	return ("Counter\nTick: "+ zrodlo + "\nCVR = " + CVR + "\nRVR = " + RVR + "\nEnableFlag = " + EnableFlag + "\nCountFlag = " + CountFlag + "\nInterruptFlag = " +InterruptFlag); 
    }
    
    public static void main(String[] args)
    {      		
        	System.out.println("CortexM0Timer");
    
    }
}

