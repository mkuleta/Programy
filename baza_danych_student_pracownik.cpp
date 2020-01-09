#include<iostream>

using namespace std;

class IIdentifable{
		
	public:
	virtual string identify()=0;
};

class Person: public IIdentifable{
		
	public:
	string identify(){
	return"Person class object";
	}


int numer;
int peselint[11];
int waga;
int wzrost;
int dzien, miesiac, rok;

string imie;
string nazwisko;
string plec;
string pesel;


public:
static int amount;

Person(string i="x", string n="x", string p="00000000000", string pe="x", int wa=0, int wz=0){
    numer = amount;
    amount++;
    imie = i;
    nazwisko = n;
    plec = p;
    pesel = pe;
    waga = wa;
    wzrost = wz;
    for(int i=0; i<11; i++){

		peselint[i]=pesel[i]-48;

    }

    if(peselint[2]>1){

        rok = 2000 + 10*peselint[0]+peselint[1];
        miesiac=10*(peselint[2]-20)+peselint[3];
        dzien=10*peselint[4]+peselint[5];

    }

	if(peselint[0]==0 && peselint[1]==0&&peselint[2]==0 && peselint[3]==0&&peselint[4]==0 && peselint[5]==0){
        rok = 0;
        miesiac =0;
        dzien =0;
    }
	else 
	{
        rok = 1900 + 10*peselint[0]+peselint[1];
        miesiac=10*peselint[2]+peselint[3];
        dzien=10*peselint[4]+peselint[5];
    }

}

virtual void wydrukujimie(void){
    cout<<imie;
}


virtual void wydrukuj(void){
    cout << "\nOsoba nr "<< numer <<"\nImie: "<<imie<<"\nNazwisko: "<<nazwisko<<"\nPlec: "<<plec<<"\nPesel: "<<pesel<<"\nWaga: "<<waga<<"\nWzrost: "<<wzrost;
     for(int i=0; i<11; i++){
        peselint[i]=pesel[i]-48;
    }
    cout <<"\nData urodzenia: "<<rok<<" "<<miesiac<<" "<<dzien;
}


virtual void dodaj(void){
    cout<<"\nWpisz imie: ";
    cin >> imie;
    cout<<"\nWpisz nazwisko: ";
    cin >> nazwisko;
    cout<<"\nWpisz plec: ";
    cin >> plec;
    cout<<"\nWpisz pesel: ";
    cin >> pesel;
    cout<<"\nWpisz wage: ";
    cin >> waga;
    cout<<"\nWpisz wzrost: ";
    cin >> wzrost;
    
	for(int i=0; i<11; i++){
        peselint[i]=pesel[i]-48;
    }

    if(peselint[2]>1){
        rok = 2000 + 10*peselint[0]+peselint[1];
        miesiac=10*(peselint[2]-2)+peselint[3];
        dzien=10*peselint[4]+peselint[5];
    }
	else
	{
        rok = 1900 + 10*peselint[0]+peselint[1];
        miesiac=10*peselint[2]+peselint[3];
        dzien=10*peselint[4]+peselint[5];
    }
}

virtual void zamien(void){
    int choice;
    cout <<"Wybierz odpowiednia opcje: \n";
    cout <<"1. Imie\n2. Nazwisko\n3. plec\n4. pesel\n5. waga\n6. wzrost\n";
    cin >> choice;
    switch (choice) {
    case 1:
        cout<<"\nPodaj nowe imie:";
        cin >> imie;
        break;
    case 2:
        cout<<"\nPodaj nowe nazwisko:";
        cin >> nazwisko;
        break;
    case 3:
        cout<<"\nPodaj inna plec:";
        cin >> plec;
        break;
    case 4:
        cout<<"\nPodaj nowy pesel:";
        cin >> pesel;
        for(int i=0; i<11; i++){
        peselint[i]=pesel[i]-48;
    }
	
    if(peselint[2]>1){
        rok = 2000 + 10*peselint[0]+peselint[1];
        miesiac=10*(peselint[2]-2)+peselint[3];
        dzien=10*peselint[4]+peselint[5];
    }

	else
	{
        rok = 1900 + 10*peselint[0]+peselint[1];
        miesiac=10*peselint[2]+peselint[3];
        dzien=10*peselint[4]+peselint[5];
    }
	break;
    case 5:
        cout<<"\nPodaj nowa wage:";
        cin >> waga;
	break;
    case 6:
        cout<<"\nPodaj nowy wzrost:";
        cin >>wzrost;
    break;
    }
}

};

int Person::amount = 1;


class Student: public Person{
   
	int nralbumu;

public:
		string identify(){
		return imie+"	"+nazwisko;
		}
		Student(string i="x", string n="x", string p="00000000000", string pe="x", int wa=0, int wz=0, int nra=0){//Konstruktor z wartosciami domniemanymi
        numer = amount;
        amount++;
        imie = i;
        nazwisko = n;
        plec = p;
        pesel = pe;
        waga = wa;
        wzrost = wz;
        nralbumu = nra;
		for(int i=0; i<11; i++){ 

            peselint[i]=pesel[i]-48;

        }
        if(peselint[2]>1){

            rok = 2000 + 10*peselint[0]+peselint[1];
            miesiac=10*(peselint[2]-20)+peselint[3];
            dzien=10*peselint[4]+peselint[5];

        } 
		if(peselint[0]==0 && peselint[1]==0&&peselint[2]==0 && peselint[3]==0&&peselint[4]==0 && peselint[5]==0){
            rok = 0;
            miesiac =0;
            dzien =0;
        }
		else
		{
            rok = 1900 + 10*peselint[0]+peselint[1];
            miesiac=10*peselint[2]+peselint[3];
            dzien=10*peselint[4]+peselint[5];
        }
    }
        virtual void wydrukuj(void){
        cout << "\nOsoba nr "<< numer <<"\nImie: "<<imie<<"\nNazwisko: "<<nazwisko<<"\nPlec: "<<plec<<"\nPesel: "<<pesel<<"\nWaga: "<<waga<<"\nWzrost: "<<wzrost;
        cout <<"\nNumer albumu: " << nralbumu;
         for(int i=0; i<11; i++){
            peselint[i]=pesel[i]-48;
        }
        cout <<"\nData urodzenia: "<<rok<<" "<<miesiac<<" "<<dzien;

    }
    virtual void dodaj(void){
    cout<<"\nWpisz imie: ";
    cin >> imie;
    cout<<"\nWpisz nazwisko: ";
    cin >> nazwisko;
    cout<<"\nWpisz plec: ";
    cin >> plec;
    cout<<"\nWpisz pesel: ";
    cin >> pesel;
    cout<<"\nWpisz wage: ";
    cin >> waga;
    cout<<"\nWpisz wzrost: ";
    cin >> wzrost;
     for(int i=0; i<11; i++){
        peselint[i]=pesel[i]-48;
    }
    if(peselint[2]>1){
        rok = 2000 + 10*peselint[0]+peselint[1];
        miesiac=10*(peselint[2]-2)+peselint[3];
        dzien=10*peselint[4]+peselint[5];
    }else {
        rok = 1900 + 10*peselint[0]+peselint[1];
        miesiac=10*peselint[2]+peselint[3];
        dzien=10*peselint[4]+peselint[5];
    }
    cout <<"\nPodaj numer albumu: ";
    cin >> nralbumu;
}
    virtual void wydrukujimie(void){
    cout<<imie;
}
    virtual void zamien(void){
    int choice;
    cout<<"Wybierz odpowiednia opcje: \n";
    cout<<"1. Imie"<<endl;
	cout<<"2. Nazwisko"<<endl;
	cout<<"3. Plec"<<endl;
	cout<<"4. Pesel"<<endl;
	cout<<"5. Waga"<<endl;
	cout<<"6. Wzrost"<<endl;
	cout<<"7. Numer albumu"<<endl;
    

	cin >> choice;
    switch(choice){
    case 1:
        cout<<"\nPodaj nowe imie:";
        cin >> imie;
        break;
    case 2:
        cout<<"\nPodaj nowe nazwisko:";
        cin >> nazwisko;
        break;
    case 3:
        cout<<"\nPodaj inna plec:";
        cin >> plec;
        break;
    case 4:
        cout<<"\nPodaj nowy pesel:";
        cin >> pesel;
        for(int i=0; i<11; i++){
        peselint[i]=pesel[i]-48;
    }
    if(peselint[2]>1){
        rok = 2000 + 10*peselint[0]+peselint[1];
        miesiac=10*(peselint[2]-2)+peselint[3];
        dzien=10*peselint[4]+peselint[5];
    }else {
        rok = 1900 + 10*peselint[0]+peselint[1];
        miesiac=10*peselint[2]+peselint[3];
        dzien=10*peselint[4]+peselint[5];
    }
        break;
    case 5:
        cout<<"\nPodaj nowa wage:";
        cin >> waga;
        break;
    case 6:
        cout<<"\nPodaj nowy wzrost:";
        cin >>wzrost;
        break;
    case 7:
        cout<<"\nPodaj nowy numer albumu";
        cin >> nralbumu;
        break;
    }

}
};

class Faculty: public Person{
    

	int kartapracy;
	string nazwakatedry;
    
    

	public:
        string identify(){
		return"Faculty";
		}
    

	Faculty(string i="x", string n="x", string p="00000000000", string pe="x", int wa=0, int wz=0,string katedra="Brak", int karta=0){

        numer=amount;
        amount++;
        imie=i;
        nazwisko=n;
        plec=p;
        pesel=pe;
        waga=wa;
        wzrost=wz;
        nazwakatedry=katedra;
        kartapracy=karta;

        for(int i=0; i<11; i++){ 

            peselint[i]=pesel[i]-48;

        }

        if(peselint[2]>1){
            rok = 2000 + 10*peselint[0]+peselint[1];
            miesiac=10*(peselint[2]-20)+peselint[3];
            dzien=10*peselint[4]+peselint[5];
        } if(peselint[0]==0 && peselint[1]==0&&peselint[2]==0 && peselint[3]==0&&peselint[4]==0 && peselint[5]==0){
            rok = 0;
            miesiac =0;
            dzien =0;
        }else {
            rok = 1900 + 10*peselint[0]+peselint[1];
            miesiac=10*peselint[2]+peselint[3];
            dzien=10*peselint[4]+peselint[5];
        }

    }

virtual void wydrukujimie(void){
    cout<<imie;
}

virtual void wydrukuj(void){
        cout << "\nOsoba nr "<< numer <<"\nImie: "<<imie<<"\nNazwisko: "<<nazwisko<<"\nPlec: "<<plec<<"\nPesel: "<<pesel<<"\nWaga: "<<waga<<"\nWzrost: "<<wzrost;
         for(int i=0; i<11; i++){
            peselint[i]=pesel[i]-48;
        }
        cout <<"\nData urodzenia: "<<rok<<" "<<miesiac<<" "<<dzien;
        cout <<"\nNazwa katedry: " << nazwakatedry;
        cout <<"\nNumer karty pracy: " <<kartapracy;
    }
    virtual void dodaj(void){
    cout<<"\nWprowadz imie: ";
    cin >> imie;
    cout<<"\nWprowadz nazwisko: ";
    cin >> nazwisko;
    cout<<"\nWprowadz plec: ";
    cin >> plec;
    cout<<"\nWprowadz pesel: ";
    cin >> pesel;
    cout<<"\nWprowadz wage: ";
    cin >> waga;
    cout<<"\nWprowadz wzrost: ";
    cin >> wzrost;
     for(int i=0; i<11; i++){
        peselint[i]=pesel[i]-48;
    }
    if(peselint[2]>1){
        rok = 2000 + 10*peselint[0]+peselint[1];
        miesiac=10*(peselint[2]-2)+peselint[3];
        dzien=10*peselint[4]+peselint[5];
    }else {
        rok = 1900 + 10*peselint[0]+peselint[1];
        miesiac=10*peselint[2]+peselint[3];
        dzien=10*peselint[4]+peselint[5];
    }
    cout<<"Podaj nazwe Katedry: ";
    cin>>nazwakatedry;
    cout<<"Podaj numer karty pracy: ";
    cin>>kartapracy;
}
    virtual void zamien(void){
    int choice;
    cout <<"Co chcesz zrobic?: \n";
    cout <<"1. Imie\n2. Nazwisko\n3. plec\n4. pesel\n5. waga\n6. wzrost\n7. nazwa Katedry\n8. Numer karty pracy\n";
    cin>>choice;
    switch(choice) {
    case 1:
        cout<<"\nPodaj nowe imie:";
        cin >> imie;
        break;
    case 2:
        cout<<"\nPodaj nowe nazwisko:";
        cin >> nazwisko;
        break;
    case 3:
        cout<<"\nPodaj inna plec:";
        cin >> plec;
        break;
    case 4:
        cout<<"\nPodaj nowy pesel:";
        cin >> pesel;
        for(int i=0; i<11; i++){
        peselint[i]=pesel[i]-48;
    }
    if(peselint[2]>1){

        rok = 2000 + 10*peselint[0]+peselint[1];
        miesiac=10*(peselint[2]-2)+peselint[3];
        dzien=10*peselint[4]+peselint[5];

    }
		else 
	{
        rok = 1900 + 10*peselint[0]+peselint[1];
        miesiac=10*peselint[2]+peselint[3];
        dzien=10*peselint[4]+peselint[5];
    }
        break;
    case 5:
        cout<<"\nPodaj nowa wage:";
        cin >> waga;
        break;
    case 6:
        cout<<"\nPodaj nowy wzrost:";
        cin >>wzrost;
        break;
    case 7:
        cout <<"\nPodaj nowa nazwe Katedry: ";
        cin >>nazwakatedry;
        break;
    case 8:
        cout <<"\nPodaj nowy numer karty pracy: ";
        cin >> kartapracy;
        break;
    }

}
};


void print(IIdentifable*obj){

	cout<<obj->identify()<<endl;

}

void menu(int overlay){
	
switch(overlay) { 
	case 1:
        cout<<endl;
        cout << "Co chcesz zrobic?: "<<endl;
        cout << "1. Wydrukuj"<<endl;
        cout << "2. Edytuj"<<endl;
        break;
    case 2:
        cout<<endl;
        cout << "Co chcesz zrobic?: "<<endl;
        cout << "1. Wydrukuj"<<endl;
        cout << "2. Edytuj"<<endl;
        cout << "3. Dodaj "<<endl;
        break;
    case 3:
    	cout<<endl;
        cout <<"Wybierz specjalnosc obiektu: "<<endl;
        cout <<"1. Pracownik"<<endl;
        cout <<"2. Student"<<endl;
        cout <<"3. Osoba"<<endl;
    }
}

	

int main(){
    

	Person**personArray = new Person*[11];
  
    	personArray[0]=new Person;
    	personArray[1]=new Person;
    	personArray[2]=new Person;
    	personArray[3]=new Person;
    	personArray[4]=new Person;
	personArray[5]=new Person;
    	personArray[6]=new Person;
	personArray[7]=new Person;
	personArray[8]=new Person;
	personArray[9]=new Person;
	/*
	//Person przyklad("Przyklad", "Osoba", "M", "98000000000", 00, 000); 
    
    //personArray[10]=&przyklad;
	*/
      
   while(1){
		      
		/*cout<<endl;
		cout<<"Pierwsze 5 obiektów to osoby"<<endl;
		cout<<endl;
		cout<<"Obiekt nr 6 to student"<<endl;
		cout<<endl;
		cout<<"Obiekt nr 7 to pracownik"<<endl;*/
		cout<<endl;		
		cout<<"Wybierz nr obiektu ktory chcesz odczytac lub zedytowac"<<endl;
       		cout<<endl;
		
		//WYPISANIE OBIEKTOW ZA POMOCA INTERFEJSU
		for(int q=0; q<10; q++){
            	cout<<q<<".	Obiekt nr "<<q+1<<" - ";
            	print(personArray[q]);
			

            	cout<<endl;
        }
        /*cout<<"11. Instrukcja_osoba" ;
        //print(personArray[10]);
        cout<<endl;*/
        cout<<"555.	Koniec"<<endl;
        int choicemenu2=0;
        int choicemenu=0;
    	


	cin>>choicemenu;
	if(choicemenu==11){
        menu(1);
        cin >> choicemenu2;
        switch(choicemenu2){
        case 1:
           personArray[10]->wydrukuj();
			//print(personArray[10]);
            break;
        case 2:
            personArray[10]->zamien();
            break;
        default:
            cout << "\nBLAD\n";
            break;
        }
    }
	else if(choicemenu ==555){
        return 0;
    }
	else
	{
       menu(2);
        cin >>choicemenu2;
       	
		switch(choicemenu2){
        case 1:
            personArray[choicemenu]->wydrukuj();
            break;
        case 2:
            personArray[choicemenu]->zamien();
            break;
        case 3:
          	menu(3);
		int specmenu;
		cin>>specmenu;
			
		if(specmenu==1){
				
			personArray[choicemenu]=new Faculty;

		}
		else
		{
		if(specmenu==2){
				
			personArray[choicemenu]=new Student;

		}
		else
		{
			personArray[choicemenu]=new Person;

		}
		}
		personArray[choicemenu]->dodaj();

            	break;
	   	default:
            	cout << "\nBLAD\n";
            	break;
        }
    }
  }

}
