import java.awt.event.*;
/**
 * Write a description of interface PulseSource here.
 * 
 * @author (x) 
 * @version (a version number or a date)
 */

public interface PulseSource
{
final static byte BURST_MODE = 0;									//generuje ilosc impulsow
final static byte CONTINOUS_MODE = 1;								//generuje nieustannie

    void addActionListener(ActionListener pl);
    void removeActionListener(ActionListener pl);

    void trigger() ;												//uruchamia generator do peli while dopisac kod ktory bedzie wlaczal wylaczal gen
    void setMode(byte mode) ;										
    byte getMode() ;												
    void halt() ;													// zatrzymaj generację  zatrzymania generatora ale bez zatrzymywania wątku
    void setPulseDelay(int ms) ;									//ustawienie opoznienia ustawia to opoznienie ktore dajemy w sleep
    int getPulseDelay() ;											
    void setPulseCount(int burst) ;									//ile impulsow ma wygenerowac burst mode
    void killThread();
}
 
 
