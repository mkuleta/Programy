package com.example.projekt_dodatkowy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int SEND_SMS_PERMISSION_REQUEST_CODE=1;
    public String wiadomosc;
    EditText cisnienie;
    EditText temperatura;
    EditText wilgotnosc;
    Button wyslij;
    EditText telefon;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        temperatura=findViewById(R.id.wartTemp);
        cisnienie=findViewById(R.id.wartCisn);
        wilgotnosc=findViewById(R.id.wartWilg);

        wyslij=findViewById(R.id.SEND);
        telefon=findViewById(R.id.numer);

        if(sprawdz(Manifest.permission.SEND_SMS))
        {
            wyslij.setEnabled(true);
        }else{
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SEND_SMS},SEND_SMS_PERMISSION_REQUEST_CODE);
        }


    }


    public void wyslij(View v)
    {
        String numertel=telefon.getText().toString();
        String temp = temperatura.getText().toString();
        String wilg = wilgotnosc.getText().toString();
        String cisn = cisnienie.getText().toString();
        wiadomosc="Temperatura: "+temp+"°C"+"\nCisnienie: "+cisn+"hPa"+"\nWilgotnosc: "+wilg+"%";
        String wiadomoscsms=wiadomosc;
        if(wiadomoscsms==null || wiadomoscsms.length()==0)
        {
            Toast.makeText(this, "Wpisz tekst wiadomości!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(numertel==null || numertel.length()==0 || numertel.length()>9 || numertel.length()<9 )
        {
            Toast.makeText(this, "Wpisz poprawny numer telefonu!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(sprawdz(Manifest.permission.SEND_SMS))
        {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(numertel, null, wiadomoscsms, null, null);
            Toast.makeText(this, "Wiadomość wysłano pomyślnie!", Toast.LENGTH_SHORT).show();
        }
    }


    public boolean sprawdz(String pozwolenie)
    {
        int check = ContextCompat.checkSelfPermission(this, pozwolenie);
        return (check == PackageManager.PERMISSION_GRANTED);

    }


}
